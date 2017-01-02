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
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.TextArea;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author valetmax
 */
public class ViewTexte extends View {
    private JLabel scoreJ1 = new JLabel("0");
    private JLabel scoreJ2 = new JLabel("0");
    private JLabel scoreAff1 = new JLabel("Score :  ");
    private JLabel scoreAff2 = new JLabel("Score :  ");
    private JPanel gridCenter = new JPanel(new GridLayout(3, 5));
    private JPanel gridSouth = new JPanel(new GridLayout(2, 1));
    private JTextField joueur1 = new JTextField();
    private JTextField joueur2 = new JTextField();
    private JButton jouer = new JButton("Jouer");
    private JButton reset = new JButton("Reset");
    private JButton quitter = new JButton("Quitter");
    private JEditorPane edit = new JEditorPane();
    private JScrollPane scroll = new JScrollPane(edit); ;
    
    
    public ViewTexte() {
        super();
        edit.setEditable(false);
        fenetre.add(borderPanel);
        fenetre.setSize(500, 240);
        fenetre.setTitle("Morpion v.2.10.578.2");
        borderPanel.add(gridCenter, BorderLayout.CENTER);
        scoreAff1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        scoreAff2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        fenetre.setLocation(200, 400);
        
        gridCenter.setMinimumSize(new Dimension(500, 100));
        gridCenter.add(new JLabel(" "), 0);
        gridCenter.add(new JLabel("Joueur 1 : "), 1);
        gridCenter.add(joueur1,2);
        gridCenter.add(scoreAff1, 3);     
        gridCenter.add(scoreJ1, 4); //Label qui peut être update pour le score du Joueur 1
        gridCenter.add(new JLabel(" "), 5);
        gridCenter.add(new JLabel("Joueur 2 : "), 6);
        gridCenter.add(joueur2,7);
        gridCenter.add(scoreAff2, 8);     
        gridCenter.add(scoreJ2, 9); //Label qui peut être update pour le score du Joueur 2
        gridCenter.add(jouer, 10);
        gridCenter.add(new JLabel(" "), 11);
        gridCenter.add(reset, 12);
        gridCenter.add(new JLabel(" "), 13);
        gridCenter.add(quitter, 14);
        
        borderPanel.add(scroll, BorderLayout.SOUTH);
        
        //Partie permettant de faire la barre de texte qui change a chaque action
        edit.setForeground(Color.red);
        edit.setMinimumSize(new Dimension(500, 100));
        edit.setPreferredSize(new Dimension(500, 100));
        
        scroll.setPreferredSize(new Dimension(500, 100));
        scroll.setMinimumSize(new Dimension(500, 100));
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
       
        this.addMessage("Règles du morpion : ");
        this.addMessage("  1- Chaque joueur joue à tour de rôle.");
        this.addMessage("  2- Le premier joueur à aligner 3 symboles identiques gagne la partie.");
        this.addMessage("  3- Le joueur a commencé change à chaque début de partie. ");
        this.addMessage("Bonne chance :)");
        
        
        reset.setEnabled(false);
        
        jouer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setChanged();
                                Commande msg = Commande.JOUER;
                                notifyObservers(msg);
                                clearChanged();
                                
                        }
            
            });
        
        reset.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setChanged(); 
                                Commande msg = Commande.RESET;
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

    

    @Override
    public void aClique(int arg, Joueur jCourant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
    public String getJoueur1() {
        return joueur1.getText();
    }
    
    public String getJoueur2() {
        return joueur2.getText();
    }
    
    public JButton getJouer() {
        return jouer;
    }

    
    public JButton getReset() {
        return reset;
    }

   
    public JButton getQuitter() {
        return quitter;
    }
    public void setScoreJ1(String text){
        scoreJ1.setText(text);
    }
    public void setScoreJ2(String text){
        scoreJ2.setText(text);
    }

    public void addMessage(String message) {
        edit.setText(edit.getText() + "\n" + message);
    }
    
    public void reset() {
    //remet l'ihm texte à la situation de départ avant que l'on ai fait quoi que ce soit
        this.joueur1.setText(null);
        this.joueur2.setText(null);
        this.scoreJ1.setText("0");
        this.scoreJ2.setText("0");
        this.edit.setText(null);
    }
    
    
}
    

