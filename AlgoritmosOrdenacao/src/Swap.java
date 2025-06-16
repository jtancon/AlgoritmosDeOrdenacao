public class Swap {

    public static void swap(int[] array, int posicao1, int posicao2) {
        int valorTemporario = array[posicao1];
        array[posicao1] = array[posicao2];
        array[posicao2] = valorTemporario;
    }

}
