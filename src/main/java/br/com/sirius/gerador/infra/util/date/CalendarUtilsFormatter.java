package br.com.sirius.gerador.infra.util.date;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Classe utilizada para realizar a formatação de datas
 * 
 * @author José Ribeiro de Morais Junior (junior.morais@yahoo.com.br)
 * 
 * @since 23/02/2012
 */
public final class CalendarUtilsFormatter {

	/**
	 * Construtor
	 */
	private CalendarUtilsFormatter() {

	}

	/**
	 * Formata uma determinada data de acordo com o pattern
	 * 
	 * @param date
	 *            - data que será formatada
	 * 
	 * @param pattern
	 *            - pattern utilizada para formatação
	 * 
	 * @return String com a data formatada
	 */
	public static String format(Date date, String pattern) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);

			return formatter.format(date);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Formata uma determinada data de acordo com o pattern
	 * 
	 * @param date
	 *            - data que será formatada
	 * 
	 * @param pattern
	 *            - pattern utilizada para formatação
	 * 
	 * @return String com a data formatada
	 */
	public static String format(Date date, SimpleDateFormat pattern) {
		try {
			SimpleDateFormat formatter = pattern;

			return formatter.format(date);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Formata uma determinada data no padrão Brasileiro dd/MM/yyyy
	 * 
	 * @param date
	 *            - data que será formatada
	 * 
	 * @return String com a data formatada
	 */
	public static String formatBR(Date date) {
		return format(date, "dd/MM/yyyy");
	}

	/**
	 * Formata uma determinada data no padrão Brasileiro dd/MM/yyyy HH:mm:ss
	 * 
	 * @param date
	 *            - data que será formatada
	 * 
	 * @return String com a data formatada com horário
	 */
	public static String formatNowDateTimeBR() {
		return format(Calendar.getInstance(), "dd/MM/yyyy HH:mm:ss");
	}

	/**
	 * Formata uma determinada data no padrão Brasileiro dd-MM-yyyy_HH-mm-ss para ser utilizado nos nomes de relatórios
	 * 
	 * @param date
	 *            - data que será formatada
	 * 
	 * @return String com a data formatada com horário
	 */
	public static String formatNowDateTimeBRRelatorio() {
		return format(Calendar.getInstance(), "dd-MM-yyyy_HH-mm-ss");
	}

	/**
	 * Formata uma determinada data no padrão Brasileiro ddMMyyyy_HHmmss para ser utilizado nos nomes de backups
	 * 
	 * @param date
	 *            - data que será formatada
	 * 
	 * @return String com a data formatada com horário
	 */
	public static String formatNowDateTimeBRBackup() {
		return format(Calendar.getInstance(), "yyyyMMdd_HHmmss");
	}

	/**
	 * Formata um determinado calendar de acordo com o pattern
	 * 
	 * @param calendar
	 *            - data que será formatada
	 * 
	 * @param pattern
	 *            - pattern utilizada para formatação
	 * 
	 * @return String com o Calendar formatado
	 */
	public static String format(Calendar calendar, String pattern) {
		return format(calendar.getTime(), pattern);
	}

	/**
	 * Formata um determinado calendar de acordo com o pattern
	 * 
	 * @param calendar
	 *            - data que será formatada
	 * 
	 * @param pattern
	 *            - pattern utilizada para formatação
	 * 
	 * @return String com o Calendar formatado
	 */
	public static String format(Calendar calendar, SimpleDateFormat pattern) {
		return format(calendar.getTime(), pattern);
	}

	/**
	 * Formata um determinado calendar de acordo com o pattern brasileiro
	 * 
	 * @param calendar
	 *            - data que será formatada
	 * 
	 * @return String com o Calendar formatado
	 */
	public static String formatBR(Calendar calendar) {
		return calendar != null ? formatBR(calendar.getTime()) : null;
	}

	/**
	 * Formata um determinada data no formato brasileiro utilizando o pattern yyyy/MM/dd
	 * 
	 * @param date
	 *            - data que será formatada
	 * 
	 * @return String com o Calendar formatado
	 */
	public static String formatBRInverso(Date date) {
		return format(date, "yyyy/MM/dd");
	}

	/**
	 * Formata um determinada data no formato brasileiro utilizando o pattern yyyy/MM/dd
	 * 
	 * @param calendar
	 *            - data que será formatada
	 * 
	 * @return String com o Calendar formatado
	 */
	public static String formatBRInverso(Calendar calendar) {
		return formatBRInverso(calendar.getTime());
	}

	/**
	 * Formata um timestamp utilizando um determinado pattern informado
	 * 
	 * @param timestamp
	 *            - Data em Timestamp que será formatada
	 * @param pattern
	 *            - pattern utilizada para formatação
	 * 
	 * @return String formatado
	 */
	public static String format(Timestamp timestamp, String pattern) {
		return format(new Date(timestamp.getTime()), pattern);
	}

	/**
	 * Formata um timestamp utilizando o padrão brasileiro
	 * 
	 * @param timestamp
	 *            - Data em Timestamp que será formatada
	 * 
	 * @return String formatado
	 */
	public static String formatBR(Timestamp timestamp) {
		return formatBR(new Date(timestamp.getTime()));
	}

	/**
	 * Formata a atual data do sistema operacional no utilizando o formato brasileiro
	 * 
	 * @return String formatado
	 */
	public static String formatNowBR() {
		return formatBR(Calendar.getInstance());
	}

	/**
	 * Formata uma determinada data utilizando o pattern dd 'de' MMMM 'de' yyyy no padrão brasileiro
	 * 
	 * @param date
	 *            - data que será formatada
	 * 
	 * @return String formatado
	 */
	public static String formatLongBR(Date date) {
		return format(date, "dd 'de' MMMM 'de' yyyy");
	}

	/**
	 * Formata uma determinado timestamp utilizando o pattern dd 'de' MMMM 'de' yyyy no padrão brasileiro
	 * 
	 * @param timestamp
	 *            - Data em Timestamp que será formatada
	 * 
	 * @return Data formatada
	 */
	public static String formatLongBR(Timestamp timestamp) {
		return formatLongBR(new Date(timestamp.getTime()));
	}

	/**
	 * Formata uma determinado calendar utilizando o pattern dd 'de' MMMM 'de' yyyy no padrão brasileiro
	 * 
	 * @param calendar
	 *            - Data que será formatada
	 * 
	 * @return Data formatada
	 */
	public static String formatLongBR(Calendar calendar) {
		return formatLongBR(calendar.getTime());
	}

	/**
	 * Formata a atual data do sistema operacional no utilizando o formato brasileiro utilizando o pattern dd 'de' MMMM 'de' yyyy
	 * 
	 * @return Data formatada
	 */
	public static String formatLongNowBR() {
		return formatLongBR(Calendar.getInstance());
	}

	/**
	 * Formata a hora de uma determinada data utilizandoo o pattern hh:mm:ss
	 * 
	 * @param time
	 *            - data que será formatada
	 * 
	 * @return Hora formatada
	 */
	public static String formatTime(Date time) {
		return format(time, "hh:mm:ss");
	}

	/**
	 * Formata a hora de uma determinada data utilizandoo o pattern hh:mm:ss
	 * 
	 * @param time
	 *            - data que será formatada
	 * 
	 * @return Hora formatada
	 */
	public static String formatTime(Calendar time) {
		return format(time, "hh:mm:ss");
	}

	/**
	 * Formata a hora de uma determinada data utilizandoo o pattern hh:mm:ss
	 * 
	 * @param time
	 *            - data em timestamp que será formatada
	 * 
	 * @return Hora formatada
	 */
	public static String formatTime(Timestamp time) {
		return format(time, "hh:mm:ss");
	}
}