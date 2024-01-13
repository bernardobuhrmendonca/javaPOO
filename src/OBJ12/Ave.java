package OBJ12;

import OBJ11.Animal;

public class Ave extends Animal implements InterfaceAve {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Atributos:

    private String corDoBico;
    private int ovos;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Construtor:

    Ave(double tamanho, String cor, int idade, int numeroDeMembros, double peso) {
        super(tamanho, cor, idade, numeroDeMembros, peso);

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Getters:

    public String getCorDoBico() {
        return this.corDoBico;
    }

    public int getOvos() {
        return this.ovos;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Setters:

    @Override
    public void setIdade(int idade) {
       if (idade%4==0){
        super.setIdade(idade);
       } else {
           System.out.println("Idade inválida pra ave, digite um numero multiplo de 4.");
       }
    }

    public void setCorDoBico(String corDoBico) {
        this.corDoBico = corDoBico;
    }

    public void setOvos(int ovos) {
        this.ovos = ovos;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //ToString:

    @Override
    public String toString() {
        return "Ave{" +
                "vivo = " + isVivo() +
                ", tamanho = " + getTamanho() +
                ", cor = " + getCor() +
                ", idade = " + getIdade() +
                ", número de membros = " + getMembros() +
                ", peso = " + getPeso() +
                ", cor do bico = " + getCorDoBico() +
                ", ovos = " + getOvos() +
                "}";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Métodos abstratos sobrescritos e que estão na interface:

    @Override
    public void locomover(int minutos) {
        System.out.println("Voando...");
        System.out.println("A ave voou: " + (minutos * 100) + " metros.");
    }

    @Override
    public void comer() {
        System.out.println("Comendo semente...");
    }

    @Override
    public void fazerAniversario() {
        setIdade(getIdade() + 4);
        if (getIdade() > 100) {
            System.out.println("A ave morreu, ela estava muito velhinha. :(");
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Outros métodos da interface:

    public void botarOvo() {
        System.out.println("Botando ovo...");
        setOvos(getOvos() + 1);
        System.out.println("Ovo botado!");
    }
}
