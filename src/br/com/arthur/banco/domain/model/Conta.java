package br.com.arthur.banco.domain.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    protected String numero;
    protected String agencia;
    protected double saldo;
    protected final Cliente cliente;
    protected List<Transacao> transacoes = new ArrayList<>();

    public Conta(String numero, String agencia, Cliente cliente) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = 0;
        this.cliente = cliente;

        this.cliente.adicionarConta(this);
    }
    
    protected void verificaValor(double valor) {
        if(valor <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior do que 0");
        }
    }

    protected void registrarTransacao(TipoTransacao tipo, double valor) {
        this.transacoes.add(new Transacao(tipo, valor, LocalDate.now(ZoneId.of("America/Sao_Paulo"))));
    }

    public void depositar(double valor) {
        verificaValor(valor);
        this.saldo += valor;
        registrarTransacao(TipoTransacao.DEPOSITO, valor);
    }

    public abstract void sacar(double valor);

    public String getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Transacao> getTransacoes() {
        return List.copyOf(this.transacoes);
    }
}
