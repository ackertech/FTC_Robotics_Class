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

    @Override
    public void runOpMode() throws InterruptedException{
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        RoadRunnerCompBot drive = new RoadRunnerCompBot(hardwareMap);

        Trajectory traj1 = drive.trajectoryBuilder(new Pose2d())
                .forward(60)
                .build();










                waitForStart();


        drive.followTrajectory(traj1);
        drive.turn(Math.toRadians(45));


        requestOpModeStop();
                if (isStopRequested()) return;




                Pose2d poseEstimate = drive.getPoseEstimate();


                        while (!isStopRequested() && opModeIsActive()) ;
    }

}
