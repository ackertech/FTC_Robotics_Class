package org.firstinspires.ftc.teamcode.FixIts.Bot_Bob;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Bob: Caroline")
public class LabBot_TeleOp_Caroline extends OpMode {

    public double speedMultiply = 0.50;

    public LabBot_Caroline Bot = new LabBot_Caroline();
    @Override
    public void init() {

     Bot.initRobot(hardwareMap);
    }

    @Override
    public void loop() {
    drive();
    speedControl();


    }

    private void speedControl() {

        if (gamepad1.dpad_right == true)
    }

    private void drive()

//comment
