/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos.enemies;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author Adriano
 */
public class TestadoraN {

    public void testa(int num_exec, int algoritmo, int tam) {
              File arq = new File("C:/Users/Adriano/workspace2/ordenacao/Arquivos/n_vetores/invertidorepetido/ArquivoTeste" + tam + ".txt");

        System.out.println("Arquivoteste" + tam + ".txt");

        Integer[] vetor4 = null;

        int count = 0;
        double delay = 0, start = 0, aux = Integer.MAX_VALUE, mediaTotal = 0;

        try {
            FileReader fileReader = new FileReader(arq);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha = null;

            int j;
            while ((linha = bufferedReader.readLine()) != null) {
                String valores[] = linha.split(" ");
                int tamanhoVetor = Integer.parseInt(valores[0]);
                vetor4 = new Integer[tamanhoVetor];

                for (j = 0; j < tamanhoVetor; j++) {

                    vetor4[j] = Integer.parseInt(valores[j + 1]);
                }
                InPlaceStableSort ms = new InPlaceStableSort();
                InPlaceStableSort2 ms2 = new InPlaceStableSort2();

                try {
                    for (int x = 0; x < num_exec / 100; x++) {
                        Integer[] vetoraux = vetor4.clone();
                        start = System.currentTimeMillis();

                        switch (algoritmo) {
                            case 1:
                                ms.mesclar(vetoraux, 0, vetoraux.length / 2, vetoraux.length);
                                break;
                            case 2:
                                ms2.mesclar(vetoraux, 0, vetoraux.length / 2, vetoraux.length);
                                break;
                        }
                        double media = 0;
                        delay = System.currentTimeMillis() - start;
                        if (x >= 2) {
                            if (delay < aux) {
                                aux = delay;
                            }
                            media += delay;
                            count++;
                        }
                    mediaTotal += media;

                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
//                for (int z = 0; z < vetor4.length; z++) {
//                    //System.out.println(vetor4[z]);
//                }
            }
            System.out.println("Media: " + mediaTotal/count);

            // liberamos o fluxo dos objetos ou fechamos o arquivo
            fileReader.close();
            bufferedReader.close();



        } catch (IOException e) {
        }
  
    }

    public static void main(String[] args) {

        int tam = 1000000;
        int num_exec = 1000;
        int algoritmo = 1;

        TestadoraN testeN = new TestadoraN();
        testeN.testa(num_exec, algoritmo, tam);

    }
}