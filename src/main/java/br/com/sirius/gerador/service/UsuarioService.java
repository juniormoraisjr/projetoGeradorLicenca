package br.com.sirius.gerador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.sirius.gerador.repository.UsuarioRepository;
import br.com.sirius.gerador.repository.entity.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void gravar(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	public Page<Usuario> listarPaginado(int page, int size) {
		Pageable pageable = new PageRequest(page, size);
		return usuarioRepository.findAll(pageable);
	}

	public Usuario buscarPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	public void excluir(String id) {
		usuarioRepository.delete(id);
	}
}