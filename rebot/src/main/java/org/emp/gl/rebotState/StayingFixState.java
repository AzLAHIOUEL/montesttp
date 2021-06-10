package org.emp.gl.rebotState;

import org.emp.gl.rebot.Robot;
public class StayingFixState extends RobotState{
    int oldstate;
    public StayingFixState(Robot robot,int oldstate) {
        super(robot);
        this.oldstate=oldstate;
        System.out.println("fix");
    }
    
    @Override
    public void goLeft(){
        if(oldstate!=4)
        this.robot.setState(new MovingLeftState(robot));
        System.out.println("left");
    }
    
    @Override
    public void goRight(){
        if(oldstate!=2)
        this.robot.setState(new MovingRightState(robot));
        System.out.println("right");
    }
      @Override
    public void goUp(){
        if(oldstate==1){
            return;
        }else{
        this.robot.setState(new MovingUpState(robot));
        System.out.println("up");
    }
    }
    
    @Override
    public void goDown(){
        if(oldstate!=3)
        this.robot.setState(new MovingDownState(robot));
        System.out.println("down");
    }
    
    @Override
    public void stayFix(){
        this.robot.setState(new StayingFixState(robot,0));
    }
    
    @Override
    public void move(){
       
        this.stayFix();
    }
    
}
