import java.util.Random;
import java.util.Scanner;

public class Partida {
    String jogadorAtual = "X";
    Tabuleiro t = new Tabuleiro();
    Scanner s = new Scanner(System.in);
    int linhaEscolhida;
    int colunaEscolhida;
    int rodada = 1;
    Vitoria v = new Vitoria();
    String[][] tabuleiro = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    String simboloEscolhido;
    Random r = new Random();
    int linhaEscolhidaComp;
    int colunaEscolhidaComp;
    boolean escolhaComp = true;
    boolean partidaComp = true;
    int menuEscolhido;

    public void alternanciaRodadas(){
        
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
            tabuleiro[linhaEscolhida - 1][colunaEscolhida - 1] = jogadorAtual;
        }
    }

    public void alternanciaRodadasComp(){
        System.out.println("\nQual símbolo você deseja (X ou O): ");
        simboloEscolhido = s.next().toUpperCase();
        
        while(partidaComp && rodada < 10){
            escolhaComp = true;
            t.exibirTabuleiro(tabuleiro);
            if(simboloEscolhido.equals("X")){
                System.out.println("Escolha uma linha (1, 2 ou 3): ");
                linhaEscolhida = s.nextInt();
                System.out.println("Escolha uma coluna (1, 2 ou 3): ");
                colunaEscolhida = s.nextInt();
                tabuleiro[linhaEscolhida - 1][colunaEscolhida - 1] = simboloEscolhido;
                if(v.verificarVitoria(tabuleiro)){
                    t.exibirTabuleiro(tabuleiro);
                    System.out.println("PARABÉNS!!! VOCÊ VENCEU.");
                    partidaComp = false;
                    break;
                }
                while(escolhaComp){
                    linhaEscolhidaComp = r.nextInt(3);
                    colunaEscolhidaComp = r.nextInt(3);
                    if(tabuleiro[linhaEscolhidaComp][colunaEscolhidaComp].equals(" ")){
                        tabuleiro[linhaEscolhidaComp][colunaEscolhidaComp] = "O";
                        escolhaComp = false;
                    }
                }
                if(v.verificarVitoria(tabuleiro)){
                    t.exibirTabuleiro(tabuleiro);
                    System.out.println("QUE PENA, VOCÊ FOI DERROTADO!!!");
                    partidaComp = false;
                }
            }
            else if(simboloEscolhido.equals("O")){
                System.out.println("Escolha uma linha (1, 2 ou 3): ");
                linhaEscolhida = s.nextInt();
                System.out.println("Escolha uma coluna (1, 2 ou 3): ");
                colunaEscolhida = s.nextInt();
                tabuleiro[linhaEscolhida - 1][colunaEscolhida - 1] = simboloEscolhido;
                if(v.verificarVitoria(tabuleiro)){
                    t.exibirTabuleiro(tabuleiro);
                    System.out.println("PARABÉNS!!! VOCÊ VENCEU.");
                    partidaComp = false;
                    break;
                }
                while(escolhaComp){
                    linhaEscolhidaComp = r.nextInt(3);
                    colunaEscolhidaComp = r.nextInt(3);
                    if(tabuleiro[linhaEscolhidaComp][colunaEscolhidaComp].equals(" ")){
                        tabuleiro[linhaEscolhidaComp][colunaEscolhidaComp] = "X";
                        escolhaComp = false;
                    }
                }
                if(v.verificarVitoria(tabuleiro)){
                    t.exibirTabuleiro(tabuleiro);
                    System.out.println("QUE PENA, VOCÊ FOI DERROTADO!!!");
                    partidaComp = false;
                }
            }
        }
        if(v.verificarVitoria(tabuleiro) == false){
            System.out.println("Deu velha!!!");
        }
    }
    
    public void jogarPartida(){
        menuEscolhido = t.exibirMenu();
        if(menuEscolhido == 2){
            while(rodada < 10){
                alternanciaRodadas();
                if(v.verificarVitoria(tabuleiro)){
                    t.exibirTabuleiro(tabuleiro);
                    System.out.println("VENCEDOR: " + jogadorAtual);
                    break;
                }
            }
            if(v.verificarVitoria(tabuleiro) == false){
                System.out.println("Deu velha");
            }
        }
        else if(menuEscolhido == 1){
            alternanciaRodadasComp();
        }
    }
}
