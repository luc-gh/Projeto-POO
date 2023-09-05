public class Testes {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("João", "(82)97523-2864", "22/11/2000");
        System.out.println(p1.getNome());
        System.out.println(p1.getNumero());
        System.out.println(p1.getDataDeNascimento());

        Medico m = new Medico("Marcos", "(11)96572-2342", "18/12/1983", "Cirúrgia");
        System.out.println(m.getArea());
    }
}
