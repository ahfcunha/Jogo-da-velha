import java.util.Scanner;

public class Tabuleiro{
    Scanner s = new Scanner(System.in);
    boolean numeroValido;
    int numeroJogadores;
    

    public void exibirTabuleiro(String[][] tabuleiro) {
        for(int i = 0; i < tabuleiro.length; i++){
            System.out.println(String.join(" | ", tabuleiro[i]));

            if(i < tabuleiro.length - 1){
                System.out.println("---------");
            }
        }
    }

    public int exibirMenu(){
        System.out.println("***JOGO DA VELHA***");
        numeroValido = false;
        while(!numeroValido){
            System.out.println("\nNúmero de jogadores (1 ou 2): ");
            numeroJogadores = s.nextInt();
            if(numeroJogadores == 1 || numeroJogadores == 2){
                numeroValido = true;
            }
        }
        return numeroJogadores;
    }
}
