package entities;

import java.util.ArrayList;
import resources.*;
import services.*;

public class Medico extends Pessoa {
    private String nome;
    private String numero;
    private String dataDeNascimento;
    private Area area;
    private ArrayList<Horario> horariosDisponiveis;
    private ArrayList<Horario> horariosMarcados;
    private ArrayList<Consulta> consultasMarcadas;

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

    public void mostrarHorariosDisponiveis(){
        if(this.getHorariosDisponiveis().isEmpty()){
            System.out.println("Não há horários disponíveis.");
        } else {
            System.out.println("Horários disponíveis do Doutor " + this.getNome() + ":");
            for (Horario h:this.getHorariosDisponiveis()) System.out.println("-> " + h.print());
        }
    }

    public void mostrarHorariosMarcados(){
        if(this.getHorariosMarcados().isEmpty()){
            System.out.println("Não há horários marcados.");
        } else {
            System.out.println("Horários marcados com o Doutor " + this.getNome() + ":");
            for (Horario h:this.getHorariosDisponiveis()) System.out.println("-> " + h.print());
        }
    }

    public void marcarConsulta(Paciente paciente, Horario horario, Urgencia urgencia){
        this.getConsultasMarcadas().add(new Consulta(this, paciente, horario, urgencia));
        System.out.println("Consulta com o paciente " + paciente.getNome() + " marcada com o Doutor " +
                this.getNome() + " para o dia " + horario.getDia() + "/" + horario.getMes() + ", " + horario.getHora() + ".");

    }

    public void designarTratamento(){

        System.out.println("--------------------\nEscolha a opção de tratamento:");
    }

    public void prescrever(){

        System.out.println("--------------------\nEscolha a opção de tratamento:");

    }
}