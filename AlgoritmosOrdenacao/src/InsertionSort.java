public class InsertionSort implements EstrategiaDeOrdenacao {

    public void ordenar(int[] array) {
        int tamanho = array.length;
        int indice = 1;

        while (indice < tamanho) {
            int posicaoAtual = indice;

            while (posicaoAtual > 0 && array[posicaoAtual] < array[posicaoAtual - 1]) {
                Swap.swap(array, posicaoAtual, posicaoAtual - 1);
                posicaoAtual--;
            }

            indice++;
        }
    }

    public String getNome() {
        return "Insertion Sort";
    }
}
