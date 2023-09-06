package resources;

public class Horario {
    private short dia;
    private short mes;
    private String hora;

    public short getDia() {
        return dia;
    }

    public void setDia(short dia) {
        this.dia = dia;
    }

    public short getMes() {
        return mes;
    }

    public void setMes(short mes) {
        this.mes = mes;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Horario(short dia, short mes, String hora){
        this.setDia(dia);
        this.setMes(mes);
        if (this.formatoAdequadoDeHora(hora)) this.setHora(hora);
        else throw new RuntimeException("Formato de hora inadequado!");
    }

    private boolean formatoAdequadoDeHora(String hora){
        String regex = "^(?:[01]\\d|2[0-3]):[0-5]\\d$\n";
        return hora.matches(regex);
    }

    public String print(){
        return this.dia + "/" + this.mes + ", " + this.getHora() + "h.";
    }
}
