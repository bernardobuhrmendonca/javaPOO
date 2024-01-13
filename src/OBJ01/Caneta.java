package OBJ01;

public class Caneta implements InterfaceCaneta {

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Atributos:

    private String marca;
    private String cor;
    private String cordotubo;
    private double ponta;
    private double porcTinta;
    private boolean tampada;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Contrutor:

    public Caneta(String marca, String cor, double ponta) {
        setTampada(true);
        setCordotubo("transparente");
        setPorcTinta(100);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Getters:

    public String getMarca() {
        return this.marca;
    }

    public String getCor() {
        return this.cor;
    }

    public String getCordotubo() {
        return this.cordotubo;
    }

    public double getPonta() {
        return this.ponta;
    }

    public double getPorcTinta() {
        return this.porcTinta;
    }

    public boolean isTampada() {
        return this.tampada;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Setters:

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setCordotubo(String cordotubo) {
        this.cordotubo = cordotubo;
    }

    public void setPonta(double ponta) {
        this.ponta = ponta;
    }

    public void setPorcTinta(double porcTinta) {
        this.porcTinta = porcTinta;
    }

    public void setTampada(boolean tampada) {
        this.tampada = tampada;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Métodos interface:

    @Override
    public void tampar() {
        setTampada(true);
    }

    @Override
    public void destampar() {
        setTampada(false);
    }

    @Override
    public void escrever(String frase) {
        String[] letras;
        if (!isTampada() && getPorcTinta() > 0) {
            System.out.println(frase);
            letras = frase.split("");
            for (int aux = 0; aux < letras.length; aux++) {
                if (letras[aux].equalsIgnoreCase(" ")) {
                    letras[aux] = "";
                }
            }
            for (int aux = 0; aux < letras.length; aux++) {
                setPorcTinta(getPorcTinta() - 0.1);
            }
        } else if (isTampada()) {
            System.out.println("\nNão é possível escrever, pois a caneta está tampada.\n");
        } else {
            System.out.println("Não é possível escrever, pois a caneta está sem tinta.\n");
        }
    }

    @Override
    public void status() {
        System.out.println("Marca: " + getMarca());
        System.out.println("Cor: " + getCor());
        System.out.println("Cor do tubo: " + getCordotubo());
        System.out.println("Ponta: " + getPonta());
        System.out.println("Tampada? " + isTampada());
        System.out.println("Tinta restante: " + getPorcTinta() + "%");
    }
}
