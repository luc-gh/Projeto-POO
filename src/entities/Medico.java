package entities;

import java.util.ArrayList;
import java.util.Scanner;

import org.jetbrains.annotations.NotNull;

import resources.*;
import services.*;

/**
* A classe Medico representa um médico no sistema
*
* Ela herda da classe Pessoa e inclui informações específicas de um médico, como sua área de atuação,
* horários disponíveis, horários marcados e consultas marcadas.
*/
public class Medico extends Pessoa {

    private Area area;
    private ArrayList<Horario> horariosDisponiveis;
    private ArrayList<Horario> horariosMarcados;
    private ArrayList<Consulta> consultasMarcadas;

    /**
     * Obtém a área de atuação do médico.
     *
     * @return A área de atuação do médico.
     */
    public Area getArea() {
        return area;
    }

    /**
     * Define a área de atuação do médico.
     *
     * @param area A área de atuação a ser definida.
     */
    public void setArea(Area area) {
        this.area = area;
    }

    /**
     * Obtém a lista de horários disponíveis do médico.
     *
     * @return A lista de horários disponíveis.
     */
    public ArrayList<Horario> getHorariosDisponiveis() {
        return horariosDisponiveis;
    }

    /**
     * Define a lista de horários disponíveis do médico.
     *
     * @param horariosDisponiveis A lista de horários disponíveis a ser definida.
     */
    public void setHorariosDisponiveis(ArrayList<Horario> horariosDisponiveis) {
        this.horariosDisponiveis = horariosDisponiveis;
    }

    /**
     * Obtém a lista de horários marcados com o médico.
     *
     * @return A lista de horários marcados.
     */
    public ArrayList<Horario> getHorariosMarcados() {
        return horariosMarcados;
    }

    /**
     * Define a lista de horários marcados com o médico.
     *
     * @param horariosMarcados A lista de horários marcados a ser definida.
     */
    public void setHorariosMarcados(ArrayList<Horario> horariosMarcados) {
        this.horariosMarcados = horariosMarcados;
    }

    /**
     * Obtém a lista de consultas marcadas com o médico.
     *
     * @return A lista de consultas marcadas.
     */
    public ArrayList<Consulta> getConsultasMarcadas() {
        return consultasMarcadas;
    }

    /**
     * Define a lista de consultas marcadas com o médico.
     *
     * @param consultasMarcadas A lista de consultas marcadas a ser definida.
     */
    public void setConsultasMarcadas(ArrayList<Consulta> consultasMarcadas) {
        this.consultasMarcadas = consultasMarcadas;
    }

    /**
     * Construtor da classe Medico.
     *
     * @param nome             O nome do médico.
     * @param numero           O número de identificação do médico.
     * @param dataDeNascimento A data de nascimento do médico.
     * @param area             A área de atuação do médico.
     */
    public Medico(String nome, String numero, String dataDeNascimento, Area area){
        super(nome, numero, dataDeNascimento);
        this.setArea(area);
        this.setHorariosDisponiveis(new ArrayList<>());
        this.setHorariosMarcados(new ArrayList<>());
        this.setConsultasMarcadas(new ArrayList<>());
    }

    /**
     * Mostra os horários disponíveis do médico.
     */
    public void mostrarHorariosDisponiveis(){
        if(this.getHorariosDisponiveis().isEmpty()){
            System.out.println("Não há horários disponíveis.");
        } else {
            System.out.println("Horários disponíveis do Doutor " + this.getNome() + ":");
            for (Horario h:this.getHorariosDisponiveis()) System.out.println("-> " + h.print());
        }
    }

    /**
     * Mostra os horários marcados com o médico.
     */
    public void mostrarHorariosMarcados(){
        if(this.getHorariosMarcados().isEmpty()){
            System.out.println("Não há horários marcados.");
        } else {
            System.out.println("Horários marcados com o Doutor " + this.getNome() + ":");
            for (Horario h:this.getHorariosDisponiveis()) System.out.println("-> " + h.print());
        }
    }

    /**
     * Marca uma consulta com o médico.
     *
     * @param paciente O paciente para o qual a consulta será marcada.
     * @param horario  O horário da consulta.
     * @param urgencia O nível de urgência da consulta.
     */
    public void marcarConsulta(Pessoa paciente, Horario horario, Urgencia urgencia){
        Consulta c = new Consulta(this, paciente, horario, urgencia);
        this.getHorariosMarcados().add(horario);
        System.out.println("Consulta com o paciente " + paciente.getNome()
                + " marcada com o Doutor " + this.getNome() +
                " para o dia " + horario.getDia() + "/" +
                horario.getMes() + ", " + horario.getHora() +
                ":" + horario.getMinuto() + ".");
    }

    /**
     * Designa um tratamento para uma consulta.
     * @param orientacoes  As orientações para o tratamento.
     */
    public void designarTratamento(String orientacoes, Consulta consulta){
        Tratamento tratamento = new Tratamento(this, "");
        Scanner sc = new Scanner(System.in);
        System.out.print("Relatório: ");
        String s = sc.nextLine();
        if (s.length() > 5) tratamento.setRelatorio(s);
        tratamento.tratamento();
        this.consultasMarcadas.remove(consulta);
    }

    /**
     * Cancela uma consulta.
     *
     * @param horario  O horário da consulta.
     */
    public void cancelarConsulta(Horario horario){
        System.out.println("As consultas atuais são:");
        for(Consulta c:this.getConsultasMarcadas()){
            System.out.println("Consulta: " + c + "\nHorário:" + c.getHorario().print() + "\nUrgencia: " + c.getUrgencia());
        }
        for (Consulta m:this.consultasMarcadas){
            if (m.getHorario().getMes() == horario.getMes() &&
                m.getHorario().getDia() == horario.getDia() &&
                m.getHorario().getHora() == horario.getHora() &&
                m.getHorario().getMinuto() == horario.getMinuto()
            ) {
                this.consultasMarcadas.remove(m);
                System.out.println("Consulta de " + horario.print() + ", do médico " + m.getMedico() + " cancelada.");
            }
            else System.out.println("Esta consulta não existe.");
        }
    }

}