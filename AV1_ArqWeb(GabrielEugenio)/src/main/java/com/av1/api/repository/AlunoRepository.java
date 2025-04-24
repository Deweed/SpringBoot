package com.av1.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.av1.api.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
