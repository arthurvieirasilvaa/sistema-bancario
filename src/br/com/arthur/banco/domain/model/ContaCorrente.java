package br.com.arthur.banco.domain.model;

import br.com.arthur.banco.domain.exception.SaldoInsuficienteException;

public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(String numero, String agencia, double saldo, Cliente cliente) {
        super(numero, agencia, saldo, cliente);
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        verificaValor(valor);

        if(valor > this.limite + this.saldo) {
            throw new SaldoInsuficienteException("O valor fornecido para sacar é maior do que o permitido!");
        }

        saldo -= valor;
    }
}