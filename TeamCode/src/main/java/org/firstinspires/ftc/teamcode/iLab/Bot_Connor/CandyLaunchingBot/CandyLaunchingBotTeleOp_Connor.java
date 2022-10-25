package org.firstinspires.ftc.teamcode.iLab.Bot_Connor.CandyLaunchingBot;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Base.Robot.AckerBot;

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


    public CandyLaunchingBot_Connor CandyBot = new CandyLaunchingBot_Connor();


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

        //   Bot.openHand();

    }
}



