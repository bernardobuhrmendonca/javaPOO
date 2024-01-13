package OBJ07;

import OBJ01.Caneta;
import OBJ06.Pessoa;

public class Aluno extends Pessoa implements InterfaceAluno{

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Atributos:

    private String matricula;
    private double nota;
    private String curso;
    private boolean matriculaAtiva;
    private int serieEperiodo;
    private boolean aprovado;
    private boolean fezAProva;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Contrutores:

    public Aluno(int idade, String nome, double altura, String genero) {
        super(idade, nome, altura, genero);
        setFezAProva(false);
        setMatriculaAtiva(true);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Getters:

    public String getMatricula() {
        return this.matricula;
    }

    public double getNota() {
        return this.nota;
    }

    public String getCurso() {
        return this.curso;
    }

    public boolean isMatriculaAtiva() {
        return this.matriculaAtiva;
    }

    public int getSerieEperiodo() {
        return this.serieEperiodo;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public boolean isFezAProva() {
        return fezAProva;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Setters:

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setMatriculaAtiva(boolean matriculaAtiva) {
        this.matriculaAtiva = matriculaAtiva;
    }

    public void setSerieEperiodo(int serieEperiodo) {
        this.serieEperiodo = serieEperiodo;
    }

    public void setAprovado(boolean aprovado) {
        if (isMatriculaAtiva()&&this.nota>=65) {
        this.aprovado = aprovado;
        } else if (!isMatriculaAtiva()) {
            System.out.println("A matricula do aluno não está ativa, logo não é possível atribuir valor de aprovação!");
        } else if (aprovado && this.nota<65){
            System.out.println("O aluno obteve menos de 65 pontos, não é possível aprová-lo.");
        }
    }

    public void setFezAProva(boolean fezAProva) {
        this.fezAProva = fezAProva;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //ToString:

    @Override
    public String toString() {
        return "Aluno{" +
                "idade = " + getIdade() +
                ", nome = " + getNome() +
                ", matricula = " + getMatricula() +
                ", nota = " + getNota() +
                ", curso = " + getCurso() +
                ", matriculaAtiva = " + isMatriculaAtiva() +
                ", serieEperiodo = " + getSerieEperiodo() +
                ", aprovado = " + isAprovado() +
                ", fezAProva = " + isFezAProva() +
                "}";
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Métodos interface:

    @Override
    public void estudar() {
        System.out.println("Estudando...");
    }

    @Override
    public void fazerAnotacoes(Caneta caneta, String frase){
        caneta.escrever(frase);
    }

    @Override
    public void fazerProva(){
        setFezAProva(true);
        System.out.println("Fazendo a prova...");
        System.out.println("Prova feita!");
    }

}
