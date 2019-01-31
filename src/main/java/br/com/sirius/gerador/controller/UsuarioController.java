package br.com.sirius.gerador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sirius.gerador.repository.entity.Usuario;
import br.com.sirius.gerador.service.UsuarioService;

@RestController
@RequestMapping(value = "usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@RequestMapping(value = "/gravar", method = RequestMethod.POST)
	public void gravar(@RequestBody Usuario usuario) {
		service.gravar(usuario);
	}

	@RequestMapping(value = "/alterar", method = RequestMethod.PUT)
	public void alterar(@RequestBody Usuario usuario) {
		service.gravar(usuario);
	}

	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.DELETE)
	public void excluirUsuario(@PathVariable("id") String id) {
		service.excluir(id);
	}

	@RequestMapping(value = "/listar", method = RequestMethod.POST)
	public List<Usuario> listar() {
		return service.listar();
	}

	@RequestMapping(value = "/listarPaginado/{page}/{size}", method = RequestMethod.GET)
	public Page<Usuario> listarPaginado(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
		return service.listarPaginado(page, size);
	}
}