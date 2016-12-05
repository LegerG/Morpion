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
        casesCochees.removeAll(casesCochees);
    }
    
    
    public boolean aGagner() {
        Case i = casesCochees.get(casesCochees.size() - 1);
        boolean aGagne = false;
        
        
            if (((i.getNumero() == casesCochees.get((i.getNumero() + 3) % 9).getNumero() % 3) &&
                (i.getNumero() == casesCochees.get((i.getNumero() + 6) % 9).getNumero() % 3)) 
                    ||
                ((i.getNumero() == casesCochees.get((i.getNumero() + 4) % 9).getNumero() % 3) &&
                (i.getNumero() == casesCochees.get((i.getNumero() + 8) % 9).getNumero() % 3)))
                {
                    aGagne = true;
                }
                
            
                //Cette partie est surement bugué
                for (Case c : casesCochees) {
                    if (c.getNumero() == 1) {
                        for (Case d : casesCochees) {
                            if(c.getNumero() == 2) {
                                for (Case e : casesCochees) {
                                    if(e.getNumero() == 3) {
                                        aGagne = true;
                                    }
                                }
                            }
                                
                        }
                    }
                }
        
        
        return aGagne;
    }
}
