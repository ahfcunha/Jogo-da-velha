public class Tabuleiro{
    public void exibirTabuleiro(String[][] tabuleiro) {
        for(int i = 0; i < tabuleiro[0].length; i++){
            System.out.print(tabuleiro[0][i]);
        }
        System.out.println("\n---------");
        for(int j = 0; j < tabuleiro[1].length; j++){
            System.out.print(tabuleiro[1][j]);
        }
        System.out.println("\n---------");
        for(int k = 0; k < tabuleiro[2].length; k++){
            System.out.print(tabuleiro[2][k]);
        }
    }
}
