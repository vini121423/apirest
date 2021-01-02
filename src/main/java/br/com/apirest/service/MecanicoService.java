package br.com.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apirest.model.Mecanico;
import br.com.apirest.repository.MecanicoRepository;
import br.com.apirest.service.exceptions.ObjectNotFoundException;


@Service
public class MecanicoService {
	@Autowired
	private MecanicoRepository mecanicoRepository;

	public Mecanico create(Mecanico mecanico) {
		return mecanicoRepository.save(mecanico);
	}

	public List<Mecanico> read() {
		return mecanicoRepository.findAll();
	}

	public Mecanico readById(Integer id) {
		Optional<Mecanico> mecanico = mecanicoRepository.findById(id);
		return mecanico.orElseThrow(() -> new ObjectNotFoundException(
				"Categoria não encontrada ! Id: " + id + " Tipo: " + Mecanico.class.getName()));
	}

	public Mecanico update(Integer id, Mecanico mecanico) {
		Mecanico mecanicoSalvo = readById(id);
		BeanUtils.copyProperties(mecanico, mecanicoSalvo, "id");
		return mecanicoRepository.save(mecanicoSalvo);
	}

	public void delete(Integer id) {
		readById(id);
		mecanicoRepository.deleteById(id);
	}
}
