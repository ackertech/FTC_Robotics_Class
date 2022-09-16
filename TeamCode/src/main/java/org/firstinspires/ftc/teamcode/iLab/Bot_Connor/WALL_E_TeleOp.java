package org.firstinspires.ftc.teamcode.iLab.Bot_Connor;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

//@Disabled
@TeleOp(name = "WALL-E_TeleOp_Connor")
public class WALL_E_TeleOp extends OpMode {

    public double speedMultiply = 0.50;
    public enum Style {
        ONESTICK, TWOSTICK, TANK
    }

    public Style driverStyle = Style.ONESTICK;

    public double leftSidePower;
    public double rightSidePower;


    double leftStickYVal;
    double leftStickXVal;
    double rightStickYVal;
    double rightStickXVal;

    public TankBot_Connor WALL_E = new TankBot_Connor();

    @Override
    public void init () {
        WALL_E.initRobot(hardwareMap);
    }

    public void loop() {
        speedControl();
        drivingStyle();
        drive();

    }

    public void speedControl () {
        if (gamepad1.dpad_right == true) {
            speedMultiply = 0.50;}
        else if (gamepad1.dpad_down == true) {
            speedMultiply = 0.75;}
        else if (gamepad1.dpad_left == true) {
            speedMultiply = 1.00;}
        else if (gamepad1.dpad_up == true){
            speedMultiply = 0.25;}

    }

    public void drive(){
        switch (driverStyle) {
            case ONESTICK:


                leftStickYVal = gamepad1.left_stick_y;
                leftStickYVal = Range.clip(leftStickYVal, -1, 1);

                leftStickXVal = gamepad1.left_stick_x;
                leftStickXVal = Range.clip(leftStickXVal, -1, 1);

                if (leftStickYVal < -0.1) {
                    WALL_E.driveForward(speedMultiply * leftStickYVal);
                } else if (leftStickYVal > 0.1) {
                    WALL_E.driveBackwards(speedMultiply * leftStickYVal);
                } else if (leftStickXVal > 0.1) {
                    WALL_E.rotateRight(speedMultiply * leftStickXVal);
                } else if (leftStickXVal < -0.1) {
                    WALL_E.rotateLeft(speedMultiply * leftStickXVal);
                } else {
                    WALL_E.stopMotors();
                }
                break;

            case TWOSTICK:
                leftStickYVal = gamepad1.left_stick_y;
                leftStickYVal = Range.clip(leftStickYVal, -1, 1);
                leftStickXVal = gamepad1.left_stick_x;
                leftStickXVal = Range.clip(leftStickXVal, -1, 1);
                rightStickYVal = gamepad1.right_stick_y;
                rightStickYVal = Range.clip(rightStickYVal, -1, 1);
                rightStickXVal = gamepad1.right_stick_x;
                rightStickXVal = Range.clip(rightStickXVal, -1, 1);

                if (leftStickYVal < -0.1) {
                    WALL_E.driveForward(speedMultiply*leftStickYVal);
                }
                else if (leftStickYVal > 0.1){
                    WALL_E.driveBackwards(speedMultiply*leftStickYVal);
                }

                else if (rightStickXVal > 0.1) {
                    WALL_E.rotateRight(speedMultiply*rightStickXVal);
                }

                else if (rightStickXVal < -0.1) {
                    WALL_E.rotateLeft(speedMultiply*rightStickXVal);
                }
                else {
                    WALL_E.stopMotors();
                }
                break;


            case TANK:
                leftStickYVal = gamepad1.left_stick_y;
                leftStickYVal = Range.clip(leftStickYVal, -1, 1);

                rightStickYVal = gamepad1.right_stick_y;
                rightStickYVal = Range.clip(rightStickYVal, -1, 1);

                leftSidePower = speedMultiply * leftStickYVal * (-1);
                rightSidePower = speedMultiply * rightStickYVal * (-1);
                WALL_E.tankDrive(leftSidePower, rightSidePower);
                break;



        }
    }

    public void drivingStyle () {

        if (gamepad1.x) {
            driverStyle = WALL_E_TeleOp.Style.ONESTICK;

        }
        if (gamepad1.b)
        { driverStyle = WALL_E_TeleOp.Style.TANK;

        }

        if (gamepad1.y)
        { driverStyle = WALL_E_TeleOp.Style.TWOSTICK;}


    }


}
