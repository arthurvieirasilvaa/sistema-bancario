package br.com.arthur.banco.domain.model;

import br.com.arthur.banco.domain.exception.SaldoInsuficienteException;

public class ContaPoupanca extends Conta {
    private static final double RENDIMENTO_PERCENTUAL = 0.005;

    public ContaPoupanca(String numero, String agencia, Cliente cliente) {
        super(numero, agencia, cliente);
    }

    @Override
    public void sacar(double valor) {
        verificaValor(valor);

        if(valor > this.saldo) {
            throw new SaldoInsuficienteException("O valor fornecido para sacar é maior do que o permitido!");
        }

        this.saldo -= valor;
        registrarTransacao(TipoTransacao.SAQUE, valor);
    }

    public void aplicarRendimento() {
        double rendimento = this.saldo * RENDIMENTO_PERCENTUAL;
        this.saldo += rendimento;
        registrarTransacao(TipoTransacao.RENDIMENTO_POUPANCA, rendimento);
    }
}