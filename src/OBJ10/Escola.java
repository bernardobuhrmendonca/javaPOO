package OBJ10;

import OBJ04.ContaBanco;
import OBJ08.Funcionario;

public class Escola implements InterfaceEscola {
    
    @Override
    public void pagarFuncionario(Funcionario funcionario, ContaBanco contaBancoFuncionario, ContaBanco contaBancoEscola) {
        if (funcionario.getSalario()>0) {
            contaBancoEscola.tranferencia(contaBancoEscola, contaBancoFuncionario, funcionario.getSalario());
        } else {
            System.out.println("Dentermine o valor do salário para realizar a tranferência.");
        }
    }
}
