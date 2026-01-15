package br.com.arthur.banco.domain;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(String numero, String agencia, double saldo, Cliente cliente) {
        super(numero, agencia, saldo, cliente);
    }
}
