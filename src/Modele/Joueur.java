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
    private ArrayList<Case> casesCochees = new ArrayList<>();
    
    
    public Joueur (String nom,Symbole symbole) {
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
        casesCochees.clear();
    }
    
    
    public boolean aGagner() {
        Case c = casesCochees.get(casesCochees.size() - 1);
        boolean aGagne = false;
        int num = c.getNumero();
        
        int i = 0;
        while (i < casesCochees.size()){
            if (((num == casesCochees.get(i).getNumero() + 3 % 9) &&
                (num == casesCochees.get(i).getNumero() + 6 % 9)) 
                    ||
                ((num == casesCochees.get(i).getNumero() + 4 % 9)) &&
                (num == casesCochees.get(i).getNumero() + 8 % 9))
                {
                    aGagne = true;
                }
            i++;
        }
            
            
                //Cette partie est surement bugué
                for (Case s : casesCochees) {
                    if (s.getNumero() == 1) {
                        for (Case d : casesCochees) {
                            if(s.getNumero() == 2) {
                                for (Case e : casesCochees) {
                                    if(e.getNumero() == 3) {
                                        aGagne = true;
                                    }
                                }
                            }                               
                        }
                    }
                    else if(c.getNumero()==4){
                        for (Case d : casesCochees) {
                            if(c.getNumero() == 5) {
                                for (Case e : casesCochees) {
                                    if(e.getNumero() == 6) {
                                        aGagne = true;
                                    }
                                }
                            }
                        }
                    }
                    else if(c.getNumero()==7){
                        for (Case d : casesCochees) {
                            if(c.getNumero() == 8) {
                                for (Case e : casesCochees) {
                                    if(e.getNumero() == 9) {
                                        aGagne = true;
                                    }
                                }
                            }
                        }
                    }
                }       
        return aGagne;
    }
    
    
    public void setScore(){
        this.score=score+1;
    }
    public int getScore(){
        return score;
    }

    public String getNom() {
        return nom;
    }
    
    
}
