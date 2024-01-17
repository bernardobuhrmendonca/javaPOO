package OBJ04;

public class ContaBanco implements InterfaceConta {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Atributos:

    private String usuarioConta;
    private String tipo;
    private int numeroConta;
    private double saldo;
    private boolean aberta;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Construtores:

    public ContaBanco() {
        setSaldo(0);
        setAberta(false);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Getters:

    public String getUsuarioConta() {
        return this.usuarioConta;
    }

    public String getTipo() {
        return this.tipo;
    }

    public int getNumeroConta() {
        return this.numeroConta;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public boolean isAberta() {
        return this.aberta;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Setters:

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setUsuarioConta(String usuarioConta) {
        this.usuarioConta = usuarioConta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }

    public void setTipo(String tipo) {
        if (tipo.equalsIgnoreCase("Conta Corrente") || tipo.equalsIgnoreCase("Conta Poupança")) {
            this.tipo = tipo;
        } else {
            System.out.println("OPÇÃO INVÁLIDA!");
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //ToString:

    public String toString() {
        return "Conta Banco{" +
                "Usuário Conta = " + usuarioConta +
                ", Tipo = " + tipo +
                ", Número Conta =" + numeroConta +
                ", Saldo = " + saldo +
                ", Aberta = " + aberta +
                '}';
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Métodos interface:

    @Override
    public void abrirConta(String tipo, String usuarioConta, int numeroConta) {
        setAberta(true);
        setTipo(tipo);
        setUsuarioConta(usuarioConta);
        setNumeroConta(numeroConta);
        if (getTipo().equalsIgnoreCase("Conta Corrente")) {
            setSaldo(getSaldo() + 50);
        } else if (getTipo().equalsIgnoreCase("Conta Poupança")) {
            setSaldo(getSaldo() + 150);
        } else {
            System.out.println("TIPO DE CONTA INVÁLIDA! NÃO FOI POSSÍVEL ABRI-LA.");
        }
    }

    @Override
    public void fecharConta() {
        if (getSaldo() == 0 && isAberta()) {
            setAberta(false);
        } else if (getSaldo() != 0) {
            System.out.println("SALDO DIFERENTE DE 0! MODIFIQUE-O PARA 0 PARA PODER ENCERRAR A CONTA.");
        } else {
            System.out.println("CONTA JÁ FECHADA!");
        }
    }

    @Override
    public void sacar(double valor) {
        if (getSaldo() >= valor && valor >= 0 && isAberta()) {
            setSaldo(getSaldo() - valor);
        } else if (getSaldo() < valor) {
            System.out.println("SALDO INSUFICIENTE.");
        } else if (valor <= 0) {
            System.out.println("VALOR INVÁLIDO.");
        } else {
            System.out.println("CONTA FECHADA, ABRA ELA NOVAMENTE PARA REALIZAR SAQUES.");
        }
    }

    @Override
    public void depositar(double valor) {
        if (isAberta()) {
            setSaldo(getSaldo() + valor);
        } else {
            System.out.println("CONTA FECHADA, ABRA ELA NOVAMENTE PARA REALIZAR DEPÓSITOS.");
        }
    }

    @Override
    public void tranferencia(ContaBanco contaSaque, ContaBanco contaDeposito, double valor) {
        contaSaque.sacar(valor);
        contaDeposito.depositar(valor);
    }

    @Override
    public void mensalidade() {
        if (isAberta()) {
            if (getTipo().equalsIgnoreCase("Conta Corrente")) {
                setSaldo(getSaldo() - 12);
            } else if (getTipo().equalsIgnoreCase("Conta Poupança")) {
                setSaldo(getSaldo() - 20);
            } else {
                System.out.println("TIPO DE CONTA INVÁLIDA! NÃO FOI POSSÍVEL COBRAR A MENSALIDADE.");
            }
        } else {
            System.out.println("CONTA FECHADA, NÃO FOI POSSÍVEL EFETUAR A COBRANÇA.");
        }
    }

    @Override
    public void infoConta() {
        System.out.println("NOME DO CLIENTE: " + getUsuarioConta());
        System.out.println("NÚMERO DA CONTA: " + getNumeroConta());
        System.out.printf("SALDO: R$%1.2f", getSaldo());
        System.out.println();
        System.out.println("TIPO DA CONTA: " + getTipo());
        System.out.println("Conta aberta? " + isAberta());
    }

}
