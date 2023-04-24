package org.firstinspires.ftc.teamcode.iLab.Bot_Connor.Wall_E;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@Autonomous (name = "Wall -E Auto_Connor")
public class CONNOR_Wall_E_Tele_Op extends LinearOpMode {


    WalleBot Wall_E = new WalleBot();

    @Override
    public void runOpMode() throws InterruptedException {

        Wall_E.initRobot(hardwareMap);
        Wall_E.setLinearOp(this);





        telemetry.addLine("Wall_E Awaiting Start");
        telemetry.update();


                waitForStart();

        while (opModeIsActive()) {







        }
        //hi
    }
}
