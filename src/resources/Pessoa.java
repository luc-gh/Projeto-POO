package resources;

/**
 * A classe Pessoa representa uma entidade com informações sobre nome, número de telefone e data de nascimento.
 * Individualmente, a classe é utilizada para representar um Paciente.
 */
public class Pessoa {
    private String nome;
    private String numero;
    private String dataDeNascimento;

    /**
     * Obtém o nome da pessoa.
     *
     * @return O nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da pessoa.
     *
     * @param nome O nome a ser definido.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o número de telefone da pessoa.
     *
     * @return O número de telefone da pessoa.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Define o número de telefone da pessoa.
     *
     * @param numero O número de telefone a ser definido.
     * @throws RuntimeException Se o formato do número não for adequado.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtém a data de nascimento da pessoa.
     *
     * @return A data de nascimento da pessoa.
     */
    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    /**
     * Define a data de nascimento da pessoa.
     *
     * @param dataDeNascimento A data de nascimento a ser definida (no formato "dd/MM/yyyy").
     * @throws RuntimeException Se o formato da data de nascimento não for adequado.
     */
    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    /**
     * Construtor da classe Pessoa.
     *
     * @param nome O nome da pessoa.
     * @param numero O número de telefone da pessoa (no formato "(xx) 9xxxx-xxxx" ou "9xxxx-xxxx").
     * @param dataDeNascimento A data de nascimento da pessoa (no formato "dd/MM/yyyy").
     * @throws RuntimeException Se o formato do número ou da data de nascimento não for adequado.
     */
    public Pessoa(String nome, String numero, String dataDeNascimento){
        this.setNome(nome);
        if (this.formatoAdequadoDeNumero(numero)) {
            this.setNumero(numero);
        } else throw new RuntimeException("Formato de número inválido.");
        if (this.formatoAdequadoDeData(dataDeNascimento)) {
            this.setDataDeNascimento(dataDeNascimento);
        } else throw new RuntimeException("Formato de data inválido.");
    }

    /**
     * Verifica se o formato do número de telefone é adequado.
     *
     * @param numero O número de telefone a ser verificado.
     * @return true se o formato do número for adequado, caso contrário, false.
     */
    private boolean formatoAdequadoDeNumero(String numero){
        // A regex de antes não permitia o espaço entre o ddd e o numero
        String regex = "(\\()?(\\d{2})?(\\))?(\\ )?9?\\d{4}-?\\d{4}";
        return numero.matches(regex);
    }

    /**
     * Verifica se o formato da data de nascimento é adequado.
     *
     * @param data A data de nascimento a ser verificada.
     * @return true se o formato da data for adequado, caso contrário, false.
     */
    private boolean formatoAdequadoDeData(String data){
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$";
        return data.matches(regex);
    }
}
