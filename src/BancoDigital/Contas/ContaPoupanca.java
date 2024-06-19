package BancoDigital.Contas;

import BancoDigital.Cliente.Cliente;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void exibirExtrato() {
        System.out.println("=== Extrato BancoDigital.Contas.Conta Poupança ===");
        super.imprimirInfosConta();
    }

}
