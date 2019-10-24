/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos.enemies;
/**
 *
 * @author Adriano
 */
public class Geradora {
    public Integer[] criaVetorAleatorioRepetido(int tam) {
        MergeSort merge = new MergeSort();
        Integer vetor[] = new Integer[tam/2];
        for (int i = 0; i < vetor.length; i++) {
            Integer rnd1 = (int) (1 + Math.random() * (tam)); // gera um valor randomico de 0.0 ate menores q 1.0, multiplica por 30 e soma 1. Convertendo o resultado para int. 
            vetor[i] = rnd1;
        }
        merge.sort(vetor);
        return vetor;
    }
    public Integer[] criaVetorAleatorioNaoRepetido(int tam) {
        Integer vetor[] = new Integer[tam];
        for (int x = 0; x < vetor.length; x++) {
            vetor[x] = x;
        }
        int index;
        for (int i = vetor.length; i > 1; i--) {
            Integer rnd1 = (int) (1 + Math.random() * 9999999);
            index = (int) Math.abs(rnd1 % i);
            int tmp = vetor[i - 1];
            vetor[i - 1] = vetor[index];
            vetor[index] = tmp;
        }
        return vetor;
    }
    public Integer[] criaVetorInvertidoNaoRepetido(int tam) {
        Integer vetor1[] = new Integer[tam / 2];
        Integer vetor2[] = new Integer[tam / 2];
        Criadora m = new Criadora();
        for (int i = 0; i < tam / 2; i++) {
            vetor1[i] = i;
        }
        int x = 0;
        for (int i = tam / 2; i < tam; i++) {
            vetor2[x] = i;
            x++;
        }
        Integer vetor3[] = m.concatena(vetor2, vetor1);
        return vetor3;
    }
    public Integer[] criaVetorInvertidoRepetido(int tam) {
        Integer vetor[] = new Integer[tam];
        for (int i = 0; i < tam; i++) {
            Integer rnd1 = (int) (1 + Math.random() * (tam*0.8)); // gera um valor randomico de 0.0 ate menores q 1.0, multiplica por 30 e soma 1. Convertendo o resultado para int. 
            vetor[i] = rnd1;
        }
        return vetor;
    }
    public Integer[] criaVetorOrdenadoNaoRepetido(int tam) {
        Integer vetor[] = new Integer[tam];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i;
        }
        return vetor;
    }
    public Integer[] criaVetorOrdenadoRepetido(int tam) {
        MergeSort ms = new MergeSort();
        Integer vetor[] = new Integer[tam];
        for (int i = 0; i < vetor.length; i++) {
            Integer rnd1 = (int) (1 + Math.random() * (tam*0.8)); // gera um valor randomico de 0.0 ate menores q 1.0, multiplica por 30 e soma 1. Convertendo o resultado para int. 
            vetor[i] = rnd1;
        }
        ms.sort(vetor);
        return vetor;
    }
}