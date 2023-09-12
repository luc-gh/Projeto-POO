package entities;

import java.util.ArrayList;
import java.util.Scanner;

import resources.*;
import services.*;

public class Medico extends Pessoa {
    private Area area;
    private ArrayList<Horario> horariosDisponiveis;
    private ArrayList<Horario> horariosMarcados;
    private ArrayList<Consulta> consultasMarcadas;

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public ArrayList<Horario> getHorariosDisponiveis() {
        return horariosDisponiveis;
    }

    public void setHorariosDisponiveis(ArrayList<Horario> horariosDisponiveis) {
        this.horariosDisponiveis = horariosDisponiveis;
    }

    public ArrayList<Horario> getHorariosMarcados() {
        return horariosMarcados;
    }

    public void setHorariosMarcados(ArrayList<Horario> horariosMarcados) {
        this.horariosMarcados = horariosMarcados;
    }

    public ArrayList<Consulta> getConsultasMarcadas() {
        return consultasMarcadas;
    }

    public void setConsultasMarcadas(ArrayList<Consulta> consultasMarcadas) {
        this.consultasMarcadas = consultasMarcadas;
    }

    public Medico(String nome, String numero, String dataDeNascimento, Area area){
        super(nome, numero, dataDeNascimento);
        this.setArea(area);
        this.setHorariosDisponiveis(new ArrayList<>());
        this.setHorariosMarcados(new ArrayList<>());
        this.setConsultasMarcadas(new ArrayList<>());
    }

    /*
    public void mostrarHorariosDisponiveis(){
        if(this.getHorariosDisponiveis().isEmpty()){
            System.out.println("Não há horários disponíveis.");
        } else {
            System.out.println("Horários disponíveis do Doutor " + this.getNome() + ":");
            for (Horario h:this.getHorariosDisponiveis()) System.out.println("-> " + h.print());
        }
    }*/

    public void mostrarHorariosMarcados(){
        if(this.getHorariosMarcados().isEmpty()){
            System.out.println("Não há horários marcados.");
        } else {
            System.out.println("Horários marcados com o Doutor " + this.getNome() + ":");
            for (Horario h:this.getHorariosDisponiveis()) System.out.println("-> " + h.print());
        }
    }

    public void marcarConsulta(Pessoa paciente, Horario horario, Urgencia urgencia){
        Consulta c = new Consulta(this, paciente, horario, urgencia);
        this.getConsultasMarcadas().add(c);
        System.out.println("Consulta com o paciente " + paciente.getNome() + " marcada com o Doutor " +
                this.getNome() + " para o dia " + horario.getDia() + "/" + horario.getMes() + ", " + horario.getHora() + ".");
    }

    public void designarTratamento(Consulta consulta, String orientacoes){
        Tratamento tratamento = new Tratamento(this, consulta.getPaciente(), consulta.getUrgencia());
        Scanner sc = new Scanner(System.in);
        System.out.print("Relatório: ");
        String s = sc.nextLine();
        if (s.length() > 5) tratamento.setRelatorio(s);
        consulta.realizarConsulta(orientacoes);
        tratamento.tratamento();
        this.consultasMarcadas.remove(consulta);
    }

    public void cancelarConsulta(Medico medico, Pessoa paciente, Horario horario, Urgencia urgencia){
        Consulta c = new Consulta(medico, paciente, horario, urgencia);
        for (Consulta m:medico.consultasMarcadas){
            if (m.getMedico().equals(c.getMedico()) &&
                m.getArea().equals(c.getArea()) &&
                m.getHorario().equals(c.getHorario()) &&
                m.getPaciente().equals(c.getPaciente())
            ) {
                m.cancelarConsulta();
            }
            else System.out.println("Esta consulta não existe.");
        }
    }

    public void cancelarConsulta(Consulta consulta){
        consulta.cancelarConsulta();
    }


}