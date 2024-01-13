package OBJ06;

public class Pessoa implements InterfacePessoa {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Atributos:

    private int idade;
    private String nome;
    private double altura;
    private String genero;
    private boolean dormindo;
    private boolean feliz;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Construtor:

    public Pessoa(int idade, String nome, double altura, String genero) {
        setIdade(idade);
        setNome(nome);
        setAltura(altura);
        setGenero(genero);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Getters:

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public double getAltura() {
        return altura;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isDormindo() {
        return this.dormindo;
    }

    public boolean isFeliz() {
        return this.feliz;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Setters:

    public void setIdade(int idade) {
        if (idade > 0) {
            this.idade = idade;
        } else {
            System.out.println("Idade inválida.");
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAltura(double altura) {
        if (altura > 0) {
            this.altura = altura;
        } else {
            System.out.println("Altura inválida.");
        }
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDormindo(boolean dormindo) {
        this.dormindo = dormindo;
    }

    public void setFeliz(boolean feliz) {
        this.feliz = feliz;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //ToString:

    public String toString() {
        return "Pessoa{" +
                "idade = " + getIdade() +
                ", nome = " + getNome() +
                ", altura = " + getAltura() +
                ", genero = " + getGenero() +
                ", dormindo = " + isDormindo() +
                ", feliz = " + isFeliz() +
                "}";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Métodos interface:

    @Override
    public void fazerAniversario() {
        setIdade(getIdade() + 1);
    }

    @Override
    public void comer(String comida) {
        setFeliz(true);
    }

    @Override
    public void dormir() {
        setDormindo(true);
    }

    @Override
    public void acordar() {
        setDormindo(false);
    }

}
