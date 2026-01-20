package br.com.arthur.banco.domain.model;

import java.time.LocalDate;

public class Transacao {
    private final TipoTransacao tipo;
    private final double valor;
    private final LocalDate data;

    public Transacao(TipoTransacao tipo, double valor, LocalDate data) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return this.tipo.getDescricao() +
                " realizado em "+this.data+
                " no valor de R$"+this.valor;
    }
}