package com.cadastro.usuario;


import java.util.Arrays;
import java.util.List; 
import java.util.Optional; 

import static org.junit.jupiter.api.Assertions.assertEquals; 
import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.Test; 
import org.mockito.InjectMocks; 
import org.mockito.Mock; 
import static org.mockito.Mockito.doNothing; 
import static org.mockito.Mockito.times; 
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when; 
import org.mockito.MockitoAnnotations; 
import org.springframework.http.ResponseEntity; 

import com.cadastro.usuario.controllers.UsuarioController;
import com.cadastro.usuario.models.Usuario; 
import com.cadastro.usuario.services.UsuarioService; 


public class UsuarioTest {

    
    @InjectMocks
    private UsuarioController usuarioController;

    @Mock
    private UsuarioService usuarioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

  
    @Test
    void testObterTodos() {
       
        List<Usuario> usuarios = Arrays.asList(
            new Usuario(1L, "User1", "user1@example.com"),
            new Usuario(2L, "User2", "user2@example.com")
        );

       
        when(usuarioService.findAll()).thenReturn(usuarios);

      
        List<Usuario> response = usuarioController.obterTodos();

        assertEquals(2, response.size());
        
        verify(usuarioService, times(1)).findAll();
    }

    @Test
    void testObterPorId() {
        Long usuarioId = 1L;
        Usuario usuario = new Usuario(usuarioId, "User1", "user1@example.com");

       
        when(usuarioService.findById(usuarioId)).thenReturn(Optional.of(usuario));

        ResponseEntity<Usuario> response = usuarioController.obterPorId(usuarioId);

    
        assertEquals(ResponseEntity.ok(usuario), response);
     
        verify(usuarioService, times(1)).findById(usuarioId);
    }

    @Test
    void testInserir() {
        Usuario usuario = new Usuario(1L, "User1", "user1@example.com");

     
        when(usuarioService.save(usuario)).thenReturn(usuario);

        Usuario response = usuarioController.inserir(usuario);

        assertEquals(usuario, response);
    
        verify(usuarioService, times(1)).save(usuario);
    }

   
    @Test
    void testAtualizar() {
     
        Long usuarioId = 1L;

        Usuario usuario = new Usuario(usuarioId, "User1", "user1@example.com");

        
        Usuario updatedUsuario = new Usuario(usuarioId, "User2", "user2@example.com");

       
        when(usuarioService.update(usuarioId, usuario)).thenReturn(Optional.of(updatedUsuario));

        ResponseEntity<Usuario> response = usuarioController.atualizar(usuarioId, usuario);

        assertEquals(ResponseEntity.ok(updatedUsuario), response);

        verify(usuarioService, times(1)).update(usuarioId, usuario);
    }
    @Test
    void testExcluir() {
        Long usuarioId = 1L;
        Usuario usuario = new Usuario(usuarioId, "User1", "user1@example.com");

        when(usuarioService.findById(usuarioId)).thenReturn(Optional.of(usuario));
      
        doNothing().when(usuarioService).deleteById(usuarioId);

        ResponseEntity<Void> response = usuarioController.excluir(usuarioId);

        assertEquals(ResponseEntity.noContent().build(), response);
        
        verify(usuarioService, times(1)).deleteById(usuarioId);
    }

     @Test
    void testSomarErro() {
       int a = 1;
       int b = 2;
       int resultadoEsperado = 3;

    
       when(usuarioController.somar(a, b)).thenReturn(3);

   
       int resultado = usuarioController.somar(a, b);

    
        assertEquals(resultadoEsperado, resultado, "O resultado da soma está incorreto");
    
        verify(usuarioService, times(1)).somar(a, b);
    }
}