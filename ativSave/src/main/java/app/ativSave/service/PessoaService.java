package app.ativSave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ativSave.entity.Pessoa;
import app.ativSave.enums.SituacaoEnum;
import app.ativSave.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public String save(Pessoa pessoa) {
		this.pessoaRepository.save(pessoa);
		return "pessoa salva com sucesso";
	}
	
	public String update(Pessoa pessoa, long id) {
		pessoa.setId(id);
		this.pessoaRepository.save(pessoa);
		return "pessoa foi atualizada com sucesoo";
	}
	
	public String delete (long id) {
		this.pessoaRepository.deleteById(id);
		return "pessoa deletada com sucesso";
	}
	
	public List<Pessoa> findAll(){
		List<Pessoa> lista = this.pessoaRepository.findAll();
		return lista;
	}
	
	public Pessoa findById(long id) {
		Pessoa pessoa = this.pessoaRepository.findById(id).get();
		return pessoa;
	}
	
	public String updateStatus(long id, SituacaoEnum status) {
		Pessoa pessoa = pessoaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("pessoa nao encontrada"));
		
		pessoa.setStatus(status);
		pessoaRepository.save(pessoa);
		
		return "status atualizado para:" + status;
	}
}
