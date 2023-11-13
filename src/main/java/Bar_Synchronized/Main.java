package Bar_Synchronized;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author mario
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(".~~~~.\n"
                + "i====i_\n"
                + "|cccc|_)\n"
                + "|cccc|   \n"
                + "`-==-'");
        Bar miBar = new Bar(5);
        for (int i = 0; i < 10; i++) {
            Cliente miCliente = new Cliente(miBar, i);
            miCliente.start();
        }
    }
}
