/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Modele.Joueur;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author valetmax
 */
public class ViewTexte extends View {
    private JLabel scoreJ1 = new JLabel("0");
    private JLabel scoreJ2 = new JLabel("0");
    private JLabel scoreAff1 = new JLabel("Score :  ");
    private JLabel scoreAff2 = new JLabel("Score :  ");
    private JLabel message = new JLabel("");
    private JPanel gridCenter = new JPanel(new GridLayout(2, 5));
    private JPanel gridSouth = new JPanel(new GridLayout(2, 1));
    private JPanel gridSouthNorth = new JPanel(new GridLayout(1, 5));
    private JTextField joueur1 = new JTextField();
    private JTextField joueur2 = new JTextField();
    private JButton jouer = new JButton("Jouer");
    private JButton reset = new JButton("Reset");
    private JButton quitter = new JButton("Quitter");
    
    
    public ViewTexte() {
        super();
        fenetre.add(borderPanel);
        fenetre.setSize(400, 150);
        borderPanel.add(gridCenter, BorderLayout.CENTER);
        scoreAff1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        scoreAff2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        
        
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
        
        borderPanel.add(gridSouth, BorderLayout.SOUTH);
        gridSouth.add(gridSouthNorth, 0);
        gridSouth.add(message, 1);
        
        gridSouthNorth.add(jouer, 0);
        gridSouthNorth.add(new JLabel(" "), 1);
        gridSouthNorth.add(reset, 2);
        gridSouthNorth.add(new JLabel(" "), 3);
        gridSouthNorth.add(quitter, 4);
        
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
    
    @Override
    public String getJoueur1() {
        return joueur1.getText();
    }
    
    @Override
    public String getJoueur2() {
        return joueur2.getText();
    }
    
    public JButton getJouer() {
        return jouer;
    }

    /**
     * @return the rejouer
     */
    public JButton getReset() {
        return reset;
    }

    /**
     * @return the quitter
     */
    public JButton getQuitter() {
        return quitter;
    }
    public void setScoreJ1(String text){
        scoreJ1.setText(text);
    }
    public void setScoreJ2(String text){
        scoreJ2.setText(text);
    }

    public void setMessage(String message) {
        this.message.setText(message);
    }
    
    public void reset() {
        this.joueur1.setText(null);
        this.joueur2.setText(null);
        this.scoreJ1.setText("0");
        this.scoreJ2.setText("0");
        this.message.setText(null);
    }
    
    
}
    

