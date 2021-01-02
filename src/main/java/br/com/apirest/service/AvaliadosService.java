package br.com.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apirest.model.Avaliados;
import br.com.apirest.repository.AvaliadosRepository;
import br.com.apirest.service.exceptions.ObjectNotFoundException;

@Service
public class AvaliadosService {
	@Autowired
	private AvaliadosRepository avaliadosRepository;

	public Avaliados create(Avaliados avaliados) {
		return avaliadosRepository.save(avaliados);
	}

	public List<Avaliados> read() {
		return avaliadosRepository.findAll();
	}

	public Avaliados readById(Integer id) {
		Optional<Avaliados> avaliados = avaliadosRepository.findById(id);
		return avaliados.orElseThrow(() -> new ObjectNotFoundException(
				"Categoria não encontrada ! Id: " + id + " Tipo: " + Avaliados.class.getName()));
	}

	public Avaliados update(Integer id, Avaliados avaliados) {
		Avaliados avaliadosSalvo = readById(id);
		BeanUtils.copyProperties(avaliados, avaliadosSalvo, "id");
		return avaliadosRepository.save(avaliadosSalvo);
	}

	public void delete(Integer id) {
		readById(id);
		avaliadosRepository.deleteById(id);
	}

}
