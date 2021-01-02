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

import br.com.apirest.model.Cidade;
import br.com.apirest.service.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping("/todas")
	public List<Cidade> listAllCity(){
		return cidadeService.read();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cidade> byId(@PathVariable Integer id) {
		Cidade cidade = cidadeService.readById(id);
		return ResponseEntity.ok().body(cidade);
	}
	
	@PostMapping()
	public ResponseEntity<Void> insert(@RequestBody Cidade cidade) {
		cidade = cidadeService.create(cidade);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(cidade.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		cidadeService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cidade> update(@PathVariable Integer id,
			    @RequestBody Cidade cidade) {
		try {
		Cidade cidadeSalva= cidadeService.update(id,cidade);
		return ResponseEntity.ok(cidadeSalva);
		}
		catch (IllegalArgumentException e){
	          return ResponseEntity.notFound().build();    
	       } 
		
	}
}
