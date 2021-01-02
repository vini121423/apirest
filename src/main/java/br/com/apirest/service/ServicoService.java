package br.com.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apirest.model.Servico;
import br.com.apirest.repository.ServicoRepository;
import br.com.apirest.service.exceptions.ObjectNotFoundException;

@Service
public class ServicoService {
  @Autowired
  private ServicoRepository servicoRepository;
  
  public Servico create(Servico servico) {
		return servicoRepository.save(servico);
	}

	public List<Servico> read() {
		return servicoRepository.findAll();
	}

	public Servico readById(Integer id) {
		Optional<Servico> servico = servicoRepository.findById(id);
		return servico.orElseThrow(() -> new ObjectNotFoundException(
				"Categoria não encontrada ! Id: " + id + " Tipo: " + Servico.class.getName()));
	}

	public Servico update(Integer id, Servico servico) {
		Servico servicoSalvo = readById(id);
		BeanUtils.copyProperties(servico, servicoSalvo, "id");
		return servicoRepository.save(servicoSalvo);
	}

	public void delete(Integer id) {
		readById(id);
		servicoRepository.deleteById(id);
	}
}
