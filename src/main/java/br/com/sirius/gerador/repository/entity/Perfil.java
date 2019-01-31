package br.com.sirius.gerador.repository.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Document
public class Perfil implements GrantedAuthority {

	/** serialVersionUID */
	private static final long serialVersionUID = 9101017665296348948L;

	private String id;

	private String nome;

	public Perfil() {

	}

	public Perfil(String nome) {
		this.nome = nome;
	}

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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAuthority() {
		return this.getNome();
	}
}