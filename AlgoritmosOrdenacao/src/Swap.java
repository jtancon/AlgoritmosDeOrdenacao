public class Swap { // Declara uma classe pública chamada 'Swap'.
    // Esta é uma classe utilitária, ou seja, ela contém métodos que realizam
    // operações comuns e podem ser reutilizadas por outras partes do programa.

    public static void swap(int[] array, int posicao1, int posicao2) { // Declara um método estático público chamado 'swap'.
        // 'static': Significa que você pode chamar este método diretamente na classe (ex: Swap.swap(...))
        // sem precisar criar um objeto 'Swap'.
        // 'void': Indica que o método não retorna nenhum valor.
        // '(int[] array, int posicao1, int posicao2)': Recebe três argumentos:
        // - o array de inteiros onde a troca será feita.
        // - o índice da primeira posição a ser trocada.
        // - o índice da segunda posição a ser trocada.

        int valorTemporario = array[posicao1]; // 1. Armazena o valor do elemento na 'posicao1' em uma variável temporária.
        // Isso é essencial para não perder o valor quando ele for sobrescrito.

        array[posicao1] = array[posicao2];     // 2. Copia o valor do elemento na 'posicao2' para a 'posicao1'.
        // Agora, a 'posicao1' tem o valor que estava na 'posicao2'.

        array[posicao2] = valorTemporario;     // 3. Copia o valor armazenado em 'valorTemporario' (o valor original da 'posicao1')
        // para a 'posicao2'.
        // Isso completa a troca dos valores entre as duas posições.
    }

}