import java.io.*; // Importa todas as classes do pacote java.io, que são necessárias para operações de entrada/saída (como leitura de arquivos).
import java.util.ArrayList; // Importa a classe ArrayList, usada para criar uma lista dinâmica de objetos.
import java.util.List;      // Importa a interface List, que define o comportamento de uma coleção de elementos.

public class LeitorCSV { // Declara a classe pública LeitorCSV. Essa classe é responsável por ler dados de arquivos CSV.

    public static List<Integer> lerNumeros(String caminhoArquivo) { // Declara um método estático público 'lerNumeros'.
        // 'static' significa que o método pertence à classe e não a uma instância dela.
        // Retorna uma 'List' de 'Integer' (números lidos).
        // Recebe o 'caminhoArquivo' (String) do CSV a ser lido.

        List<Integer> numeros = new ArrayList<>(); // Inicializa uma nova lista vazia de inteiros para armazenar os números lidos do CSV.
        File arquivo = new File(caminhoArquivo);  // Cria um objeto File que representa o arquivo no caminho especificado.

        if (!arquivo.exists()) { // Verifica se o arquivo especificado no caminho realmente existe no sistema de arquivos.
            System.out.println("Arquivo não encontrado: " + caminhoArquivo); // Se o arquivo não existir, imprime uma mensagem de erro.
            return numeros; // Retorna a lista vazia, pois não foi possível ler o arquivo.
        }

        // Bloco try-with-resources: Garante que o BufferedReader será fechado automaticamente após o uso,
        // mesmo que ocorram exceções.
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha; // Declara uma variável para armazenar cada linha lida do arquivo.
            boolean primeiraLinha = true; // Flag para controlar se é a primeira linha do arquivo (útil para cabeçalhos).

            while ((linha = br.readLine()) != null) { // Loop que lê o arquivo linha por linha até o fim (quando readLine() retorna null).
                linha = linha.trim(); // Remove espaços em branco do início e do fim da linha lida.

                if (primeiraLinha) { // Verifica se é a primeira linha do arquivo.
                    primeiraLinha = false; // Define a flag como false para as próximas linhas.
                    if (linha.equalsIgnoreCase("Value")) { // Verifica se a primeira linha é o cabeçalho "Value" (ignorando maiúsculas/minúsculas).
                        continue; // Se for o cabeçalho, pula para a próxima iteração do loop, ignorando esta linha.
                    }
                }

                if (linha.isEmpty()) { // Verifica se a linha está vazia após remover os espaços em branco.
                    continue; // Se a linha estiver vazia, pula para a próxima iteração do loop.
                }

                try { // Bloco try-catch para lidar com possíveis erros de conversão de string para número.
                    int numero = Integer.parseInt(linha); // Tenta converter a string da linha para um número inteiro.
                    numeros.add(numero); // Se a conversão for bem-sucedida, adiciona o número à lista.
                } catch (NumberFormatException e) { // Captura a exceção se a linha não puder ser convertida para um inteiro.
                    System.out.println("Linha inválida (não é um número): '" + linha + "' no arquivo " + caminhoArquivo); // Imprime uma mensagem de erro para a linha inválida.
                }
            }
        } catch (IOException e) { // Captura exceções de I/O (entrada/saída) que podem ocorrer durante a leitura do arquivo.
            System.out.println("Erro ao ler o arquivo: " + caminhoArquivo); // Imprime uma mensagem de erro geral de leitura.
            e.printStackTrace(); // Imprime o rastreamento da pilha da exceção para depuração.
        }

        return numeros; // Retorna a lista de números que foram lidos e convertidos com sucesso.
    }
}