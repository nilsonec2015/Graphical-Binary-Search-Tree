package modelo;

import javax.swing.JLabel;

/**
 *
 * @author nilso
 */
public class No extends JLabel {

    protected int valor;
    public int altura;
    public int relacao;

    No noEsq;
    No noDir;

    public No(int valor) {
        this.valor = valor;
        desenhar(valor + "");
    }

    public No(int valor, int altura, int relacao) {
        this.valor = valor;
        this.altura = altura;
        this.relacao = relacao;
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
