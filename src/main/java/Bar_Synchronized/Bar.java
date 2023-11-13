/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bar_Synchronized;

/**
 *
 * @author mario
 */
class Bar {

    private int aforoTotal;
    private int aforoActual;

    public Bar(int aforo) {
        this.aforoTotal = aforo;
    }

    /*En la clase Bar implementar los métodos entrar() y salir()
    añadir los atributos que sean necesarios y añadir al constructor las acciones que sean precisas
    usar synchronized*/
    
    public synchronized void entrada(int id) throws InterruptedException {
        while (aforoActual == aforoTotal) {            
            System.out.println("Cliente "+id+" espera.");
            this.wait();//Ponemos a los hilos en espera
        }
        aforoActual++;
        abrirPuertaE(id);
    }

    public synchronized void salir(int id) {
        abrirPuertaS(id);
        this.notify();//Notifica a otro hilo
        aforoActual--;
    }

    public synchronized void abrirPuertaE(int id) {
        System.out.println("Se puede entrar."+id);
    }

    public synchronized void abrirPuertaS(int id) {
        System.out.println("Se puede salir."+id);
    }

}
