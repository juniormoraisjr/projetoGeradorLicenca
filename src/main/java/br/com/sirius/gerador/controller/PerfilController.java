package br.com.sirius.gerador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sirius.gerador.repository.entity.Perfil;
import br.com.sirius.gerador.service.PerfilService;

@RestController
@RequestMapping(value = "perfil")
public class PerfilController {

	@Autowired
	private PerfilService service;

	@RequestMapping(value = "gravar", method = RequestMethod.POST)
	public void listar(@RequestBody Perfil perfil) {
		service.gravar(perfil);
	}

	@RequestMapping(value = "listar", method = RequestMethod.POST)
	public List<Perfil> listar() {
		return service.listar();
	}

	@RequestMapping(value = "listar/{page}/{size}", method = RequestMethod.GET)
	public Page<Perfil> listar(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
		return service.listarPaginado(page, size);
	}
}
