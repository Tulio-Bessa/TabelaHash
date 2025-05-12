import java.util.Random;

public class GeradorPalavras {

    public static String gerarPalavraAleatoria(int tamanhoMin, int tamanhoMax) {
        Random random = new Random();
        int tamanho = random.nextInt(tamanhoMax - tamanhoMin + 1) + tamanhoMin;
        StringBuilder palavra = new StringBuilder(tamanho);

        for (int i = 0; i < tamanho; i++) {
            // Gera um caractere aleatório entre 'a' (97) e 'z' (122)
            char letra = (char) (random.nextInt(26) + 97);
            palavra.append(letra);
        }

        return palavra.toString();
    }

    public static void main(String[] args) {
        // Testando a função com 100 palavras aleatórias
        for (int i = 0; i < 100; i++) {
            System.out.println(gerarPalavraAleatoria(3, 10));
        }
    }
}