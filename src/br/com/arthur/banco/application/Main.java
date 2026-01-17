package br.com.arthur.banco.application;

import br.com.arthur.banco.service.ClienteService;
import br.com.arthur.banco.service.ContaService;
import br.com.arthur.banco.service.TransacaoService;

public class Main {
    public static void main(String[] args) {
        UI ui = new UI();

        ClienteService clienteService = new ClienteService();
        ContaService contaService = new ContaService();
        TransacaoService transacaoService = new TransacaoService();

        ClienteController clienteController = new ClienteController(ui, clienteService);
    }
}
