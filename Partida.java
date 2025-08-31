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
    boolean escolhaComp = false;
    int menuEscolhido;
    boolean entradaValida;

    public void escolhaJogador(String simbolo){
        entradaValida = false;
        while(!entradaValida){
            System.out.println("Escolha uma linha (1, 2 ou 3): ");
            linhaEscolhida = s.nextInt();
            System.out.println("Escolha uma coluna (1, 2 ou 3): ");
            colunaEscolhida = s.nextInt();
            if((linhaEscolhida == 1 || linhaEscolhida == 2 || linhaEscolhida == 3) && (colunaEscolhida == 1 || colunaEscolhida == 2 || colunaEscolhida == 3) && tabuleiro[linhaEscolhida - 1][colunaEscolhida - 1].equals(" ")){
                tabuleiro[linhaEscolhida - 1][colunaEscolhida - 1] = simbolo;
                entradaValida = true;
            }
            else{
                System.out.println("ERRO, entrada inválida!!!");
            }
        }
    }

    public void alternanciaRodadas(){
        while(rodada < 10){
            jogadorAtual = jogadorAtual.equals("X") ? "O" : "X";
            System.out.println("Vez de: " + jogadorAtual);
            t.exibirTabuleiro(tabuleiro);
            escolhaJogador(jogadorAtual);
            if(v.verificarVitoria(tabuleiro, jogadorAtual)){
                t.exibirTabuleiro(tabuleiro);
                System.out.println("VENCEDOR: " + jogadorAtual);
                return;
            }
            rodada += 1;
        }
        if(v.verificarVitoria(tabuleiro, "X") == false && v.verificarVitoria(tabuleiro, "O")){
            t.exibirTabuleiro(tabuleiro);
            System.out.println("Deu velha");
        }
    }

    public void jogadaInteligente(String simboloComputador, String simboloJogador, String[][] tabuleiro){
        if(tentarGanhar(simboloComputador, tabuleiro)){
            return;
        }
        if(tentarBloquear(simboloJogador, simboloComputador, tabuleiro)){
            return;
        }
        while(!escolhaComp){
            linhaEscolhidaComp = r.nextInt(3);
            colunaEscolhidaComp = r.nextInt(3);
            if(tabuleiro[linhaEscolhidaComp][colunaEscolhidaComp].equals(" ")){
                tabuleiro[linhaEscolhidaComp][colunaEscolhidaComp] = simboloComputador;
                escolhaComp = true;
            }
        }
    }

    public boolean tentarGanhar(String simboloComputador, String[][] tabuleiro){
        for(int i = 0; i < tabuleiro.length; i++){
            for(int j = 0; j < 3; j++){
                if(tabuleiro[i][j].equals(" ")){
                    tabuleiro[i][j] = simboloComputador;
                    if(v.verificarVitoria(tabuleiro, simboloComputador)){
                        return true;
                    }
                    tabuleiro[i][j] = " ";
                }
            }
        }
        return false;
    }

    public boolean tentarBloquear(String simboloJogador, String simboloComputador, String[][] tabuleiro){
        for(int i = 0; i < tabuleiro.length; i++){
            for(int j = 0; j < 3; j++){
                if(tabuleiro[i][j].equals(" ")){
                    tabuleiro[i][j] = simboloJogador;
                    if(v.verificarVitoria(tabuleiro, simboloJogador)){
                        tabuleiro[i][j] = simboloComputador;
                        return true;
                    }
                    tabuleiro[i][j] = " ";
                }
            }
        }
        return false;
    }

    public void alternanciaRodadasComp(){
        System.out.println("\nQual símbolo você deseja (X ou O): ");
        simboloEscolhido = s.next().toUpperCase();
        String simboloComp = simboloEscolhido.equals("X") ? "O" : "X";
        
        while(rodada < 10){
            t.exibirTabuleiro(tabuleiro);
            escolhaJogador(simboloEscolhido);
            rodada += 1;
            if(v.verificarVitoria(tabuleiro, simboloEscolhido)){
                t.exibirTabuleiro(tabuleiro);
                System.out.println("MEUS PARABÉNS VOCÊ VENCEU!!!");
                return;
            }
            jogadaInteligente(simboloComp, simboloEscolhido, tabuleiro);
            rodada += 1;
            if(v.verificarVitoria(tabuleiro, simboloComp)){
                t.exibirTabuleiro(tabuleiro);
                System.out.println("QUE PENA, VOCÊ FOI DERROTADO!!!");
                return;
            }
        }
        t.exibirTabuleiro(tabuleiro);
        System.out.println("DEU VELHA!!!");
    }
    
    public void jogarPartida(){
        menuEscolhido = t.exibirMenu();
        if(menuEscolhido == 2){
            alternanciaRodadas();
        }
        else if(menuEscolhido == 1){
            alternanciaRodadasComp();
        }
    }
}
