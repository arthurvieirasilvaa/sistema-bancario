package br.com.arthur.banco.domain.model;

import br.com.arthur.banco.domain.exception.SaldoInsuficienteException;

import java.time.LocalDate;
import java.time.ZoneId;

public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(String numero, String agencia, double saldo, Cliente cliente, double limite) {
        super(numero, agencia, saldo, cliente);
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        verificaValor(valor);

        if(valor > this.limite + this.saldo) {
            throw new SaldoInsuficienteException("O valor fornecido para sacar é maior do que o permitido!");
        }

        this.saldo -= valor;
        this.transacoes.add(new Transacao("Saque Conta Corrente", valor, LocalDate.now(ZoneId.of("America/Sao_Paulo"))));
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}