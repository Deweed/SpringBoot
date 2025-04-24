package com.av1.api.model;

import java.sql.Date;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@EntityScan("com.av1.api.model")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private String nome;
    private String email;
    private Date dataNascimento;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

}
