package org.firstinspires.ftc.teamcode.iLab.Bot_Connor.CompetitionRobot;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.iLab.Bot_Connor.Tank_TeleOp_Connor;

@TeleOp (name = "CompetitionTeleOp_Connor")

public class Connor_CompetitionTeleop extends OpMode {




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
    public ElapsedTime TeleOpTime = new ElapsedTime();
    public enum ControlOfLinearSlide {GROUND, LOW, MIDDLE, HIGH}
    public ControlOfLinearSlide controlOfLinearSlide = ControlOfLinearSlide.GROUND;
    public enum ControlOfCompClaw {OPEN, CLOSED}
    public ControlOfCompClaw controlOfCompClaw = ControlOfCompClaw.OPEN;
    public double linearSlideTicks = 350; //537.6
    public double linearSlideMidTicks = 250;
    public double linearSlideLowTicks = 150;
    public double linearSlidePower = 1;

    public enum LazySusanEncoder {FORWARD, REVERSE, OFF}
    public LazySusanEncoder lazySusanEncoder = LazySusanEncoder.OFF;
    public double lazySusanTicks = 5000;
    public double lazySusanPower = 0.90;




    public CompetitionBot CompBot = new CompetitionBot();


    @Override
    public void init() {
        CompBot.initRobot(hardwareMap);
        CompBot.claw.setPosition(0);
    }


    @Override
    public void init_loop() {  }

    @Override
    public void start() {

    }
    @Override
    public void loop(){
        clawControl();
        linearSlideControl();
        mannualLinearSlideControl();
        lazySusanControl();
        drive();
        speedControl();
        telemetryOutput();

    }

    @Override
    public void stop() {  }

    public void drive() {

        leftStickYVal = gamepad1.left_stick_y;
        leftStickYVal = Range.clip(leftStickYVal, -1, 1);
        leftStickXVal = -gamepad1.left_stick_x;
        leftStickXVal = Range.clip(leftStickXVal, -1, 1);
        rightStickXVal = -gamepad1.right_stick_x;
        rightStickXVal = Range.clip(rightStickXVal, -1, 1);

        frontLeftSpeed = leftStickYVal + leftStickXVal + rightStickXVal;
        frontLeftSpeed = Range.clip(frontLeftSpeed, -1, 1);

        frontRightSpeed = leftStickYVal - leftStickXVal - rightStickXVal;
        frontRightSpeed = Range.clip(frontRightSpeed, -1, 1);

        rearLeftSpeed = leftStickYVal - leftStickXVal + rightStickXVal;
        rearLeftSpeed = Range.clip(rearLeftSpeed, -1, 1);

        rearRightSpeed = leftStickYVal + leftStickXVal - rightStickXVal;
        rearRightSpeed = Range.clip(rearRightSpeed, -1, 1);

        if (frontLeftSpeed <= powerThreshold && frontLeftSpeed >= -powerThreshold) {
            frontLeftSpeed = 0;
            CompBot.frontLeftMotor.setPower(frontLeftSpeed);
        } else {
            CompBot.frontLeftMotor.setPower(frontLeftSpeed * speedMultiply);
        }

        if (frontRightSpeed <= powerThreshold && frontRightSpeed >= -powerThreshold){
            frontRightSpeed = 0;
            CompBot.frontRightMotor.setPower(frontRightSpeed);
        } else {
            CompBot.frontRightMotor.setPower(frontRightSpeed * speedMultiply);
        }

        if (rearLeftSpeed <= powerThreshold && rearLeftSpeed >= -powerThreshold) {
            rearLeftSpeed = 0;
            CompBot.rearLeftMotor.setPower(rearLeftSpeed);
        } else {
            CompBot.rearLeftMotor.setPower(rearLeftSpeed * speedMultiply);
        }

        if (rearRightSpeed <= powerThreshold && rearRightSpeed >= -powerThreshold){
            rearRightSpeed = 0;
            CompBot.rearRightMotor.setPower(rearRightSpeed);
        } else {
            CompBot.rearRightMotor.setPower(rearRightSpeed * speedMultiply);
        }
    }


    public void clawControl(){

        if (gamepad2.right_trigger > 0.1) {
            CompBot.claw.setPosition(0);
        }

        if (gamepad2.left_trigger > 0.1) {
            CompBot.claw.setPosition(.5);
        }
    }







    public void linearSlideControl() {
        if (gamepad2.dpad_up)  {
            controlOfLinearSlide = controlOfLinearSlide.GROUND;
            CompBot.linearSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            CompBot.linearSlide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        if (gamepad2.dpad_right) {
            controlOfLinearSlide = controlOfLinearSlide.LOW;
            CompBot.linearSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            CompBot.linearSlide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        if (gamepad2.dpad_down) {
            controlOfLinearSlide = controlOfLinearSlide.MIDDLE;
            CompBot.linearSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            CompBot.linearSlide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        if (gamepad2.dpad_left) {
            controlOfLinearSlide = controlOfLinearSlide.HIGH;
            CompBot.linearSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            CompBot.linearSlide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        if (controlOfLinearSlide == controlOfLinearSlide.HIGH) {
            if (Math.abs(CompBot.linearSlide.getCurrentPosition()) < linearSlideTicks) {
                CompBot.linearSlide.setPower(linearSlidePower);
            }
            else{
                CompBot.linearSlide.setPower(0);
            }

        }

       else if (controlOfLinearSlide == controlOfLinearSlide.MIDDLE) {
            if (Math.abs(CompBot.linearSlide.getCurrentPosition()) < linearSlideMidTicks) {
                CompBot.linearSlide.setPower(linearSlidePower);
            }
            else{
                CompBot.linearSlide.setPower(0);
            }

        }

       else if (controlOfLinearSlide == controlOfLinearSlide.LOW) {
            if (Math.abs(CompBot.linearSlide.getCurrentPosition()) < linearSlideLowTicks) {
                CompBot.linearSlide.setPower(linearSlidePower);
            }
            else{
                CompBot.linearSlide.setPower(0);
            }

        }

      else  if (controlOfLinearSlide == controlOfLinearSlide.GROUND) {
                CompBot.linearSlide.setPower(0);
         }


    }

    public void  mannualLinearSlideControl() {
        leftStickYVal = gamepad2.left_stick_y;
        leftStickYVal = Range.clip(leftStickYVal, -1, 1);

        if (leftStickYVal > 0.1) {
            CompBot.linearSlideUp(linearSlidePower);
        }

        else if (leftStickYVal < -0.1) {
            CompBot.linearSlideDown(linearSlidePower);
        }

        else {
            CompBot.linearSlideStop();
        }
    }



public void lazySusanControl(){
    if (gamepad2.left_bumper) {
        lazySusanEncoder = lazySusanEncoder.FORWARD;
        CompBot.lazy_Susan.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        CompBot.lazy_Susan.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    if (gamepad2.right_bumper) {
        lazySusanEncoder = lazySusanEncoder.REVERSE;
        CompBot.lazy_Susan.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        CompBot.lazy_Susan.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    if (lazySusanEncoder == lazySusanEncoder.FORWARD) {
        if (Math.abs(CompBot.lazy_Susan.getCurrentPosition()) < lazySusanTicks ){
            CompBot.lazy_Susan.setPower(lazySusanPower);
        }
        else {
            CompBot.lazy_Susan.setPower(0);
        }
    }

    else if (lazySusanEncoder == lazySusanEncoder.REVERSE) {
        if (Math.abs(CompBot.lazy_Susan.getCurrentPosition()) < lazySusanTicks ) {
            CompBot.lazy_Susan.setPower(-lazySusanPower);
        }
        else {
            CompBot.lazy_Susan.setPower(0);
        }
    }

    if (gamepad2.right_stick_x > 0.1) {
        CompBot.lazySusanLeft(lazySusanPower);
    }

    else if (gamepad2.right_stick_x < -0.1) {
        CompBot.lazySusanRight(lazySusanPower);
    }

    else{
        CompBot.lazySusanStop();
    }
}



    public void telemetryOutput() {

        telemetry.addLine("LONG LIVE TACO");
        telemetry.addData("pwr", "FL mtr: " + frontLeftSpeed);
        telemetry.addData("pwr", "FR mtr: " + frontRightSpeed);
        telemetry.addData("pwr", "RL mtr: " + rearLeftSpeed);
        telemetry.addData("pwr", "RR mtr: " + rearRightSpeed);
        telemetry.addData("linSLide", "hi",CompBot.linearSlide.getCurrentPosition());
        if (controlOfLinearSlide == ControlOfLinearSlide.HIGH) {
            telemetry.addLine("Linear Slide Position - HIGH");
        }
       else if (controlOfLinearSlide == ControlOfLinearSlide.MIDDLE) {
            telemetry.addLine("Linear Slide Position - MIDDLE");
        }
       else if (controlOfLinearSlide == ControlOfLinearSlide.LOW) {
            telemetry.addLine("Linear Slide Position - LOW");
        }
       else if (controlOfLinearSlide == ControlOfLinearSlide.GROUND) {
            telemetry.addLine("Linear Slide Position - GROUND");
        }
        telemetry.update();
    }

    public void speedControl() {

        if (gamepad1.dpad_up) {
            speedMultiply = 0.5;
        }

       else if (gamepad1.dpad_down) {
           speedMultiply = 1;
        }
    }



}













