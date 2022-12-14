package org.firstinspires.ftc.teamcode.FixIts.Bot_Bob;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@Disabled
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

    private void speedControl() {}

    private void drive() {}}

//comment
