package br.com.sirius.gerador.repository.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class GeradorLicenca {

	@Id
	private String id;

	private String urlSistema;

	private String empresa;

	private String idEmpresa;

	private String cnpjEmpresa;

	private String idOrganizacao;

	private Integer qtdeDiaLicenca;

	private String token;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the urlSistema
	 */
	public String getUrlSistema() {
		return urlSistema;
	}

	/**
	 * @param urlSistema
	 *            the urlSistema to set
	 */
	public void setUrlSistema(String urlSistema) {
		this.urlSistema = urlSistema;
	}

	/**
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa
	 *            the empresa to set
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return the idEmpresa
	 */
	public String getIdEmpresa() {
		return idEmpresa;
	}

	/**
	 * @param idEmpresa
	 *            the idEmpresa to set
	 */
	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	/**
	 * @return the cnpjEmpresa
	 */
	public String getCnpjEmpresa() {
		return cnpjEmpresa;
	}

	/**
	 * @param cnpjEmpresa
	 *            the cnpjEmpresa to set
	 */
	public void setCnpjEmpresa(String cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}

	/**
	 * @return the idOrganizacao
	 */
	public String getIdOrganizacao() {
		return idOrganizacao;
	}

	/**
	 * @param idOrganizacao
	 *            the idOrganizacao to set
	 */
	public void setIdOrganizacao(String idOrganizacao) {
		this.idOrganizacao = idOrganizacao;
	}

	/**
	 * @return the qtdeDiaLicenca
	 */
	public Integer getQtdeDiaLicenca() {
		return qtdeDiaLicenca;
	}

	/**
	 * @param qtdeDiaLicenca
	 *            the qtdeDiaLicenca to set
	 */
	public void setQtdeDiaLicenca(Integer qtdeDiaLicenca) {
		this.qtdeDiaLicenca = qtdeDiaLicenca;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
}