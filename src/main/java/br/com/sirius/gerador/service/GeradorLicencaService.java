package br.com.sirius.gerador.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sirius.gerador.infra.util.cypher.PasswordUtils;
import br.com.sirius.gerador.infra.util.date.CalendarUtils;
import br.com.sirius.gerador.infra.util.date.CalendarUtilsFormatter;
import br.com.sirius.gerador.infra.util.exception.BusinessException;
import br.com.sirius.gerador.infra.util.number.NumberUtils;
import br.com.sirius.gerador.repository.GeradorLicencaRepository;
import br.com.sirius.gerador.repository.entity.GeradorLicenca;

@Service
public class GeradorLicencaService {

	@Autowired
	private GeradorLicencaRepository repository;

	public GeradorLicenca gerarTokenLicenca(GeradorLicenca entity) throws BusinessException {
		String nomeEmpresa = createEmpresa(entity);
		String codigoEmpresa = createCodigoEmpresa(entity);
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

		return entity;
	}

	public String createDataFinal(GeradorLicenca entity, Calendar dataCorrente) {
		CalendarUtils.setLastHourInCalendar(dataCorrente);
		dataCorrente.add(Calendar.DATE, entity.getQtdeDiaLicenca());
		return "Data Final Licença&" + CalendarUtilsFormatter.format(dataCorrente, "dd/MM/yyyy HH:mm:ss");
	}

	public String createDataInicial(Calendar dataCorrente) {
		return "Data Inicial Licença&" + CalendarUtilsFormatter.format(dataCorrente, "dd/MM/yyyy HH:mm:ss");
	}

	public String createDataGeracao() {
		return "Data Geração&" + CalendarUtilsFormatter.format(Calendar.getInstance(), "dd/MM/yyyy HH:mm:ss");
	}

	public String createDigitoCnpj(String cnpjEmpresa) throws BusinessException {
		if (cnpjEmpresa != null && !cnpjEmpresa.equals("")) {
			return cnpjEmpresa.split("-")[1];
		} else {
			throw new BusinessException(BusinessException.MSG_CNPJ_EMPRESA);
		}
	}

	public String createOrganizacaoEmpresarial(GeradorLicenca entity) throws BusinessException {
		if (entity.getIdOrganizacao() != null && !entity.getIdOrganizacao().equals("")) {
			return "Código Organizacao Empresarial Cliente&" + entity.getIdOrganizacao();
		} else {
			throw new BusinessException(BusinessException.MSG_ID_ORGANIZACAO_EMPRESARIAL);
		}
	}

	public String createCnpjEmpresa(GeradorLicenca entity) throws BusinessException {
		if (entity.getCnpjEmpresa() != null && !entity.getCnpjEmpresa().equals("")) {
			return "Cnpj Empresa&" + entity.getCnpjEmpresa();
		} else {
			throw new BusinessException(BusinessException.MSG_CNPJ_EMPRESA);
		}
	}

	public String createCodigoEmpresa(GeradorLicenca entity) throws BusinessException {
		if (entity.getIdEmpresa() != null && !entity.getIdEmpresa().equals("")) {
			return "Código Empresa&" + entity.getIdEmpresa();
		} else {
			throw new BusinessException(BusinessException.MSG_ID_EMPRESA);
		}
	}

	public String createEmpresa(GeradorLicenca entity) throws BusinessException {
		if (entity.getEmpresa() != null && !entity.getEmpresa().equals("")) {
			return "Empresa&" + entity.getEmpresa();
		} else {
			throw new BusinessException(BusinessException.MSG_NOME_EMPRESA);
		}
	}

	public String createContraSenha(GeradorLicenca entity) throws BusinessException {
		if (entity.getIdEmpresa() != null && !entity.getIdEmpresa().equals("")) {
			if (entity.getIdOrganizacao() != null && !entity.getIdOrganizacao().equals("")) {
				if (entity.getCnpjEmpresa() != null && !entity.getCnpjEmpresa().equals("")) {
					Long result = (NumberUtils.toLong(entity.getIdEmpresa())
							+ NumberUtils.toLong(entity.getIdOrganizacao())
							+ NumberUtils.toLong(createDigitoCnpj(entity.getCnpjEmpresa()))) * 10;
					return "Contra Senha&" + PasswordUtils.encrip(result.toString());
				} else {
					throw new BusinessException(BusinessException.MSG_CNPJ_EMPRESA);
				}
			} else {
				throw new BusinessException(BusinessException.MSG_ID_ORGANIZACAO_EMPRESARIAL);
			}
		} else {
			throw new BusinessException(BusinessException.MSG_ID_EMPRESA);
		}
	}

	public String createTokenLicenca(String nomeEmpresa, String codigoEmpresa, String cnpjEmpresa,
			String codigoOrganizacaoEmpresarial, String dataGeracao, String dataInicialLicenca, String dataFinalLicenca,
			String contraSenhaGeracaoLicenca) {
		String token = PasswordUtils.encrip(nomeEmpresa + ";" + dataGeracao + ";" + dataInicialLicenca + ";"
				+ dataFinalLicenca + ";" + codigoEmpresa + ";" + codigoOrganizacaoEmpresarial + ";" + cnpjEmpresa + ";"
				+ contraSenhaGeracaoLicenca);
		return token;
	}
}