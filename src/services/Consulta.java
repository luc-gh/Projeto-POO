package services;

import resources.*;
import entities.*;

import java.util.Arrays;
import java.util.HashSet;

public class Consulta {
    private final Paciente paciente;
    private final Medico medico;
    private final Horario horario;
    private final Area area;
    private final Urgencia urgencia;
    private Status status;
    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public Horario getHorario() {
        return horario;
    }

    public Area getArea() {
        return area;
    }

    public Urgencia getUrgencia() {
        return urgencia;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Consulta(Medico medico, Paciente paciente, Horario horario, Urgencia urgencia){
        this.paciente = paciente;
        this.medico = medico;
        this.area = medico.getArea();
        this.urgencia = urgencia;
        this.horario = horario;
        this.setStatus(Status.Agendada);
        this.medico.getConsultasMarcadas().add(this);  //Já adiciona esta consulta para o médico indicado
    }

    public synchronized void cancelarConsulta(){
        this.setStatus(Status.Cancelada);
        this.getMedico().getConsultasMarcadas().remove(this);
        System.out.println("Esta consulta foi cancelada.");
    }

    public synchronized void realizarConsulta(String orientacoes){
        this.setStatus(Status.Realizada);
        System.out.println("Consulta realizada. \nOrientações: " + orientacoes + "\n");
    }


}
