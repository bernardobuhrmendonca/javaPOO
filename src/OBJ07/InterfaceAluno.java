package OBJ07;

import OBJ01.Caneta;
import OBJ04.ContaBanco;

public interface InterfaceAluno {
    void estudar();
    void fazerAnotacoes(Caneta caneta, String frase);
    void fazerProva();
    void pagarMensalidade(ContaBanco contaBancoEscola, ContaBanco contaBancoAluno);
}
