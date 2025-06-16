import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<EstrategiaDeOrdenacao> estrategias = List.of(
                new BubbleSort(),
                new InsertionSort(),
                new QuickSort()
        );

        String[] arquivos = getArquivos();

        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.printf("%-30s", "Tipo de Conjunto");
        for (EstrategiaDeOrdenacao estrategia : estrategias) {
            System.out.printf(" | %-18s", estrategia.getNome() + " (ms)");
        }
        System.out.println("\n---------------------------------------------------------------------------------------------------------");

        for (String arquivo : arquivos) {
            String nomeAmigavel = new File(arquivo).getName();
            List<Integer> dados = LeitorCSV.lerNumeros(arquivo);

            if (dados.isEmpty()) {
                System.out.printf("%-30s | Arquivo vazio ou não encontrado!\n", nomeAmigavel);
                continue;
            }

            System.out.printf("%-30s", nomeAmigavel);

            for (EstrategiaDeOrdenacao estrategia : estrategias) {
                int[] copia = dados.stream().mapToInt(Integer::intValue).toArray();

                long inicio = System.nanoTime();
                estrategia.ordenar(copia);
                long fim = System.nanoTime();

                double tempoMs = (fim - inicio) / 1_000_000.0;

                System.out.printf(" | %-18.4f", tempoMs);
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }

    private static String[] getArquivos() {
        String pastaDados = "src" + File.separator + "conjuntoDeDados";

        String[] arquivos = {
                pastaDados + File.separator + "aleatorio_100.csv",
                pastaDados + File.separator + "crescente_100.csv",
                pastaDados + File.separator + "decrescente_100.csv",
                pastaDados + File.separator + "aleatorio_1000.csv",
                pastaDados + File.separator + "crescente_1000.csv",
                pastaDados + File.separator + "decrescente_1000.csv",
                pastaDados + File.separator + "aleatorio_10000.csv",
                pastaDados + File.separator + "crescente_10000.csv",
                pastaDados + File.separator + "decrescente_10000.csv"
        };

        return arquivos;
    }
}
