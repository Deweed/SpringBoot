package com.av1.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.av1.api.model.Aluno;
import com.av1.api.services.AlunoService;

@RestController
public class AlunoController {
    @Autowired 
    private AlunoService alunoService;
    
    @GetMapping("/Alunos")
    public List<Aluno> listarAlunos() {
        return alunoService.listarAlunos();
    }

    @PostMapping("/Alunos")
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoService.criarAluno(aluno);
    }
}
