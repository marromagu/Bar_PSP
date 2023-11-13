/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bar_ReentrantLock_Condition;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mario
 */
public class Cliente extends Thread {//Con la clase Thread hacemos que la clase Cliente se comporte como un hilo.

    Bar miBar;
    int id;
    String tipo;

    public Cliente(Bar miBar, int id, String tipo) {
        this.miBar = miBar;
        this.id = id;
        this.tipo = tipo;
    }

    @Override
    public void run() {
        try {
            miBar.entrar(id,tipo);
            Thread.sleep(5 * 1000);
            miBar.salir(id);
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
