/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Modele.Joueur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author valetmax
 */
public abstract class View extends Observable {
    protected final JFrame fenetre = new JFrame();
    protected JPanel borderPanel = new JPanel(new BorderLayout());
    protected JPanel gridNorth = new JPanel(new GridLayout(2, 1));
    protected JPanel gridNorthSouth = new JPanel(new GridLayout(2, 5));
    protected JPanel gridSouth = new JPanel(new GridLayout(1, 5));
    protected JTextField joueur1 = new JTextField();
    protected JTextField joueur2 = new JTextField();
    private JButton jouer = new JButton("Jouer");
    private JButton rejouer = new JButton("Rejouer");
    private JButton quitter = new JButton("Quitter");
    
    
    public View() {
        fenetre.setSize(700, 700);
        fenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        
        fenetre.add(borderPanel) ;
        
        
        borderPanel.add(gridNorth, BorderLayout.NORTH) ;
        JLabel titre = new JLabel("Morpion Du Turfu");
        
        gridNorth.add(titre, 0);
        gridNorth.add(gridNorthSouth, 1);
        
        
        //Remplissage du grid layout
        gridNorthSouth.add(new JLabel(" "), 0);
        gridNorthSouth.add(new JLabel("Joueur 1 : "), 1);
        gridNorthSouth.add(joueur1,2);
        gridNorthSouth.add(new JLabel(" "), 3);     //Label qui peut être update pour le score du Joueur 1
        gridNorthSouth.add(new JLabel(" "), 4);
        gridNorthSouth.add(new JLabel(" "), 5);
        gridNorthSouth.add(new JLabel("Joueur 2 : "), 6);
        gridNorthSouth.add(joueur2,7);
        gridNorthSouth.add(new JLabel(" "), 8);     //Label qui peut être update pour le score du Joueur 2
        gridNorthSouth.add(new JLabel(" "), 9);
        
        
        borderPanel.add(gridSouth, BorderLayout.SOUTH);
        
        gridSouth.add(jouer, 0);
        gridSouth.add(new JLabel(" "), 1);
        gridSouth.add(rejouer, 2);
        gridSouth.add(new JLabel(" "), 3);
        gridSouth.add(quitter, 4);
        
        rejouer.setEnabled(false);
        
        jouer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setChanged(); 
                                Commande msg = Commande.JOUER;
                                notifyObservers(msg);
                                clearChanged();
                        }
            
            });
        
        rejouer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setChanged(); 
                                Commande msg = Commande.REJOUER;
                                notifyObservers(msg);
                                clearChanged();
                        }
            
            });
        
        quitter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setChanged(); 
                                Commande msg = Commande.QUITTER;
                                notifyObservers(msg);
                                clearChanged();
                        }
            
            });
         
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

    public String getJoueur1() {
        return joueur1.getName();
    }

    public String getJoueur2() {
        return joueur2.getName();
    }
    
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
    
}
