public interface EstrategiaDeOrdenacao { // Declara uma interface pública chamada 'EstrategiaDeOrdenacao'.
    // Em Java, interfaces definem um "contrato" de métodos que classes implementadoras devem seguir.
    // É uma peça chave para o polimorfismo e o padrão Strategy, permitindo que diferentes
    // algoritmos de ordenação sejam tratados de forma uniforme.

    void ordenar(int[] array); // Declara um método abstrato 'ordenar'.
    // 'void' indica que não retorna nenhum valor.
    // '(int[] array)' indica que ele recebe um array de inteiros para ser ordenado.
    // Qualquer classe que implementar esta interface será OBRIGADA a fornecer o código
    // para como a ordenação deve ser feita.

    String getNome(); // Declara outro método abstrato 'getNome'.
    // 'String' indica que ele deve retornar uma string.
    // '()' indica que não recebe argumentos.
    // Classes que implementam esta interface devem retornar o nome do algoritmo de ordenação (ex: "Quick Sort").
}