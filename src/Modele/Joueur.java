/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;

/**
 *
 * @author valetmax
 */
public class Joueur {
    
    private String nom;
    private int score;
    private Symbole symbole;
    private ArrayList<Case> casesCochees;
    
    
    Joueur (String nom,Symbole symbole) {
        this.nom=nom;
        this.score=0;
        this.symbole=symbole;       
    }

    public Symbole getSymbole() {
        return symbole;
    }

    public ArrayList<Case> getCasesCochees() {
        return casesCochees;
    }
    public void resetCases(){
        casesCochees=new ArrayList<Case>();
    }
    
    
    public boolean aGagner() {
        int i = casesCochees.get(casesCochees.size() - 1).getNumero();
        boolean aGagne = false;
        
        for (Case c : casesCochees) {
            if (((c.getNumero() % 3 == casesCochees.get((c.getNumero() + 3) % 9).getNumero() % 3) &&
                (c.getNumero() % 3 == casesCochees.get((c.getNumero() + 6) % 9).getNumero() % 3)) 
                    ||
                ((c.getNumero() % 3 == casesCochees.get((c.getNumero() + 4) % 9).getNumero() % 3) &&
                (c.getNumero() % 3 == casesCochees.get((c.getNumero() + 8) % 9).getNumero() % 3)))
                {
                    aGagne = true;
                }
            else if (c.getNumero() == 1){
                
            }
        }
        
        return aGagne;
    }
}
