package com.github.usuarios.config.exceptions;

import com.github.usuarios.exceptions.EmailAlreadyExistsException;
import com.github.usuarios.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ProblemDetail handleGenericException(Exception exception) {
    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
        HttpStatus.INTERNAL_SERVER_ERROR,
        exception.getMessage()
    );
    problemDetail.setTitle("Erro interno do servidor");
    problemDetail.setType(URI.create("about:blank"));

    return problemDetail;
  }


  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
    problemDetail.setTitle("Erro de validação");
    problemDetail.setDetail("Um ou mais campos são inválidos");

    exception.getFieldErrors().forEach(error ->
        problemDetail.setProperty(error.getField(), error.getDefaultMessage())
    );

    return problemDetail;
  }

  @ExceptionHandler(UserNotFoundException.class)
  public ProblemDetail handleUserNotFoundException(UserNotFoundException exception) {

    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
    problemDetail.setTitle("Erro ao buscar usuário");
    problemDetail.setDetail(exception.getMessage());

    return problemDetail;
  }

  @ExceptionHandler(EmailAlreadyExistsException.class)
  public ProblemDetail handleEmailAlreadyExistsException(EmailAlreadyExistsException exception) {

    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
    problemDetail.setTitle("Erro ao criar usuário");
    problemDetail.setDetail(exception.getMessage());

    return problemDetail;
  }

}
