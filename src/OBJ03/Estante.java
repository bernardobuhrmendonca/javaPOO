package OBJ03;

import OBJ02.Livro;

import java.util.ArrayList;

public class Estante {

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Atributos:

    private int prateleiras;
    private String material;
    private String cor;
    private int numeroLivros;
    private int livrosPorPrateleira;
    private int maxLivros;
    private ArrayList<Livro> livros = new ArrayList<Livro>();

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Construtores:

    public Estante(int prateleiras, int livrosPorPrateleira) {
        setPrateleiras(prateleiras);
        setLivrosPorPrateleira(livrosPorPrateleira);
        setNumeroLivros(0);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Getters:

    public int getPrateleiras() {
        return this.prateleiras;
    }

    public String getMaterial() {
        return this.material;
    }

    public String getCor() {
        return this.cor;
    }

    public int getNumeroLivros() {
        return this.numeroLivros;
    }

    public int getLivrosPorPrateleira() {
        return this.livrosPorPrateleira;
    }

    public int getMaxLivros() {
        return this.maxLivros;
    }

    public ArrayList<Livro> getLivros() {
        return this.livros;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Setters:

    public void setPrateleiras(int prateleiras) {
        this.prateleiras = prateleiras;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setNumeroLivros(int numeroLivros) {
        this.numeroLivros = numeroLivros;
    }

    public void setLivrosPorPrateleira(int livrosPorPrateleira) {
        this.livrosPorPrateleira = livrosPorPrateleira;
    }

    public void setMaxLivros(int maxLivros) {
        this.maxLivros = maxLivros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Métodos interface:

    public void adicionarLivro(Livro novoLivro) {
        if (getNumeroLivros() < getMaxLivros()) {
            setNumeroLivros(getNumeroLivros() + 1);
            getLivros().add(novoLivro);
        } else {
            System.out.println("Estante cheia! Remova algum livro ou use uma diferente!");
        }
    }

    public void retirarLivro(Livro livroRetirado) {
        if (getNumeroLivros() != 0 && getLivros().contains(livroRetirado)) {
            setNumeroLivros(getNumeroLivros() + 1);
            getLivros().remove(livroRetirado);
        } else if (getNumeroLivros() == 0) {
            System.out.println("Não há nenhum livro na estante, assim não é possível executar nehnhuma remoção.");
        } else {
            System.out.println("Esse livro não está entre os contidos na estante.");
        }
    }

}
