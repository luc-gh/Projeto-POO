package services;

import entities.*;
import resources.*;

import java.util.Scanner;

/**
 * A classe Tratamento representa um tratamento médico no sistema.
 * Ela mantém informações sobre o médico responsável pelo tratamento, o paciente, a urgência do tratamento,
 * a área de atuação do médico e um relatório opcional sobre o tratamento.
 */
public class Tratamento {
    private final Medico medicoResponsavel;
    private final Area area;

    private String relatorio;

    /**
     * Construtor da classe Tratamento com relatório.
     *
     * @param medicoResponsavel O médico responsável pelo tratamento.
     * @param relatorio O relatório opcional sobre o tratamento.
     */
    public Tratamento(Medico medicoResponsavel, String relatorio) {
        this.medicoResponsavel = medicoResponsavel;
        this.relatorio = relatorio;
        area = medicoResponsavel.getArea();
    }

    /**
     * Obtém o médico responsável pelo tratamento.
     *
     * @return O médico responsável pelo tratamento.
     */
    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    /**
     * Obtém o relatório do tratamento.
     *
     * @return O relatório do tratamento.
     */
    public String getRelatorio() {
        return relatorio;
    }

    /**
     * Define o relatório do tratamento.
     *
     * @param relatorio O relatório a ser definido.
     */
    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    /**
     * Obtém a área de atuação do médico responsável pelo tratamento.
     *
     * @return A área de atuação do médico responsável pelo tratamento.
     */
    public Area getArea() {
        return area;
    }

    /**
     * Inicia o tratamento, avaliando a necessidade de prescrição médica com base na área de atuação do médico.
     */
    public void tratamento(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("O paciente mostra sinais reais da doença específica da área? (S/N)" +
                "\nR: ");
        String resp = scanner.next().toUpperCase();
        System.out.println("-----------------------\nO tratamento indicado pelo médico " +
                this.getMedicoResponsavel().getNome() + " para o paciente é:");
        switch (resp) {
            case "S" -> {
                Prescricao prescricao1 = new Prescricao(this.getMedicoResponsavel(), this.getRelatorio());
                prescricao1.listarPrescricoesRecomendadas();
            }
            case "N" -> {
                Prescricao prescricao2 = new Prescricao(this.getMedicoResponsavel(), this.getRelatorio());
                prescricao2.setArea(Area.Geral);
                prescricao2.listarPrescricoesRecomendadas();
            }
            default -> {
                System.out.println("Erro!");
                throw new RuntimeException("Resposta inválida!");
            }
        }
    }
}
