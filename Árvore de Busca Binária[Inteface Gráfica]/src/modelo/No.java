package modelo;

import javax.swing.JLabel;

/**
 *
 * @author nilso
 */
public class No extends JLabel {

    int valor;

    No noEsq;
    No noDir;
      
    public No(int valor) {
        super();
        this.valor = valor;        
    }

}
