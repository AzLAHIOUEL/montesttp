package org.emp.gl.timer.service.impl;

import java.beans.PropertyChangeSupport;
import java.util.Timer;
import java.util.TimerTask;

import org.emp.gl.timer.service.TimerChangeListner;
import org.emp.gl.timer.service.TimerService;

public class TimerServiceImpl extends TimerTask implements TimerService {
    PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    
    
    public TimerServiceImpl(){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(this, 0, 1000);
    }
    
    public void addTimerChangeListner(TimerChangeListner listner){
        
        pcs.addPropertyChangeListener(listner);
        System.out.println(listner);
    }
    public void removeTimerChangeListner(TimerChangeListner listner){
        pcs.removePropertyChangeListener(listner);
    }
    @Override
    public void oneSecond() {
        
        pcs.firePropertyChange("oneSeconde", null, null);
    }
    

    @Override
    public void run() {
        
     oneSecond();   
    }

    
    
}
