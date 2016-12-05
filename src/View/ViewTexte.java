/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Modele.Joueur;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author valetmax
 */
public class ViewTexte extends View {
    private JLabel resultat;
    private JPanel gridNorthSouth = new JPanel(new GridLayout(2, 5));
    
    public ViewTexte() {
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

}
    

