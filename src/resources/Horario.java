package resources;

/**
 * A classe Horario representa um horário com informações de dia, mês e hora.
 */
public class Horario {
    private int dia;
    private int mes;
    private String hora;

    /**
     * Obtém o dia do horário.
     *
     * @return O dia do horário.
     */
    public int getDia() {
        return dia;
    }

    /**
     * Define o dia do horário.
     *
     * @param dia O dia a ser definido.
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * Obtém o mês do horário.
     *
     * @return O mês do horário.
     */
    public int getMes() {
        return mes;
    }

    /**
     * Define o mês do horário.
     *
     * @param mes O mês a ser definido.
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * Obtém a hora do horário.
     *
     * @return A hora do horário.
     */
    public String getHora() {
        return hora;
    }

    /**
     * Define a hora do horário.
     *
     * @param hora A hora a ser definida (no formato "HH:mm").
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * Construtor da classe Horario.
     *
     * @param dia O dia do horário.
     * @param mes O mês do horário.
     * @param hora A hora do horário (no formato "HH:mm").
     * @throws RuntimeException Se o formato da hora não for adequado.
     */
    public Horario(int dia, int mes, String hora){
        this.setDia(dia);
        this.setMes(mes);
        if (this.formatoAdequadoDeHora(hora)) this.setHora(hora);
        else throw new RuntimeException("Formato de hora inadequado!");
    }

    /**
     * Verifica se o formato da hora é adequado (no formato "HH:mm").
     *
     * @param hora A hora a ser verificada.
     * @return true se o formato da hora for adequado, caso contrário, false.
     */
    private boolean formatoAdequadoDeHora(String hora){
        // a regex terminava em \n, o que acabava obrigando ter uma quebra de linha
        String regex = "^(?:[0-1]?\\d|2[0-3]):[0-5]\\d$";
        return hora.matches(regex);
    }

    /**
     * Retorna uma representação em formato de string do horário.
     *
     * @return Uma string que representa o horário no formato "dia/mês, hora".
     */
    public String print(){
        return this.dia + "/" + this.mes + ", " + this.getHora() + "h.";
    }
}
