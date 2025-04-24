package com.av1.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.av1.api.model.Curso;
import com.av1.api.services.CursoService;

@RestController
public class CursoController {
    @Autowired
    private CursoService cursoService;
    
    @GetMapping("/Cursos")
    public List<Curso> listarCursos() {
        return cursoService.listarCursos();
    }

    @PostMapping("/Cursos")
    public Curso criarCurso(@RequestBody Curso curso) {
        return cursoService.criarAluno(curso);
    }
}
