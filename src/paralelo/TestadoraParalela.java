package paralelo;

import algoritmos.enemies.Inutil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author Adriano
 */
public class TestadoraParalela {

    public boolean verifica(Integer vetor[]) {
        for (int i = 0; i < (vetor.length - 1); ++i) {
            if (vetor[i] > vetor[i + 1]) {
                System.out.println("Nao ordenado");
                return false;

            }
        }
        System.out.println("Ordenado");
        return true;
    }
    
    private static Integer[] leArquivo(String nomeArquivo, int tam) {

        File arq = new File("C:/Users/Adriano/workspace2/ordenacao/Arquivos/um_vetor/aleatoriorepetido/" + nomeArquivo + tam + ".txt");

        System.out.println(nomeArquivo + tam + ".txt");

        Integer[] vetor4 = null;
        try {
            // Indicamos o arquivo que ser� lido
            FileReader fileReader = new FileReader(arq);
            // Criamos o objeto bufferReader que nos
            // oferece o m�todo de leitura readLine()
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // String que ir� receber cada linha do arquivo
            String linha = null;
            // Fazemos um loop linha a linha no arquivo,
            // enquanto ele seja diferente de null.
            // O m�todo readLine() devolve a linha na
            // posicao do loop para a variavel linha.

            //int tamanho = Integer.valueOf(bufferedReader.readLine());
            //vetor4 = new Integer[tamanho];
            int j;
            while ((linha = bufferedReader.readLine()) != null) {
                String valores[] = linha.split(" ");
                int tamanhoVetor = Integer.parseInt(valores[0]);
                vetor4 = new Integer[tamanhoVetor];
                // System.out.println(nomeArquivo + tam + ".txt ");

                for (j = 0; j < tamanhoVetor; j++) {

                    vetor4[j] = Integer.parseInt(valores[j + 1]);
//                    System.out.println(vetor4[j]);
                }

            }
            // liberamos o fluxo dos objetos ou fechamos o arquivo
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
        }
        return vetor4;
    }

    public Integer[] testa(int num_exec, int algoritmo, int tam, Integer[] vetor4) {
        int count = 0;
        double delay = 0, start = 0, aux = Integer.MAX_VALUE, media = 0;
        ParallelInPlaceStableSort pms = new ParallelInPlaceStableSort();
        ParallelInPlaceStableSort2 pms2 = new ParallelInPlaceStableSort2();
        Integer[] vetoraux = null;
        try {
            for (int x = 0; x < num_exec; x++) {
                vetoraux = vetor4.clone();
                start = System.currentTimeMillis();

                switch (algoritmo) {
                    case 1:
                        pms.mesclar(vetoraux, 0, vetoraux.length / 2, vetoraux.length);
                        break;
                    case 2:
                        pms2.mesclar(vetoraux, 0, vetoraux.length / 2, vetoraux.length);

                        break;
                }

                delay = System.currentTimeMillis() - start;
//                System.out.println(x + " - " + delay + ";");
                if (x >= (num_exec / 10)) {
                    //System.out.println(x + " - " + "Demorou " + delay + " milissegundos");
                    if (delay < aux) {
                        aux = delay;

                    }
                    media += delay;
                    count++;
                }
            }
            media = media / count;
            System.out.println("Média dos tempos: " + media);
            System.out.println("Menor tempo foi: " + aux);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return vetoraux;
    }

    public static void main(String[] args) {

        int tam = 10000000;
        int num_exec = 1;
        int algoritmo = 2;


        Integer[] vetor4 = leArquivo("ArquivoTeste", tam);


        TestadoraParalela teste = new TestadoraParalela();

        vetor4 = teste.testa(num_exec, algoritmo, tam, vetor4);
        //teste.verifica(vetor4);

//        for (int i = 0; i < vetor4.length; i++) {
//            System.out.println(vetor4[i]);
//        }


    }
}