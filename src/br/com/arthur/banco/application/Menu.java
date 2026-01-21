package br.com.arthur.banco.application;

public class Menu {
    private final UI ui;
    private final ClienteController clienteController;
    private final ContaController contaController;
    private final TransacaoController transacaoController;

    public Menu(UI ui,
                ClienteController clienteController,
                ContaController contaController,
                TransacaoController transacaoController) {
        this.ui = ui;
        this.clienteController = clienteController;
        this.contaController = contaController;
        this.transacaoController = transacaoController;
    }

    public void executar() {
        boolean executando = true;

        while(executando) {
            ui.exibirMenuPrincipal();
            int opcao = ui.lerOpcao();

            switch(opcao) {
                case 1:
                    abrirMenuClientes();
                    break;
                case 2:
                    abrirMenuContas();
                    break;
                case 3:
                    abrirMenuTransacoes();
                    break;
                case UI.OPCAO_SAIR:
                    executando = false;
                    break;
                default:
                    this.ui.exibirMensagem("Opção inválida!\n");
            }
        }
    }

    public void abrirMenuClientes() {
        boolean isMenuClientesAberto = true;

        while(isMenuClientesAberto) {
            ui.exibirMenuClientes();
            int opcao = ui.lerOpcao();

            switch(opcao) {
                case 1:
                    clienteController.cadastrarCliente();
                    break;
                case 2:
                    clienteController.removerCliente();
                    break;
                case 3:
                    clienteController.visualizarDadosCliente();
                    break;
                case UI.OPCAO_VOLTAR:
                    isMenuClientesAberto = false;
                    break;
                default:
                    this.ui.exibirMensagem("Opção inválida!\n");
            }
        }
    }

    public void abrirMenuContas() {
        boolean isMenuContasAberto = true;

        while(isMenuContasAberto) {
            ui.exibirMenuContas();
            int opcao = ui.lerOpcao();

            switch(opcao) {
                case 1:
                    contaController.criarContaCorrente();
                    break;
                case 2:
                    contaController.criarContaPoupanca();
                    break;
                case 3:
                    contaController.removerConta();
                    break;
                case 4:
                    contaController.consultarSaldo();
                    break;
                case 5:
                    contaController.visualizarExtrato();
                    break;
                case 6:
                    contaController.aplicarRendimentoPoupanca();
                    break;
                case UI.OPCAO_VOLTAR:
                    isMenuContasAberto = false;
                    break;
                default:
                    this.ui.exibirMensagem("Opção inválida!\n");
            }
        }
    }

    public void abrirMenuTransacoes() {
        boolean isMenuTransacoesAberto = true;

        while(isMenuTransacoesAberto) {
            ui.exibirMenuTransacoes();
            int opcao = ui.lerOpcao();

            switch(opcao) {
                case 1:
                    transacaoController.depositar();
                    break;
                case 2:
                    transacaoController.sacar();
                    break;
                case 3:
                    transacaoController.realizarTransferencia();
                    break;
                case UI.OPCAO_VOLTAR:
                    isMenuTransacoesAberto = false;
                    break;
                default:
                    this.ui.exibirMensagem("Opção inválida!\n");
            }
        }
    }
}
