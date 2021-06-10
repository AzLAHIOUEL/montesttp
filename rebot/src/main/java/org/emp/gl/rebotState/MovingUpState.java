package org.emp.gl.rebotState;

import org.emp.gl.rebot.Robot;

public class MovingUpState extends RobotState{
    
    public MovingUpState(Robot robot) {
        super(robot);
    }
    
    
    
        
    @Override
    public void goLeft(){
        this.robot.orientation=4;
        this.robot.setState(new MovingLeftState(robot));
    }
    
    @Override
    public void goRight(){
        this.robot.orientation=2;
        this.robot.setState(new MovingRightState(robot));
    }
    
    
   
    
    
}
