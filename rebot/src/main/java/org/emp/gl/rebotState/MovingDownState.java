package org.emp.gl.rebotState;

import org.emp.gl.rebot.Robot;

public class MovingDownState extends RobotState{

    public MovingDownState(Robot robot) {
        super(robot);
        //TODO Auto-generated constructor stub
    }
    @Override
    public void goLeft(){
        this.robot.orientation=4;
        System.out.println(this.robot.orientation);
        this.robot.setState(new MovingLeftState(robot));
    }
    

    @Override
    public void goRight(){
        this.robot.orientation=2;
        System.out.println(this.robot.orientation);
       this.robot.setState(new MovingRightState(robot));
    }

}
