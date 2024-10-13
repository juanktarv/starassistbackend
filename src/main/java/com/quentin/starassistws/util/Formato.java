package com.quentin.starassistws.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
public abstract class Formato {

	public static String fechaHoyFormat() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static String fechaHoyDD_MM_YYYY() {
		String fecha = fechaHoyYYYYMMDD();
		fecha = fechaDDMMYYY(fecha);
		return fecha;
	}

	public static String fechaHoyYYYYMMDD() {
		StringBuilder sb = new StringBuilder();
		Calendar c = Calendar.getInstance();
		sb.append(c.get(Calendar.YEAR));
		sb.append(c.get(Calendar.MONTH) < 9 ? "0" + (c.get(Calendar.MONTH) + 1)
				: c.get(Calendar.MONTH) + 1);
		sb.append(c.get(Calendar.DAY_OF_MONTH) < 10 ? "0"
				+ c.get(Calendar.DAY_OF_MONTH) : c.get(Calendar.DAY_OF_MONTH));

		return sb.toString();

	}

	public static String fechaDDMMYYY(String cadena) {

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = null;
		try {
			fecha = dateFormat.parse(cadena);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return formato.format(fecha).toString();
	}

	private static String calendarToString(Calendar c, int format) {
		DecimalFormat dformat = new DecimalFormat("00");
		DecimalFormat yformat = new DecimalFormat("0000");
		StringBuffer sb = new StringBuffer();
		sb.append(dformat.format(c.get(5)));
		sb.append("/");
		sb.append(dformat.format(c.get(2) + 1));
		sb.append("/");
		sb.append(yformat.format(c.get(1)));
		if (format == 1) {
			sb.append(" ");
			sb.append(dformat.format(c.get(11)));
			sb.append(":");
			sb.append(dformat.format(c.get(12)));
			sb.append(":");
			sb.append(dformat.format(c.get(13)));
		}
		return sb.toString();
	}

	public static String dateToString(Date d) {
		if (d == null) {
			return "00/00/0000";
		} else {
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			return calendarToString(cal, 0);
		}
	}

	public static String fechaStringDDMMYYYYConGuion(String fecha) {
		String[] date = fecha.split("-");
		String fechaNew = date[2] + "/" + date[1] + "/" + date[0];
		return fechaNew;
	}

	public static String fechaStringDDMMYYYYConGuionLarge(String fecha) {
		fecha = fecha.substring(0, 10);
		String[] date = fecha.split("-");
		String fechaNew = date[2] + "/" + date[1] + "/" + date[0];
		return fechaNew;
	}

	/**
	 * rellenaIzquierda
	 * 
	 * @param cadena
	 * @param relleno
	 * @param longitud
	 * @return
	 */
	public static String rellenaIzquierda(String cadena, char relleno, int longitud) {
		if (cadena == null) {
			return null;
		}
		if (cadena.length() >= longitud) {
			return cadena;
		}
		StringBuffer resultado = new StringBuffer();
		int pad = longitud - cadena.length();
		for (int i = 1; i <= pad; i++) {
			resultado.append(relleno);
		}
		resultado.append(cadena);
		return resultado.toString();
	}

	/**
	 * rellenaDerecha
	 * 
	 * @param cadena
	 * @param relleno
	 * @param longitud
	 * @return
	 */
	public static String rellenaDerecha(String cadena, char relleno,int longitud) {
		if (cadena == null) {
			return null;
		}
		if (cadena.length() >= longitud) {
			return cadena;
		}
		StringBuffer resultado = new StringBuffer();
		resultado.append(cadena);
		int pad = longitud - cadena.length();
		for (int i = 1; i <= pad; i++) {
			resultado.append(relleno);
		}
		return resultado.toString();
	}
	public static String fechaStringYYYYDDMM(Date fecha ){
	 	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 	String date = null;
	 	date = dateFormat.format(fecha);
	    return date;
	    
 	}
	public static String fechaStringDDMMYYHHMMSS(Date fecha ){
	 	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	 	String date = null;
	 	date = dateFormat.format(fecha);
	    return date;
	    
 }
	
	
	 public static String fechaHoyFormat_ConGuion() {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		 Date date = new Date();

		 return dateFormat.format(date);
		 }
	 
	 public static java.sql.Date  fechaStringADate(String fechaString) {
		 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 Date date= null;
		 java.sql.Date sqlDate = null;
		try {
			date = dateFormat.parse(fechaString);
			 sqlDate = new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return sqlDate;
		 
	 }
	 


	 
	 
	public static void main(String[] args) {
		String fechaHoy = fechaHoyFormat();
//		String fechaHoy2 = fechaHoyDD_MM_YYYY();
//		// String fechaStringAux = "2017-04-10" ;
		String fechaStringLargo = "2017-04-10 00:00:00.0";
//		fechaStringLargo = fechaStringLargo.substring(0, 10);

	}
}