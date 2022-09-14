package org.firstinspires.ftc.teamcode.FixIts.Bot_Johntavious;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


//@Disabled
@Autonomous (name = "Johntavious:Nick")

public class AutonomousJohntavious_Nick extends LinearOpMode {

    Johntavious_Nick Bot = new Johntavious_Nick();

    @Override


    public void runOpMode() throws InterruptedException {

        Bot.initRobot(hardwareMap);

        telemetry.addLine("Awaiting Start");
        telemetry.update();

        waitForStart();


        while (opModeIsActive()) {

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(1);
            sleep(1000);

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(0.5);
            sleep(1000);

            telemetry.addLine("Turning Right");
            telemetry.update();
            Bot.rotateLeft(0.5);
            sleep(500);

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(1);
            sleep(800);

            telemetry.addLine("Turning Right");
            telemetry.update();
            Bot.rotateLeft(0.5);
            sleep(500);

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(1);
            sleep(800);

            telemetry.addLine("Turning Right");
            telemetry.update();
            Bot.rotateLeft(0.5);
            sleep(500);

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(1);
            sleep(800);

            telemetry.addLine("Turning Left");
            telemetry.update();
            Bot.rotateRight(0.5);
            sleep(500);

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(1);
            sleep(800);

            requestOpModeStop();
        }

        idle();
    }


}


