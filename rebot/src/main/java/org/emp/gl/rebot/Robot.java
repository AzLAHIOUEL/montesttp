package org.emp.gl.rebot;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

import org.emp.gl.action.Action;
import org.emp.gl.rebotState.MovingRightState;
import org.emp.gl.rebotState.RobotState;
import org.emp.gl.rebotState.StayingFixState;
import org.emp.gl.robotPositionChangeListner.RobotPositionChangeListner;
import org.emp.gl.timer.service.TimerChangeListner;

import java.awt.*;

public class Robot  implements Action ,TimerChangeListner{
    private boolean[][] labyrinthe = {
        {false, false, false, false, false, false, false, false, false, false, false, false},
        {false, true, true, true, false, true, true, true, true, true, true, false},
        {true, true, false, true, false, true, false, false, false, false, true, false},
        {false, false, false, true, false, true, true, true, true, false, true, false},
        {false, true, true, true, true, false, false, false, true, false, true, true},
        {false, false, false, false, true, false, true, false, true, false, true, false},
        {false, true, true, false, true, false, true, false, true, false, true, false},
        {false, false, true, false, true, false, true, false, true, false, true, false},
        {false, true, true, true, true, true, true, true, true, false, true, false},
        {false, false, false, false, false, false, true, false, false, false, true, false},
        {false, true, true, true, true, true, true, false, true, true, true, false},
        {false, false, false, false, false, false, false, false, false, false, false, false}};
    RobotState currentState;
    PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    public Integer x=2,y=0;
    public int orientation=2;
    public Robot(){
        this.currentState=new MovingRightState(this);
       
    }
    public void setState(RobotState currentState){
        
        this.currentState=currentState;
    }

  

    @Override
    public void moveLeft() {
        this.currentState.goLeft();
    }

    @Override
    public void moveRight() {
        this.currentState.goRight();
    }

    @Override
    public void moveUp() {
       this.currentState.goUp();
    }

    @Override
    public void moveDown() {
        this.currentState.goDown();
    }
    
    
    public void addRobotPositionChangeListner(RobotPositionChangeListner listner){
        pcs.addPropertyChangeListener(listner);
    }
    public void removeRobotPositionChangeListner(RobotPositionChangeListner listner){
        pcs.removePropertyChangeListener(listner);
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        if(orientation==1&&x>0&&this.labyrinthe[x-1][y]){x--;}
        if(orientation==3&&x<9&&this.labyrinthe[x+1][y]){x++;}
        if(orientation==4&&y>0&&this.labyrinthe[x][y-1]){y--;}
        if(orientation==2&&y<9&&this.labyrinthe[x][y+1]){y++;}
        
        Point newp = new Point(x,y);
        System.out.println(newp);
        pcs.firePropertyChange("rebot move", null, newp);
        
    }
    @Override
    public void fix() {
       // this.currentState.stayFix();
        
    }
    
    
}
