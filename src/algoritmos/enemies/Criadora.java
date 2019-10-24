package algoritmos.enemies;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Criadora {

    private static void shuffle(Integer[] vetor, int i) {
    }

    //public static Integer[] vetor4 = new Integer[40];
    public Integer[] concatena(Integer vetor1[], Integer vetor2[]) { // Concatena vetor1 e vetor2
        Integer[] vetor3;
        vetor3 = new Integer[vetor1.length + vetor2.length];

        System.arraycopy(vetor1, 0, vetor3, 0, vetor1.length);
        System.arraycopy(vetor2, 0, vetor3, vetor1.length, vetor2.length);

        return vetor3;

    }

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
    // Gerando o arquivo para testes

//
//    private static Integer[] leArquivo(String nomeArquivo, int tam) {
//
//        File arq = new File(nomeArquivo + tam + ".txt");
//
//        System.out.println(nomeArquivo + tam + ".txt");
//
//        Integer[] vetor4 = null;
//        try {
//            // Indicamos o arquivo que ser� lido
//            FileReader fileReader = new FileReader(arq);
//            // Criamos o objeto bufferReader que nos
//            // oferece o m�todo de leitura readLine()
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            // String que ir� receber cada linha do arquivo
//            String linha = null;
//            // Fazemos um loop linha a linha no arquivo,
//            // enquanto ele seja diferente de null.
//            // O m�todo readLine() devolve a linha na
//            // posicao do loop para a variavel linha.
//
//            int tamanho = Integer.valueOf(bufferedReader.readLine());
//            vetor4 = new Integer[tamanho];
//            int i = 0;
//            while ((linha = bufferedReader.readLine()) != null) {
//                vetor4[i] = Integer.valueOf(linha);
//                i++;
//            }
//            // liberamos o fluxo dos objetos ou fechamos o arquivo
//            fileReader.close();
//            bufferedReader.close();
//        } catch (IOException e) {
//        }
//        return vetor4;
//    }
//    public void criaArquivo(String nomeArquivo, Integer[] vetor3) {
//
//        File arquivo =new File(nomeArquivo + vetor3.length + ".txt");
//        FileOutputStream fos = null;
//        try {
//            fos = new FileOutputStream(arquivo);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            String string = " ";//, linha = "\r\n";
//
//            fos.write(Integer.valueOf(vetor3.length).toString().getBytes("UTF-8"));
//
//            fos.write(string.toString().getBytes("UTF-8"));
//
//            for (int i = 0; i < vetor3.length; i++) {
//                fos.write(vetor3[i].toString().getBytes("UTF-8"));
//                fos.write(string.toString().getBytes("UTF-8"));
//
//            }
//            //fos.write(linha.toString().getBytes("UTF-8"));
//
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public void criaArquivo(String nomeArquivo, Integer[] vetor3) {

        File arquivo = new File(nomeArquivo + vetor3.length + ".txt");
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(arquivo, true));
        } catch (IOException ex) {
            Logger.getLogger(Criadora.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String string = " ", linha = "\r\n";

            bw.write(Integer.valueOf(vetor3.length).toString());

            bw.write(string.toString());

            for (int i = 0; i < vetor3.length; i++) {
                bw.write(vetor3[i].toString());
                bw.write(string.toString());

            }
            bw.write(linha.toString());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Geradora gera = new Geradora();
        Criadora m = new Criadora();



        //for (int y = 0; y <= 6; y++) {
        //int a = 10;

        //int tam = (int) Math.pow(a, y + 1);
        int tam = 5000000, y = 500;
        System.out.println("Arquivo " + y + " : " + tam);

        for (int x = 0; x < 1; x++) {

            Integer[] vetor1 = gera.criaVetorAleatorioRepetido(tam);
            Integer[] vetor2 = gera.criaVetorAleatorioRepetido(tam);

            MergeSort.sort(vetor1);
            MergeSort.sort(vetor2);

            Integer[] vetor3 = m.concatena(vetor1, vetor2);
            // Integer[] vetor3 = gera.criaVetorOrdenadoRepetido(tam);

            //Embaralhador de vetor
//                Integer[] vetor3 = gera.criaVetorInvertidoRepetido(tam);
//                MergeSort ms = new MergeSort();
//                ms.sort(vetor3);
//                int metade = tam / 2;
//                Integer[] vetor1 = java.util.Arrays.copyOfRange(vetor3, 0, metade);
//                Integer[] vetor2 = java.util.Arrays.copyOfRange(vetor3, metade, vetor3.length);
//                vetor3 = m.concatena(vetor2, vetor1);

            File arquivo = new File("ArquivoTeste" + vetor3.length + ".txt");
            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter(arquivo, true));
            } catch (IOException ex) {
                Logger.getLogger(Criadora.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                String string = " ", linha = "\r\n";

                bw.write(Integer.valueOf(vetor3.length).toString());

                bw.write(string.toString());

                for (int i = 0; i < vetor3.length; i++) {
                    bw.write(vetor3[i].toString());
                    bw.write(string.toString());

                }
                bw.write(linha.toString());

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
