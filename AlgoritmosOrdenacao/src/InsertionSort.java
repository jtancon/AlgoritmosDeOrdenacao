public class InsertionSort implements EstrategiaDeOrdenacao { // Declara a classe pública InsertionSort.
    // Ela implementa a interface EstrategiaDeOrdenacao,
    // o que significa que se compromete a fornecer
    // as implementações para os métodos 'ordenar' e 'getNome'.

    public void ordenar(int[] array) { // Este é o método público exigido pela interface EstrategiaDeOrdenacao.
        // É o ponto de entrada para aplicar o algoritmo Insertion Sort a um array.

        int tamanho = array.length; // Obtém o número total de elementos no array.
        int indice = 1;             // 'indice' representa o primeiro elemento da parte "não ordenada" do array.
        // Começa em 1 porque o primeiro elemento (índice 0) é considerado a parte "ordenada" inicial.

        while (indice < tamanho) { // Loop principal: Continua enquanto houver elementos na parte não ordenada para processar.
            // A cada iteração, um novo elemento é selecionado para ser inserido na parte ordenada.

            int posicaoAtual = indice; // 'posicaoAtual' guarda o índice do elemento que está sendo inserido na parte ordenada.
            // Inicialmente, ele aponta para o primeiro elemento da parte não ordenada.

            while (posicaoAtual > 0 && array[posicaoAtual] < array[posicaoAtual - 1]) {
                // Loop interno: Move o elemento em 'posicaoAtual' para trás no array,
                // enquanto ele for menor que o elemento anterior.
                // 'posicaoAtual > 0': Garante que não tentamos acessar um índice negativo (limite do array).
                // 'array[posicaoAtual] < array[posicaoAtual - 1]': Verifica se o elemento atual é menor que o anterior.
                // Se sim, estão na ordem errada para uma ordenação crescente.

                Swap.swap(array, posicaoAtual, posicaoAtual - 1); // Troca o elemento atual com o elemento anterior,
                // movendo o elemento menor uma posição para a esquerda.
                posicaoAtual--; // Decrementa 'posicaoAtual' para continuar comparando o elemento recém-movido
                // com o próximo elemento à sua esquerda.
            }

            indice++; // Incrementa 'indice' para mover para o próximo elemento na parte não ordenada do array,
            // que será o próximo a ser inserido na parte ordenada.
        }
    }

    public String getNome() { // Este é o método público exigido pela interface EstrategiaDeOrdenacao.
        return "Insertion Sort"; // Retorna o nome do algoritmo de ordenação.
    }
}