package org.firstinspires.ftc.teamcode.FixIts.Bot_Bob;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "BobBot: AnneMarie")
public class Bob_TeleOp_AnneMarie extends OpMode {

public double speedMuiltiply= 0.50;

public Bob_AnneMarie Bot = new Bob_AnneMarie();


    public void init (){

    Bot.initRobot(hardwareMap);
    }

    
    public void loop (){
    drive();
    speedControl();
    }

public void speedControl() {;
    if (gamepad1.dpad_right){
        speedMuiltiply = 0.25;
    }
    else if (gamepad1.dpad_down){
    speedMuiltiply = 0.50;
}
    else if (gamepad1.dpad_left){
        speedMuiltiply = 0.75;
        }
    else if (gamepad1.dpad_up){
        speedMuiltiply = 1.0;
    }
}
public void drive(){
    if (gamepad1.left_stick_y > 0.1){Bot.driveForward(speedMuiltiply * gamepad1.left_stick_y);
    }
    else if(gamepad1.left_stick_y> -0.1){
        Bot.driveBackward(speedMuiltiply * gamepad1.left_stick_y);
      }
else if (gamepad1.left_stick_x > 0.1){
    Bot.rotateRight(speedMuiltiply * gamepad1.left_stick_x);
    }
    else if (gamepad1.left_stick_x > -0.1){
        Bot.rotateRight(speedMuiltiply * gamepad1.left_stick_x);
    }
    else{
        Bot.stopMotors();
    }
}

}

