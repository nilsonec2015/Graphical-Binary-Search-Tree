/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import interfaces.InterfaceArvore;
import java.text.NumberFormat;
import modelo.Abb;
import modelo.No;
import javax.swing.JLabel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author nilso
 */
public class TelaPrincipal extends javax.swing.JFrame {

    Abb arvore;
    int x0 = 220;
    int y0 = 10;
    int x = 0;
    int y;
    int distV = 80;
    int iPreordem = 0;
    int alturaAtual = 0;

    public TelaPrincipal() {
        initComponents();
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        
        arvore = new Abb(new InterfaceArvore() {
            @Override
            public void desenhar(No no) {
//                if(no.altura!=alturaAtual){
//                    alturaAtual=no.altura;
//                    x=0;
//                }else
//                    x++;

//alturaAtual = no.altura;
                //x = panel.getWidth()/(no.altura+1)-25;
                //System.out.println(panel.getWidth()+" - "+x);
                
                //x0 = panel.getWidth() / (no.altura + 1) - 25;

//                System.out.println("Altura: " + no.altura + " Relacao: " + no.relacao);

                //FORMULA CORRETA DO Y                
                //int Y = (int)Math.pow(2, no.altura-2)*2;

                int Y = (int)Math.pow(2, no.altura-2)*2;

                if(no.y<0){
                    y = (Y/2) + no.y + 1;
                }else if(no.y>0){
                    y = (Y/2) + no.y;
                }else{
                    y= 1;
                    Y=1;
                }
                              
                System.out.println("[" + no.valor + "] no.x=" + no.altura + " | no.y=" + no.y+" | Y="+Y+" | y="+y);
                System.out.println("[" + no.valor + "] largura=" + panel.getWidth() + " | pontos=" + (Y) +" | divisao atual="+( panel.getWidth()*y/(Y+1) ));
                //se tenho 2 pontos, divido a tela em 3. assim: 1/3 e 2/3 da tela terao nos
                //se tenho 4 pontos, divido a tela em 5. assim 1/5, 2/5, 3/5 e 4/5 da tela terao nos
                //dividindo a tela em partes impares nunca havera um no no meio
                int divisao = panel.getWidth()/(Y+1);
                
                panel.add(no, new AbsoluteConstraints(
                        //x0 * (no.altura + no.y),
                        //(panel.getWidth()*y/(Y*2)-25),
                        (divisao*y - 25),
                        y0 + ((no.altura - 1) * 54),
                        50, 50));
                //x0 += 60;
                panel.validate();
                panel.repaint();
            }
        });
        arvore.inserir(20);
        arvore.inserir(25);
        arvore.inserir(30);
        //arvore.inserir(35);
        //arvore.inserir(40);
        //arvore.inserir(45);
        
        
//        arvore.desenhar(5);
//        arvore.desenhar(4);
//        arvore.desenhar(3);
//        
//        arvore.desenhar(11);
//        arvore.desenhar(10);
//        arvore.desenhar(12);
//        System.out.println("" + arvore.getAlturaEsq());
//        System.out.println("" + arvore.getAlturaDir());
//        System.out.println("" + arvore.getAltura());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        NumberFormat formato = NumberFormat.getNumberInstance();
        txNo = new javax.swing.JFormattedTextField(formato);
        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        lbModelo = new javax.swing.JLabel();
        btLimpar = new javax.swing.JButton();
        btArvore = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Árvore Binparia de Busca");

        jButton1.setText("Adicionar No");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txNo.setToolTipText("Valor");

        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbModelo.setBackground(new java.awt.Color(255, 255, 255));
        lbModelo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbModelo.setText("RAIZ");
        lbModelo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbModelo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbModelo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbModelo.setOpaque(true);
        panel.add(lbModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 47, 48));

        jScrollPane1.setViewportView(panel);

        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btArvore.setText("Exibir Arvore");
        btArvore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btArvoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txNo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btArvore)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(btLimpar)
                    .addComponent(btArvore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //try {

        int num = Integer.parseInt(txNo.getText());
        arvore.inserir(num);
        //arvore.preordem();
        txNo.setText("");
        txNo.requestFocus();
        //} catch (NumberFormatException e) {
        //    System.out.println("Isto nao eh um numero inteiro");
        //} catch (Exception e){
        //    System.out.println(e);
        //}

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        arvore.limpar();
        panel.removeAll();
        x0 = 10;
        panel.revalidate();
        panel.repaint();
        txNo.setText("");
        txNo.requestFocus();
    }//GEN-LAST:event_btLimparActionPerformed

    private void btArvoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btArvoreActionPerformed
        panel.removeAll();
        x0 = 220;
        System.out.println(arvore.getAltura());
    }//GEN-LAST:event_btArvoreActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btArvore;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbModelo;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txNo;
    // End of variables declaration//GEN-END:variables
}
