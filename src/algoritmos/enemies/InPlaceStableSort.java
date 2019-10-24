package algoritmos.enemies;
//no risk of exploding a stack.
//cost: a relatively high number of moves. stack can still

import algoritmos.Sorter;
import java.awt.List;
import java.util.ArrayList;
// ser caro demais.
// esta � uma esp�cie de mesclagem com uma inteligente fus�o no lugar que
// 'roda' as matrizes sub. para ver a forma como ele funciona, v�-lo
// em array invertido

public class InPlaceStableSort implements Sorter {

    //public static int[] vetor1 = new int[20]; 
    //public static int[] vetor2 = new int[20]; 
    public Integer tableau[];

    @Override
    public void mesclar(Integer[] vetor, int inicio, int meio, int fim) {
        tableau = vetor;
        mesclar(inicio, meio, fim);
    }

    public void mesclar(int inicio, int meio, int fim) {
        merge(inicio, meio, fim, meio - inicio, fim - meio);
    }

    int lower(int from, int to, int val) {
        int len = to - from, half;
        while (len > 0) {
            half = len / 2;
            int mid = from + half, aux;
            aux = tableau[mid] - tableau[val];
            if (aux < 0) {
                from = mid + 1;
                len = len - half - 1;
            } else {
                len = half;
            }
        }
        return from;
    }

    int upper(int from, int to, int val) {
        int len = to - from, half;
        while (len > 0) {
            half = len / 2;
            int mid = from + half, aux;
            aux = tableau[mid] - tableau[val];

            if (aux < 0) {
                len = half;
            } else {
                from = mid + 1;
                len = len - half - 1;
            }
        }
        return from;
    }

    void insert_sort(int from, int to) {
        if (to > from + 1) {
            for (int i = from + 1; i < to; i++) {
                for (int j = i; j > from; j--) {
                    if (tableau[j] - tableau[j - 1] < 0) {
                        int tmp = tableau[j];
                        tableau[j] = tableau[j - 1];
                        tableau[j - 1] = tmp;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    int gcd(int m, int n) {
        while (n != 0) {
            int t = m % n;
            m = n;
            n = t;
        }
        return m;
    }

    void reverse(int from, int to) {
        while (from < to) {
            {
                int tmp = tableau[from++];
                tableau[from] = tableau[to--];
                tableau[to] = tmp;
            }
        }
    }

    void rotate(int from, int mid, int to) {
        /*		a less sophisticated but costlier version:
        reverse(from, mid-1);
        reverse(mid, to-1);
        reverse(from, to-1);
         */
        if (from == mid || mid == to) {
            return;
        }
        int n = gcd(to - from, mid - from);
        while (n-- != 0) {
            int val = tableau[from + n];
            int shift = mid - from;
            int p1 = from + n, p2 = from + n + shift;
            while (p2 != from + n) {
                tableau[p1] = tableau[p2];
                p1 = p2;
                if (to - p2 > shift) {
                    p2 += shift;
                } else {
                    p2 = from + (shift - (to - p2));
                }
            }

            tableau[p1] = val;
        }

    }

    public void merge(int from, int pivot, int to, int len1, int len2) {
        if (len1 == 0 || len2 == 0) {
            return;
        }
        if (len1 + len2 == 2) {
            if (tableau[pivot] - tableau[from] < 0) {
                int tmp = tableau[pivot];
                tableau[pivot] = tableau[from];
                tableau[from] = tmp;
            }
            return;
        }


        int first_cut, second_cut;
        int len11, len22;
        if (len1 > len2) {
            len11 = len1 / 2;
            first_cut = from + len11;
            second_cut = lower(pivot, to, first_cut);
            len22 = second_cut - pivot;
        } else {
            len22 = len2 / 2;
            second_cut = pivot + len22;
            first_cut = upper(from, pivot, second_cut);
            len11 = first_cut - from;
        }
        rotate(first_cut, pivot, second_cut);
        int new_mid = first_cut + len22;
        merge(from, first_cut, new_mid, len11, len22);
        merge(new_mid, second_cut, to, len1 - len11, len2 - len22);
    }

    void sort(int from, int to) {
        if (to - from < 12) {
            insert_sort(from, to);
            return;
        }
        int middle = (from + to) / 2;
        sort(from, middle);
        sort(middle, to);
        merge(from, middle, to, middle - from, to - middle);
    }
}