package org.emp.gl.rebotState;

import org.emp.gl.rebot.Robot;

public class MovingLeftState extends RobotState {
    
    public MovingLeftState(Robot robot) {
        super(robot);
    }
    
    
    @Override
    public void goUp(){
        this.robot.orientation=1;
        this.robot.setState(new MovingUpState(robot));
    }
    
    @Override
    public void goDown(){
        this.robot.orientation=3;
        this.robot.setState(new MovingDownState(robot));
    }
    
    
    
    
    
    @Override
    public void move(){
        
    }
    
}
