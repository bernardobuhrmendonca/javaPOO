package OBJ12;

import OBJ12.Ave;

public class mainAve {
    public static void main(String[] args) {
        Ave a = new Ave(1.5, "azul",12,4,5.6);
        System.out.println(a.toString());
        a.setCorDoBico("preto");
        a.setOvos(6);
        a.botarOvo();
        System.out.println(a.toString());
    }
}
