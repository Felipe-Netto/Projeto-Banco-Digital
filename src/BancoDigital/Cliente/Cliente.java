package BancoDigital.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome(){
        return nome;
    }
}