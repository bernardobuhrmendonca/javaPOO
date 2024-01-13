package OBJ02;

import OBJ06.Pessoa;

public class mainLivro {
    public static void main(String[] args) {
        Pessoa[] pessoas = new Pessoa[3];
        Pessoa p1 = new Pessoa(12, "jolao", 1.78, "masculino");
        Livro l1 = new Livro(500, 490, "Bu", p1);
        for (int aux = 0; aux < pessoas.length; aux++) {
            pessoas[aux] = new Pessoa(0, "x", 0, "x");
        }
        System.out.println(l1.isFechado());
        System.out.println();

    }
}
