package com.cadastro.usuario.services; 

import java.util.List; 
import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 

import com.cadastro.usuario.models.Usuario; 
import com.cadastro.usuario.repositories.UsuarioRepository; 

@Service 
public class UsuarioService {

    @Autowired 
    private UsuarioRepository usuarioRepository;

    
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

   
    public Optional<Usuario> update(Long id, Usuario usuario) {
        return usuarioRepository.findById(id).map(existingUsuario -> {
           
            existingUsuario.setNome(usuario.getNome());
            existingUsuario.setEmail(usuario.getEmail());
          
            return usuarioRepository.save(existingUsuario);
        });
    }

    
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    public int somar(int a, int b){
        return a + b;
    }
}