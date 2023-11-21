package com.phyllipesa.workshopmongo.domain.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Classe utilitária para manipulação de URLs e conversão de datas.
 */
public class URL {

  /**
   * Decodifica um parâmetro de texto usando a codificação UTF-8.
   *
   * @param text Texto a ser decodificado.
   * @return Texto decodificado.
   */
  public static String decodeParam(String text) {
    try {
      return URLDecoder.decode(text, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      return "";
    }
  }

  /**
   * Converte uma data representada como texto para um objeto Date.
   *
   * @param textDate      Texto que representa a data.
   * @param defaultValue  Valor padrão a ser retornado se a conversão falhar.
   * @return Objeto Date representando a data convertida ou o valor padrão em caso de falha.
   */
  public static Date convertDate(String textDate, Date defaultValue) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
    try {
      return sdf.parse(textDate);
    } catch (ParseException e) {
      return defaultValue;
    }
  }
}
