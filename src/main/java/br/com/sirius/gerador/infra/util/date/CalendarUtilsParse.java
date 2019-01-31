package br.com.sirius.gerador.infra.util.date;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Classe utilitária utilizada para realizar a manipulação das datas
 * 
 * @author José Ribeiro de Morais Junior (junior.morais@yahoo.com.br)
 * 
 * @since 23/02/2012
 */
public final class CalendarUtilsParse {

	/**
	 * Construtor
	 */
	private CalendarUtilsParse() {

	}

	/**
	 * Converte uma determinada String em uma Data utilizando um determinado pattern
	 * 
	 * @param date
	 *            Valor que será convertido em data
	 * @param pattern
	 *            String com o pattern que será aplicado
	 * 
	 * @return Data convertida
	 */
	public static Date toDate(String date, String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);

		try {
			return formatter.parse(date);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Converte uma determinada String em uma Data utilizando o pattern dd/MM/yyyy
	 * 
	 * @param date
	 *            Valor que será convertido em data
	 * 
	 * @return Data convertida
	 */
	public static Date toDate(String date) {
		try {
			return toDate(date, "dd/MM/yyyy");
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Converte uma determinada Long em uma Data
	 * 
	 * @param date
	 *            Valor que será convertido em data
	 * 
	 * @return Data convertida
	 */
	public static Date toDate(Long date) {
		try {
			return new Date(date);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Converte uma determina Data em um Calendar
	 * 
	 * @param calendar
	 *            Valor que será convertido em data
	 * 
	 * @return Data convertida
	 */
	public static Date toDate(Calendar calendar) {
		try {
			return calendar.getTime();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Converte um determinado Timestamp em um Date
	 * 
	 * @param timestamp
	 *            Valor que será convertido em data
	 * 
	 * @return Data convertida
	 */
	public static Date toDate(Timestamp timestamp) {
		try {
			return new Date(timestamp.getTime());
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Converte uma determinada String em uma Data utilizando o pattern dd/MM/yyyy no padrão brasileiro
	 * 
	 * @param date
	 *            Valor que será convertido em data
	 * 
	 * @return Data convertida
	 */
	public static Date toDateBR(String date) {
		return toDate(date, "dd/MM/yyyy");
	}

	/**
	 * Converte uma determinada String em um Calendar utilizando um determinado pattern
	 * 
	 * @param date
	 *            Valor que será convertido em data
	 * @param pattern
	 *            String com o pattern que será aplicado
	 * 
	 * @return Calendar convertido
	 */
	public static Calendar toCalendar(String date, String pattern) {
		Date newDate = toDate(date, pattern);

		return toCalendar(newDate);
	}

	/**
	 * Converte uma determinada String em um Calendar
	 * 
	 * @param date
	 *            Valor que será convertido em data
	 * 
	 * @return Calendar convertido
	 */
	public static Calendar toCalendar(String date) {
		Date newDate = toDate(date);

		return toCalendar(newDate);
	}

	/**
	 * Converte uma determinada Data em um Calendar
	 * 
	 * @param date
	 *            Valor que será convertido em data
	 * 
	 * @return Calendar convertido
	 */
	public static Calendar toCalendar(Date date) {
		Calendar calendar = null;
		if (date != null) {
			calendar = Calendar.getInstance();
			calendar.setTime(date);
		}
		return calendar;
	}

	/**
	 * Converte uma determinado Timestamp em um Calendar
	 * 
	 * @param date
	 *            Valor que será convertido em data
	 * 
	 * @return Calendar convertido
	 */
	public static Calendar toCalendar(Timestamp timestamp) {
		Date newDate = toDate(timestamp);

		return toCalendar(newDate);
	}

	/**
	 * Converte uma determinado String em um Calendar utilizando o padrão brasileiro
	 * 
	 * @param date
	 *            Valor que será convertido em data
	 * 
	 * @return Calendar convertido
	 */
	public static Calendar toCalendarBR(String date) {
		return toCalendar(toDateBR(date));
	}

	/**
	 * Converte uma determinada String em um Timestamp utilizando um determinado pattern
	 * 
	 * @param date
	 *            Valor que será convertido em data
	 * @param pattern
	 *            String com o pattern que será aplicado
	 * 
	 * @return Timestamp convertido
	 */
	public static Timestamp toTimestamp(String date, String pattern) {
		Date newDate = toDate(date, pattern);

		return toTimestamp(newDate);
	}

	/**
	 * Converte uma determinada String em um Timestamp
	 * 
	 * @param timestamp
	 *            Valor que será convertido em data
	 * 
	 * @return Timestamp convertido
	 */
	public static Timestamp toTimestamp(String timestamp) {
		return Timestamp.valueOf(timestamp);
	}

	/**
	 * Converte uma determinada Data em um Timestamp
	 * 
	 * @param date
	 *            Valor que será convertido em data
	 * 
	 * @return Timestamp convertido
	 */
	public static Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	/**
	 * Converte um determinado Calendar em um Timestamp
	 * 
	 * @param calendar
	 *            Valor que será convertido em data
	 * 
	 * @return Timestamp convertido
	 */
	public static Timestamp toTimestamp(Calendar calendar) {
		Date newDate = toDate(calendar);

		return toTimestamp(newDate);
	}

	/**
	 * Converte uma determinado String em um Timestamp utilizando o padrão brasileiro
	 * 
	 * @param date
	 *            Valor que será convertido em data
	 * 
	 * @return Timestamp convertido
	 */
	public static Timestamp toTimestampBR(String date) {
		return toTimestamp(toDateBR(date));
	}
}