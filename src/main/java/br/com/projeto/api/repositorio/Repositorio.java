package br.com.projeto.api.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.api.model.Pessoa;

@Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer>{

}