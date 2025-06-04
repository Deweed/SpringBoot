package com.cadastro.usuario.controllers; 
import java.util.List; 
import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.RestController; 

import com.cadastro.usuario.models.Usuario; 
import com.cadastro.usuario.services.UsuarioService; 

@RestController 
@RequestMapping("/usuarios") 
public class UsuarioController {

    @Autowired 
    private UsuarioService usuarioService;

    @GetMapping 
    public List<Usuario> obterTodos() {
        return usuarioService.findAll(); 
    }

    @GetMapping("/{id}") 
    public ResponseEntity<Usuario> obterPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.findById(id); 
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping 
    public Usuario inserir(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario); 
    }

    @PutMapping("/{id}") 
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        Optional<Usuario> updatedUsuario = usuarioService.update(id, usuario); 
        return updatedUsuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); 
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!usuarioService.findById(id).isPresent()) { 
            return ResponseEntity.notFound().build(); 
        }
        usuarioService.deleteById(id); 
        return ResponseEntity.noContent().build(); 
    }

    @GetMapping("/somar") 
    public int somar(@RequestParam int a, @RequestParam int b) {
        return usuarioService.somar(a, b); 
    }
}