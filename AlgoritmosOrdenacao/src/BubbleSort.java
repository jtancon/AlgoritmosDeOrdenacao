public class BubbleSort implements EstrategiaDeOrdenacao { // Declara a classe pública BubbleSort que implementa a interface EstrategiaDeOrdenacao.
    // Isso significa que ela deve fornecer as implementações para os métodos definidos na interface.

    public void ordenar(int[] array) { // Este é o método público exigido pela interface EstrategiaDeOrdenacao, usado para iniciar o processo de ordenação.
        bubbleSort(array, array.length); // Chama o método auxiliar 'bubbleSort' (privado e recursivo) passando o array completo e seu tamanho.
    }

    private void bubbleSort(int[] array, int tamanho) { // Método auxiliar privado que contém a lógica recursiva do algoritmo Bubble Sort.

        if (tamanho <= 1) { // Condição de parada da recursão: se o tamanho da porção do array for 0 ou 1, ela já está ordenada.
            return;         // Retorna, encerrando a chamada recursiva atual.
        }

        boolean houveTroca = false; // Variável booleana para otimização: indica se alguma troca ocorreu nesta passagem do array.
        // Se nenhuma troca ocorrer, o array já está ordenado.

        for (int indice = 0; indice < tamanho - 1; indice++) { // Loop para percorrer a porção não ordenada do array.
            // Ele vai até o penúltimo elemento, pois compara com o próximo.
            if (array[indice] > array[indice + 1]) { // Compara o elemento atual com o próximo. Se o atual for maior, eles estão fora de ordem.
                Swap.swap(array, indice, indice+1); // Realiza a troca dos dois elementos usando o método estático da classe utilitária Swap.
                houveTroca = true;                  // Marca que houve uma troca nesta passagem.
            }
        }

        if (!houveTroca) { // Após a passagem completa do loop 'for', verifica se não houve nenhuma troca.
            return;        // Se não houve trocas, significa que o array está totalmente ordenado, então retorna.
        }

        bubbleSort(array, tamanho - 1); // Chama recursivamente o método 'bubbleSort'. O '- 1' indica que o maior elemento
    }                                   // (que "borbulhou" para o final) já está posição correta e não precisa ser considerado na próxima passagem.

    public String getNome() { // Este é o outro método público exigido pela interface EstrategiaDeOrdenacao.
        return "Bubble Sort"; // Retorna o nome do algoritmo de ordenação como uma string.
    }
}