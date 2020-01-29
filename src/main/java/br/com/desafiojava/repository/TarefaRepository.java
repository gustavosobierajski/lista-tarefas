package br.com.desafiojava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafiojava.model.Tarefa;;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> { }
