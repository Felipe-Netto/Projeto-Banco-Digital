package BancoDigital.Contas;

import BancoDigital.Cliente.Cliente;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void exibirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosConta();
    }

}
