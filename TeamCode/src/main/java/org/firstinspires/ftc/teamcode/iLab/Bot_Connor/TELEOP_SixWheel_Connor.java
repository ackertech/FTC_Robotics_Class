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


  public SixWheelBot_Connor sixWheelBot = new SixWheelBot_Connor();


    @Override
    public void init () {

        sixWheelBot.initRobot(hardwareMap);


    }


    public void loop() {
        drive();
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
}
