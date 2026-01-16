package br.com.arthur.banco.domain.model;

import br.com.arthur.banco.domain.exception.SaldoInsuficienteException;

public class ContaPoupanca extends Conta {
    private static final double RENDIMENTO_PERCENTUAL = 0.5;

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

    public void aplicarRendimento() {
        this.saldo += this.saldo * RENDIMENTO_PERCENTUAL;
    }
}