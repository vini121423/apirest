package br.com.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apirest.model.Cidade;
import br.com.apirest.repository.CidadeRepository;
import br.com.apirest.service.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {
 
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cidade create(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}

	public List<Cidade> read() {
		return cidadeRepository.findAll();
	}

	public Cidade readById(Integer id) {
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		return cidade.orElseThrow(() -> new ObjectNotFoundException(
				"Categoria não encontrada ! Id: " + id + " Tipo: " + Cidade.class.getName()));
	}

	public Cidade update(Integer id, Cidade cidade) {
		Cidade cidadeSalvo = readById(id);
		BeanUtils.copyProperties(cidade, cidadeSalvo, "id");
		return cidadeRepository.save(cidadeSalvo);
	}

	public void delete(Integer id) {
		readById(id);
		cidadeRepository.deleteById(id);
	}
}
