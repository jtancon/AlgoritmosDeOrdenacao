import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeitorCSV {

    public static List<Integer> lerNumeros(String caminhoArquivo) {
        List<Integer> numeros = new ArrayList<>();
        File arquivo = new File(caminhoArquivo);

        if (!arquivo.exists()) {
            System.out.println("Arquivo não encontrado: " + caminhoArquivo);
            return numeros;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();

                if (primeiraLinha) {
                    primeiraLinha = false;
                    if (linha.equalsIgnoreCase("Value")) {
                        continue;
                    }
                }

                if (linha.isEmpty()) {
                    continue;
                }

                try {
                    int numero = Integer.parseInt(linha);
                    numeros.add(numero);
                } catch (NumberFormatException e) {
                    System.out.println("Linha inválida (não é um número): '" + linha + "' no arquivo " + caminhoArquivo);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + caminhoArquivo);
            e.printStackTrace();
        }

        return numeros;
    }
}
