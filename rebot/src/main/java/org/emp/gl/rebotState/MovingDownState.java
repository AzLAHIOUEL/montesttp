package org.emp.gl.rebotState;

import org.emp.gl.rebot.Robot;

public class MovingDownState extends RobotState{
    
    public MovingDownState(Robot robot) {
        super(robot);
    }
    
    
    @Override
    public void goLeft(){
        this.robot.setState(new MovingLeftState(robot));
    }
    
    @Override
    public void goRight(){
        this.robot.setState(new MovingRightState(robot));
    }
    
    
    @Override
    public void stayFix(){
        this.robot.setState(new StayingFixState(robot,3));
    }
    @Override
    public void move(){
        robot.y=robot.y+1;
        
    }
    
    
    
    
}
