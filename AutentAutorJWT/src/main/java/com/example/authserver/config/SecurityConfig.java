package com.example.authserver.config;

import com.example.authserver.model.User;
import com.example.authserver.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.boot.CommandLineRunner;

import org.springframework.beans.factory.annotation.Value;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> userRepository.findByUsername(username)
                .map(user -> org.springframework.security.core.userdetails.User.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .roles(user.getRole())
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        SecretKeySpec secretKey = new SecretKeySpec(jwtSecret.getBytes(StandardCharsets.UTF_8), "HmacSha256");
        return NimbusJwtDecoder.withSecretKey(secretKey).build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(jwt -> {
            String role = jwt.getClaimAsString("role");
            if (role == null) {
                return List.of();
            }
            return List.of(new SimpleGrantedAuthority("ROLE_" + role));
        });
        return converter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/login").permitAll()
                .requestMatchers("/auth/validate").permitAll()
                .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                .requestMatchers("/api/admin/**").hasRole("ADMIN")


                .anyRequest().authenticated()
                
            )
            .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))
            .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> 
                jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())
            ));

        return http.build();
    }

    @Bean
    public CommandLineRunner initData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User(null, "admin", passwordEncoder.encode("admin123"), "ADMIN", "admin@admin.com.br");
                userRepository.save(admin);
                System.out.println("Usuário 'admin' criado com senha codificada.");
            }
            if (userRepository.findByUsername("user").isEmpty()) {
                User user = new User(null, "user", passwordEncoder.encode("user123"), "USER", "user@user.com.br");
                userRepository.save(user);
                System.out.println("Usuário 'user' criado com senha codificada.");
            }
        };
    }
}
