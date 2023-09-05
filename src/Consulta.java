public class Consulta {
    private final Cliente cliente;
    private final Medico medico;
    private final Horario horario;
    private final Area area;
    private final Urgencia urgencia;
    private Status status;

    public Cliente getCliente() {
        return cliente;
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

    public Consulta(Medico medico, Cliente cliente, Horario horario, Area area, Urgencia urgencia){
        this.cliente = cliente;
        this.medico = medico;
        this.area = area;
        this.urgencia = urgencia;
        this.horario = horario;
        this.setStatus(Status.Agendada);
        this.medico.getConsultasMarcadas().add(this);  //Já adiciona esta consulta para o médico indicado
    }

    public void cancelarConsulta(){
        this.setStatus(Status.Cancelada);
        this.getMedico().getConsultasMarcadas().remove(this);
        System.out.println("Esta consulta foi cancelada.");
    }

    public void realizarConsulta(String orientacoes){
        this.setStatus(Status.Realizada);
        System.out.println("Consulta realizada. \n Orientações: " + orientacoes);
    }
}
