package joke;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Jaqueline
 */
public class Joke {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            
            String[] opcoes = {"Pedra", "Papel", "Tesoura"};
            
            System.out.println("Bem-vindo ao Jo-Ken-Po!");
            
            while (true) {
                System.out.println("Escolha uma opção:\n1. Pedra\n2. Papel\n3. Tesoura\n0. Sair");
                int escolhaJogador = scanner.nextInt();
                
                if (escolhaJogador == 0) {
                    System.out.println("Obrigado por jogar. Até logo!");
                    break;
                }
                
                if (escolhaJogador < 1 || escolhaJogador > 3) {
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
                    continue;
                }
                
                int escolhaComputador = random.nextInt(3) + 1;
                
                System.out.println("Jogador escolheu: " + opcoes[escolhaJogador - 1]);
                System.out.println("Computador escolheu: " + opcoes[escolhaComputador - 1]);
                
                int resultado = verificarVencedor(escolhaJogador, escolhaComputador);
                
                switch (resultado) {
                    case 0:
                        System.out.println("Empate!");
                        break;
                    case 1:
                        System.out.println("Jogador venceu!");
                        break;
                    default:
                        System.out.println("Computador venceu!");
                        break;
                }
            }
        }
    }

    private static int verificarVencedor(int escolhaJogador, int escolhaComputador) {
        if (escolhaJogador == escolhaComputador) {
            return 0; // Empate
        } else if ((escolhaJogador == 1 && escolhaComputador == 3) ||
                (escolhaJogador == 2 && escolhaComputador == 1) ||
                (escolhaJogador == 3 && escolhaComputador == 2)) {
            return 1; // Jogador vence
        } else {
            return -1; // Computador vence
        }
    }
    }
    

