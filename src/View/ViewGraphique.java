/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import Modele.Joueur;
import java.awt.Font;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

/**
 *
 * @author valetmax
 */
public class ViewGraphique extends View{
    private ArrayList<JButton> buttons = new ArrayList<>();
    private JPanel gridCenter = new JPanel(new GridLayout(3, 3));
    

    public ViewGraphique() {
        super();
        fenetre.setSize(700, 700);
        fenetre.setLocation(700, 200);
        
        
        borderPanel.add(gridCenter, BorderLayout.CENTER) ;
        
        for (int i=1; i<=9; i++) {
            JButton button = new JButton() ;
            button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
            button.setBackground(Color.white);
            gridCenter.add(button);
            button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setChanged(); 
                                int msg = getButtons().indexOf(button);
                                UIManager.put("Button.DisabledText", Color.BLACK);
                                notifyObservers(msg);
                                clearChanged();
                        }
            
            });
            
            button.setEnabled(false);
            buttons.add(button);
        }  
        
        String actionKey = "CtrlZ";      
        Action action = new CtrlZ_ActionListener();
        borderPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ctrl Z"), actionKey);
        borderPanel.getActionMap().put(actionKey, action);
    }

    public JPanel getGridPanel() {
        return gridNorth;
    }

    public ArrayList<JButton> getButtons() {
        return buttons;
    }

    @Override
    public void aClique(int arg, Joueur jCourant) {
        
        buttons.get(arg).setFont(new Font("Calibri", Font.PLAIN, 100));
        buttons.get(arg).setText(jCourant.getSymbole().name());
        buttons.get(arg).setEnabled(false);
        
    }

    @Override
    public String getJoueur1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJoueur2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setEnableButton(boolean bool) {
        for (JButton b : buttons) {
            b.setEnabled(bool);
        }
    }
    
    public void nettoie(){
        for(JButton b: this.buttons){
            b.setText(null);
        }
    }
    
    private class CtrlZ_ActionListener extends AbstractAction {
        CtrlZ_ActionListener() {
            super();
        }
            @Override
            public void actionPerformed(ActionEvent event) {

                setChanged();
                Commande msg = Commande.CTRL_Z;
                notifyObservers(msg);
                clearChanged();
            }
        }
    
    public void supprDerniereCase(int i) {
        buttons.get(i).setEnabled(true);
        buttons.get(i).setText(null);
        
    }
    
    
    
}
