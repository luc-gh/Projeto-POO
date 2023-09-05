public class Pessoa {
    private String nome;
    private String numero;
    private String dataDeNascimento;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Pessoa(String nome, String numero, String dataDeNascimento){
        this.setNome(nome);
        if (formatoAdequadoDeNumero(numero)) {
            this.setNumero(numero);
        } else throw new RuntimeException("Formato de número inválido.");
        if (formatoAdequadoDeData(dataDeNascimento)) {
            this.setDataDeNascimento(dataDeNascimento);
        } else throw new RuntimeException("Formato de data inválido.");
    }

    public static boolean formatoAdequadoDeNumero(String numero){
        String regex = "(\\()?(\\d{2})?(\\))?(\\)?9?\\d{4}-?\\d{4})";
        return numero.matches(regex);
    }

    public static boolean formatoAdequadoDeData(String data){
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$";
        return data.matches(regex);
    }
}
