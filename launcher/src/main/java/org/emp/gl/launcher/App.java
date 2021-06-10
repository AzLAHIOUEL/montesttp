package org.emp.gl.launcher;

import org.emp.gl.action.Action;
import org.emp.gl.gui.LabyrintheGraphique;
import org.emp.gl.lookup.Lookup;
import org.emp.gl.rebot.Robot;
import org.emp.gl.timer.service.TimerChangeListner;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.impl.TimerServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        TimerServiceImpl ts = new TimerServiceImpl();
        Robot robot = new Robot();
        Lookup.getInstance().register(Action.class, robot);
        ts.addTimerChangeListner(robot);
        
        
        LabyrintheGraphique painter = new LabyrintheGraphique();
        Lookup.getInstance().register(LabyrintheGraphique.class, painter);
        robot.addRobotPositionChangeListner(painter);
        
        
        
        
    }
}