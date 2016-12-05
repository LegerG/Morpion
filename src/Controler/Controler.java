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
import View.ViewTexte;


/**
 *
 * @author valetmax
 */
public class Controler implements Observer{
    private ViewGraphique ihmGraphique;
    private ViewTexte ihmTexte;
    private ArrayList<Joueur> joueurs;
    private ArrayList<Case> cases;
    private Joueur JCourant;

    public Controler(ViewGraphique ihmGraphique, ViewTexte ihmTexte) {
        this.ihmGraphique = ihmGraphique;
        this.ihmTexte = ihmTexte;
        this.ihmGraphique.setVisible (true);
        this.ihmTexte.setVisible(true);
        JCourant = joueurs.get(0);
        
    }
    public void reset(){
        for (int i = 0; i < 9; i++) {
            this.ihmGraphique.getButtons().get(i).enable(true);
        }
        this.joueurs.get(0).resetCases();
        this.joueurs.get(1).resetCases();
        this.cases=new ArrayList<Case>();
    }
    
    
    

    @Override
    public void update(Observable o, Object arg) {
       if (arg instanceof Integer){
           ihmGraphique.aClique((int)arg, JCourant);
           JCourant.getCasesCochees().add(cases.get((int)arg));
           
           if (JCourant.aGagner()){
               
           }
           this.auJoueurSuivant();
       }
       else if (arg==Commande.JOUER){
           reset();
           lancerPartie();
           JCourant=this.joueurs.get(0);
       }
       else if (arg==Commande.QUITTER){
           ihmGraphique.fermer();
           
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
    private void auJoueurSuivant(){
        int res =0;
        for (int i = 0; i < 2; i++) {
            if(JCourant==this.joueurs.get(i)){
                res=i;
            }
        }
        if (res==1){
            JCourant=this.joueurs.get(0);
        }
        else if(res==0){
            JCourant=this.joueurs.get(1);
        }
    }
}
