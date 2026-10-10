package com.github.usuarios.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {

  public EmailAlreadyExistsException() {
    super("E-mail informado está em uso");
  }

  public EmailAlreadyExistsException(String message) {
        super(message);
    }

}
