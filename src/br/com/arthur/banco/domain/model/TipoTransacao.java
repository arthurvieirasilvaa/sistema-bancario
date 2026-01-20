package br.com.arthur.banco.domain.model;

public enum TipoTransacao {
    DEPOSITO("Depósito"),
    SAQUE("Saque"),
    TRANSFERENCIA("Transferência"),
    RENDIMENTO_POUPANCA("Rendimento na poupança");

    private final String descricao;

    TipoTransacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}