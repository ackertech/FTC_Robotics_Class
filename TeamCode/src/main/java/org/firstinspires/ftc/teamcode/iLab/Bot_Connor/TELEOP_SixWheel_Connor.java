package org.firstinspires.ftc.teamcode.iLab.Bot_Connor;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;
@TeleOp (name = "SixWheelTeleOp_Connor")
public class TELEOP_SixWheel_Connor extends OpMode {

    double leftStickYVal;
    double leftStickXVal;
    double rightStickXVal;
    double rightStickYVal;

    double frontLeftSpeed;
    double frontRightSpeed;
    double rearLeftSpeed;
    double rearRightSpeed;

    double powerThreshold = 0;
    double speedMultiply = 1;

    public double leftSidePower;
    public double rightSidePower;
    public enum DrivingMode {ONESTICK, TANK}
    public DrivingMode drivingMode = DrivingMode.ONESTICK;

  public SixWheelBot_Connor sixWheelBot = new SixWheelBot_Connor();


    @Override
    public void init () {

        sixWheelBot.initRobot(hardwareMap);


    }


    public void loop() {
        speedControl();
        drivingMode();
        drive();
    }


    public void speedControl () {
        if (gamepad1.dpad_right == true) {
            speedMultiply = 0.50;}
        else if (gamepad1.dpad_down == true) {
            speedMultiply = 0.60;}
        else if (gamepad1.dpad_left == true) {
            speedMultiply = 0.75;}
        else if (gamepad1.dpad_up == true){
            speedMultiply = 0.25;}
        else if (gamepad1.a == true){
            speedMultiply = 1.00;}
    }


    public void drive() {




      leftStickYVal = gamepad1.left_stick_y;
      leftStickYVal = Range.clip(leftStickYVal, -1, 1);

      rightStickYVal = gamepad1.right_stick_y;
      rightStickYVal = Range.clip(rightStickYVal, -1, 1);

      leftSidePower = speedMultiply * leftStickYVal * (-1);
      rightSidePower = speedMultiply * rightStickYVal * (-1);
      sixWheelBot.tankDrive(leftSidePower, rightSidePower);
  }

  public void drivingMode() {

        if (gamepad1.a) {
            drivingMode = DrivingMode.ONESTICK;
        }

        else if (gamepad1.b) {
            drivingMode= DrivingMode.TANK;
        }
  }
}
