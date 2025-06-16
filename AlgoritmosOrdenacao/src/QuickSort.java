public class QuickSort implements EstrategiaDeOrdenacao {

    public void ordenar(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int indiceInicio, int indiceFim) {
        if (indiceInicio < indiceFim) {
            int indicePivot = particionar(array, indiceInicio, indiceFim);
            quickSort(array, indiceInicio, indicePivot - 1);
            quickSort(array, indicePivot + 1, indiceFim);
        }
    }

    private int particionar(int[] array, int indiceInicio, int indiceFim) {
        int pivot = array[indiceFim];
        int indiceMenor = indiceInicio - 1;

        for (int indiceAtual = indiceInicio; indiceAtual < indiceFim; indiceAtual++) {
            if (array[indiceAtual] <= pivot) {
                indiceMenor++;
                Swap.swap(array, indiceMenor, indiceAtual);
            }
        }

        Swap.swap(array, indiceMenor + 1, indiceFim);
        return indiceMenor + 1;
    }

    public String getNome() {
        return "Quick Sort";
    }
}
