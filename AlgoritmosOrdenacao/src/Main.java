import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Inicializa uma lista imutável de objetos que implementam a interface EstrategiaDeOrdenacao.
        // Isso utiliza o padrão de design Strategy, permitindo que o programa
        // facilmente use e troque entre diferentes algoritmos de ordenação.
        List<EstrategiaDeOrdenacao> estrategias = List.of(
                new BubbleSort(),   // Adiciona uma instância de BubbleSort à lista.
                new InsertionSort(),// Adiciona uma instância de InsertionSort à lista.
                new QuickSort()     // Adiciona uma instância de QuickSort à lista.
        );


        //int[] nomes = {1, 2, 3, 5, 4};
        //System.out.print("Array original: ");
        //imprimirArray(nomes); // Usa nosso método auxiliar para imprimir o array original
        //new QuickSort().ordenar(nomes);
        //System.out.print("Array ordenado (QuickSort): ");
        //imprimirArray(nomes); // Usa nosso método auxiliar para imprimir o array após a ordenação
        //System.out.println();

        // Chama um método auxiliar privado para obter um array de caminhos de arquivos (conjuntos de dados CSV).
        String[] arquivos = getArquivos();
        // Imprime uma linha separadora para melhorar a legibilidade da tabela de saída.
        System.out.println("---------------------------------------------------------------------------------------------------------");
        // Imprime o cabeçalho
        System.out.printf("%-30s", "Tipo de Conjunto");
        // Itera sobre cada estratégia de ordenação para imprimir seus nomes como cabeçalhos de coluna.
        for (EstrategiaDeOrdenacao estrategia : estrategias) {
            // Imprime o nome do algoritmo de ordenação (ex: "Bubble Sort (ms)")
            System.out.printf(" | %-18s", estrategia.getNome() + " (ms)");
        }
        System.out.println("\n---------------------------------------------------------------------------------------------------------");

        // Loop principal: itera sobre cada arquivo de dados (CSV) a ser processado.
        for (String arquivo : arquivos) {
            // Extrai um nome de arquivo amigável (ex: "aleatorio_100.csv") do caminho completo.
            String nomeAmigavel = new File(arquivo).getName();
            // Lê números inteiros do arquivo CSV atual usando a classe utilitária LeitorCSV.
            List<Integer> dados = LeitorCSV.lerNumeros(arquivo);
            // Verifica se a lista de dados lidos está vazia (ex: arquivo não encontrado ou vazio).
            if (dados.isEmpty()) {
                // Se estiver vazia, imprime uma mensagem indicando o problema com o arquivo e pula para o próximo arquivo.
                System.out.printf("%-30s | Arquivo vazio ou não encontrado!\n", nomeAmigavel);
                continue; // Pula o restante da iteração atual do loop.
            }
            // Imprime o nome amigável do arquivo (tipo de conjunto de dados) na primeira coluna da linha atual.
            System.out.printf("%-30s", nomeAmigavel);
            // Loop interno: itera sobre cada estratégia de ordenação para testá-la com o conjunto de dados atual.
            for (EstrategiaDeOrdenacao estrategia : estrategias) {
                // Cria uma nova cópia do array de dados original para cada algoritmo de ordenação.
                // Isso é crucial para garantir que cada algoritmo comece com os dados não ordenados idênticos.
                int[] copia = dados.stream().mapToInt(Integer::intValue).toArray();
                // Registra o tempo de início em nanossegundos antes de iniciar a ordenação.
                long inicio = System.nanoTime();
                // Executa o algoritmo de ordenação no array copiado.
                estrategia.ordenar(copia);
                // Registra o tempo de fim em nanossegundos após a conclusão da ordenação.
                long fim = System.nanoTime();
                // Calcula o tempo decorrido em milissegundos.
                // 1_000_000.0 é usado para divisão de ponto flutuante para obter milissegundos.
                double tempoMs = (fim - inicio) / 1_000_000.0;
                // Imprime o tempo medido para o algoritmo atual, formatado com 4 casas decimais.
                System.out.printf(" | %-18.4f", tempoMs);
            }
            // Após todas as estratégias serem testadas para um arquivo, avança para a próxima linha para os resultados do próximo arquivo.
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }

    /**
     * Método auxiliar privado para gerar um array de caminhos de arquivos CSV predefinidos.
     * Esses arquivos contêm os conjuntos de dados usados para testar os algoritmos de ordenação.
     * @return Um array de Strings contendo os caminhos para os arquivos de dados CSV.
     */
    private static String[] getArquivos() {
        // Constrói o caminho base para a pasta de dados, garantindo compatibilidade entre plataformas
        // usando File.separator (ex: "/" no Linux/macOS, "\" no Windows).
        String pastaDados = "src" + File.separator + "conjuntoDeDados";

        // Define um array de caminhos de string para os arquivos de dados CSV específicos.
        String[] arquivos = {
                pastaDados + File.separator + "aleatorio_100.csv",    // Números aleatórios, 100 elementos
                pastaDados + File.separator + "crescente_100.csv",    // Números crescentes, 100 elementos
                pastaDados + File.separator + "decrescente_100.csv",  // Números decrescentes, 100 elementos
                pastaDados + File.separator + "aleatorio_1000.csv",   // Números aleatórios, 1000 elementos
                pastaDados + File.separator + "crescente_1000.csv",   // Números crescentes, 1000 elementos
                pastaDados + File.separator + "decrescente_1000.csv", // Números decrescentes, 1000 elementos
                pastaDados + File.separator + "aleatorio_10000.csv",  // Números aleatórios, 10000 elementos
                pastaDados + File.separator + "crescente_10000.csv",  // Números crescentes, 10000 elementos
                pastaDados + File.separator + "decrescente_10000.csv" // Números decrescentes, 10000 elementos
        };

        return arquivos; // Retorna o array de caminhos de arquivo.
    }
    //private static void imprimirArray(int[] array) {
    //    System.out.print("[");
    //    for (int i = 0; i < array.length; i++) {
    //        System.out.print(array[i]);
    //        if (i < array.length - 1) {
    //            System.out.print(", ");
    //        }
    //    }
    //    System.out.println("]");
    //}
}
