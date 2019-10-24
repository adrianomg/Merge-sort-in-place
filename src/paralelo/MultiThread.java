/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paralelo;

/**
 *
 * @author Adriano
 */
class UmaThread extends Thread {

    private int delay;

    public UmaThread(String identificacao, int delay) {

        super(identificacao);

        this.delay = delay;

    }

    public void run() {

        String identificacao = this.getName();

        try {

            sleep(delay);

        } catch (InterruptedException e) {

            System.out.println("Thread: " + identificacao + " foi interrompida");

        }

        System.out.println(">>" + identificacao + " " + delay);

    }
}

public class MultiThread {

    public static void main(String[] args) {

        UmaThread t1, t2, t3;

        t1 = new UmaThread("Primeira", (int) (Math.random() * 8000));

        t2 = new UmaThread("Segunda", (int) (Math.random() * 8000));

        t3 = new UmaThread("Terceira", (int) (Math.random() * 8000));



        t1.start();

        t2.start();

        t3.start();

    }
}