/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bar_Semaphore;

import Bar_Synchronized.*;
import java.util.concurrent.Semaphore;

/**
 *
 * @author mario
 */
class Bar {

    Semaphore semaforo = new Semaphore(5);

    /*En la clase Bar implementar los métodos entrar() y salir()
    añadir los atributos que sean necesarios y añadir al constructor las acciones que sean precisas
    usar synchronized*/

    public void entrada(int id) throws InterruptedException {
        semaforo.acquire();
        abrirPuertaE(id);
    }

    public void salir(int id) {
        semaforo.release();
        abrirPuertaS(id);
    }

    public void abrirPuertaE(int id) {
        System.out.println("Se puede entrar." + id);
    }

    public void abrirPuertaS(int id) {
        System.out.println("Se puede salir." + id);
    }

}
