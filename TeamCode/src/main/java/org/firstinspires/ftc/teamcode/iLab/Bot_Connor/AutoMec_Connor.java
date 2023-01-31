package org.firstinspires.ftc.teamcode.iLab.Bot_Connor;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous (name = "Connor_MechBotAuto")

public class AutoMec_Connor extends LinearOpMode {

    CompetitionBot FixitsBot = new CompetitionBot();

    @Override
    public void runOpMode() throws InterruptedException {

        FixitsBot.initRobot(hardwareMap);
        FixitsBot.setLinearOp(this);



        telemetry.addLine("Robot Awaiting Start Procedure");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            telemetryUpdate("Drive Forward");
            FixitsBot.driveForward(1,2);
            sleep(1000);

            telemetryUpdate("Drive Back");
            FixitsBot.driveBack(1,2);
            sleep(1000);

            telemetryUpdate("Strafe Left");
            FixitsBot.strafeLeft(1,2);
            sleep(1000);

            telemetryUpdate("Strafe Right");
            FixitsBot.strafeRight(1,2);
            sleep(1000);

            telemetryUpdate("Rotate Left");
            FixitsBot.rotateLeft(1,1);
            sleep(1000);

            telemetryUpdate("Rotate Right");
            FixitsBot.rotateRight(1,1);
            sleep(5000);

            requestOpModeStop();
        }

        idle();
    }



    public void telemetryUpdate(String comment) {
        telemetry.addLine("LONG LIVE TACO");
        telemetry.addLine(comment);
        telemetry.addData("Front Lef Motor:", FixitsBot.frontLeftMotor.getPower());
        telemetry.addData("Front Rig Motor:", FixitsBot.frontRightMotor.getPower());
        telemetry.addData("Rear Lef Motor:", FixitsBot.rearLeftMotor.getPower());
        telemetry.addData("Rear Rig Motor:", FixitsBot.rearRightMotor.getPower());
        telemetry.addData("Encoder Count: ", FixitsBot.frontLeftMotor.getCurrentPosition());
        telemetry.update();
    }


}
