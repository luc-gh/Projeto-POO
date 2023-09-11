package services;

import entities.*;
import resources.*;

import java.util.Scanner;

public class Tratamento {
    private final Medico medicoResponsavel;
    private final Pessoa paciente;
    private final Urgencia urgencia;
    private final Area area;

    private String relatorio;

    public Tratamento(Medico medicoResponsavel, Pessoa paciente, Urgencia urgencia) {
        this.medicoResponsavel = medicoResponsavel;
        this.area = medicoResponsavel.getArea();
        this.paciente = paciente;
        this.urgencia = urgencia;
        this.relatorio = "Relatório não fornecido.";
    }

    public Tratamento(Medico medicoResponsavel, Pessoa paciente, Urgencia urgencia, String relatorio) {
        this.medicoResponsavel = medicoResponsavel;
        this.paciente = paciente;
        this.urgencia = urgencia;
        this.relatorio = relatorio;
        area = medicoResponsavel.getArea();
    }

    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public Pessoa getPaciente() {
        return paciente;
    }

    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    public Urgencia getUrgencia() {
        return urgencia;
    }

    public Area getArea() {
        return area;
    }

    @Override
    public String toString(){
        return "Médico responsável: " + getMedicoResponsavel().getNome() + "\n" + "Cliente: " + getPaciente().getNome();
    }

    public void tratamento(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("O paciente mostra sinais reais da doença específica da área? (S/N)" +
                "\nR: ");
        String resp = scanner.next().toUpperCase();
        scanner.close();
        System.out.println("-----------------------\nO tratamento indicado é:");
        System.out.println(this.toString());
        switch (resp) {
            case "S":
                Prescricao prescricao1 = new Prescricao(this.getMedicoResponsavel(), this.getPaciente(), this.getRelatorio());
                prescricao1.listarPrescricoesRecomendadas();
                break;
            case "N":
                Prescricao prescricao2 = new Prescricao(this.getMedicoResponsavel(), this.getPaciente(), this.getRelatorio());
                prescricao2.setArea(Area.Geral);
                prescricao2.listarPrescricoesRecomendadas();
                break;
            default:
                System.out.println("Erro!");
                throw new RuntimeException("Resposta inválida!");
        }
    }
}
