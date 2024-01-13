package OBJ04;

public interface InterfaceConta {
    void abrirConta(String tipo, String usuarioConta, int numeroConta);

    void fecharConta();

    void sacar(double valor);

    void depositar(double valor);

    void tranferencia(ContaBanco contaDeposito, ContaBanco contaSaque, double valor);

    void mensalidade();

    void infoConta();
}
