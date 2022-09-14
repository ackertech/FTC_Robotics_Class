package org.firstinspires.ftc.teamcode.FixIts.Bot_Gregory;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Gregory_Matthew", group = "Bot_Gregory")

public class TeleOpGregory_Matthew extends OpMode {

    public double speedMultiply = 0.50;

    public Gregory_Matthew Bot = new Gregory_Matthew();

    @Override
    public void init() {

        Bot.initRobot(hardwareMap);
        Bot.lowerFlag();
    }

    public void loop () {

        drive();
        speedControl();
        flagControl();
        ledControl();
    }

    public void drive() {

        if (gamepad1.left_stick_y < -.1) {

            Bot.driveForward(speedMultiply * gamepad1.left_stick_y);
        } else if (gamepad1.left_stick_y > .1) {

            Bot.driveBackward(speedMultiply * gamepad1.left_stick_y);
        } else if (gamepad1.left_stick_x > .1) {

            Bot.rotateRight(speedMultiply * gamepad1.left_stick_x);
        } else if (gamepad1.left_stick_x < -.1) {

            Bot.rotateLeft(speedMultiply * gamepad1.left_stick_x);
        } else {

            Bot.stopMotors();
        }
    }
    public void speedControl() {

        if (gamepad1.dpad_right) {
            speedMultiply = 0.25;
        }
        else if (gamepad1.dpad_down) {
            speedMultiply = 0.50;
        }
        else if (gamepad1.dpad_left) {
            speedMultiply = 0.75;
        }
        else if (gamepad1.dpad_up) {
            speedMultiply = 1.0;
        }
    }

    public void flagControl() {
        if (gamepad1.y) {
            Bot.raiseFlag();
        }
        else if (gamepad1.a) {
            Bot.lowerFlag();
        }
        else if (gamepad1.b) {
            Bot.waveFlagRight();
        }
        else if (gamepad1.x) {
            Bot.waveFlagLeft();
        }
    }

    public void ledControl () {

        if (gamepad1.left_trigger > 0.1) {
            Bot.setLedPattern(RevBlinkinLedDriver.BlinkinPattern.GREEN);
        }
        else if (gamepad1.right_trigger > 0.1) {
            Bot.setLedPattern(RevBlinkinLedDriver.BlinkinPattern.RED);
        }
        else if (gamepad1.left_bumper == true) {
            Bot.setLedPattern(RevBlinkinLedDriver.BlinkinPattern.BEATS_PER_MINUTE_FOREST_PALETTE);
        }
        else if (gamepad1.right_bumper == true) {
            Bot.setLedPattern(RevBlinkinLedDriver.BlinkinPattern.COLOR_WAVES_LAVA_PALETTE);
        }

    }




}

