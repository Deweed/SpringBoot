package com.av1.api.model;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@EntityScan("com.av1.api.model")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private String nome;
    private String descricao;
    private Integer cargaHoraria;

    @OneToMany(mappedBy = "curso")
    private List<Aluno> alunos;
}
