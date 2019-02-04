package br.com.sirius.gerador.infra.util.exception;

public class BusinessException extends Exception {

	/** serialVersionUID */
	private static final long serialVersionUID = -4996872884513628003L;

	public static String MSG_NOME_EMPRESA = "Nome Empresa inválida, está nula ou vazia.";

	public static String MSG_ID_EMPRESA = "Id Empresa inválido, está nulo ou vazia.";

	public static String MSG_ID_ORGANIZACAO_EMPRESARIAL = "Id Organização Empresarial inválido, está nulo ou vazia.";

	public static String MSG_CNPJ_EMPRESA = "Cnpj Empresa inválido, ele está nulo ou vazia.";

	public BusinessException(String msg) {
		super(msg);
	}
}