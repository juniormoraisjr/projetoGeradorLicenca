package br.com.sirius.gerador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sirius.gerador.infra.util.exception.BusinessException;
import br.com.sirius.gerador.repository.entity.GeradorLicenca;
import br.com.sirius.gerador.service.GeradorLicencaService;

@RestController
@RequestMapping(value = "geradorLicenca")
public class GeradorLicencaController {

	@Autowired
	private GeradorLicencaService service;

	@RequestMapping(value = "/gerarToken", method = RequestMethod.POST)
	public String gerarToken(@RequestBody GeradorLicenca entity) {
		try {
			GeradorLicenca result = service.gerarTokenLicenca(entity);
			return result.getToken();
		} catch (BusinessException e) {
			return e.getMessage();
		}
	}
}
