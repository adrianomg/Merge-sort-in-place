package algoritmos.enemies;

// nenhum risco de explos�o de uma pilha.
// custo: um n�mero relativamente elevado de movimentos. pilha pode ainda
import algoritmos.Sorter;

// ser caro demais.
// esta � uma esp�cie de mesclagem com uma inteligente fus�o no lugar que
// 'roda' as matrizes sub. para ver a forma como ele funciona, v�-lo
// em array invertido
public class InPlaceStableSort2 implements Sorter {

    public Integer[] data;

    @Override
    public void mesclar(Integer[] vetor, int inicio, int meio, int fim) throws Exception {
        setData(vetor);
        merge(inicio, meio, fim - 1);
    }

    public void setData(Integer[] data) {
        this.data = data;
    }

    /**
     * ����� * Mesclar duas matrizes. ����� * �����
     *
     * @ Param a partir do in�cio do primeiro intervalo �����
     * @ Param in�cio segunda parte do segundo intervalo �����
     * @ Param para o �ltimo elemento da gama segundo �����
     */
    public void merge(int from, int second, int to) {
        int len1 = second - from, len2 = to - second + 1;
        if (len1 == 0 || len2 == 0) {
            return;
        }
        if (len1 + len2 == 2) {
            if (data[second] < data[from]) {
                swap(data, second, from);
            }
            return;
        }
        mergeBig(from, second, to);
    }

    /**
     * ����� * Mesclar duas (grandes) matrizes. Isso � feito recursivamente
     * atrav�s da fus�o da ����� * A partir de duas matrizes e, em seguida o fim
     * das duas matrizes. ����� * �����
     *
     * @ Param a partir do in�cio do primeiro intervalo �����
     * @ Param in�cio segunda parte do segundo intervalo �����
     * @ Param para o �ltimo elemento da gama segundo �����
     */
    private void mergeBig(int from, int second, int to) {
        int len1 = second - from, len2 = to - second + 1;
        int firstCut, secondCut, newSecond;
        if (len1 > len2) {
            firstCut = from + len1 / 2;
            secondCut = findLower(data[firstCut], second, to);
            int len = secondCut - second;
            newSecond = firstCut + len;
        } else {
            int len = len2 / 2;
            secondCut = second + len;
            firstCut = findUpper(data[secondCut], from, second - 1);
            newSecond = firstCut + len;
        }
        swapBlocks(firstCut, second, secondCut - 1);
        merge(from, firstCut, newSecond - 1);
        merge(newSecond, secondCut, to);
    }

    /**
     * ����� * Encontrar o maior elemento no array que � menor do que x. ����� *
     * �����
     *
     * @ Param x elemento a pesquisar �����
     * @ Param a partir do �ndice da primeira entrada �����
     * @ Param com o �ndice da �ltima entrada �����
     * @ Return o �ndice do elemento resultante �����
     */
    private int findLower(Integer x, int from, int to) {
        int len = to - from + 1, half;
        while (len > 0) {
            half = len / 2;
            int m = from + half;
            if (data[m] < x) {
                from = m + 1;
                len = len - half - 1;
            } else {
                len = half;
            }
        }
        return from;
    }

    /**
     * ����� * Encontre o menor elemento no array que é maior do que ou ����� *
     * Igual a x. ����� * �����
     *
     * @ x elemento a pesquisar �����
     * @ a partir do índice da primeira entrada �����
     * @ com o índice da última entrada �����
     * @ Return o índice do elemento resultante �����
     */
    private int findUpper(Integer x, int from, int to) {
        int len = to - from + 1, half;
        while (len > 0) {
            half = len / 2;
            int m = from + half;
            if (data[m] <= x) {
                from = m + 1;
                len = len - half - 1;
            } else {
                len = half;
            }
        }
        return from;
    }

    /**
     * ����� * Troque os elementos de dois blocos na matriz de dados. Ambos os
     * blocos s�o os pr�ximos ����� * Para o outro (o segundo bloco come�a logo
     * ap�s o primeiro bloco termina). ����� * �����
     *
     * @ Param a partir do �ndice do primeiro elemento no primeiro bloco �����
     * @ Param segundo o �ndice do primeiro elemento no segundo bloco �����
     * @ Param para o �ndice do �ltimo elemento no segundo bloco �����
     */
    private void swapBlocks(int from, int second, int to) {
        int len1 = second - from, len2 = to - second + 1;
        if (len1 == 0 || len2 == 0) {
            return;
        }
        reverseBlock(from, second - 1);
        reverseBlock(second, to);
        reverseBlock(from, to);
    }
//
//    private void swap(int a, int b, int m, int j){
//	while (m-- > 0) {
//            swap(x[ a++], x[ b++]);
//        }
//    }
//    private void Gries_and_Mills(int a, int l, int m, int r){
//	int rotdist = m - l + 1;
//        int n = r - l + 1;
//        if (rotdist == 0 || rotdist == n) {
//            return;
//        }
//        int p, i = p = rotdist;
//        int j = n - p;
//        while (i != j) {
//            if (i > j) {
//                swap(a, p - i, p, j);
//                i -= j;
//            } else {
//                swap(a, p - i, p + j - i, i);
//                j -= i;
//            }
//        }
//        swap(a, p - i, p, i);
//    }

    /**
     * ����� * Reverter todos os elementos em um bloco. ����� * �����
     *
     * @ Param a partir do �ndice do primeiro elemento �����
     * @ Param para o �ndice do �ltimo elemento �����
     */
    private void reverseBlock(int from, int to) {
        while (from < to) {
            Integer old = data[from];
            data[from++] = data[to];
            data[to--] = old;
        }
    }

    /**
     * ����� * Troque dois elementos na matriz. ����� * �����
     *
     * @ Param dados a matriz �����
     * @ Param um �ndice do primeiro elemento �����
     * @ Param b o �ndice do segundo elemento �����
     */
    private void swap(Integer[] data, int a, int b) {
        Integer temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
/*
 public static void main(String args[])
 {
 InPlaceStableSort2 ms = new InPlaceStableSort2();
 Integer[] numbers = new Integer[]{3,4,1,5};
 try {
 ms.mesclar(numbers, 0, numbers.length/2, numbers.length);
 } catch (Exception e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }

 for (int x=0;x<numbers.length;x++)
 System.out.println(numbers[x]);	

 }
 }*/
/**
 * ����� * Mesclar dois (pequeno) arrays usando a matriz tempor�ria. Isto �
 * feito para acelerar ����� * At� fundir. ����� * �����
 *
 * @ Param matriz alvo o alvo �����
 * @ Param pos a posi��o do primeiro elemento na matriz de destino �����
 * @ param s1 a matriz primeira fonte �����
 * @ Param a partir de 1 o �ndice do primeiro elemento na matriz de origem
 * primeiro �����
 * @ Param para1 o �ndice do �ltimo elemento da matriz de origem primeira �����
 * @ Param s2 a matriz segunda fonte �����
 * @ Param from2 o �ndice do primeiro elemento na matriz segunda fonte �����
 * @ Param to2 o �ndice do �ltimo elemento da matriz segunda fonte �����
 */
//    private void mergeSmall(Integer[] target, int pos, Integer[] s1, int from1, int to1, Integer[] s2, int from2, int to2) {
//        Integer x1 = s1[from1], x2 = s2[from2];
//        while (true) {
//            if (x1 <= x2) {
//                target[pos++] = x1;
//                if (++from1 > to1) {
//                    System.arraycopy(s2, from2, target, pos, to2 - from2 + 1);
//                    break;
//                }
//                x1 = s1[from1];
//            } else {
//                target[pos++] = x2;
//                if (++from2 > to2) {
//                    System.arraycopy(s1, from1, target, pos, to1 - from1 + 1);
//                    break;
//                }
//                x2 = s2[from2];
//            }
//        }
//    }
//
//inicio    
//var vetor
//    metodo mesclar(vetor, inicio, meio, fim)
//        setVetor(vetor)
//        merge(inicio, meio, fim - 1)
//    fimmetodo
//
//    método setVetor(vetor) {
//        this.vetor <- vetor
//    fimmetodo
//
//    metodo merge(inicio, second, fim) 
//        var tam1 <- second - inicio, tam2 <- fim - second + 1
//        se (tam1 == 0 || tam2 == 0) 
//            retorna
//        fimse
//        se (tam1 + tam2 == 2) 
//            se (vetor[second] < vetor[inicio]) {
//                swap(vetor, second, inicio)
//            fimse
//            retorna
//        fimse
//        mergeBig(inicio, second, fim)
//    fimmetodo
//
//    metodo mergeBig(inicio, second, fim) 
//        var tam1 <- second - inicio, tam2 <- fim - second + 1
//        var primeiroCorte, segundoCorte, novoSegundo
//        se (tam1 > tam2) 
//            primeiroCorte <- inicio + tam1 / 2
//            segundoCorte <- procuraMenor(vetor[primeiroCorte], second, fim)
//            var tam <- segundoCorte - second
//            novoSegundo <- primeiroCorte + tam
//        fimse
//        senão
//            var tam <- tam2 / 2
//            segundoCorte <- second + tam
//            primeiroCorte <- procuraMaior(vetor[segundoCorte], inicio, second - 1)
//            novoSegundo <- primeiroCorte + tam
//        fimsenão
//        swapBlocks(primeiroCorte, second, segundoCorte - 1)
//        merge(inicio, primeiroCorte, novoSegundo - 1)
//        merge(novoSegundo, segundoCorte, fim)
//    fimmetodo
//
//
//    metodo procuraMenor(x, inicio, fim) {
//        var tam <- fim - inicio + 1, meio
//        enquanto (tam > 0) 
//            meio <- tam / 2
//            var m <- inicio + meio
//            se (vetor[m] < x) 
//                inicio <- m + 1
//                tam <- tam - meio - 1
//            fimse 
//            senão 
//                tam <- meio
//            fimsenão
//        fimenquanto
//        retorna inicio
//    fimmetodo
//
//    metodo procuraMaior(x, inicio, fim) 
//        var tam <- fim - inicio + 1, meio
//        enquanto (tam > 0) 
//            meio <- tam / 2
//            var m <- inicio + meio
//            se (vetor[m] <= x) {
//                inicio <- m + 1
//                tam <- tam - meio - 1
//            fimse
//            senão
//            	tam <- meio
//          fimsenão
//        fimenquanto
//        retorna inicio
//    fimmetodo
//
//    metodo swapBlocks(inicio, second, fim) {
//        var tam1 <- second - inicio, tam2 <- fim - second + 1
//        se (tam1 == 0 || tam2 == 0) {
//            retorna
//        fimse
//        reverseBlock(inicio, second - 1)
//        reverseBlock(second, fim)
//        reverseBlock(inicio, fim)
//    fimmetodo
//
//    metodo reverseBlock(inicio, fim) 
//        enaquanto (inicio < fim) {
//            var old <- vetor[inicio]
//            vetor[inicio++] <- vetor[fim]
//            vetor[fim--] <- old
//        fimenquanto
//    fimmetodo
//
//    metodo swap(vetor, a, b) {
//        temp <- vetor[a]
//        vetor[a] <- vetor[b]
//        vetor[b] <- temp
//    fimmetodo
//fim
