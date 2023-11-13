/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bar_ReentrantLock_Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author mario
 */
public class Bar {

    private final int aforoTotal = 5;
    private int aforoActual;
    private int nEwok;
    private int nGorax;

    private Lock lock = new ReentrantLock();
    private Condition lockEwok = lock.newCondition();
    private Condition lockGorax = lock.newCondition();

    //Creamos un Booleano para saber si esta lleno o no el bar 
    public boolean noLleno() {
        if (aforoActual < aforoTotal) {
            aforoActual++;
            return true;
        }
        return false;
    }

    public void entrar(int i, String tipo) throws InterruptedException {
        lock.lock();
        while (noLleno() == false) {
            System.out.println(tipo + " espera." + i);
            if (tipo.compareTo("Ewok") == 0) {
                nEwok++;
                lockEwok.await();
                nEwok--;
            }
            if (tipo.compareTo("Gorax") == 0) {
                nGorax++;
                lockGorax.await();
                nGorax--;
            }
        }
        System.out.println("Ha entrado el " + tipo + " id: " + i);
        System.out.println("En cola:");
        System.out.println("\tEwok: " + nEwok);
        System.out.println("\tGorax: " + nGorax);
        lock.unlock();
    }

    public void salir(int i) {
        lock.lock();
        System.out.println("Sale el cliente: " + i);
        if (nEwok > 0) {
            lockEwok.signal();
        } else {
            lockGorax.signal();
        }
        aforoActual--;
        lock.unlock();
    }
}
