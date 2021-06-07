package br.org.generation.blogPessoal.controller;

import java.util.List;//ok

import org.springframework.beans.factory.annotation.Autowired;//ok
import org.springframework.http.HttpStatus;//ok
import org.springframework.http.ResponseEntity;//ok
import org.springframework.web.bind.annotation.CrossOrigin;//ok
import org.springframework.web.bind.annotation.DeleteMapping;//ok
import org.springframework.web.bind.annotation.GetMapping;//ok
import org.springframework.web.bind.annotation.PathVariable;//ok
import org.springframework.web.bind.annotation.PostMapping;//ok
import org.springframework.web.bind.annotation.PutMapping;//ok
import org.springframework.web.bind.annotation.RequestBody;//ok
import org.springframework.web.bind.annotation.RequestMapping;//ok
import org.springframework.web.bind.annotation.RestController;//ok

import br.org.generation.blogPessoal.model.Tema;
import br.org.generation.blogPessoal.repository.TemaRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/tema")
public class TemaController {
	
	@Autowired 
	private TemaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Tema>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tema> getById (@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Tema>> getByName (@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Tema> postTema (@RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity<Tema> putTema (@RequestBody Tema tema){
		return ResponseEntity.ok(repository.save(tema));
	}
	
	@DeleteMapping("/{id}")
	public void deleteTema(@PathVariable long id) {
		repository.deleteById(id);
	}
}
