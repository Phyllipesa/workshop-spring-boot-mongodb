package com.phyllipesa.workshopmongo.domain.services.exception;

/**
 * Exceção lançada quando um objeto não é encontrado.
 */
public class ObjectNotFoundException extends RuntimeException {

  /**
   * Construtor que aceita uma mensagem de erro.
   *
   * @param msg Mensagem de erro explicando a razão da exceção.
   */
  public ObjectNotFoundException (String msg) {
    super(msg);
  }
}
