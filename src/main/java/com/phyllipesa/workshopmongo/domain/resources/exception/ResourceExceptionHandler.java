package com.phyllipesa.workshopmongo.domain.resources.exception;

import com.phyllipesa.workshopmongo.domain.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Classe responsável por lidar com exceções globais na aplicação.
 */
@ControllerAdvice
public class ResourceExceptionHandler {

  /**
   * Manipula a exceção do tipo ObjectNotFoundException.
   *
   * @param e       Exceção lançada quando um objeto não é encontrado.
   * @param request Objeto HttpServletRequest representando a requisição HTTP.
   * @return Resposta ResponseEntity contendo um objeto StandardError e o status HTTP correspondente.
   */
  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardError err = new StandardError(
        System.currentTimeMillis(),
        status.value(),
        "Não encontrado",
        e.getMessage(),
        request.getRequestURI()
    );

    return ResponseEntity.status(status).body(err);
  }
}
