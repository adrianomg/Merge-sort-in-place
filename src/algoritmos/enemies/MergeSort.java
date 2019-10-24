package algoritmos.enemies;

//http://penguin.ewu.edu/cscd300/Topic/AdvSorting/MergeSorts/InPlace.html#Footnote

import java.util.*;

/**
 * Implementa o algoritmo de ordenação recursivo de mesclagem. Nesta versão, copia   
 * Dos subtabelas são feitas, classificado, e depois fundidos.   
 * @Author Koffman e Wolfgang  
 */

public class MergeSort extends InPlaceStableSort2 {
	/**
	 * Ordenar a matriz usando o algoritmo de classificação por intercalação.
	 *        pré: tabela contém objetos comparáveis​​.        mensagem: tabela
	 * é classificada.        @ param A matriz tabela a ser classificada    
	 */

	public static <T extends Comparable<T>> void sort(T[] table) { 
		// Uma tabela
		// com um
		// elemento
		// já está
		// classificada.

		if (table.length > 1) { // Dividir tabela em duas metades.
			int halfSize = table.length / 2;
			T[] leftTable = (T[]) new Comparable[halfSize];
			T[] rightTable = (T[]) new Comparable[table.length - halfSize];
			System.arraycopy(table, 0, leftTable, 0, halfSize);
			System.arraycopy(table, halfSize, rightTable, 0, table.length - halfSize);

			// Classificar as duas metades.
			sort(leftTable);
			sort(rightTable);

			// Mesclar as duas metades.
			merge(table, leftTable, rightTable);
		}
	}

	/**
	 * Juntar duas seqüências.         pré: leftSequence e rightSequence são
	 * classificados.         mensagem: outputSequence é o resultado mesclado e
	 * é classificado.         @ param outputSequence O destino         @ param
	 * leftSequence A entrada esquerda         @ param rightSequence A entrada à
	 * direita    
	 */

	private static <T extends Comparable<T>> void merge(T[] outputSequence, T[] leftSequence, T[] rightSequence) {
		int i = 0; // Índice para a seqüência de entrada à esquerda.
		int j = 0; // Índice para a seqüência de entrada direita.
		int k = 0; // Índice para a seqüência de saída.

		// Embora não haja dados em ambas as seqüências de entrada
		while (i < leftSequence.length && j < rightSequence.length) {

			// Encontrar o menor e
			// Inseri-lo na seqüência de saída.

			if (leftSequence[i].compareTo(rightSequence[j]) <= 0) {
				outputSequence[k++] = leftSequence[i++];
			} else {
				outputSequence[k++] = rightSequence[j++];
			}
		}

		// Afirmam: uma das seqüências tem mais itens para copiar.
		// Copy restante da seqüência de entrada à esquerda para a saída.

		while (i < leftSequence.length) {
			outputSequence[k++] = leftSequence[i++];
		}
		// Copiar entrada restante da seqüência correta para a saída.
		while (j < rightSequence.length) {
			outputSequence[k++] = rightSequence[j++];
		}
	}

	/**
	 *   * No Lugar-Merge Sort.   *   * Construção no núcleo algoritmo
	 * encontrado em   * Http://www.cs.ubc.ca/ ~ harrison / Java /
	 * MergeSortAlgorithm.java.html  
	 */
	public static void inPlaceSort(Comparable[] x) {
		inPlaceSort(x, 0, x.length - 1);
	}

	public static void inPlaceSort(Comparable[] x, int first, int last) {
		int mid, lt, rt;
		Comparable tmp;

		if (first >= last)
			return;

		mid = (first + last) / 2;

		inPlaceSort(x, first, mid);
		inPlaceSort(x, mid + 1, last);

		lt = first;
		rt = mid + 1;
		// Uma verificação extra: podemos SKIP a fusão?
		if (x[mid].compareTo(x[rt]) <= 0)
			return;

		while (lt <= mid && rt <= last) {
			// Selecione a partir da esquerda: nenhuma mudança, apenas avançar
			// lt
			if (x[lt].compareTo(x[rt]) <= 0)
				lt++;
			// Selecione da direita: rotate [lt .. rt] e correta
			else {
				tmp = x[rt]; // Irá se mover para [lt]
				System.arraycopy(x, lt, x, lt + 1, rt - lt);
				x[lt] = tmp;
				// TUDO subiu por um
				lt++;
				mid++;
				rt++;
			}
		}
		// O que quer que permanece em [rt .. passado] está em vigor
	}
}