package br.com.arthur.banco.domain.exception;

public class ContaInexistenteException extends RuntimeException {
    public ContaInexistenteException(String message) {
        super(message);
    }
}
