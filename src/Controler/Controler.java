/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import Modele.Case;
import Modele.Joueur;
import View.ViewGraphique;
import View.Commande;


/**
 *
 * @author valetmax
 */
public class Controler implements Observer{
    private ViewGraphique ihm;
    private ArrayList<Joueur> joueurs;
    private ArrayList<Case> cases;
    private Joueur JCourant;

    public Controler(ViewGraphique ihm) {
        this.ihm = ihm;
        ihm.setVisible (true);
        JCourant = joueurs.get(0);
        
    }
    
    
    

    @Override
    public void update(Observable o, Object arg) {
       if (arg instanceof Integer){
           ihm.aClique((int)arg, JCourant);
           Case c = cases.get((int)arg);
           JCourant.getCasesCochees().add(c);
       }
       else if (arg==Commande.JOUER){
           lancerPartie();
       }
       else if (arg==Commande.QUITTER){
           
       }
       else if (arg==Commande.REJOUER){
           
       }
    }

    public Joueur getJCourant() {
        return JCourant;
    }

    
    private void lancerPartie(){
        for (int i = 0; i < 9; i++) {
            Case c = new Case(i);
            cases.add(c);       
        }
 
    }
}