package org.firstinspires.ftc.teamcode.FixIts.Bot_Bob;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class LabBot_Caroline extends FourMotorDrive_Caroline{
    //comment

    public Servo flag = null;
    public HardwareMap hwBot = null;

  //comment
    public LabBot_Caroline(){}

    //comment
    public void initRobot (HardwareMap hwMap) {
        hwBot = hwMap;
        //comment
        frontLeftMotor = hwBot.dcMotor.get("front_Left_Motor");
        frontRightMotor = hwBot.dcMotor.get("front_Right_Motor");
        rearLeftMotor = hwBot.dcMotor.get("rear_Left_Motor");
        rearRightMotor = hwBot.dcMotor.get("rear_Right_Motor");

        //comment
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rearLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rearRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        //comment
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //comment
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //comment
        flag = hwBot.get(Servo.class, "flag");
        flag.setDirection(Servo.Direction.FORWARD);
    }

     //comment
    public void lowerFlag() {
        flag.setPosition(0);
    }

    public void raiseFlag() {flag.setPosition(0.475);}

    public void waveFlagLeft() {flag.setPosition(0.38);}

    public void waveFlagRight(){flag.setPosition(.8);}

}

