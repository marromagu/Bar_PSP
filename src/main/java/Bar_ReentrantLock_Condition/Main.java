/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Bar_ReentrantLock_Condition;

/**
 *
 * @author mario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(".~~~~.\n"
                + "i====i_\n"
                + "|cccc|_)\n"
                + "|cccc|   \n"
                + "`-==-'");
        Bar miBar = new Bar();
        for (int i = 0; i < 10; i++) {
            Cliente miCliente = new Cliente(miBar, i, "Gorax");
            miCliente.start();
        }
        for (int i = 0; i < 10; i++) {
            Cliente miCliente = new Cliente(miBar, i, "Ewok");
            miCliente.start();
        }
    }

}
