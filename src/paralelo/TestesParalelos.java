/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paralelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adriano
 */
class Escrita extends Thread {

    public void run() {

        System.out.println("Eu sou a thread 1");


    }
}

class Escrita2 extends Thread {

    
    public void run() {
        try {
            sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Escrita2.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Eu sou a thread 2");


    }
}

public class TestesParalelos {

    public static void main(String[] args) {

        Escrita e = new Escrita();   //Cria o contexto de execução
        Escrita2 e2 = new Escrita2();

        e.start();                             //Ativa a thread
        e2.start();

    }
}
