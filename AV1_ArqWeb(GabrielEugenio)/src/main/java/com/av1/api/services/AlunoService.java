package com.av1.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.av1.api.model.Aluno;
import com.av1.api.repository.AlunoRepository;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);

    }
}
