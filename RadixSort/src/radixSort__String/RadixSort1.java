package radixSort__String;

import javax.swing.JOptionPane;
import sun.misc.Queue;

/**
 * Ordenação de Strings
 *
 * @author 50enta
 */
public class RadixSort1 {

    /**
     * Este método calcula o comprimento da menor palavra contida no array
     * passado por parâmetro
     *
     * @param a
     * @return comprimentoDaMenorPalavra
     */
    public static int calcularComprimentoDaMenorPalavra(String[] a) {
        int menor = a[0].length();
        for (String p : a) {
            if (p.length() < menor) {
                menor = p.length();
            }
        }
        return menor;
    }

    /**
     * Método que organiza o array, usando o procedimento RafixSort
     *
     * @param array
     */
    public static void radixSort(String[] array) {
        int ComprimentoDaMenorPalavra = calcularComprimentoDaMenorPalavra(array);
        int tamanhoArray = array.length;
        Queue[] matrizAuxiliar = new Queue[256];

        //instancia cada posição do array/matriz
        for (int i = 0; i < 256; i++) {
            matrizAuxiliar[i] = new Queue();
        }

        for (int i = ComprimentoDaMenorPalavra - 1; i >= 0; i--) {
            for (int j = 0; j < tamanhoArray; j++) {
                int codigoAscii = array[j].charAt(i);
                matrizAuxiliar[codigoAscii].enqueue(new String(array[j]));
            }

            int a = 0;
            for (int k = 0; k < 256; k++) {

                while (!matrizAuxiliar[k].isEmpty()) {
                    try {
                        array[a++] = ((String) matrizAuxiliar[k].dequeue()).toString();
                    } catch (InterruptedException ex) {
                    }
                }
            }
        }
    }

//Metodo main
    public static void main(String[] args) {
        String[] samira = {"Zacarias", "Válter", "Samira", "Micaela", "Adelina", "Emília", "Cátia", "Helena",
            "Josefina", "Carla", "João", "Mário", "Alberto", "António", "Paito", "Pedro", "Patrick"};

        System.err.println("ANTES DA ORDENAÇÃO: ");
        for (String a : samira) {
            System.out.println(a);
        }

        System.out.println("...............");
        radixSort(samira);//odenação
        System.err.println("DEPOIS DA ORDENAÇÃO: ");

        for (String a : samira) {
            System.out.println(a);
        }
    }

}//Classe principal

