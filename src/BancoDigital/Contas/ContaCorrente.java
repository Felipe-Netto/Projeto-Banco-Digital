package BancoDigital.Contas;

import BancoDigital.Cliente.Cliente;

public class ContaCorrente extends Conta {


    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void exibirExtrato() {
        System.out.println("=== Extrato BancoDigital.Contas.Conta Corrente ===");
        super.imprimirInfosConta();
    }
}
