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

import br.com.apirest.model.Usuario;
import br.com.apirest.service.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {
  @Autowired
  private UsuarioService usuarioService;
  
	@GetMapping("/todos")
	public List<Usuario> listAllUser() {
		return usuarioService.read();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> byId(@PathVariable Integer id) {
		Usuario usuario = usuarioService.readById(id);
		return ResponseEntity.ok().body(usuario);
	}

	@PostMapping()
	public ResponseEntity<Void> insert(@RequestBody Usuario usuario) {
		usuario = usuarioService.create(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		usuarioService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario usuario) {
		try {
			Usuario usuarioSalvo = usuarioService.update(id, usuario);
			return ResponseEntity.ok(usuarioSalvo);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}

	}
  
}
