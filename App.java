import java.util.ArrayList;
import java.util.Scanner;

public class App {

    // Função hash baseada na primeira letra maiúscula da palavra
    public static int funcaoHash(String palavra, int tamanho) {
        int hash = 0;
        hash = 13 + palavra.toUpperCase().charAt(0); 
        return hash % tamanho;
    }

    public static boolean buscarPalavra(String palavra, ArrayList<String>[] tabelaHash, int tam) {
        // Converte a palavra para maiúsculas para garantir consistência
        palavra = palavra.toUpperCase();

        int categoria = funcaoHash(palavra, tam);

        if (tabelaHash[categoria].contains(palavra)) {
            System.out.println("Palavra \"" + palavra + "\" encontrada na categoria " + categoria + ".");
            return true;
        } else {
            System.out.println("Palavra \"" + palavra + "\" NÃO encontrada na categoria " + categoria + ".");
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  

        int totalCategorias = 26;
        ArrayList<String>[] tabelaHash = new ArrayList[totalCategorias];

        // Inicializar a tabela hash
        for (int i = 0; i < tabelaHash.length; i++) {
            tabelaHash[i] = new ArrayList<String>();
        }

        ArrayList<String> palavrasInseridas = new ArrayList<>();

        System.out.println("Adicionando palavras:");
        for (int i = 0; i < 100; i++) {
            String palavra = GeradorPalavras.gerarPalavraAleatoria(3, 10).toUpperCase(); // Converte para maiúsculas
            palavrasInseridas.add(palavra);

            int categoria = funcaoHash(palavra, totalCategorias);
            tabelaHash[categoria].add(palavra);

            System.out.println(palavra + " -> " + categoria);
        }

        // Loop para pedir palavras ao usuário até que ele digite 0
        while (true) {
            System.out.println("\nDigite a palavra que você deseja buscar (somente letras) ou 0 para sair: ");
            String palavraParaBuscar = scanner.nextLine(); // Recebe a palavra do usuário

            if (palavraParaBuscar.equals("0")) {
                System.out.println("Saindo do programa.");
                break;  // Encerra o loop e sai do programa
            }

            buscarPalavra(palavraParaBuscar, tabelaHash, totalCategorias); 
        }

        scanner.close(); 
}
}
