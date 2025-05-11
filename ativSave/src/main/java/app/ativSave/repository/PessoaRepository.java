package app.ativSave.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.ativSave.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
