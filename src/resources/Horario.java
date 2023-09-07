package resources;

public class Horario {
    private int dia;
    private int mes;
    private String hora;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Horario(int dia, int mes, String hora){
        this.setDia(dia);
        this.setMes(mes);
        if (this.formatoAdequadoDeHora(hora)) this.setHora(hora);
        else throw new RuntimeException("Formato de hora inadequado!");
    }

    private boolean formatoAdequadoDeHora(String hora){
        // a regex terminava em \n, o que acabava obrigando ter uma quebra de linha
        String regex = "^(?:[01]\\d|2[0-3]):[0-5]\\d$";
        return hora.matches(regex);
    }

    public String print(){
        return this.dia + "/" + this.mes + ", " + this.getHora() + "h.";
    }
}
