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

import br.com.apirest.model.Mecanico;
import br.com.apirest.service.MecanicoService;

@RestController
@RequestMapping("/mecanicos")
public class MecanicoResource {
	@Autowired
	private MecanicoService mecanicoService;

	@GetMapping("/todos")
	public List<Mecanico> listAllMechanic() {
		return mecanicoService.read();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Mecanico> byId(@PathVariable Integer id) {
		Mecanico mecanico = mecanicoService.readById(id);
		return ResponseEntity.ok().body(mecanico);
	}

	@PostMapping()
	public ResponseEntity<Void> insert(@RequestBody Mecanico mecanico) {
		mecanico = mecanicoService.create(mecanico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(mecanico.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		mecanicoService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Mecanico> update(@PathVariable Integer id, @RequestBody Mecanico mecanico) {
		try {
			Mecanico mecanicoSalvo = mecanicoService.update(id, mecanico);
			return ResponseEntity.ok(mecanicoSalvo);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}

	}
}
