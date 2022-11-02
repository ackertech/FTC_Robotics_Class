package org.firstinspires.ftc.teamcode.FixIts.Bot_Micro;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Drive Micro - Berkley")

public class MicroBot_TeleOp_Berkley extends OpMode {

    public double speedMultiply = 0.50;


    public MicroBot_Berkley Bot = new MicroBot_Berkley();

    @Override
    public void init() {

        Bot.initRobot(hardwareMap);

    }

    @Override
    public void loop() {

        drive();
        speedControl();
        controlFlag();

    }

    public void speedControl() {
        if (gamepad1.dpad_right ) {
            speedMultiply = 0.25;
        } else if (gamepad1.dpad_down) {
            speedMultiply = 0.50;
        } else if (gamepad1.dpad_left) {
            speedMultiply = 0.75;
        } else if (gamepad1.dpad_up ) {
            speedMultiply = 1.0;
        }
    }

    public void drive() {

        if (gamepad1.left_stick_y > 0.1) {
            Bot.driveForward(speedMultiply * gamepad1.left_stick_y);
        }
        else if (gamepad1.left_stick_y < -0.1){
            Bot.driveBackward(speedMultiply * gamepad1.left_stick_y );
        }
        else if (gamepad1.left_stick_x > 0.1){
            Bot.driveBackward(speedMultiply * gamepad1.left_stick_x);
        }
        else if(gamepad1.left_stick_x <-0.1){
            Bot.rotateLeft(speedMultiply * gamepad1.left_stick_x);
        }
        else{
            Bot.stopMotors();
        }

    }
public void controlFlag() {
        if(gamepad1.right_trigger > 0.01){
            Bot. raiseFlag();
        }
        else if (gamepad1.left_trigger > 0.01) {
            Bot.lowerFlag();
        }
        else Bot.lowerFlag();
}


}
