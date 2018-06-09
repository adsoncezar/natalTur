package com.adson.ws.natalws.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.adson.ws.natalws.dominio.AvaliacaoPontoTuristico;
import com.adson.ws.natalws.repository.AvaliacaoRepository;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoResource {
	
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	//CREATE
	@PostMapping(consumes="application/json", produces="application/json")
	@ResponseStatus(code=HttpStatus.CREATED)
	public AvaliacaoPontoTuristico createAvaliacao(@Valid @RequestBody AvaliacaoPontoTuristico avaliacao) {
		return avaliacaoRepository.save(avaliacao);
	}
	
	//READ
	@GetMapping("/{idAvaliacao}")
	public AvaliacaoPontoTuristico findByPrimaryKey(@PathVariable Long idAvaliacao) {
		return avaliacaoRepository.findById(idAvaliacao).get();
	}
	
	//GET
	//Comiatar
	
	@GetMapping
	public List<AvaliacaoPontoTuristico> findAvaliacoes(){
		return avaliacaoRepository.findAll(new Sort(Direction.ASC, "data"));
	}
	
	//UPDATE
	@PutMapping(consumes="application/json", produces="application/json")
	@ResponseStatus(code=HttpStatus.OK)
	public AvaliacaoPontoTuristico updateAvaliacao(@Valid @RequestBody AvaliacaoPontoTuristico avaliacao) {
		return avaliacaoRepository.save(avaliacao);
	}
	
	//DELETE
	@DeleteMapping("/{idAvaliacao}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void removeAvaliacao(@PathVariable Long idAvaliacao) {
		avaliacaoRepository.deleteById(idAvaliacao);
	}
}
