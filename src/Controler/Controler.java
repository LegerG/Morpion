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
import Modele.Symbole;
import View.ViewGraphique;
import View.Commande;
import View.ViewTexte;


/**
 *
 * @author valetmax
 */
public class Controler implements Observer{
    private ViewGraphique ihmGraphique;
    private ViewTexte ihmTexte;
    private ArrayList<Joueur> joueurs = new ArrayList<>();
    private ArrayList<Case> cases;
    private Joueur JCourant;

    public Controler(ViewGraphique ihmGraphique, ViewTexte ihmTexte) {
        this.ihmGraphique = ihmGraphique;
        this.ihmTexte = ihmTexte;
        
        this.ihmTexte.setVisible(true);
        this.cases = new ArrayList<>();
        
        
        
        
        
    }
   
    
    
    

    @Override
    public void update(Observable o, Object arg) {
       if (arg instanceof Integer){
           ihmGraphique.aClique((int)arg, JCourant);
           JCourant.getCasesCochees().add(cases.get((int)arg));
           
           if (JCourant.aGagner()){

               System.out.println(JCourant.getNom() + " a gagné cette partie.");

               this.JCourant.setScore();
               if (this.numJCourant()==0){
                   this.ihmTexte.setScoreJ1(String.valueOf(this.JCourant.getScore()));
               }
               else {
                   this.ihmTexte.setScoreJ2(String.valueOf(this.JCourant.getScore()));
               }

           }
           JCourant = auJoueurSuivant();
       }
       
       else if (arg == Commande.JOUER){
           
           this.ihmGraphique.setVisible(true);
           lancerPartie();
           JCourant=this.joueurs.get(0);
           resetCasesJoueurs();
           ihmTexte.getJouer().setEnabled(true);
       }
       
       else if (arg == Commande.QUITTER){
           ihmGraphique.fermer();
           ihmGraphique.reset();
           
       }
       
       else if (arg == Commande.REJOUER){
           
       }
    }

    public Joueur getJCourant() {
        return JCourant;
    }

    
    private void lancerPartie(){
        Joueur j1 = new Joueur(ihmTexte.getJoueur1(), Symbole.O);
        Joueur j2 = new Joueur(ihmTexte.getJoueur1(), Symbole.X);
        joueurs.add(j1);
        joueurs.add(j2);
        JCourant = joueurs.get(0);
        for (int i = 0; i < 9; i++) {
            Case c = new Case(i);
            cases.add(c);       
        }
        ihmGraphique.setEnableButton();
        
        
 
    }
    private Joueur auJoueurSuivant(){
        int i = numJCourant();
        
        i = (i + 1) % 2;
     
        return joueurs.get(i);
    }
    
    
    private int numJCourant(){
        return joueurs.lastIndexOf(JCourant);
    }
    
    public void resetCasesJoueurs(){
        this.joueurs.get(0).resetCases();
        this.joueurs.get(1).resetCases();
    }
}
