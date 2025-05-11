package app.ativSave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ativSave.entity.Endereco;
import app.ativSave.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecorepository;
	
	public String save(Endereco endereco) {
		this.enderecorepository.save(endereco);
		return "endereco salvo com sucesso";
	}
	
	public String update(Endereco endereco, long id) {
		endereco.setId(id);
		this.enderecorepository.save(endereco);
		return "endereco foi atualizado com sucesoo";
	}
	
	public String delete (long id) {
		this.enderecorepository.deleteById(id);
		return "endereco deletado com sucesso";
	}
	
	public List<Endereco> findAll(){
		List<Endereco> lista = this.enderecorepository.findAll();
		return lista;
	}
	
	public Endereco findById(long id) {
		Endereco endereco = this.enderecorepository.findById(id).get();
		return endereco;
	}

}
