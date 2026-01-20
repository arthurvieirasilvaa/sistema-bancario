package br.com.arthur.banco.domain.model;

import br.com.arthur.banco.domain.exception.SaldoInsuficienteException;

public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(String numero, String agencia, Cliente cliente, double limite) {
        super(numero, agencia, cliente);

        if(limite < 0) {
            throw new IllegalArgumentException("O limite não pode ser negativo!");
        }
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        verificaValor(valor);

        if(valor > this.limite + this.saldo) {
            throw new SaldoInsuficienteException("O valor fornecido para sacar é maior do que o permitido!");
        }

        this.saldo -= valor;
        registrarTransacao(TipoTransacao.SAQUE, valor);
    }

    public double getLimite() {
        return limite;
    }
}