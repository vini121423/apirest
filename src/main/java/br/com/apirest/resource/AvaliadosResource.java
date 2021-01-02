package br.com.apirest.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.apirest.model.Avaliados;
import br.com.apirest.service.AvaliadosService;

@RestController
@RequestMapping("/avaliado")
public class AvaliadosResource {
  @Autowired
  private AvaliadosService avaliadosService;
  
  @GetMapping("/todas")
	public List<Avaliados> listAllRate(){
		return avaliadosService.read();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Avaliados> byId(@PathVariable Integer id) {
		Avaliados avaliados = avaliadosService.readById(id);
		return ResponseEntity.ok().body(avaliados);
	}
	
	@PostMapping()
	public ResponseEntity<Void> insert(@RequestBody Avaliados avaliados) {
		avaliados = avaliadosService.create(avaliados);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(avaliados.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		avaliadosService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Avaliados> update(@PathVariable Integer id,
			    @RequestBody Avaliados avaliados) {
		try {
		Avaliados avaliadosSalvo= avaliadosService.update(id,avaliados);
		return ResponseEntity.ok(avaliadosSalvo);
		}
		catch (IllegalArgumentException e){
	          return ResponseEntity.notFound().build();    
	       } 
		
	}
	
}
