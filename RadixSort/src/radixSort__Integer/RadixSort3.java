/**
Algorítmo RadixSort, ideal para classisicar inteiros
 */
package radixSort__Integer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * RadixSort - a forma mais eficiente de classficar
 *
 * @author 50enta
 */
public class RadixSort3 {

    /**
     * Método que recebe o array que se deseja ordenar e faz a ordenação usando
     * o método radix sort
     *
     * @param arrayPorOrdenar
     */
    public static void sort(int[] arrayPorOrdenar) {
        final int DEZ = 10;
        ArrayList<Integer>[] matrizAuxiliar = new ArrayList[19];

        for (int pos = 0; pos < matrizAuxiliar.length; pos++) {
            matrizAuxiliar[pos] = new ArrayList<>();
        }

        boolean fim;
        int flag, placeValue = 1;

        do {
            fim = true;
            for (Integer valor : arrayPorOrdenar) {
                flag = valor / placeValue;

                encaicharValor(flag, valor, matrizAuxiliar); // o valor é colocado onde deve estar

                if (fim && (flag > 0 || flag < 0)) {
                    fim = false;
                }
            }

            int a = 0;
            for (int b = 0; b < 19; b++) {
                for (int i : matrizAuxiliar[b]) {
                    arrayPorOrdenar[a++] = i;
                }
                matrizAuxiliar[b].clear();
            }

            placeValue *= DEZ;

        } while (!fim);
    }

    /**
     * Método que vi encaixando os valores no arrayAuxiliar, tendo em conta a
     * posição da chave que está sendo analisada
     *
     * @param temp
     * @param valor
     * @param matriz
     */
    private static void encaicharValor(int temp, int valor, ArrayList<Integer>[] matriz) {
        double[] controlador = new double[19];

        //inicializando com valores de -9 à 9
        int j = -9;
        for (int i = 0; i < 19; i++) {
            controlador[i] = j++;
        }

        //identificação do indice para encaixar o valor em causa
        int indice = 0;
        for (int i = 0; i < 19; i++) {
            if (controlador[i] == (temp % 10)) {
                indice = i;
            }
        }
        matriz[indice].add(valor);

    }

    //
    public static void main(String[] args) {
        int a[] = {-10, 7, -54, -35, 100, 180, 374, 34, -56};
        sort(a);
        Arrays.stream(a).forEach(System.out::println);
    }

}
