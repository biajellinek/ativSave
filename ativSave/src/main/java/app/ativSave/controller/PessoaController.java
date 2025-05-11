package app.ativSave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.ativSave.entity.Pessoa;
import app.ativSave.enums.SituacaoEnum;
import app.ativSave.service.PessoaService;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Pessoa pessoa) {

		try {

			String mensagem = this.pessoaService.save(pessoa);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Pessoa pessoa,@PathVariable  long id) {
		try {
			String mensagem = this.pessoaService.update(pessoa, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete (@PathVariable long id) {
		try {
			String mensagem = this.pessoaService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Pessoa>> findAll(){
		try {
			List<Pessoa> lista = this.pessoaService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable long id) {
		try {
			Pessoa pessoa = this.pessoaService.findById(id);
			return new ResponseEntity<>(pessoa, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}

	public ResponseEntity<String> uptadeStatus(@PathVariable long id,@RequestBody SituacaoEnum status){
		try {
			String mensagem = this.pessoaService.updateStatus(id, status);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("erro ao atualizar status", HttpStatus.BAD_REQUEST);
		}
	}
}
