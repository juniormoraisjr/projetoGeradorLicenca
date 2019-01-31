package br.com.sirius.gerador.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sirius.gerador.infra.util.cypher.PasswordUtils;
import br.com.sirius.gerador.infra.util.date.CalendarUtils;
import br.com.sirius.gerador.infra.util.date.CalendarUtilsFormatter;
import br.com.sirius.gerador.infra.util.number.NumberUtils;
import br.com.sirius.gerador.repository.GeradorLicencaRepository;
import br.com.sirius.gerador.repository.entity.GeradorLicenca;

@Service
public class GeradorLicencaService {

	@Autowired
	private GeradorLicencaRepository repository;

	public String gerarTokenLicenca(GeradorLicenca entity) {
		String nomeEmpresa = createInfoEmpresa(entity);
		String codigoEmpresa = createEmpresaEmpresa(entity);
		String cnpjEmpresa = createCnpjEmpresa(entity);
		String codigoOrganizacaoEmpresarial = createOrganizacaoEmpresarial(entity);

		String dataGeracao = createDataGeracao();
		Calendar dataCorrente = CalendarUtils.setZeroAllHourInCalendar(Calendar.getInstance());
		String dataInicialLicenca = createDataInicial(dataCorrente);
		String dataFinalLicenca = createDataFinal(entity, dataCorrente);

		String contraSenhaGeracaoLicenca = createContraSenha(entity);
		String token = createTokenLicenca(nomeEmpresa, codigoEmpresa, cnpjEmpresa, codigoOrganizacaoEmpresarial,
				dataGeracao, dataInicialLicenca, dataFinalLicenca, contraSenhaGeracaoLicenca);

		entity.setToken(token);
		
		repository.save(entity);

		return token;
	}

	private String createDataFinal(GeradorLicenca entity, Calendar dataCorrente) {
		CalendarUtils.setLastHourInCalendar(dataCorrente);
		dataCorrente.add(Calendar.DATE, entity.getQtdeDiaLicenca());
		return "Data Final Licença&" + CalendarUtilsFormatter.format(dataCorrente, "dd/MM/yyyy HH:mm:ss");
	}

	private String createDataInicial(Calendar dataCorrente) {
		return "Data Inicial Licença&" + CalendarUtilsFormatter.format(dataCorrente, "dd/MM/yyyy HH:mm:ss");
	}

	private String createDataGeracao() {
		return "Data Geração&" + CalendarUtilsFormatter.format(Calendar.getInstance(), "dd/MM/yyyy HH:mm:ss");
	}

	private String createDigitoCnpj(String cnpjEmpresa) {
		return cnpjEmpresa.split("-")[1];
	}

	private String createOrganizacaoEmpresarial(GeradorLicenca entity) {
		return "Código Organizacao Empresarial Cliente&" + entity.getIdOrganizacao();
	}

	private String createCnpjEmpresa(GeradorLicenca entity) {
		return "Cnpj Empresa&" + entity.getCnpjEmpresa();
	}

	private String createEmpresaEmpresa(GeradorLicenca entity) {
		return "Código Empresa&" + entity.getIdEmpresa();
	}

	private String createInfoEmpresa(GeradorLicenca entity) {
		return "Empresa&" + entity.getEmpresa();
	}

	private String createContraSenha(GeradorLicenca entity) {
		Long result = (NumberUtils.toLong(entity.getIdEmpresa()) + NumberUtils.toLong(entity.getIdOrganizacao())
				+ NumberUtils.toLong(createDigitoCnpj(entity.getCnpjEmpresa()))) * 10;
		return "Contra Senha&" + PasswordUtils.encrip(result.toString());
	}

	private String createTokenLicenca(String nomeEmpresa, String codigoEmpresa, String cnpjEmpresa,
			String codigoOrganizacaoEmpresarial, String dataGeracao, String dataInicialLicenca, String dataFinalLicenca,
			String contraSenhaGeracaoLicenca) {
		String token = PasswordUtils.encrip(nomeEmpresa + ";" + dataGeracao + ";" + dataInicialLicenca + ";"
				+ dataFinalLicenca + ";" + codigoEmpresa + ";" + codigoOrganizacaoEmpresarial + ";" + cnpjEmpresa + ";"
				+ contraSenhaGeracaoLicenca);
		return token;
	}

}