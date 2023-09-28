package services;

import resources.*;
import entities.*;

/**
 * A classe Consulta representa uma consulta médica no sistema.
 *
 * Ela mantém informações sobre o paciente, médico, horário, área de atuação, urgência e status da consulta.
 */
public class Consulta {
    private final Pessoa paciente;
    private final Medico medico;
    private final Horario horario;
    private final Area area;
    private final Urgencia urgencia;
    private Status status;

    /**
     * Obtém o paciente da consulta.
     *
     * @return O paciente da consulta.
     */
    public Pessoa getPaciente() {
        return paciente;
    }

    /**
     * Obtém o médico responsável pela consulta.
     *
     * @return O médico responsável pela consulta.
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * Obtém o horário da consulta.
     *
     * @return O horário da consulta.
     */
    public Horario getHorario() {
        return horario;
    }

    /**
     * Obtém a área de atuação da consulta, que é a mesma do médico.
     *
     * @return A área de atuação da consulta.
     */
    public Area getArea() {
        return area;
    }

    /**
     * Obtém o nível de urgência da consulta.
     *
     * @return O nível de urgência da consulta.
     */
    public Urgencia getUrgencia() {
        return urgencia;
    }

    /**
     * Obtém o status atual da consulta.
     *
     * @return O status atual da consulta.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Define o status da consulta.
     *
     * @param status O status a ser definido.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Construtor da classe Consulta.
     *
     * @param medico   O médico responsável pela consulta.
     * @param paciente O paciente da consulta.
     * @param horario  O horário da consulta.
     * @param urgencia O nível de urgência da consulta.
     */
    public Consulta(Medico medico, Pessoa paciente, Horario horario, Urgencia urgencia){
        this.paciente = paciente;
        this.medico = medico;
        this.area = medico.getArea();
        this.urgencia = urgencia;
        this.horario = horario;
        this.setStatus(Status.Agendada);
        this.medico.getConsultasMarcadas().add(this);  //Já adiciona esta consulta para o médico indicado
    }

    /**
     * Cancela a consulta, atualizando o status e removendo-a da lista de consultas marcadas do médico.
     */
    public synchronized void cancelarConsulta(){
        this.setStatus(Status.Cancelada);
        this.getMedico().getConsultasMarcadas().remove(this);
        System.out.println("Esta consulta foi cancelada.");
    }

    /**
     * Realiza a consulta, atualizando o status e exibindo as orientações fornecidas.
     *
     * @param orientacoes As orientações dadas durante a consulta.
     */
    public synchronized void realizarConsulta(String orientacoes){
        this.setStatus(Status.Realizada);
        System.out.println("Consulta realizada. \nOrientações: " + orientacoes + "\n");
        this.getMedico().designarTratamento(orientacoes, this);
    }


}
