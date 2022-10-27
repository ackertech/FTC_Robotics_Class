package org.firstinspires.ftc.teamcode.iLab.Bot_Connor.CandyLaunchingBot;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.checkerframework.checker.units.qual.C;
import org.firstinspires.ftc.teamcode.Base.Robot.AckerBot;
import org.firstinspires.ftc.teamcode.iLab.Bot_Connor.Tank_TeleOp_Connor;
import org.firstinspires.ftc.teamcode.iLab.Bot_Connor.The_Mighty_and_All_Powerful_Hand;

@TeleOp(name = "CandyLaunchingBotJohnCena_Connor")

public class CandyLaunchingBotTeleOp_Connor extends OpMode{

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
    boolean reverseModeToggle = false;

    public ElapsedTime TeleOpTime = new ElapsedTime();

    public enum ArmControl {AUTO, MANUAL}
    public Tank_TeleOp_Connor.ArmControl armControl = Tank_TeleOp_Connor.ArmControl.MANUAL;

    public enum LazySusanControl {AUTO, MANUAL}
    public Tank_TeleOp_Connor.LazySusanControl lazySusanControl = Tank_TeleOp_Connor.LazySusanControl.MANUAL;
    public enum LazySusanEncoder {FORWARD, REVERSE, OFF}
    public Tank_TeleOp_Connor.LazySusanEncoder lazySusanEncoder = Tank_TeleOp_Connor.LazySusanEncoder.OFF;
    public double lazySusanTicks = 5000;
    public double lazySusanPower = 0.90;


    public CandyLaunchingBot_Connor CandyBot = new CandyLaunchingBot_Connor();
    public The_Mighty_and_All_Powerful_Hand Hand = new The_Mighty_and_All_Powerful_Hand();

    @Override
    public void init() {
        CandyBot.initRobot(hardwareMap);
    }

    @Override
    public void init_loop() { }

    @Override
    public void start() { }

    @Override
    public void loop() {}


    @Override
    public void stop() {

    }

    public void telemetryOutput() {
        telemetry.addLine("Rick Astley is never gonna give you up");
        telemetry.addData("LED", "TeleOp Time: " + CandyBot.currentTime);
        telemetry.addData("LED", "LED Timer: " + CandyBot.ledTimer);
        telemetry.addData("LED", "LED Counter: " + CandyBot.ledCounter);
        telemetry.addData("LED", "LED Pattern: " + CandyBot.ledPattern);
        telemetry.addData("LED", "LED Pattern: " + CandyBot.ledLights);
        telemetry.addData("pwr", "FL mtr: " + frontLeftSpeed);
        telemetry.addData("pwr", "FR mtr: " + frontRightSpeed);
        telemetry.addData("pwr", "RL mtr: " + rearLeftSpeed);
        telemetry.addData("pwr", "RR mtr: " + rearRightSpeed);
        telemetry.addData("Left joystick Y (gp2): ", gamepad2.left_stick_y);
        telemetry.addData("Right joystick Y (gp2): ", gamepad2.right_stick_y);
        telemetry.update();

    }

    public void controlLauncher() {
        if(gamepad1.right_trigger > 0.1) {
            CandyBot.runLauncher(1.0);
        }
        if (gamepad1.left_trigger > 0.1) {
            CandyBot.stopLauncher();
        }
        if (gamepad1.left_bumper) {
            CandyBot.openCandyDoor();
        }
        if(gamepad1.right_bumper) {
            CandyBot.closeCandyDoor();
        }
    }


    public void controlCamPivot() {

        if(gamepad2.left_bumper) {
            CandyBot.camLeft();
        }
        else if(gamepad2.right_bumper) {
            CandyBot.camRight();
        }
        else  {
            CandyBot.camCenter();
        }
    }


    public void handControl() {
        if (gamepad1.dpad_up) {
            Hand.raiseArm();
        }


    }


    public void lazySusanControl() {
        if (gamepad2.x) {
            if (lazySusanControl == lazySusanControl.MANUAL) {
                lazySusanControl = lazySusanControl.AUTO;
            }

            else  {
                lazySusanControl = lazySusanControl.MANUAL;
            }
        }

        if (lazySusanControl == lazySusanControl.MANUAL) {
            if (gamepad2.right_stick_x > 0.1) {
                CandyBot.lazySusanLeft(lazySusanPower);
            }

            else if (gamepad2.right_stick_x < -0.1) {
                CandyBot.lazySusanRight(lazySusanPower);
            }

            else{
                CandyBot.lazySusanStop();
            }
        }

        else if (lazySusanControl == lazySusanControl.AUTO) {
            if (gamepad2.left_bumper) {
                lazySusanEncoder = lazySusanEncoder.FORWARD;
                CandyBot.lazy_Susan.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                CandyBot.lazy_Susan.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            }

            if (gamepad2.right_bumper) {
                lazySusanEncoder = lazySusanEncoder.REVERSE;
                CandyBot.lazy_Susan.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                CandyBot.lazy_Susan.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            }

            if (lazySusanEncoder == lazySusanEncoder.FORWARD) {
                if (Math.abs(CandyBot.lazy_Susan.getCurrentPosition()) < lazySusanTicks ){
                    CandyBot.lazy_Susan.setPower(lazySusanPower);
                }
                else {
                    CandyBot.lazy_Susan.setPower(0);
                }
            }

            else if (lazySusanEncoder == lazySusanEncoder.REVERSE) {
                if (Math.abs(CandyBot.lazy_Susan.getCurrentPosition()) < lazySusanTicks ) {
                    CandyBot.lazy_Susan.setPower(-lazySusanPower);
                }
                else {
                    CandyBot.lazy_Susan.setPower(0);
                }
            }

        }
    }


}



