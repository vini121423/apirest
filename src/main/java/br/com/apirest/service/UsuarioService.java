package br.com.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apirest.model.Usuario;
import br.com.apirest.repository.UsuarioRepository;
import br.com.apirest.service.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario create(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public List<Usuario> read() {
		return usuarioRepository.findAll();
	}

	public Usuario readById(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElseThrow(() -> new ObjectNotFoundException(
				"Categoria não encontrada ! Id: " + id + " Tipo: " + Usuario.class.getName()));
	}

	public Usuario update(Integer id, Usuario usuario) {
		Usuario usuarioSalvo = readById(id);
		BeanUtils.copyProperties(usuario, usuarioSalvo, "id");
		return usuarioRepository.save(usuarioSalvo);
	}

	public void delete(Integer id) {
		readById(id);
		usuarioRepository.deleteById(id);
	}
}
