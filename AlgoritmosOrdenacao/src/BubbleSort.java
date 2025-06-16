public class BubbleSort implements EstrategiaDeOrdenacao {

    public void ordenar(int[] array) {
        bubbleSort(array, array.length);
    }

    private void bubbleSort(int[] array, int tamanho) {

        if (tamanho <= 1) {
            return;
        }

        boolean houveTroca = false;

        for (int indice = 0; indice < tamanho - 1; indice++) {
            if (array[indice] > array[indice + 1]) {
                Swap.swap(array, indice, indice+1);
                houveTroca = true;
            }
        }

        if (!houveTroca) {
            return;
        }

        bubbleSort(array, tamanho - 1);
    }

    public String getNome() {
        return "Bubble Sort";
    }
}
