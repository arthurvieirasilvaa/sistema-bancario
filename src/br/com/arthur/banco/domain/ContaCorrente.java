package br.com.arthur.banco.domain;

public class ContaCorrente extends Conta {
    public ContaCorrente(String numero, String agencia, double saldo, Cliente cliente) {
        super(numero, agencia, saldo, cliente);
    }
}
