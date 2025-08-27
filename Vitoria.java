public class Vitoria {
    public String verificarVitoria(String[][] tabuleiro){
        if ((tabuleiro[0][0].equals('X') && tabuleiro[0][2].equals('X') && tabuleiro[0][4].equals('X')) |
            (tabuleiro[1][0].equals('X') && tabuleiro[1][2].equals('X') && tabuleiro[1][4].equals('X')) |
            (tabuleiro[2][0].equals('X') && tabuleiro[2][2].equals('X') && tabuleiro[2][4].equals('X')) |
            (tabuleiro[0][0].equals('X') && tabuleiro[1][0].equals('X') && tabuleiro[2][0].equals('X')) |
            (tabuleiro[0][2].equals('X') && tabuleiro[1][2].equals('X') && tabuleiro[2][2].equals('X')) |
            (tabuleiro[0][4].equals('X') && tabuleiro[1][4].equals('X') && tabuleiro[2][4].equals('X')) |
            (tabuleiro[0][0].equals('X') && tabuleiro[1][2].equals('X') && tabuleiro[2][4].equals('X')) |
            (tabuleiro[0][4].equals('X') && tabuleiro[1][2].equals('X') && tabuleiro[2][0].equals('X'))){
                return "Jogador X";
            }
        else if((tabuleiro[0][0].equals('O') && tabuleiro[0][2].equals('O') && tabuleiro[0][4].equals('O')) |
                (tabuleiro[1][0].equals('O') && tabuleiro[1][2].equals('O') && tabuleiro[1][4].equals('O')) |
                (tabuleiro[2][0].equals('O') && tabuleiro[2][2].equals('O') && tabuleiro[2][4].equals('O')) |
                (tabuleiro[0][0].equals('O') && tabuleiro[1][0].equals('O') && tabuleiro[2][0].equals('O')) |
                (tabuleiro[0][2].equals('O') && tabuleiro[1][2].equals('O') && tabuleiro[2][2].equals('O')) |
                (tabuleiro[0][4].equals('O') && tabuleiro[1][4].equals('O') && tabuleiro[2][4].equals('O')) |
                (tabuleiro[0][0].equals('O') && tabuleiro[1][2].equals('O') && tabuleiro[2][4].equals('O')) |
                (tabuleiro[0][4].equals('O') && tabuleiro[1][2].equals('O') && tabuleiro[2][0].equals('O'))){
                    return "Jogador O";
                }
        else {
            return "Empate";
        }
    }
}
