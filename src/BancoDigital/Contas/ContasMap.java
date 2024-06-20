package BancoDigital.Contas;

import BancoDigital.Cliente.Cliente;

import java.util.HashMap;
import java.util.Map;

public class ContasMap {

    Map<String, Conta> contasMap;

    public ContasMap(){
        contasMap = new HashMap<>();
    }

    public void adicionarContaCorrente(String cpf, Cliente c){
        contasMap.put(cpf, new ContaCorrente(c));
    }

    public void adicionarContaPoupanca(String cpf, Cliente c){
        contasMap.put(cpf, new ContaPoupanca(c));
    }

    public Map<String, Conta> getContasMap(){
        return contasMap;
    }

}
