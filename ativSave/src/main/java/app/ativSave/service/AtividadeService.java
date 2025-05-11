package app.ativSave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ativSave.entity.Atividades;
import app.ativSave.repository.AtividadesRepository;

@Service
public class AtividadeService {
	
	@Autowired
	private AtividadesRepository atividadesRepository;

	public String save(Atividades atividade) {
		this.atividadesRepository.save(atividade);
		return "atividade salva com sucesso";
	}
	
	public String update(Atividades atividade, long id) {
		atividade.setId(id);
		this.atividadesRepository.save(atividade);
		return "atividade foi atualizada com sucesoo";
	}
	
	public String delete (long id) {
		this.atividadesRepository.deleteById(id);
		return "atividade deletada com sucesso";
	}
	
	public List<Atividades> findAll(){
		List<Atividades> lista = this.atividadesRepository.findAll();
		return lista;
	}
	
	public Atividades findById(long id) {
		Atividades atividade = this.atividadesRepository.findById(id).get();
		return atividade;
	}
	
	public List<Atividades> listarAtividadesOrdenadasPorExpiracao(){
		return atividadesRepository.findAllPorOrdemDeExpiracao();
	}
}
