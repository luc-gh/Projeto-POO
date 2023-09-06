import resources.Horario;

public class Tratamento {
    private final Medico medicoResponsavel;
    private final Paciente paciente;
    private final Horario horario;
    private String relatorio;

    public Tratamento(Medico medicoResponsavel, Paciente paciente, Horario horario) {
        this.medicoResponsavel = medicoResponsavel;
        this.paciente = paciente;
        this.horario = horario;
        this.relatorio = "Relatório não fornecido.";
    }

    public Tratamento(Medico medicoResponsavel, Paciente paciente, Horario horario, String relatorio) {
        this.medicoResponsavel = medicoResponsavel;
        this.paciente = paciente;
        this.horario = horario;
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

    @Override
    public String toString(){
        return "Médico responsável: "+getMedicoResponsavel().getNome()+"\n"+"Cliente: "
                +getPaciente().getNome()+"\n"+"Relatório: "+getRelatorio();
    }
}
