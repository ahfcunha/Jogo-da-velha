public class Vitoria {
    public boolean verificarVitoria(String[][] tabuleiro, String simbolo){
        for(int i = 0; i < tabuleiro.length; i++){
            // verifica se as linhas 
            if(tabuleiro[i][0].equals(simbolo) && tabuleiro[i][1].equals(simbolo) && tabuleiro[i][2]. equals(simbolo)){
                return true;
            }
            // verifica se as colunas
            if(tabuleiro[0][i].equals(simbolo) && tabuleiro[1][i].equals(simbolo) && tabuleiro[2][i].equals(simbolo)){
                return true;
            }
        }
        // verifica as diagonais
        if(tabuleiro[0][0].equals(simbolo) && tabuleiro[1][1].equals(simbolo) && tabuleiro[2][2].equals(simbolo)){
            return true;
        }
        if(tabuleiro[0][2].equals(simbolo) && tabuleiro[1][1].equals(simbolo) && tabuleiro[2][0].equals(simbolo)){
            return true;
        }
        // caso não haja vitória 
        return false;
    }
}
