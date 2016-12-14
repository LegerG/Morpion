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
               this.JCourant.setScore();
               if (this.numJCourant()==0){
                   this.ihmTexte.setScoreJ1(String.valueOf(this.JCourant.getScore()));
               }
               else {
                   this.ihmTexte.setScoreJ2(String.valueOf(this.JCourant.getScore()));
               }
               ihmGraphique.setEnableButton(false);
               ihmTexte.addMessage(getJCourant().getNom() + " a gagné cette partie.");
               this.ihmTexte.getJouer().setEnabled(true);
               this.ihmTexte.getReset().setEnabled(true);
           }
           else if ((joueurs.get(0).getCasesCochees().size() + joueurs.get(1).getCasesCochees().size()) == 9) {
               this.ihmTexte.addMessage(" === Egalité === ");
               this.ihmTexte.getJouer().setEnabled(true);
               this.ihmTexte.getReset().setEnabled(true);
               
           }
           JCourant = auJoueurSuivant();
           
       }
       
       else if (arg == Commande.JOUER){           
           
           this.ihmGraphique.setVisible(true);
           lancerPartie();
           JCourant=this.joueurs.get(0);
           resetCasesJoueurs();
           ihmTexte.getJouer().setEnabled(true);
           this.ihmGraphique.nettoie();
           this.ihmTexte.getJouer().setEnabled(false);
           this.ihmTexte.getReset().setEnabled(false);
       }
       
       else if (arg == Commande.QUITTER){
           this.ihmTexte.getJouer().setEnabled(true);
           this.ihmTexte.getReset().setEnabled(true);
           
           
           ihmGraphique.fermer();
           
           
           
           
       }
       
       else if (arg == Commande.RESET){
           this.ihmTexte.reset();
           
           ihmGraphique.fermer();
           this.joueurs.clear();
           this.cases.clear();
           this.ihmTexte.getReset().setEnabled(false);
           lancerPartie();
       }
       else if (arg == Commande.CTRL_Z){
           controleZ();
       }
    }

    public Joueur getJCourant() {
        return JCourant;
    }

    
    private void lancerPartie(){
        Joueur j1 = new Joueur(ihmTexte.getJoueur1(), Symbole.O);
        Joueur j2 = new Joueur(ihmTexte.getJoueur2(), Symbole.X);
        joueurs.add(j1);
        joueurs.add(j2);
        JCourant = joueurs.get(0);
        for (int i = 0; i < 9; i++) {
            Case c = new Case(i);
            cases.add(c);       
        }
        ihmGraphique.setEnableButton(true);
        
        
 
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
    
    public void controleZ() {
        Joueur j = auJoueurSuivant();
        int numCase = j.supprDerniereCase();
        ihmGraphique.supprDerniereCase(numCase);
        JCourant = auJoueurSuivant();
        
    }
}
