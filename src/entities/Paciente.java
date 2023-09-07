package entities;

import resources.Pessoa;

public class Paciente extends Pessoa {
    private String nome;
    private String numero;
    private String dataDeNascimento;


    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNumero() {
        return numero;
    }

    @Override
    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    @Override
    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Paciente(String nome, String numero, String dataDeNascimento){
        super(nome, numero, dataDeNascimento);
    }
}
