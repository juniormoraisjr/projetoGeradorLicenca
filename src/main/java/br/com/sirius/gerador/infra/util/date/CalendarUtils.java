package br.com.sirius.gerador.infra.util.date;

import java.util.Calendar;
import java.util.Date;

/**
 * Classe utilitária utilizada para realizar a manipulação das datas
 * 
 * @author José Ribeiro de Morais Junior (junior.morais@yahoo.com.br)
 * 
 * @since 23/02/2012
 */
public final class CalendarUtils {

	/**
	 * Construtor
	 */
	private CalendarUtils() {

	}

	/**
	 * Cria um calendar com o horário 00:00:00
	 * 
	 * @param calendar
	 *            - calendar a ser setados os valores
	 * 
	 * @return Calendar com as horas zeradas
	 */
	public static Calendar setZeroHourInCalendar(final Calendar calendar) {
		Calendar newCalendar = (Calendar) calendar.clone();
		newCalendar.set(Calendar.HOUR, 0);
		newCalendar.set(Calendar.MINUTE, 0);
		newCalendar.set(Calendar.SECOND, 0);

		return newCalendar;
	}

	/**
	 * Cria um calendar com o horário 00:00:00
	 * 
	 * @param calendar
	 *            - calendar a ser setados os valores
	 * 
	 * @return Calendar com as horas zeradas
	 */
	public static Calendar setZeroAllHourInCalendar(final Calendar calendar) {
		Calendar newCalendar = (Calendar) calendar.clone();
		newCalendar.set(Calendar.HOUR, 0);
		newCalendar.set(Calendar.MINUTE, 0);
		newCalendar.set(Calendar.SECOND, 0);
		newCalendar.set(Calendar.MILLISECOND, 0);
		newCalendar.set(Calendar.HOUR_OF_DAY, 0);
		newCalendar.set(Calendar.AM_PM, 0);

		return newCalendar;
	}

	/**
	 * Cria um calendar com o horário 00:00:00
	 * 
	 * @param date
	 *            - data a ser setados os valores
	 * 
	 * @return Calendar com as horas limites de um dia
	 */
	@SuppressWarnings("deprecation")
	public static Calendar setZeroAllHourInCalendar(final Date date) {
		final int hora = 0;
		final int minuto = 0;
		final int segundo = 0;
		date.setHours(hora);
		date.setMinutes(minuto);
		date.setSeconds(segundo);

		return CalendarUtilsParse.toCalendar(date);
	}

	/**
	 * Cria um calendar com o horário 23:59:59
	 * 
	 * @param calendar
	 *            - calendar a ser setados os valores
	 * 
	 * @return Calendar com as horas limites de um dia
	 */
	public static Calendar setLastHourInCalendar(final Calendar calendar) {
		Calendar newCalendar = (Calendar) calendar.clone();

		final int hora = 23;
		final int minuto = 59;
		final int segundo = 59;
		newCalendar.set(Calendar.HOUR, hora);
		newCalendar.set(Calendar.MINUTE, minuto);
		newCalendar.set(Calendar.SECOND, segundo);

		return newCalendar;
	}

	/**
	 * Cria um calendar com o horário 23:59:59
	 * 
	 * @param date
	 *            - data a ser setados os valores
	 * 
	 * @return Calendar com as horas limites de um dia
	 */
	@SuppressWarnings("deprecation")
	public static Calendar setLastHourInCalendar(final Date date) {
		final int hora = 23;
		final int minuto = 59;
		final int segundo = 59;
		date.setHours(hora);
		date.setMinutes(minuto);
		date.setSeconds(segundo);

		return CalendarUtilsParse.toCalendar(date);
	}

	/**
	 * Cria um calendar com o horário 11:59:59 AM e PM
	 * 
	 * @param calendar
	 *            - calendar a ser setados os valores
	 * 
	 * @return Calendar com as horas limites de um dia utilizando AM e PM
	 */
	public static Calendar setLastHourInCalendarAmPm(final Calendar calendar) {
		Calendar newCalendar = (Calendar) calendar.clone();

		final int hora = 11;
		final int minuto = 59;
		final int segundo = 59;
		newCalendar.set(Calendar.HOUR, hora);
		newCalendar.set(Calendar.MINUTE, minuto);
		newCalendar.set(Calendar.SECOND, segundo);

		return newCalendar;
	}

	/**
	 * Cria um calendar com o horário 00:00:00
	 * 
	 * @param calendar
	 *            - calendar a ser setados os valores
	 * 
	 * @return Calendar com as horas zeradas
	 */
	public static Calendar setZeroHourInCalendar(final String calendar) {
		Calendar newCalendar = CalendarUtilsParse.toCalendar(calendar);
		return setZeroHourInCalendar(newCalendar);
	}

	/**
	 * Cria um calendar com o horário 23:59:59
	 * 
	 * @param calendar
	 *            - calendar a ser setados os valores
	 * 
	 * @return Calendar com as horas limites de um dia
	 */
	public static Calendar setLastHourInCalendar(final String calendar) {
		Calendar newCalendar = CalendarUtilsParse.toCalendar(calendar);
		return setLastHourInCalendar(newCalendar);
	}

	/**
	 * Obtém uma determinada data anterior conforme número de dias informados
	 * 
	 * @return Data
	 */
	public static Date getCurrentDateSubtractDays(int numberDays) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -numberDays);
		return c.getTime();
	}

	/**
	 * Obtém uma determinada data anterior conforme número de dias informados
	 * 
	 * @return Data
	 */
	public static Date getCurrentDateSubtractDaysZeroAllHour(int numberDays) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -numberDays);
		c = setZeroAllHourInCalendar(c);
		return c.getTime();
	}

	/**
	 * Obtém uma determinada data anterior conforme número de dias informados
	 * 
	 * @return Data
	 */
	public static Date getCurrentDateSubtractDaysLastAllHour(int numberDays) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -numberDays);
		c = setLastHourInCalendar(c);
		return c.getTime();
	}

	/**
	 * Obtém Mes/Ano atual
	 * 
	 * @return Data com Mes/Ano atual
	 */
	public static Date getCurrentMonthAndYear() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

	/**
	 * Obtém o ano da data corrente
	 * 
	 * @return Ano atual
	 */
	public static int getCurrentYear() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.YEAR);
	}

	/**
	 * Obtém a diferença de dias entre duas datas
	 * 
	 * @param dateOne
	 *            - data inicial
	 * @param dateTwo
	 *            - data final
	 * 
	 * @return Diferença de dias entre as datas
	 */
	public static int diffInDays(Calendar dateOne, Calendar dateTwo) {
		final int MILLIS_IN_DAY = 86400000;

		dateOne.set(Calendar.MILLISECOND, 0);
		dateOne.set(Calendar.SECOND, 0);
		dateOne.set(Calendar.MINUTE, 0);
		dateOne.set(Calendar.HOUR_OF_DAY, 0);

		dateTwo.set(Calendar.MILLISECOND, 0);
		dateTwo.set(Calendar.SECOND, 0);
		dateTwo.set(Calendar.MINUTE, 0);
		dateTwo.set(Calendar.HOUR_OF_DAY, 0);

		return (int) ((dateOne.getTimeInMillis() - dateTwo.getTimeInMillis()) / MILLIS_IN_DAY);
	}

	/**
	 * Obtém a diferença de horas entre duas datas
	 * 
	 * @param dateOne
	 *            - data inicial
	 * @param dateTwo
	 *            - data final
	 * 
	 * @return Diferença de horas entre as datas
	 */
	public static int diffInHours(Calendar dateOne, Calendar dateTwo) {
		return (int) ((dateTwo.getTimeInMillis() - dateOne.getTimeInMillis()) / 1000 / 3600);
	}

	/**
	 * Obtém a diferença de horas entre duas datas
	 * 
	 * @param dateOne
	 *            - data inicial
	 * @param dateTwo
	 *            - data final
	 * 
	 * @return Diferença de horas entre as datas
	 */
	public static double diffInHoursDecimal(Calendar dateOne, Calendar dateTwo) {
		return (dateTwo.getTime().getTime() - dateOne.getTime().getTime()) / (double) (1000 * 3600);
	}

	/**
	 * Obtém a diferença de minutos entre duas datas
	 * 
	 * @param dateOne
	 *            - data inicial
	 * @param dateTwo
	 *            - data final
	 * 
	 * @return Diferença de horas entre as datas
	 */
	public static int diffInMinutes(Calendar dateOne, Calendar dateTwo) {
		return (int) ((dateTwo.getTimeInMillis() - dateOne.getTimeInMillis()) / 1000 / 60);
	}

	/**
	 * Obtém a diferença de meses entre duas datas
	 * 
	 * @param dateOne
	 *            - data inicial
	 * @param dateTwo
	 *            - data final
	 * 
	 * @return Diferença de horas entre as datas
	 */
	public static int diffInMonth(Calendar dateOne, Calendar dateTwo) {
		int difMes = dateTwo.get(Calendar.MONTH) - dateOne.get(Calendar.MONTH);
		int difAno = ((dateTwo.get(Calendar.YEAR) - dateOne.get(Calendar.YEAR)) * 12);
		return (int) (difAno + difMes);
	}

	/**
	 * Obtém a data que representa o primeiro dia do ano
	 * 
	 * @param year
	 *            ano
	 * 
	 * @return Primeiro dia do ano passado
	 */
	public static Date getYearBegin(int year) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_YEAR, 1);
		c.set(Calendar.YEAR, year);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);

		return c.getTime();
	}

	/**
	 * Obtém o ultimo dia do ano informado
	 * 
	 * @param year
	 *            Ano
	 * 
	 * @return Ultimo dia do ano informado
	 */
	public static Date getYearEnd(int year) {
		Calendar c = Calendar.getInstance();
		final int dia = 31;
		final int hora = 23;
		final int minuto = 59;
		final int segundo = 59;
		c.set(Calendar.DAY_OF_MONTH, dia);
		c.set(Calendar.MONTH, Calendar.DECEMBER);
		c.set(Calendar.YEAR, year);
		c.set(Calendar.HOUR_OF_DAY, hora);
		c.set(Calendar.MINUTE, minuto);
		c.set(Calendar.SECOND, segundo);
		return c.getTime();
	}

	/**
	 * Seta a data corrente com o primeiro dia do Mês
	 * 
	 * @return Nova Data
	 */
	public static Calendar setOneDay() {
		Calendar newData = Calendar.getInstance();
		newData.set(Calendar.DATE, 1);
		return newData;
	}

	/**
	 * Seta o primeiro dia conforme Data informado
	 * 
	 * @return Nova Data
	 */
	public static Calendar setOneDay(Calendar date) {
		Calendar newData = (Calendar) date.clone();
		newData.set(Calendar.DATE, 1);
		return newData;
	}

	/**
	 * Seta o último dia conforme Data informado
	 * 
	 * @return Nova Data
	 */
	public static Calendar setLastDay(Calendar date) {
		Calendar newData = (Calendar) date.clone();
		newData.set(Calendar.DATE, newData.getActualMaximum(Calendar.DAY_OF_MONTH));
		return newData;
	}

	/**
	 * Adicionar meses em uma determinada Data
	 * 
	 * @param date
	 *            - data a ser alterada
	 * @param value
	 *            - quantidade de meses
	 * 
	 * @return Nova Data
	 */
	public static Calendar addMonth(Calendar date, int value) {
		Calendar newData = (Calendar) date.clone();
		int beforeMonth = newData.get(Calendar.MONTH) + value;

		if (beforeMonth > 12) {
			newData = addYear(newData, 1);
			newData.set(Calendar.MONTH, newData.get(Calendar.MONTH) + (0 + value));
		} else {
			newData.set(Calendar.MONTH, newData.get(Calendar.MONTH) + value);
		}

		return newData;
	}

	/**
	 * Adicionar anos em uma determinada Data
	 * 
	 * @param date
	 *            - data a ser alterada
	 * @param value
	 *            - quantidade de anos
	 * 
	 * @return Nova Data
	 */
	public static Calendar addYear(Calendar date, int value) {
		Calendar newData = (Calendar) date.clone();
		newData.set(Calendar.YEAR, newData.get(Calendar.YEAR) + value);
		return newData;
	}

	/**
	 * Remove meses em uma determinada Data
	 * 
	 * @param date
	 *            - data a ser alterada
	 * @param value
	 *            - quantidade de meses
	 * 
	 * @return Nova Data
	 */
	public static Calendar removeMonth(Calendar date, int value) {
		Calendar newData = (Calendar) date.clone();
		int beforeMonth = newData.get(Calendar.MONTH) - value;

		if (beforeMonth < 0) {
			newData = removeYear(newData, 1);
			newData.set(Calendar.MONTH, newData.get(Calendar.MONTH) + (12 - value));
		} else {
			newData.set(Calendar.MONTH, newData.get(Calendar.MONTH) - value);
		}

		return newData;
	}

	/**
	 * Remove anos em uma determinada Data
	 * 
	 * @param date
	 *            - data a ser alterada
	 * @param value
	 *            - quantidade de anos
	 * 
	 * @return Nova Data
	 */
	public static Calendar removeYear(Calendar date, int value) {
		Calendar newData = (Calendar) date.clone();
		newData.set(Calendar.YEAR, newData.get(Calendar.YEAR) - value);
		return newData;
	}
}