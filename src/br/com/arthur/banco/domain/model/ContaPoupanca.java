package br.com.arthur.banco.domain.model;

import br.com.arthur.banco.domain.exception.SaldoInsuficienteException;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(String numero, String agencia, double saldo, Cliente cliente) {
        super(numero, agencia, saldo, cliente);
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        verificaValor(valor);

        if(valor > saldo) {
            throw new SaldoInsuficienteException("O valor fornecido para sacar é maior do que o permitido!");
        }
    }
}