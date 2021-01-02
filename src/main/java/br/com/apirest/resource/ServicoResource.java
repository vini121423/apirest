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

import br.com.apirest.model.Servico;
import br.com.apirest.service.ServicoService;

@RestController
@RequestMapping("/servicos")
public class ServicoResource {

	@Autowired
	private ServicoService servicoService;

	@GetMapping("/todos")
	public List<Servico> listAllService() {
		return servicoService.read();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Servico> byId(@PathVariable Integer id) {
		Servico servico = servicoService.readById(id);
		return ResponseEntity.ok().body(servico);
	}

	@PostMapping()
	public ResponseEntity<Void> insert(@RequestBody Servico servico) {
		
		servico = servicoService.create(servico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(servico.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		servicoService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Servico> update(@PathVariable Integer id, @RequestBody Servico servico) {
		try {
			Servico servicoSalvo = servicoService.update(id, servico);
			return ResponseEntity.ok(servicoSalvo);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}

	}
}
