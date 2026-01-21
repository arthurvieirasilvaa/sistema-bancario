package br.com.arthur.banco.application;

import br.com.arthur.banco.domain.exception.ClienteInexistenteException;
import br.com.arthur.banco.domain.exception.ContaInexistenteException;
import br.com.arthur.banco.domain.model.Cliente;
import br.com.arthur.banco.domain.model.Conta;
import br.com.arthur.banco.domain.model.Transacao;
import br.com.arthur.banco.service.ClienteService;
import br.com.arthur.banco.service.ContaService;

import java.util.List;

public class ContaController {
    private final UI ui;
    private final ContaService contaService;
    private final ClienteService clienteService;

    public ContaController(UI ui, ContaService contaService, ClienteService clienteService) {
        this.ui = ui;
        this.contaService = contaService;
        this.clienteService = clienteService;
    }

    private Cliente buscarCliente() {
        this.ui.exibirMensagem("CPF do cliente: ");
        String cpf = this.ui.lerTexto();

        return this.clienteService.buscarCliente(cpf);
    }

    public void criarContaCorrente() {
        try {
            this.ui.exibirMensagem("Agência: ");
            String agencia = this.ui.lerTexto();

            Cliente cliente = buscarCliente();

            this.ui.exibirMensagem("Limite da conta: ");
            double limite = this.ui.lerDecimal();

            Conta conta = this.contaService.criarContaCorrente(agencia, cliente, limite);
            this.ui.exibirMensagem("A conta corrente da agência "+
                    conta.getAgencia()+
                    " e número "+
                    conta.getNumero()+
                    " foi criada com sucesso!\n");
        }catch (ClienteInexistenteException e) {
            this.ui.exibirMensagem("O cliente não existe!\n");
        }
        catch (Exception e) {
            this.ui.exibirMensagem("Ocorreu um erro ao criar a conta corrente!\n");
        }
    }

    public void criarContaPoupanca() {
        try {
            this.ui.exibirMensagem("Agência: ");
            String agencia = this.ui.lerTexto();

            Cliente cliente = buscarCliente();

            Conta conta = this.contaService.criarContaPoupanca(agencia, cliente);
            this.ui.exibirMensagem("A conta poupança da agência "+
                    conta.getAgencia()+
                    " e número "+
                    conta.getNumero()+
                    " foi criada com sucesso!\n");
        }catch (ClienteInexistenteException e) {
            this.ui.exibirMensagem("O cliente não existe!\n");
        }
        catch (Exception e) {
            this.ui.exibirMensagem("Ocorreu um erro ao criar a conta poupança!\n");
        }
    }

    public void removerConta() {
        try {
            this.ui.exibirMensagem("Informe o número da conta que será removida: ");
            String numero = this.ui.lerTexto();

            Conta conta = this.contaService.removerConta(numero);
            this.ui.exibirMensagem("A conta de número "+conta.getNumero()+" foi removida com sucesso!\n");
        }catch (ContaInexistenteException e) {
            this.ui.exibirMensagem("A conta não existe!\n");
        }catch (Exception e) {
            this.ui.exibirMensagem("Ocorreu um erro ao remover o cliente!\n");
        }
    }

    public void consultarSaldo() {
        try {
            this.ui.exibirMensagem("Informe o número da conta que você deseja consultar o saldo: ");
            String numero = this.ui.lerTexto();

            double saldo = this.contaService.consultarSaldo(numero);
            this.ui.exibirMensagem("O saldo da conta é R$"+saldo+"\n");
        }catch (ContaInexistenteException e) {
            this.ui.exibirMensagem("A conta não existe!\n");
        }catch (Exception e) {
            this.ui.exibirMensagem("Ocorreu um erro ao consultar o saldo!\n");
        }
    }

    public void visualizarExtrato() {
        try {
            this.ui.exibirMensagem("Informe o número da conta que você deseja visualizar o extrato: ");
            String numero = this.ui.lerTexto();

            List<Transacao> extrato = this.contaService.obterExtrato(numero);

            if(extrato.isEmpty()) {
                this.ui.exibirMensagem("Nenhuma transação foi realizada ainda!\n");
            }

            else {
                this.ui.exibirMensagem("Extrato da conta:\n");
                for(Transacao transacao : extrato) {
                    this.ui.exibirMensagem(transacao.toString()+"\n");
                }
            }
        }catch (ContaInexistenteException e) {
            this.ui.exibirMensagem("A conta não existe!\n");
        }catch (Exception e) {
            this.ui.exibirMensagem("Ocorreu um erro ao visualizar o extrato!\n");
        }
    }

    public void aplicarRendimentoPoupanca() {
        try {
            this.ui.exibirMensagem("Informe o número da conta poupança que você deseja aplicar o rendimento mensal: ");
            String numero = this.ui.lerTexto();

            Conta conta = this.contaService.buscarConta(numero);
            this.contaService.aplicarRendimentoPoupanca(conta);
            this.ui.exibirMensagem("Rendimento mensal aplicado com sucesso na conta poupança!\n");
        }catch (ContaInexistenteException e) {
            this.ui.exibirMensagem("A conta não existe!\n");
        }catch (IllegalArgumentException e) {
            this.ui.exibirMensagem("A conta precisa ser poupança!\n");
        }catch (Exception e) {
            this.ui.exibirMensagem("Ocorreu um erro ao aplicar o rendimento na conta poupança!\n");
        }
    }
}