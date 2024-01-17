package OBJ05;

public class ControleRemoto implements InterfaceControle {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Atributos:

    private int volume;
    private boolean mute;
    private boolean ligado;
    private boolean tocando;
    private int aux;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Construtor:

    public ControleRemoto() {
        setVolume(50);
        setLigado(false);
        setTocando(false);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Getters:
    public int getVolume() {
        return this.volume;
    }

    public boolean isMute() {
        return this.mute;
    }

    public boolean isLigado() {
        return this.ligado;
    }

    public boolean isTocando() {
        return this.tocando;
    }

    public int getAux() {
        return this.aux;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Setters:

    public void setVolume(int volume) {
        if (this.isLigado()) {
            if (volume >= 0 && volume <= 100) {
                this.volume = volume;
            }
        }
    }

    public void setMute(boolean mute) {
        if (this.isLigado()) {
            this.mute = mute;
        }
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public void setTocando(boolean tocando) {
        if (this.isLigado()) {
            this.tocando = tocando;
        }
    }

    public void setAux(int aux) {
        this.aux = aux;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //ToString:

    public String toString() {
        return "ControleRemoto{" +
                "volume = " + this.volume +
                ", mute = " + this.mute +
                ", ligado = " + this.ligado +
                ", tocando = " + this.tocando +
                ", aux = " + this.aux +
                '}';
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Métodos interface:

    @Override
    public void aumentarVolume() {
        if (this.isLigado() && this.getVolume() < 100) {
            if (this.isMute()) {
                mute_desmute();
            }
            setVolume(this.getVolume() + 1);
        }
    }

    @Override
    public void diminuirVolume() {
        if (this.isLigado() && this.getVolume() > 0) {
            if (this.isMute()) {
                mute_desmute();
            }
            setVolume(this.getVolume() - 1);
        } else if (this.getVolume() == 0) {
            System.out.println("O volume já está no mínimo!");
        }
    }

    @Override
    public void mute_desmute() {
        if (!isMute()) {
            setAux(this.getVolume());
            setMute(true);
            setVolume(0);
        } else {
            setMute(false);
            this.setVolume(this.getAux());
        }
    }

    @Override
    public void ligar_desligar() {
        setLigado(!this.isLigado());
    }

    @Override
    public void play_pause() {
        if (this.isLigado()) {
            setTocando(!this.isTocando());
        }
    }

    @Override
    public void menu() {
        if (this.ligado) {
            System.out.println("\t----- MENU -----\t");
            System.out.println("LIGADO? " + isLigado());
            System.out.println("TOCANDO? " + isTocando());
            System.out.print("VOLUME: " + getVolume() + " ");
            for (int aux = 0; aux <= getVolume() - 1; aux = aux + 2) {
                System.out.print("|");
            }
        }
    }

    @Override
    public void fecharMenu() {
        System.out.println();
        System.out.println("Fechando menu...");
    }
}
