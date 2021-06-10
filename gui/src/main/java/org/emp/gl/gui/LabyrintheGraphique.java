package org.emp.gl.gui;



import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.emp.gl.action.Action;
import org.emp.gl.lookup.Lookup;
import org.emp.gl.robotPositionChangeListner.RobotPositionChangeListner;
public class LabyrintheGraphique extends JFrame
implements RobotPositionChangeListner,KeyListener
{
   /**
    * <p>Serial version UID.</p>
    */
   private static final long serialVersionUID = 1L;

   /** La minuterie pour l'affichage des disques. */
   private Timer minuterie;

   /** Le labyrinthe. */
   private boolean[][] labyrinthe = {
      {false, false, false, false, false, false, false, false, false, false},
      {false, true, true, true, false, true, false, true, false, true },
      {false, true, true, true, false, true, false, true, true, true},
      {false, true, false, false, false, true, false, true, false, false},
      {false, true, true, true, true, true, false, true, false, false},
      {true, true, true, true, false, false, false, true, false, false},
      {false, true, true, true, true, true, true, true, false, false},
      {false, true, false, false, false, false, false, false, false, false},
      {false, true, true, true, true, true, true, true, true, false},
      {false, false, false, false, false, false, false, false, false, false},
  };
/*
private boolean[][] labyrinthe = {
   {true, true, true, true, true, true, true, true, true, true, true, true},
   {true, true, true, true, true, true, true, true, true, true, true, true},
   {true, true, true, true, true, true, true, true, true, true, true, true},
   {true, true, true, true, true, true, true, true, true, true, true, true},
   {true, true, true, true, true, true, true, true, true, true, true, true},
   {true, true, true, true, true, true, true, true, true, true, true, true},
   {true, true, true, true, true, true, true, true, true, true, true, true},
   {true, true, true, true, true, true, true, true, true, true, true, true},
   {true, true, true, true, true, true, true, true, true, true, true, true},
   {true, true, true, true, true, true, true, true, true, true, true, true},
   {true, true, true, true, true, true, true, true, true, true, true, true},
   {true, true, true, true, true, true, true, true, true, true, true, true}};
*/
   /** Position courante en x dans le labyrinthe. */
   private int x=0;

   /** Position courante en y dans le labyrinthe. */
   private int y=5;

   /** Position de départ en x dans le labyrinthe. */
   private final int xd = 0;

   /** Position de départ en y dans le labyrinthe. */
   private final int yd = 2;





/** Taille du pion se déplaçant dans le labyrinthe. */
   private static final int TAILLE_PION = 18;

   /** Taille des cases du labyrinthe. */
   private static final int TAILLE_CASE = 20;

   /** Taille du décalage à gauche du labyrinthe. */
   private static final int DEC_GAUCHE = 25;

   /** Taille du décalage en haut du labyrinthe. */
   private static final int DEC_HAUT = 50;



 public LabyrintheGraphique()
   {
      super("Labyrinthe graphique");

      // Initialisation du labyrinthe.
      

      // Initialisation du timer.
     

      // Propriétés de la fenêtre.
      addKeyListener(this);
      setLocation(50, 50);
      setSize(295, 315);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
 public void paint(Graphics g)
   {
      // Parcourt le labyrinthe.
      for(int i = 0; i < this.labyrinthe.length; i++)
      {
         for(int j = 0; j < this.labyrinthe.length; j++)
         {
            // Case libre.
            if(this.labyrinthe[i][j])
            {
               g.setColor(Color.WHITE);
               g.fillRect(DEC_GAUCHE + j * TAILLE_CASE, DEC_HAUT + i * TAILLE_CASE, 
                     TAILLE_CASE, TAILLE_CASE);
               g.setColor(Color.LIGHT_GRAY);
               g.drawRect(DEC_GAUCHE + j * TAILLE_CASE, DEC_HAUT + i * TAILLE_CASE, 
                     TAILLE_CASE, TAILLE_CASE);
            }
            // Mur.
            else
            {
               g.setColor(Color.BLUE);
               g.fillRect(DEC_GAUCHE + j * TAILLE_CASE, DEC_HAUT + i * TAILLE_CASE, 
                     TAILLE_CASE, TAILLE_CASE);
            }
         }
         
      }
      g.setColor(Color.red);
      g.fillOval(DEC_GAUCHE+1+this.x*TAILLE_CASE,DEC_HAUT+1+this.y*TAILLE_CASE,TAILLE_PION,TAILLE_PION);
   }



   public boolean exist(int x,int y){
      if(x<=11&&x>=0&&y<=11&&y>=0&&labyrinthe[y][x]==true){
         return true;
      }
      return false;
   }
  

@Override
public void propertyChange(PropertyChangeEvent evt) {
   Point newp = (Point) evt.getNewValue();
   
   y=newp.x;
   x=newp.y;
   
   this.repaint();
  
}


   

  
   

@Override
public void keyPressed(KeyEvent e) {
   
   Action action = (Action) Lookup.getInstance().getService(Action.class);
   if(e.getKeyCode()== KeyEvent.VK_RIGHT)
  action.moveRight();
else if(e.getKeyCode()== KeyEvent.VK_LEFT)
   action.moveLeft();   
else if(e.getKeyCode()== KeyEvent.VK_DOWN)
   action.moveDown();
else if(e.getKeyCode()== KeyEvent.VK_UP)
   action.moveUp();
   
}
@Override
public void keyReleased(KeyEvent arg0) {
  
   
}
@Override
public void keyTyped(KeyEvent arg0) {
 
   
}







   
}