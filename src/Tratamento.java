import resources.Horario;
import resources.Urgencia;

public class Tratamento {
    private final Medico medicoResponsavel;
    private final Paciente paciente;
    private final Horario horario;
    private final Urgencia urgencia;

    private String relatorio;

    public Tratamento(Medico medicoResponsavel, Paciente paciente, Horario horario, Urgencia urgencia) {
        this.medicoResponsavel = medicoResponsavel;
        this.paciente = paciente;
        this.horario = horario;
        this.urgencia = urgencia;
        this.relatorio = "Relatório não fornecido.";
    }

    public Tratamento(Medico medicoResponsavel, Paciente paciente, Horario horario, Urgencia urgencia, String relatorio) {
        this.medicoResponsavel = medicoResponsavel;
        this.paciente = paciente;
        this.horario = horario;
        this.urgencia = urgencia;
        this.relatorio = relatorio;
    }

    public Tratamento(Medico medicoResponsavel, Paciente paciente, Horario horario, String relatorio) {
        this.medicoResponsavel = medicoResponsavel;
        this.paciente = paciente;
        this.horario = horario;
        this.urgencia = Urgencia.Rotina;
        this.relatorio = relatorio;
    }

    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Horario getHorario() {
        return horario;
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

    @Override
    public String toString(){
        return "Médico responsável: "+getMedicoResponsavel().getNome()+"\n"+"Cliente: "
                +getPaciente().getNome()+"\n"+"Relatório: "+getRelatorio();
    }
}
