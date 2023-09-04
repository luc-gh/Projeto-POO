public class Testes {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Lucas", "(82)98201-6164", "15/10/2000");
        System.out.println(p1.getNome());
        System.out.println(p1.getNumero());
        System.out.println(p1.getDataDeNascimento());

    }
}
