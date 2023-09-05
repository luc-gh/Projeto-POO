public class Consulta {
    private final Cliente cliente;
    private final Medico medico;
    private final Horario horario;
    private final Area area;
    private final Urgencia urgencia;

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

    public Consulta(Medico medico, Cliente cliente, Horario horario, Area area, Urgencia urgencia){
        this.cliente = cliente;
        this.medico = medico;
        this.area = area;
        this.urgencia = urgencia;
        this.horario = horario;
        this.medico.getConsultasMarcadas().add(this);  //Já adiciona esta consulta para o médico indicado
    }
}
