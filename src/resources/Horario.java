package resources;

/**
 * A classe Horario representa um horário com informações de dia, mês e hora.
 */
public class Horario {
    private int dia;
    private int mes;
    private int hora;
    private int minuto;

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
    public int getHora() {
        return hora;
    }

    /**
     * Define a hora do horário.
     *
     * @param hora A hora a ser definida.
     */
    public void setHora(int hora) {
        this.hora = hora;
    }


    /**
     * Obtém os minutos od horário.
     *
     * @return Os minutos do horário.
     */
    public int getMinuto() {
        return minuto;
    }

    /**
     * Define os minutos do horário.
     *
     * @param minuto Os minutos do horário.
     */
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    /**
     * Construtor da classe Horario.
     *
     * @param dia O dia do horário.
     * @param mes O mês do horário.
     * @param hora A hora do horário.
     * @param minutos Os minutos do horário.
     * @throws RuntimeException Se o formato da hora não for adequado.
     */
    public Horario(int dia, int mes, int hora, int minutos){
        this.setDia(dia);
        this.setMes(mes);
        if (hora >= 24 || minutos > 59 || hora < 0 || minutos < 0) throw new RuntimeException("A hora ou os minutos definidos não são adequados.");
        else {
            this.setHora(hora);
            this.setMinuto(minutos);
        }
    }

    /**
     * Retorna uma representação em formato de string do horário.
     *
     * @return Uma string que representa o horário no formato "dia/mês, hora".
     */
    public String print(){
        return this.dia + "/" + this.mes + ", " + this.getHora() + ":" + this.getMinuto();
    }
}
