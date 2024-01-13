package OBJ11;

public abstract class Animal {

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Atributos:

    private boolean vivo;
    private double tamanho;
    private String cor;
    private int idade;
    private int numeroDeMembros;
    private double peso;

    public Animal(double tamanho, String cor, int idade, int numeroDeMembros, double peso) {
        setTamanho(tamanho);
        setVivo(true);
        setCor(cor);
        setIdade(idade);
        setMembros(numeroDeMembros);
        setPeso(peso);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Getters:

    public boolean isVivo() {
        return this.vivo;
    }

    public double getTamanho() {
        return this.tamanho;
    }

    public String getCor() {
        return this.cor;
    }

    public int getIdade() {
        return this.idade;
    }

    public int getMembros() {
                return this.numeroDeMembros;
    }

    public double getPeso() {
                return this.peso;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Setters:

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setMembros(int membros) {
                this.numeroDeMembros = membros;
    }

    public void setPeso(double peso) {
                this.peso = peso;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //ToString:

    public String toString() {
        return "Animal{" +
                "vivo = " + isVivo() +
                ", tamanho = " + getTamanho() +
                ", cor = " + getCor() +
                ", idade = " + getIdade() +
                ", número de membros = " + getMembros() +
                ", peso = " + getPeso() +
                "}";
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Métodos abstratos:

    public abstract void locomover(int minutos);
    public abstract void comer();
    public abstract void fazerAniversario();
}
