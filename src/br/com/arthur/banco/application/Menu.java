package br.com.arthur.banco.application;

import br.com.arthur.banco.service.ContaService;

public class Menu {
    private ContaService contaService;
    private UI ui;

    public Menu(ContaService contaService, UI ui) {
        this.contaService = contaService;
        this.ui = ui;
    }

    public void executar() {
        boolean executando = true;

        while(executando) {
            ui.exibirMenu();
            short opcao = ui.lerOpcao();

            switch(opcao) {
                case 1:
                    ui.cadastrarCliente();
                    break;
                case 2:
                    ui.visualizarDadosCliente();
                    break;
                case 3:
                    ui.criarContaCorrente();
                    break;
                case 4:
                    ui.criarContaPoupanca();
                    break;
                case 5:
                    ui.depositar();
                    break;
                case 6:
                    ui.sacar();
                    break;
                case 7:
                    ui.realizarTransferencia();
                    break;
                case 8:
                    ui.consultarSado();
                    break;
                case 9:
                    ui.visualizarExtrato();
                    break;
                case 0:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
