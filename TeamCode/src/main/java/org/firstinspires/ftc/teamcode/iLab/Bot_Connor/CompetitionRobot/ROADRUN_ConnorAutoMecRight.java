package org.firstinspires.ftc.teamcode.iLab.Bot_Connor.CompetitionRobot;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.util.Angle;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@Autonomous (name = "ROADRUNAuto_Connor")
public class ROADRUN_ConnorAutoMecRight extends LinearOpMode {


    public static double ANGLE = -180;
    public static double ANGLE2 = 90;
    public static double STRAFEDISTANCE = 13;
    @Override
    public void runOpMode() throws InterruptedException{
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        RoadRunnerCompBot drive = new RoadRunnerCompBot(hardwareMap);

        Trajectory traj1 = drive.trajectoryBuilder(new Pose2d())
                .forward(60)
                .build();

        Trajectory traj2 = drive.trajectoryBuilder(new Pose2d())
                        .strafeLeft(STRAFEDISTANCE)
                                .build();











                waitForStart();





                while (opModeIsActive()) {
                drive.followTrajectory(traj1);
                drive.turn(Math.toRadians(ANGLE2));
                 drive.followTrajectory(traj2);
                 drive.turn(Math.toRadians(ANGLE));
                 drive.clawOpen();
                 requestOpModeStop();

                }
        idle();

    }

}
