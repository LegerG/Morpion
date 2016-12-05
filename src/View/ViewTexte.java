/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Modele.Joueur;
import java.awt.BorderLayout;
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
    private JLabel resultat;
    private JPanel gridCenter = new JPanel(new GridLayout(2, 5));
    protected JTextField joueur1 = new JTextField();
    protected JTextField joueur2 = new JTextField();
    protected JButton jouer = new JButton("Jouer");
    protected JButton rejouer = new JButton("Rejouer");
    protected JButton quitter = new JButton("Quitter");
    
    
    public ViewTexte() {
        super();
        fenetre.add(borderPanel);
        borderPanel.add(gridCenter, BorderLayout.CENTER);
        
        gridCenter.add(new JLabel(" "), 0);
        gridCenter.add(new JLabel("Joueur 1 : "), 1);
        gridCenter.add(joueur1,2);
        gridCenter.add(new JLabel(" "), 3);     //Label qui peut être update pour le score du Joueur 1
        gridCenter.add(new JLabel(" "), 4);
        gridCenter.add(new JLabel(" "), 5);
        gridCenter.add(new JLabel("Joueur 2 : "), 6);
        gridCenter.add(joueur2,7);
        gridCenter.add(new JLabel(" "), 8);     //Label qui peut être update pour le score du Joueur 2
        gridCenter.add(new JLabel(" "), 9);
        
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

    

    @Override
    public void aClique(int arg, Joueur jCourant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getJoueur1() {
        return joueur1.getName();
    }
    
    @Override
    public String getJoueur2() {
        return joueur2.getName();
    }
}
    

