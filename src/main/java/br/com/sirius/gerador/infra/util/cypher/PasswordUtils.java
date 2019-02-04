package br.com.sirius.gerador.infra.util.cypher;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;

import sun.misc.BASE64Encoder;

/**
 * Classe utilitária responsável por realizar a criptografia e descriptografia
 * de um valor
 * 
 * @author José Ribeiro de Morais Junior (junior.morais@yahoo.com.br)
 * 
 * @since 12/06/2012
 * 
 * @version 1.0
 */
public final class PasswordUtils {

	/** Logger **/
	private static Logger logger = Logger.getLogger(PasswordUtils.class);

	/**
	 * Construtor
	 */
	private PasswordUtils() {

	}

	/**
	 * Encriptografa uma determinada senha
	 * 
	 * @param value
	 *            - valor que será encriptografado
	 * 
	 * @return Valor encriptografado
	 */
	public static String encrip(String value) {
		try {
			// Codifica a String usando UTF-8
			byte[] utf8 = value.getBytes("UTF-8");
			BASE64Encoder base = new BASE64Encoder();

			// Codifica os bytes usando Base64
			return base.encode(utf8);
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
		}

		return null;
	}

	/**
	 * Encriptografa uma determinada senha
	 * 
	 * @param value
	 *            - valor que será encriptografado
	 * 
	 * @return Valor encriptografado
	 */
	public static String encrip(Long value) {
		return encrip(value.toString());
	}

	/**
	 * Descriptografa uma determinada senha
	 * 
	 * @param value
	 *            - valor que será descriptografado
	 * 
	 * @return Valor descriptografado
	 */
	public static String descrip(String value) {
		try {
			if (value != null) {
				// Decodifica na base64 os bytes capturados
				byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(value);

				// Decodifica usando UTF-8
				return new String(dec, "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
		} catch (java.io.IOException e) {
			logger.error(e);
		}

		return null;
	}

	/**
	 * Gerador de contra senha conformor parâmetros informados
	 * 
	 * @param value
	 *            - valor que será encritografado
	 * 
	 * @return Valor descriptografado
	 */
	public static String generateAgainstPassword(Long value, Long mult) {
		Long generate = (value * mult);

		return encrip(generate.toString());
	}
}