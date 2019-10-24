/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos.enemies;

/**
 *
 * @author Adriano
 */
public class Inutil {
    
    public static boolean confereOrdenacao(Integer[] num){
        int i = num[0];
        for( Integer n : num){
            if( i != n)
                return false;
            i++;
        }
        return true;
    }
}
