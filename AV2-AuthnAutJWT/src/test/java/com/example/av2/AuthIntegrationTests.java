package com.example.av2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.av2.repository.UserRepository;
import com.example.av2.service.JwtService;

import org.springframework.security.crypto.password.PasswordEncoder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
class AuthIntegrationTests {

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setup() {
        userRepository.findByUsername("admin").ifPresentOrElse(
                user -> { /* Já existe */ },
                () -> {
                    com.example.av2.model.User admin = new com.example.av2.model.User(null, "admin", passwordEncoder.encode("admin123"), "ADMIN", "admin@admin.com.br");
                    userRepository.save(admin);
                }
        );
        userRepository.findByUsername("user").ifPresentOrElse(
                user -> { /* Já existe */ },
                () -> {
                    com.example.av2.model.User regularUser = new com.example.av2.model.User(null, "user", passwordEncoder.encode("user123"), "USER","user@user.com.br");
                    userRepository.save(regularUser);
                }
        );
    }

@Test
void testLoginSuccess() throws Exception {
    String token = mockMvc.perform(post("/auth/login")
            .param("username", "admin")
            .param("password", "admin123")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED))
           .andExpect(status().isOk())
           .andReturn().getResponse().getContentAsString();

    // Valida o token programaticamente
    assert jwtService.validateToken(token);

    // Confirma que ele não está vazio
    org.assertj.core.api.Assertions.assertThat(token).isNotEmpty();
}


    @Test
    void testLoginFailureInvalidPassword() throws Exception {
        mockMvc.perform(post("/auth/login")
                .param("username", "admin")
                .param("password", "errada123")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
               .andExpect(status().isUnauthorized())
               .andExpect(content().string(containsString("Senha incorreta.")));
    }

    @Test
    void testProtectedEndpointAccessDeniedWithoutToken() throws Exception {
        mockMvc.perform(get("/api/hello"))
               .andExpect(status().isUnauthorized());
    }

    @Test
    void testProtectedEndpointAccessWithValidToken() throws Exception {
        String token = mockMvc.perform(post("/auth/login")
                .param("username", "user")
                .param("password", "user123")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
               .andExpect(status().isOk())
               .andReturn().getResponse().getContentAsString();

        mockMvc.perform(get("/api/hello")
                .header("Authorization", "Bearer " + token))
               .andExpect(status().isOk())
               .andExpect(content().string("Olá! Você acessou um endpoint protegido com sucesso!"));
    }

    @Test
    void testProtectedAdminEndpointAccessWithAdminToken() throws Exception {
        String adminToken = mockMvc.perform(post("/auth/login")
                .param("username", "admin")
                .param("password", "admin123")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
               .andExpect(status().isOk())
               .andReturn().getResponse().getContentAsString();

        mockMvc.perform(get("/api/admin")
                .header("Authorization", "Bearer " + adminToken))
               .andExpect(status().isOk())
               .andExpect(content().string("Bem-vindo, Administrador! Este é um recurso restrito."));
    }

    @Test
    void testProtectedAdminEndpointAccessDeniedWithUserToken() throws Exception {
        String userToken = mockMvc.perform(post("/auth/login")
                .param("username", "user")
                .param("password", "user123")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
               .andExpect(status().isOk())
               .andReturn().getResponse().getContentAsString();

        mockMvc.perform(get("/api/admin")
                .header("Authorization", "Bearer " + userToken))
               .andExpect(status().isForbidden());
    }
}
