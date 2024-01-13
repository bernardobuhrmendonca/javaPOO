package OBJ08;

import OBJ04.ContaBanco;
import OBJ06.Pessoa;
public class Funcionario extends Pessoa {
    private double salario;
    public String salarioFormatado;
    private double horas;
    private ContaBanco contaBancoFuncionario;

     public Funcionario(int idade, String nome, double altura, String genero, ContaBanco contaBancoFuncionario, double salario) {
        super(idade, nome, altura, genero);
        setContaBancoFuncionario(contaBancoFuncionario);
        setSalario(salario);
    }

    public double getSalario() {
        return this.salario;
    }

    public double getHoras() {
        return this.horas;
    }

    public ContaBanco getContaBancoFuncionario() {
        return this.contaBancoFuncionario;
    }

    public String getSalarioFormatado() {
        return salarioFormatado;
    }

    public void setSalario(double salario) {
        if (salario > 0) {
            this.salario = salario;
            setSalarioFormatado(salario);
        } else {
            System.out.println("Valor inválido para o salário.");
        }
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public void setContaBancoFuncionario(ContaBanco contaBancoFuncionario) {
        this.contaBancoFuncionario = contaBancoFuncionario;
    }

    public void setSalarioFormatado(double salario) {
        this.salarioFormatado = String.format("%1.2f", salario);
    }
}
