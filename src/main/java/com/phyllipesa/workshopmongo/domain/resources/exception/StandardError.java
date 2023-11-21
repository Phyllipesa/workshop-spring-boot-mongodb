package com.phyllipesa.workshopmongo.domain.resources.exception;

/**
 * Classe que representa uma estrutura padrão para mensagens de erro em respostas HTTP.
 */
public class StandardError {

  private Long timestamp;
  private Integer status;
  private String error;
  private String message;
  private String path;

  public StandardError() {
  }

  /**
   * Construtor para criar uma instância de StandardError com informações específicas.
   *
   * @param timestamp Horário em que o erro ocorreu.
   * @param status    Código de status HTTP representando o tipo de erro.
   * @param error     Descrição do tipo de erro.
   * @param message   Mensagem detalhada sobre o erro.
   * @param path      Caminho do URI que causou o erro.
   */
  public StandardError(Long timestamp, Integer status, String error, String message, String path) {
    this.timestamp = timestamp;
    this.status = status;
    this.error = error;
    this.message = message;
    this.path = path;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }
}
