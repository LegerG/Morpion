/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Modele.Joueur;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
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
    protected JPanel gridNorth = new JPanel();
    protected JPanel gridSouth = new JPanel(new GridLayout(1, 5));
   
    
    
    public View() {
        
        fenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        
        fenetre.add(borderPanel) ;
        
        
        borderPanel.add(gridNorth, BorderLayout.NORTH) ;
        JLabel titre = new JLabel("Morpion Du Turfu");
        
        gridNorth.add(titre);
        
         
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

    
    
    public void fermer() {
        fenetre.dispose();
    }

    /**
     * @return the jouer
     */
    public JButton getJouer() {
        return jouer;
    }

    /**
     * @param jouer the jouer to set
     */
    public void setJouer(JButton jouer) {
        this.jouer = jouer;
    }

    /**
     * @return the rejouer
     */
    public JButton getRejouer() {
        return rejouer;
    }

    /**
     * @param rejouer the rejouer to set
     */
    public void setRejouer(JButton rejouer) {
        this.rejouer = rejouer;
    }

    /**
     * @return the quitter
     */
    public JButton getQuitter() {
        return quitter;
    }

    /**
     * @param quitter the quitter to set
     */
    public void setQuitter(JButton quitter) {
        this.quitter = quitter;
    }
    
    public abstract String getJoueur1();
    
    public abstract String getJoueur2();
}
