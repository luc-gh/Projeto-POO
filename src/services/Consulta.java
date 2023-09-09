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
    public static HashSet<Consulta> consultas;

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
        consultas.add(this);
        this.medico.getConsultasMarcadas().add(this);  //Já adiciona esta consulta para o médico indicado
    }

    public void cancelarConsulta(){
        this.setStatus(Status.Cancelada);
        consultas.remove(this);
        this.getMedico().getConsultasMarcadas().remove(this);
        System.out.println("Esta consulta foi cancelada.");
    }

    public void realizarConsulta(String orientacoes){
        this.setStatus(Status.Realizada);
        System.out.println("Consulta realizada. \nOrientações: " + orientacoes + "\n");
        this.getMedico().designarTratamento(this.getPaciente(), this.getUrgencia());
        consultas.remove(this);
    }

    public static void listarConsultas(){
        int i = 1;
        for(Consulta c:consultas){
            System.out.println("\nConsulta --------- " +
                    "\nMédico: " + c.getMedico().getNome() +
                    "\nPaciente: " + c.getPaciente().getNome() +
                    "\nHorário: " + c.getHorario().print() +
                    "\nUrgência: " + c.getUrgencia() +
                    "\nÁrea: " + c.getArea() +
                    "\nÍndice: " + i
            );
            i++;
        }
    }
}
