package br.com.arthur.banco.domain.exception;

public class ClienteInexistenteException extends RuntimeException {
    public ClienteInexistenteException(String message) {
        super(message);
    }
}
