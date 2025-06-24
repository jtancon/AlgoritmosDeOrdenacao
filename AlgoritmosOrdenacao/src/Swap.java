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
/*
 * --- LEMBRETES RÁPIDOS DE JAVA ---
 *
 * 1. IMPRIMIR (Exibir no Console):
 * System.out.print("Texto");      // Imprime sem pular linha.
 * System.out.println("Texto");    // Imprime e pula para a próxima linha.
 * System.out.printf("Formato: %s %d", "Texto", 10); // Imprime formatado.
 *
 * 2. ENTRADA (Ler do Teclado):
 * import java.util.Scanner;       // Importar no início do arquivo.
 * Scanner leitor = new Scanner(System.in); // Cria um Scanner.
 * String texto = leitor.nextLine();       // Lê uma linha inteira.
 * int numero = leitor.nextInt();           // Lê um inteiro.
 * leitor.close();                          // Sempre fechar o Scanner!
 *
 * 3. LOOP 'for':
 * // Executa um bloco de código um número fixo de vezes.
 * for (int i = 0; i < 10; i++) {
 * // Código a ser repetido.
 * }
 *
 * 4. LOOP 'while':
 * // Executa um bloco de código ENQUANTO uma condição for verdadeira.
 * int contador = 0;
 * while (contador < 3) {
 * // Código a ser repetido.
 * contador++; // Garante que a condição eventualmente se torne falsa!
 * }
 *
 * 5. FUNÇÕES/MÉTODOS:
 * // Blocos de código reutilizáveis para tarefas específicas.
 * // 'void' significa que o método NÃO retorna nada.
 * public void meuMetodo(int parametro) {
 * // Código do método.
 * }
 *
 * // Métodos que RETORNAM um valor (o tipo antes do nome do método indica o tipo do retorno).
 * public int soma(int a, int b) {
 * return a + b; // 'return' envia o resultado de volta para quem chamou o método.
 * }
 *
 * 6. RETORNAR (em Métodos):
 * // A palavra-chave 'return' encerra a execução do método
 * // e, opcionalmente, envia um valor de volta.
 * return;        // Retorna (para métodos 'void').
 * return valor;  // Retorna um valor específico.
 *
 * 7. ARRAYS:
 * // Coleções de elementos do MESMO tipo, com tamanho FIXO.
 * // Os elementos são acessados por um índice numérico que começa em 0.
 *
 * // Declaração e inicialização de um array de inteiros de tamanho 5.
 * int[] meuArrayDeInteiros = new int[5];
 *
 * // Declaração e inicialização de um array de Strings com valores.
 * String[] nomes = {"Alice", "Bob", "Charlie"};
 *
 * // Acessar um elemento:
 * System.out.println(nomes[0]); // Imprime "Alice" (primeiro elemento).
 *
 * // Alterar um elemento:
 * meuArrayDeInteiros[0] = 10; // Coloca o valor 10 na primeira posição.
 *
 * // Tamanho do array:
 * int tamanhoDoArray = nomes.length; // Retorna 3.
 *
 * // Iterar sobre um array (percorrer todos os elementos):
 * for (int i = 0; i < nomes.length; i++) {
 * System.out.println("Elemento no índice " + i + ": " + nomes[i]);
 * }
 * // Ou usando for-each (mais simples para percorrer):
 * for (String nome : nomes) {
 * System.out.println("Nome: " + nome);
 * }
 */