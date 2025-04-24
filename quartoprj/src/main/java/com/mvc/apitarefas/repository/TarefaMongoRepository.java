package com.mvc.apitarefas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.mvc.apitarefas.model.Tarefa;

public interface TarefaMongoRepository extends MongoRepository<Tarefa, String> {}
