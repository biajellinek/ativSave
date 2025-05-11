package app.ativSave.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.ativSave.entity.Atividades;

public interface AtividadesRepository extends JpaRepository<Atividades, Long>{

	List<Atividades> findAllPorOrdemDeExpiracao();
}
