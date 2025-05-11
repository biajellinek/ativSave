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

import app.ativSave.entity.Atividades;
import app.ativSave.entity.Pessoa;
import app.ativSave.service.AtividadeService;

@RestController
@RequestMapping("/api/atividades")
public class AtividadesController {
	
	@Autowired
	private AtividadeService atividadesService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Atividades atividade) {

		try {

			String mensagem = this.atividadesService.save(atividade);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Atividades atividade,@PathVariable  long id) {
		try {
			String mensagem = this.atividadesService.update(atividade, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete (@PathVariable long id) {
		try {
			String mensagem = this.atividadesService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Atividades>> findAll(){
		try {
			List<Atividades> lista = this.atividadesService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<Atividades> findById(@PathVariable long id) {
		try {
			Atividades atividade = this.atividadesService.findById(id);
			return new ResponseEntity<>(atividade, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping("/ordenacaoPorExpiracao")
	public List<Atividades> listarAtividadesOrdenadasPorExpiracao(){
		return atividadesService.listarAtividadesOrdenadasPorExpiracao();
	}
}
