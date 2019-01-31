package br.com.sirius.gerador.infra.util.number;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.apache.log4j.Logger;

/**
 * Classe utilitária com operações de manipulação de valores numéricos
 * 
 * @author José Ribeiro de Morais Junior (junior.morais@yahoo.com.br)
 * 
 * @since 23/02/2012
 */
public final class NumberUtils {

	/** Logger **/
	private static Logger logger = Logger.getLogger(NumberUtils.class);

	/**
	 * Construtor
	 */
	private NumberUtils() {

	}

	/**
	 * Convete uma string, mantendo apenas caracteres numéricos
	 * 
	 * @param value
	 *            texto a ser convertido
	 * 
	 * @return Texto apenas com os números
	 */
	public static String onlyNumber(String value) {
		StringBuffer result = new StringBuffer();

		for (int i = 0; i < value.length(); i++) {
			if (Character.isDigit(value.charAt(i))) {
				result.append(value.charAt(i));
			}
		}

		return result.toString();
	}

	/**
	 * Verifica se a strin só possui números
	 * 
	 * @param value
	 *            texto a ser convertido
	 * 
	 * @return true ou false
	 */
	public static boolean isNumber(String value) {
		if (isEmpty(value)) {
			return false;
		} else {
			for (int i = 0; i < value.length(); i++) {
				if (!Character.isDigit(value.charAt(i))) {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * Verifica se a string só possui números e ponto
	 * 
	 * @param value
	 *            texto a ser convertido
	 * 
	 * @return true ou false
	 */
	public static boolean isFinancialNumber(String value) {
		if (isEmpty(value)) {
			return false;
		} else {
			for (int i = 0; i < value.length(); i++) {
				if (!Character.isDigit(value.charAt(i)) && value.charAt(i) != ('.')) {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * Verifica se a strin só possui números
	 * 
	 * @param value
	 *            texto a ser convertido
	 * 
	 * @return true ou false
	 */
	public static boolean isNumber(Long value) {
		if (isEmpty(value)) {
			return false;
		} else {
			return isNumber(value.toString());
		}
	}

	/**
	 * Verifica se um valor é igual a nulo
	 * 
	 * @param value
	 *            - valor a ser validado
	 * 
	 * @return true ou false
	 */
	public static boolean isEmpty(Object value) {
		return value == null;
	}

	/**
	 * Verifica se um valor é igual a nulo ou vazio
	 * 
	 * @param value
	 *            - valor a ser validado
	 * 
	 * @return true ou false
	 */
	public static boolean isEmpty(String value) {
		return value == null || value.trim().equals("");
	}

	/**
	 * Completa o conteúdo da string com o filler informados a esquerda
	 * 
	 * @param str
	 *            string
	 * @param fill
	 *            caracter de filler
	 * @param qtd
	 *            quantidade
	 * 
	 * @return string formatada
	 */
	public static String fill(String str, char fill, Integer qtd) {
		StringBuilder sb = new StringBuilder();

		if (str != null) {
			if (str.length() > qtd) {
				sb.append(str.substring(0, qtd));
			} else {
				int restantes = qtd - str.length();

				for (int i = 0; i < restantes; i++) {
					sb.append(fill);
				}
				sb.append(str);
			}
		}

		return sb.toString();
	}

	/**
	 * Formata um determinado valor para uma quantidade de dígitos (Monetário)
	 * 
	 * @param valor
	 *            - valor a ser formatado
	 * @param digits
	 *            - quantidade de dígitos
	 * 
	 * @return Valor formatado
	 */
	public static String format(String valor, int digits) {
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
		numberFormat.setMaximumFractionDigits(digits);
		numberFormat.setMinimumFractionDigits(digits);
		numberFormat.setRoundingMode(RoundingMode.HALF_DOWN);

		return numberFormat.format(new Double(valor));
	}

	/**
	 * Formata um determinado valor para uma quantidade de dígitos (Decimal)
	 * 
	 * @param valor
	 *            - valor a ser formatado
	 * @param digits
	 *            - quantidade de dígitos
	 * 
	 * @return Valor formatado
	 */
	public static String formatDecimal(String valor, int digits) {
		NumberFormat numberFormat = NumberFormat.getNumberInstance();
		numberFormat.setMaximumFractionDigits(digits);
		numberFormat.setMinimumFractionDigits(digits);
		numberFormat.setRoundingMode(RoundingMode.HALF_DOWN);

		return numberFormat.format(new Double(valor.replace("R$ ", "").replace(",", ".").trim()));
	}
	
	/**
	 * Formata um determinado valor para uma quantidade de dígitos (Decimal)
	 * 
	 * @param valor
	 *            - valor a ser formatado
	 * @param digits
	 *            - quantidade de dígitos
	 * 
	 * @return Valor formatado
	 */
	public static String formatDecimal(Double valor, int digits) {
		NumberFormat numberFormat = NumberFormat.getNumberInstance();
		numberFormat.setMaximumFractionDigits(digits);
		numberFormat.setMinimumFractionDigits(digits);
		numberFormat.setRoundingMode(RoundingMode.HALF_DOWN);

		return numberFormat.format(valor);
	}

	/**
	 * Formata um determinado valor inteiro
	 * 
	 * @param valor
	 *            - valor a ser formatado
	 * @param digits
	 *            - quantidade de dígitos
	 * 
	 * @return Valor formatado
	 */
	public static String formatInteger(int valor, int digits) {
		DecimalFormat numberFormat = new DecimalFormat("###,###,##0.00");
		numberFormat.setMaximumFractionDigits(digits);

		return numberFormat.format(valor);
	}

	/**
	 * Converter um valor para numérico
	 * 
	 * @param value
	 *            - valor a ser formatado
	 * 
	 * @return Valor numérico
	 * 
	 * @throws ParseException
	 *             - exception lançada quando ocorre erro na conversão do valor
	 */
	public static BigDecimal toCurrency(String value) {
		BigDecimal currency = BigDecimal.ZERO;

		try {
			NumberFormat nf = NumberFormat.getInstance();
			nf.setGroupingUsed(true);
			nf.setMaximumFractionDigits(2);
			nf.setMinimumFractionDigits(2);
			nf.setRoundingMode(RoundingMode.HALF_DOWN);

			Number number = nf.parse(value.replace("R$ ", ""));
			currency = new BigDecimal(number.doubleValue());

			return currency;
		} catch (ParseException e) {
			logger.error(e);
		}
		return currency;
	}

	/**
	 * Converter um valor para numérico
	 * 
	 * @param value
	 *            - valor a ser formatado
	 * 
	 * @return Valor numérico
	 * 
	 * @throws ParseException
	 *             - exception lançada quando ocorre erro na conversão do valor
	 */
	public static BigDecimal toPercent(String value) {
		BigDecimal percent = BigDecimal.ZERO;

		try {
			NumberFormat nf = NumberFormat.getInstance();
			nf.setGroupingUsed(true);
			nf.setMaximumFractionDigits(2);
			nf.setMinimumFractionDigits(2);
			nf.setRoundingMode(RoundingMode.HALF_DOWN);

			Number number = nf.parse(value.replace("% ", ""));
			percent = new BigDecimal(number.doubleValue());

			return percent;
		} catch (ParseException e) {
			logger.error(e);
		}
		return percent;
	}

	/**
	 * Formata o valor BigDecimal em valor monetário no padrão Brasileiro
	 * 
	 * @param value
	 *            valor a ser convertido
	 * 
	 * @return Valor formatado
	 */
	public static String toCurrency(BigDecimal value) {
		Locale locale = new Locale("pt", "BR");
		NumberFormat formatter = DecimalFormat.getCurrencyInstance(locale);
		formatter.setMinimumFractionDigits(2);
		formatter.setMaximumFractionDigits(2);
		String currency = "";

		currency = formatter.format(value);
		return currency;
	}

	/**
	 * Formata o valor BigDecimal em valor monetário no padrão Brasileiro
	 * 
	 * @param value
	 *            valor a ser convertido
	 * 
	 * @return Valor formatado
	 */
	public static String toPercent(BigDecimal value) {
		Locale locale = new Locale("pt", "BR");
		NumberFormat formatter = DecimalFormat.getNumberInstance(locale);
		formatter.setMinimumFractionDigits(2);
		formatter.setMaximumFractionDigits(2);
		String percent = "";

		percent = formatter.format(value);
		return percent;
	}

	/**
	 * Formata o valor BigDecimal em valor monetário no padrão Brasileiro com Símbolo
	 * 
	 * @param value
	 *            valor a ser convertido
	 * 
	 * @return Valor formatado
	 */
	public static String toPercentSimbolo(BigDecimal value) {
		Locale locale = new Locale("pt", "BR");
		NumberFormat formatter = DecimalFormat.getNumberInstance(locale);
		formatter.setMinimumFractionDigits(2);
		formatter.setMaximumFractionDigits(2);
		String percent = "";

		percent = "% " + formatter.format(value);
		return percent;
	}

	/**
	 * Formata o valor BigDecimal sem retornar o R$
	 * 
	 * @param BigDecimal
	 *            valor a ser convertido
	 * 
	 * @return String com o valor sem o R$. Ex.: 4.094,30
	 */
	public static String toCurrencyNoCifrao(BigDecimal value) {
		Locale locale = new Locale("pt", "BR");
		NumberFormat formatter = DecimalFormat.getCurrencyInstance(locale);
		formatter.setMinimumFractionDigits(2);
		formatter.setMaximumFractionDigits(2);
		String currency = "";
		final int inicioString = 3;

		currency = formatter.format(value);

		return currency.substring(inicioString, currency.length());
	}

	/**
	 * Converte uma String em um Double
	 * 
	 * @param value
	 *            - valor a ser convertido
	 * 
	 * @return Valor convertido
	 */
	public static double toDouble(String value) {
		double result = 0;
		result = Double.parseDouble(value);

		return result;
	}

	/**
	 * Converte uma String em um Long
	 * 
	 * @param value
	 *            - valor a ser convertido
	 * 
	 * @return Valor convertido
	 */
	public static long toLong(String value) {
		return value != null ? Long.parseLong(value) : null;
	}

	/**
	 * Converte uma String em um Integer
	 * 
	 * @param value
	 *            - valor a ser convertido
	 * 
	 * @return Valor convertido
	 */
	public static int toInteger(String value) {
		return value != null ? Integer.parseInt(value) : null;
	}

	/**
	 * Converte uma String em um Long
	 * 
	 * @param value
	 *            - valor a ser convertido
	 * 
	 * @return Valor convertido
	 */
	public static long toLong(int value) {
		return new Long(value);
	}
}