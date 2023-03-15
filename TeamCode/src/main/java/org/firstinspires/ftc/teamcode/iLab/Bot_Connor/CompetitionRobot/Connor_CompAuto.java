package org.firstinspires.ftc.teamcode.iLab.Bot_Connor.CompetitionRobot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Base.Sensors.TagSleeveDetection;
import org.openftc.easyopencv.OpenCvCamera;

public class Connor_CompAuto extends Connor_AutoMain {

    CompetitionBot FixitsBot = new CompetitionBot();

    public ParkingPosition_Connor parkPosition = ParkingPosition_Connor.NONE;

    @Override
    public void runOpMode() throws InterruptedException {
        FixitsBot.initRobot(hardwareMap);
        FixitsBot.setLinearOp(this);
        initPipeline();


        telemetry.addLine("Robot Awaiting Start Procedure");
        telemetry.update();

        while (!isStarted() && !isStopRequested()) {
            findTag();
            sleep(500);
            findTag();
            sleep(500);
            findTag();
            sleep(500);
            camera.closeCameraDevice();
        }

        waitForStart();

        while (opModeIsActive()) {

            FixitsBot.gyroReset();



            if (parkPosition == ParkingPosition_Connor.RIGHT) {

                telemetryUpdate("Park Right");
                FixitsBot.driveForward(1, 7.25);
                sleep(200);
                FixitsBot.gyroCorrection(.5,-45);
                sleep(200);
                FixitsBot.strafeRight(1,4);
                sleep(200);
                FixitsBot.gyroCorrection(.5,-45);
                sleep(200);
            }
            else if (parkPosition == ParkingPosition_Connor.MIDDLE) {

                telemetryUpdate("Park Center");
                FixitsBot.driveForward(1,7.4);
                sleep(200);
                FixitsBot.gyroCorrection(.5,0);
                sleep(200);
            }

            else if (parkPosition == ParkingPosition_Connor.LEFT) {

                telemetryUpdate("Park Left");
                FixitsBot.driveForward(1,7.4);
                sleep(200);
                FixitsBot.gyroCorrection(.5,-45);
                sleep(200);
                FixitsBot.strafeLeft(1,4);
                sleep(200);
                FixitsBot.gyroCorrection(.5,-45);
                sleep(200);
            }

            else if (parkPosition == ParkingPosition_Connor.NONE){
                telemetryUpdate("Cannot Park - Park Position = NONE");

            }






        }
        requestOpModeStop();

        idle();
    }

    public void telemetryUpdate(String comment) {
        telemetry.addLine(comment);
        parkingTelemetry();
        telemetry.addData("Front Lef Motor:", FixitsBot.frontLeftMotor.getPower());
        telemetry.addData("Front Rig Motor:", FixitsBot.frontRightMotor.getPower());
        telemetry.addData("Rear Lef Motor:", FixitsBot.rearLeftMotor.getPower());
        telemetry.addData("Rear Rig Motor:", FixitsBot.rearRightMotor.getPower());
        telemetry.addData("Encoder Count: ", FixitsBot.frontLeftMotor.getCurrentPosition());
        telemetry.addLine("LONG LIVE TACO");
        telemetry.update();
    }

}

