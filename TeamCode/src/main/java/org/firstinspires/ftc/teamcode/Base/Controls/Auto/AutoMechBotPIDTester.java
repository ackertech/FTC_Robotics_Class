package org.firstinspires.ftc.teamcode.Base.Controls.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Base.Robot.MechBot;

//@Disabled
@Autonomous(name = "MechBot PID Tester")

public class AutoMechBotPIDTester extends LinearOpMode {

    MechBot Bot = new MechBot();

    @Override
    public void runOpMode() throws InterruptedException {

        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);

        telemetry.addLine("Awaiting Start");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()){

            updateTelemetry("Driving Forward with PID Control");
            sleep(1000);
            Bot.driveForwardPID(8,0.70,.0,.30);
            //updateTelemetry("Finished");
            sleep(3000);

            requestOpModeStop();

        }

        idle();

    }

    public void updateTelemetry(String comment) {
        telemetry.addLine(comment);
        telemetry.addData("Front Lef Motor: ", Bot.frontLeftMotor.getPower());
        telemetry.addData("Encoder Counts: ", Bot.frontLeftMotor.getCurrentPosition());
        telemetry.update();
    }

}
