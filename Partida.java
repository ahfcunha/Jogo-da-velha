import java.util.Scanner;

public class Partida {
    String jogadorAtual = "X";
    Tabuleiro t = new Tabuleiro();
    Scanner s = new Scanner(System.in);
    int linhaEscolhida;
    int colunaEscolhida;
    int rodada = 1;
    Vitoria v = new Vitoria();

    public String[][] alternanciaRodadas(){
        String[][] tabuleiro = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        if(jogadorAtual.equals("X")){
            jogadorAtual = "O";
        }
        else{
            jogadorAtual = "X";
        }
        t.exibirTabuleiro(tabuleiro);
        System.out.println("\nVez de: " + jogadorAtual);
        System.out.println("Escolha uma linha (1. 2 ou 3): ");
        linhaEscolhida = s.nextInt();
        System.out.println("Escolha uma colunha (1, 2 ou 3): ");
        colunaEscolhida = s.nextInt();
        if(tabuleiro[linhaEscolhida - 1][colunaEscolhida - 1].equals(jogadorAtual)){
            System.out.println("\nERRO! Este esaço já está ocupado.");
        }
        else{
            tabuleiro[linhaEscolhida][colunaEscolhida] = jogadorAtual;
        }
        return tabuleiro;
    }
    
    public void jogarPartida(){
        while(rodada < 10){
            alternanciaRodadas();
            if(v.verificarVitoria(alternanciaRodadas()) == true){
                System.out.println("VENCEDOR: " + jogadorAtual);
                break;
            }
        }
        if(v.verificarVitoria(alternanciaRodadas()) == false){
            System.out.println("Empate");
        }
    }
}
