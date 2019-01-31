package br.com.sirius.gerador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.sirius.gerador.repository.PerfilRepository;
import br.com.sirius.gerador.repository.entity.Perfil;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepository perfilRepository;

	public void gravar(Perfil perfil) {
		perfilRepository.save(perfil);
	}

	public List<Perfil> listar() {
		return perfilRepository.findAll();
	}

	public Page<Perfil> listarPaginado(int page, int size) {
		Pageable pageable = new PageRequest(page, size);
		return perfilRepository.findAll(pageable);
	}

	public void excluir(String id) {
		perfilRepository.delete(id);
	}
}