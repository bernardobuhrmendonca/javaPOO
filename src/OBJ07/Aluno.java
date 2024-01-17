package OBJ07;

import OBJ01.Caneta;
import OBJ04.ContaBanco;
import OBJ06.Pessoa;

public class Aluno extends Pessoa implements InterfaceAluno{

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Atributos:

    private String matricula;
    private double nota;
    private String curso;
    private boolean matriculaAtiva;
    private int serieOuPeriodo;
    private boolean aprovado;
    private boolean fezAProva;
    private ContaBanco contaBancoAluno;
    private double mensalidade;
    private boolean mensalidadePaga;
    private int porcentagemBolsa;

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

    public int getSerieOuPeriodo() {
        return this.serieOuPeriodo;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public boolean isFezAProva() {
        return fezAProva;
    }

    public ContaBanco getContaBancoAluno() {
        return this.contaBancoAluno;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public int getPorcentagemBolsa() {
        return porcentagemBolsa;
    }

    public boolean isMensalidadePaga() {
        return mensalidadePaga;
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

    public void setSerieOuPeriodo(int serieOuPeriodo) {
        this.serieOuPeriodo = serieOuPeriodo;
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

    public void setContaBancoAluno(ContaBanco contaBancoAluno) {
        this.contaBancoAluno = contaBancoAluno;
    }

    public void setMensalidade(double mensalidade) {
        if (!isMatriculaAtiva()) {
            System.out.println("Matrícula inativa, impossível atribuir valor de mensalidade.");
            this.mensalidade = 0;
        } else {
            if (mensalidade>0 && porcentagemBolsa != 100){
                this.mensalidade = mensalidade;
            } else if (mensalidade==0 && getPorcentagemBolsa()==100) {
                this.mensalidade = mensalidade;
            } else {
                System.out.println("Incoerência entre valor de mensalidade e porcentagem de bolsa.");
            }
        }
    }

    public void setPorcentagemBolsa(int porcentagemBolsa) {
        if (!isMatriculaAtiva()) {
            System.out.println("Matrícula inativa, impossível atribuir valor de mensalidade.");
            this.mensalidade = 0;
        } else {
            if (porcentagemBolsa>0 && porcentagemBolsa<=100){
                this.porcentagemBolsa = porcentagemBolsa;
                setMensalidade(getMensalidade() - getMensalidade() * getPorcentagemBolsa() / 100);
                System.out.println("Porcentagem de bolsa atualizada!");
            } else if (porcentagemBolsa==0) {
                if (getPorcentagemBolsa()==0){
                    System.out.println("Esse aluno já não possuia nenhum valor de bolsa.");
                } else {
                    System.out.println("Porcentagem de bolsa atualizada. O aluno deixou de ser bolsista.");
                    this.porcentagemBolsa = porcentagemBolsa;
                }
            } else {
                System.out.println("Valor inválido para porcentagem de bolsa.");
            }
        }
    }

    public void setMensalidadePaga(boolean mensalidadePaga) {
        this.mensalidadePaga = mensalidadePaga;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //ToString:

    public String toString() {
        return "Aluno{" +
                "idade = " + getIdade() +
                ", nome = " + getNome() +
                ", matricula = " + getMatricula() +
                ", nota = " + getNota() +
                ", curso = " + getCurso() +
                ", matriculaAtiva = " + isMatriculaAtiva() +
                ", série Ou Período = " + getSerieOuPeriodo() +
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

    @Override
    public void pagarMensalidade(ContaBanco contaBancoEscola, ContaBanco contaBancoAluno) {
        getContaBancoAluno().tranferencia(contaBancoEscola, contaBancoAluno, getMensalidade());
        setMensalidadePaga(true);
    }

}
