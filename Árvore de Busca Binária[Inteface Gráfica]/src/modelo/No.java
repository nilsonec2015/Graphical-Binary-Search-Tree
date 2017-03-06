package modelo;

import javax.swing.JLabel;

/**
 *
 * @author nilso
 */
public class No extends JLabel {

    public int valor;
    public int altura;
    public int relacao;
    
    //private int Y=Math.pow(2, xP-1);
    //y aumenta de 0 ao infinito esta é a altura do no em vez de usar x vamos usar altura
    public int x=0;
    //y aumenta de 0 a +infinito ede 0 a -infinito
    //a raiz é 0 seus filhos sao -1 e +1
    //filhos[2] sao -2 -1 1 2
    //filhos[3] sao -4 -3 -2 -1 1 2 3 4
    //filhos[4] sao -8 -7 -6 -5 -4 -3 -2 -1 1 2 3 4 5 6 7 8
    //e assim por diante
    //o y é o indice horizontal do no
    //formula do y:
    //filho da direita yf = 2*Y
    //filho da esquerda yf = 2*Y-1
    public int y=0;

    No noEsq;
    No noDir;

    public No(int valor) {
        this.valor = valor;
        desenhar(valor + "");
    }

    public No(int valor, int altura, int y) {
        this.valor = valor;
        this.altura = altura;
        this.y = y;
        desenhar(valor + "");
    }
    

    private void desenhar(String texto) {
        this.setBackground(new java.awt.Color(255, 255, 255));
        this.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        this.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        this.setOpaque(true);
        this.setText(texto);
    }

}
