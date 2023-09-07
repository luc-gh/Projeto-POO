package services;

import entities.*;
import resources.*;

public class Tratamento {
    private final Medico medicoResponsavel;
    private final Paciente paciente;
    private final Urgencia urgencia;
    private final Area area;

    private String relatorio;

    //Tratamento não tem horário fixo

    public Tratamento(Medico medicoResponsavel, Paciente paciente, Urgencia urgencia) {
        this.medicoResponsavel = medicoResponsavel;
        this.area = medicoResponsavel.getArea();
        this.paciente = paciente;
        this.urgencia = urgencia;
        this.relatorio = "Relatório não fornecido.";
    }

    public Tratamento(Medico medicoResponsavel, Paciente paciente, Urgencia urgencia, String relatorio) {
        this.medicoResponsavel = medicoResponsavel;
        this.paciente = paciente;
        this.urgencia = urgencia;
        this.relatorio = relatorio;
        area = medicoResponsavel.getArea();
    }

    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public Paciente getPaciente() {
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
        return "Médico responsável: "+getMedicoResponsavel().getNome()+"\n"+"Cliente: "
                +getPaciente().getNome()+"\n"+"Relatório: "+getRelatorio();
    }
}
