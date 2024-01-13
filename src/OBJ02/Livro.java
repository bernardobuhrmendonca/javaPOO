package OBJ02;

import OBJ06.Pessoa;

public class Livro implements InterfaceLivro {

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Atributos:

    private int paginaAtual;
    private int totalPaginas;
    private String nomeLiv;
    private boolean fechado;
    private String corLivro;
    private Pessoa leitor;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Construtores:

    public Livro() {
        this.fecharLivro();
        this.setPaginaAtual(1);
    }

    public Livro(int totalPaginas, int paginaAtual, String nomeLivro, Pessoa leitor) {
        abrirLivro();
        setTotalPaginas(totalPaginas);
        setPaginaAtual(paginaAtual);
        setNomeLiv(nomeLivro);
        setLeitor(leitor);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Getters:

    public int getPaginaAtual() {
        return this.paginaAtual;
    }

    public int getTotalPaginas() {
        return this.totalPaginas;
    }

    public String getNomeLiv() {
        return this.nomeLiv;
    }

    public boolean isFechado() {
        return this.fechado;
    }

    public String getCorLivro() {
        return this.corLivro;
    }

    public Pessoa getLeitor() {
        return this.leitor;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Setters:

    public void setPaginaAtual(int paginaAtual) {
        if (paginaAtual < 1 || paginaAtual > this.totalPaginas) {
            System.out.println("Número inválido! Indique um valor positivo e menor ou igual ao total de páginas!");
        } else {
            this.paginaAtual = paginaAtual;
        }
    }

    public void setTotalPaginas(int totalPaginas) {
        if (totalPaginas < 1) {
            System.out.println("Número inválido! Indique um valor positivo!");
        } else {
            this.totalPaginas = totalPaginas;
        }
    }

    public void setNomeLiv(String nomeLiv) {
        this.nomeLiv = nomeLiv;
    }

    public void setFechado(boolean fechado) {
        this.fechado = fechado;
    }

    public void setCorLivro(String corLivro) {
        this.corLivro = corLivro;
    }

    public void setLeitor(Pessoa leitor) {
        this.leitor = leitor;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Métodos interface:

    @Override
    public void abrirLivro() {
        this.fechado = false;
    }

    @Override
    public void fecharLivro() {
        this.fechado = true;
    }

    @Override
    public void voltarPagina() {
        if (!isFechado()) {
            if (getPaginaAtual() == 1) {
                System.out.println("Não é possível voltar! Estamos na primeira página!");
            } else if (getPaginaAtual() > 1) {
                setPaginaAtual(getPaginaAtual() - 1);
            }
        } else {
            System.out.println("O livro está fechado! Abra-o primeiro!");
        }
    }

    @Override
    public void avancarPagina() {
        if (!isFechado()) {
            if (getPaginaAtual() <= getTotalPaginas()) {
                setPaginaAtual(getPaginaAtual() + 1);
            } else if (getPaginaAtual() == getTotalPaginas() + 1) {
                System.out.println("Parabéns! Você terminou o livro!");
                fecharLivro();
            }
        } else {
            System.out.println("O livro está fechado! Abra-o primeiro!");
        }
    }

    @Override
    public void ler(int minuto) {
        int cont = 0;
        if (isFechado()) {
            System.out.println("O livro está fechado! Abra ele para poder ler!");
        } else if (minuto < 0) {
            System.out.println("É impossível ler em tempo negativo! Insira um número válido!");
        } else {
            for (int aux = 0; aux < minuto / 4; aux++) {
                System.out.println("Lendo...");
                avancarPagina();
                cont++;
                if (getPaginaAtual() == getTotalPaginas() + 1) {
                    avancarPagina();
                    break;
                }
            }
            System.out.println(cont + " páginas lidas.");
        }
    }
}
