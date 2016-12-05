/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Modele.Joueur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Observable;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author valetmax
 */
public abstract class View extends Observable {
    protected final JFrame fenetre = new JFrame();
    protected JPanel borderPanel = new JPanel(new BorderLayout());
    JPanel northPanel = new JPanel();
    
    public View() {
        fenetre.setSize(1000, 1000);
        fenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        
        fenetre.add(borderPanel) ;
        
        
        borderPanel.add(northPanel, BorderLayout.NORTH) ;
        JLabel titre = new JLabel("Morpion Du Turfu");
        titre.setBorder(BorderFactory.createLineBorder(Color.orange, 4));
        northPanel.add(titre);
        
         
    }
    
    
    public void setVisible(boolean b) {
        this.fenetre.setVisible(b);
    }

    public JFrame getFenetre() {
        return fenetre;
    }

    public JPanel getBorderPanel() {
        return borderPanel;
    }
    
    public abstract void aClique(int arg, Joueur JCourant);
    
    
}
