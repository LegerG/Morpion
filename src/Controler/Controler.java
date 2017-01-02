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
import Modele.Action;
import View.ViewGraphique;
import View.Commande;
import View.ViewTexte;

/*
    Message a destination de maxime, j'ai fais une class d'action qui se compose de Joueur et de case sur laquelle il a cliqué.
    Pour le ctrl-Z on supprime la dernièere action de la ArrayList actions (qui contient des Action).
    Test le programme tu verras que lorsque l'on clique sur ctrl-Z la taille de actions diminue (la suppression fonctionne) mais
    les cases de l'ihm ne sont pas mis à jour. voili voilou bonne chance.
*/


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
    private Joueur joueurACommencer;
    private ArrayList<Action> actions = new ArrayList<>();
    

    public Controler(ViewGraphique ihmGraphique, ViewTexte ihmTexte) {
        this.ihmGraphique = ihmGraphique;
        this.ihmTexte = ihmTexte;
        
        this.ihmTexte.setVisible(true);
        this.cases = new ArrayList<>();
        
        for (int i = 0; i < 9; i++) {
            Case c = new Case(i);
            cases.add(c);       
        }
    }
    
    
    @Override
    public void update(Observable o, Object arg) {
       if (arg instanceof Integer){
           //creation d'une action qui contient un joueur et une case (celle sur laquelle il a cliqué
           Action a = new Action(JCourant, cases.get((int)arg));
           actions.add(a);
           
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
               
               
               this.ihmGraphique.setEnableButton(false);
               this.ihmTexte.addMessage(getJCourant().getNom() + " a gagné cette partie.");
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
           Action a;
           lancerPartie();
           
           if (!actions.isEmpty()) {
               a = actions.get(actions.size() - 1);
               actions.clear();
               JCourant= changeJoueur(a.getJoueur());
           }
           else {
               JCourant = joueurACommencer;
           }
           
           
           
           resetCasesJoueurs();
           this.ihmGraphique.setVisible(true);
           this.ihmTexte.getJouer().setEnabled(true);
           this.ihmGraphique.nettoie();
           this.ihmTexte.getJouer().setEnabled(false);
           this.ihmTexte.getReset().setEnabled(false);
           this.ihmTexte.addMessage("Vous avez lancé une partie.");
       }
       else if (arg == Commande.QUITTER){
           this.ihmTexte.addMessage("Vous avez fermé la fenêtre de jeu.");
           this.ihmTexte.getJouer().setEnabled(true);
           this.ihmTexte.getReset().setEnabled(true);
           
           
           ihmGraphique.fermer();
           
       }
       else if (arg == Commande.RESET){
           this.ihmTexte.reset();
           
           ihmGraphique.fermer();
           this.joueurs.clear();
           this.ihmTexte.getReset().setEnabled(false);
           lancerPartie();
           this.ihmTexte.addMessage("Réinitialisation des joueurs et de leurs scores.");
       }
       else if (arg == Commande.CTRL_Z){
           controleZ();
           
       }
       
        
        
       
    }

    public Joueur getJCourant() {
        return JCourant;
    }

    
    private void lancerPartie(){
        if (joueurs.isEmpty()) {
            Joueur j1 = new Joueur(ihmTexte.getJoueur1(), Symbole.O);
            Joueur j2 = new Joueur(ihmTexte.getJoueur2(), Symbole.X);
            joueurs.add(j1);
            joueurs.add(j2);
            joueurACommencer = j1;
        }
        else {
            joueurACommencer = changeJoueur(joueurACommencer);
        }
        
        ihmGraphique.setEnableButton(true);
        
        
 
    }
    
    private Joueur changeJoueur(Joueur j){
        
        if (actions.size() != 0) {
            j = joueurs.get((joueurs.indexOf(dernierJoueurAAvoirJoue()) + 1) % 2);
        }
        else {
            j = joueurACommencer;
        }
        return j;
    }
    
    
    private Joueur auJoueurSuivant(){
        Joueur j;
        if (actions.size() != 0) {
            j = joueurs.get((joueurs.indexOf(dernierJoueurAAvoirJoue()) + 1) % 2);
        }
        else {
            j = joueurACommencer;
        }
        return j;
    }
    
    
    private int numJCourant(){
        return joueurs.lastIndexOf(JCourant);
    }
    
    public void resetCasesJoueurs(){
        this.joueurs.get(0).resetCases();
        this.joueurs.get(1).resetCases();
    }
    
    public void controleZ() {
        Action a;


        if (!actions.isEmpty() && !this.dernierJoueurAAvoirJoue().aGagner()) {
            a = actions.get(actions.size() - 1); //dernière action de la listes
            this.JCourant=this.dernierJoueurAAvoirJoue();
            ihmGraphique.supprDerniereCase(a.getNumCase());
            
            this.JCourant.supprDerniereCaseCochee();
            actions.remove(a);
            this.ihmTexte.addMessage("Retour en arrière.");
            
        }
        else {
            this.ihmTexte.addMessage("Il ne se passe rien si le plateau est vide ou si un des joueurs a gagné.");
        }
        
        
        
        
        
    }
    
    public Joueur dernierJoueurAAvoirJoue() {
        Joueur j;
        j = actions.get(actions.size() - 1).getJoueur();
        
        return j;
    }
}

