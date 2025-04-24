package com.av1.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.av1.api.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    
}
