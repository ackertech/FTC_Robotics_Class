package org.firstinspires.ftc.teamcode.FixIts.Bot_Roadkill;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp(name = "RoadKillCampbell")
public class RoadKill_TeleOp_Campbell extends OpMode {

public double speedMultiply = 0.50;
 public RoadKill_Campbell bot = new RoadKill_Campbell();

 @Override
 public void init() {
     bot.initRobot(hardwareMap);
 }
 @Override
 public void loop () {

     drive();
     speedControl();

 }

    public void speedControl() {
        if (gamepad1.dpad_right) {
            speedMultiply = 0.25;
        } else if (gamepad1.dpad_down) {
            speedMultiply = 0.50;
        } else if (gamepad1.dpad_left) {
            speedMultiply = 0.75;
        } else if (gamepad1.dpad_up) {
            speedMultiply = 1.0;
        }
    }
    public void drive() {
     if (gamepad1.left_stick_y > 0.1) {
         bot.driveForward(speedMultiply * gamepad1.left_stick_y);
     }
     else if(gamepad1.left_stick_y < -0.1) {
         bot.driveBackward(speedMultiply * gamepad1.left_stick_y);
     }
     else if(gamepad1.left_stick_x < 0.1) {
         bot.rotateRight(speedMultiply * gamepad1.left_stick_x);
     }
     else if(gamepad1.left_stick_x > -0.1) {
         bot.rotateLeft(speedMultiply * gamepad1.left_stick_x);
     }
     else {
         bot.stopMotors();
     }

    }





}
