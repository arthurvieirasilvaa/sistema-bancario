package br.com.arthur.banco.domain.exception;

public class CpfDuplicadoException extends RuntimeException {
    public CpfDuplicadoException(String message) {
        super(message);
    }
}
