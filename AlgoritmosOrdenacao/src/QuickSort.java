public class QuickSort implements EstrategiaDeOrdenacao { // Declara a classe pública QuickSort.
    // Ela implementa a interface EstrategiaDeOrdenacao,
    // o que significa que deve fornecer implementações
    // para os métodos 'ordenar' e 'getNome'.

    public void ordenar(int[] array) { // Este é o método público exigido pela interface EstrategiaDeOrdenacao.
        // É o ponto de entrada para iniciar o processo de ordenação Quick Sort.
        // Chama o método auxiliar recursivo 'quickSort' para ordenar todo o array,
        // definindo o início como 0 e o fim como o último índice do array.
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int indiceInicio, int indiceFim) { // Método auxiliar privado e recursivo do Quick Sort.
        // Ele ordena a sub-array definida por 'indiceInicio' e 'indiceFim'.

        if (indiceInicio < indiceFim) { // Condição de parada da recursão: se o índice de início for menor que o de fim,
            // significa que há pelo menos dois elementos para particionar e ordenar.
            // Se for igual ou maior, a sub-array tem 0 ou 1 elemento e já está "ordenada".

            // Chama o método 'particionar' para rearranjar os elementos da sub-array
            // e encontrar a posição final do pivô. Retorna o índice do pivô.
            int indicePivot = particionar(array, indiceInicio, indiceFim);

            // Chama recursivamente 'quickSort' para ordenar a sub-array à esquerda do pivô.
            quickSort(array, indiceInicio, indicePivot - 1);

            // Chama recursivamente 'quickSort' para ordenar a sub-array à direita do pivô.
            quickSort(array, indicePivot + 1, indiceFim);
        }
    }

    private int particionar(int[] array, int indiceInicio, int indiceFim) { // Método auxiliar privado para particionar a sub-array.
        // Ele rearranja os elementos de forma que todos os menores
        // ou iguais ao pivô fiquem à sua esquerda, e os maiores à sua direita.
        // Retorna o índice final do pivô.

        int pivot = array[indiceFim]; // Escolhe o último elemento da sub-array como o pivô.
        // (Outras estratégias de pivô incluem o primeiro, o meio ou um aleatório).
        int indiceMenor = indiceInicio - 1; // 'indiceMenor' rastreia o índice do último elemento menor ou igual ao pivô.
        // Começa em '-1' (ou 'indiceInicio - 1') para que o primeiro incremento o leve a 'indiceInicio'.

        for (int indiceAtual = indiceInicio; indiceAtual < indiceFim; indiceAtual++) { // Loop para percorrer os elementos da sub-array, exceto o pivô.
            if (array[indiceAtual] <= pivot) { // Se o elemento atual for menor ou igual ao pivô...
                indiceMenor++; // Incrementa 'indiceMenor' para apontar para a próxima posição onde um elemento menor/igual deve ir.
                Swap.swap(array, indiceMenor, indiceAtual); // Troca o elemento atual (que é menor/igual ao pivô)
                // com o elemento na posição de 'indiceMenor'.
                // Isso move elementos maiores que o pivô para a direita.
            }
        }

        // Após o loop, todos os elementos menores ou iguais ao pivô estão à esquerda de 'indiceMenor + 1'.
        // Agora, coloca o pivô em sua posição final correta.
        Swap.swap(array, indiceMenor + 1, indiceFim); // Troca o pivô (que estava em 'indiceFim')
        // com o elemento na posição 'indiceMenor + 1'.

        return indiceMenor + 1; // Retorna o índice final onde o pivô foi colocado. Esta é a "divisão" para as chamadas recursivas.
    }

    public String getNome() { // Este é o outro método público exigido pela interface EstrategiaDeOrdenacao.
        return "Quick Sort"; // Retorna o nome do algoritmo de ordenação.
    }
}