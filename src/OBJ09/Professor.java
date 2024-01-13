package OBJ09;

import OBJ04.ContaBanco;
import OBJ07.Aluno;
import OBJ08.Funcionario;

public class Professor extends Funcionario implements InterfaceProfessor {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Atributos:

    private String cursoDeFormacao;
    private String materiaQueLessiona;
    private int aulasNoMes;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Construtor:

    public Professor(int idade, String nome, double altura, String genero, ContaBanco contaBancoFuncionario, double salario) {
        super(idade, nome, altura, genero, contaBancoFuncionario, salario);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Getters:

    public String getCursoDeFormacao() {
        return this.cursoDeFormacao;
    }

    public int getAulasNoMes() {
        return this.aulasNoMes;
    }

    public String getMateriaQueLessiona() {
        return this.materiaQueLessiona;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Setters:

    public void setCursoDeFormacao(String cursoDeFormacao) {
        this.cursoDeFormacao = cursoDeFormacao;
    }

    public void setAulasNoMes(int aulasNoMes) {
        this.aulasNoMes = aulasNoMes;
    }

    public void setMateriaQueLessiona(String materiaQueLessiona) {
        this.materiaQueLessiona = materiaQueLessiona;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //ToString:

    @Override
    public String toString() {
        return "Professor{" +
                "idade = " + getIdade() +
                ", nome = " + getNome() +
                ", cursoDeFormacao = " + getCursoDeFormacao() +
                ", matéria que lessiona = " + getMateriaQueLessiona() +
                ", aulas no mês = " + getAulasNoMes() +
                ", conta de banco = " + getContaBancoFuncionario().getNumeroConta() +
                ", salário = R$" + getSalarioFormatado() +
                "}";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Métodos interface:
    @Override
    public void darNota(Aluno aluno, double nota) {
        if (aluno.isFezAProva()) {
            aluno.setNota(aluno.getNota() + nota);
        } else {
            System.out.println("O aluno não fez a prova, não é possível inserir nota.");
        }
    }

    @Override
    public void darAula() {
        System.out.println("Dando aula...");
        setAulasNoMes(getAulasNoMes() + 1);
        System.out.println("Aula computada!");
        setHoras(getHoras() + (double) 5/6);
    }
}
