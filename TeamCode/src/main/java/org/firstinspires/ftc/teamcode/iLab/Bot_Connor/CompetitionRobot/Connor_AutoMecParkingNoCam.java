package org.firstinspires.ftc.teamcode.iLab.Bot_Connor.CompetitionRobot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous (name = "Connor_AutoParkingNoCam")

public class Connor_AutoMecParkingNoCam extends LinearOpMode {

    CompetitionBot FixitsBot = new CompetitionBot();

    public enum ParkingPosition {
        RIGHT,
        CENTER,
        LEFT,
        IDLE
    }

   public ParkingPosition parkingPosition = ParkingPosition.LEFT;


    @Override
    public void runOpMode() throws InterruptedException {

        FixitsBot.initRobot(hardwareMap);
        FixitsBot.setLinearOp(this);


        telemetry.addLine("Robot Awaiting Start Procedure");
        telemetry.update();

        waitForStart();


        while (opModeIsActive()) {


            if (parkingPosition == ParkingPosition.RIGHT) {

                telemetryUpdate("Park Right");
                FixitsBot.driveForward(1, 7.8);
                sleep(1000);
            }

            else if (parkingPosition == ParkingPosition.CENTER) {

                telemetryUpdate("Park Center");
                FixitsBot.driveForward(1,7.8);
                sleep(1000);
                FixitsBot.strafeLeft(1,6.6);
                sleep(1000);
            }

            else if (parkingPosition == ParkingPosition.LEFT) {

                telemetryUpdate("Park Left");
                FixitsBot.driveForward(1,7.8);
                sleep(1000);
                FixitsBot.strafeLeft(1,9.9);
                sleep(1000);
            }

            else {
                telemetryUpdate("Cannot Park");
                parkingPosition = ParkingPosition.IDLE;
            }


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
