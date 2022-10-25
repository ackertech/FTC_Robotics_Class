package org.firstinspires.ftc.teamcode.iLab.Bot_Connor;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class CandyLaunchingBot_Connor extends MecanumDrive_Connor {

public HardwareMap hwBot = null;

public RevBlinkinLedDriver ledLights;
public RevBlinkinLedDriver.BlinkinPattern patternArray [] = {
        RevBlinkinLedDriver.BlinkinPattern.BLUE,
        RevBlinkinLedDriver.BlinkinPattern.BLUE_GREEN,
        RevBlinkinLedDriver.BlinkinPattern.GRAY,
        RevBlinkinLedDriver.BlinkinPattern.GOLD,
        RevBlinkinLedDriver.BlinkinPattern.LIGHT_CHASE_BLUE,
        RevBlinkinLedDriver.BlinkinPattern.COLOR_WAVES_PARTY_PALETTE,

};

public ElapsedTime currentTime = new ElapsedTime();
public int ledTimer;
public int ledTimerIncrementer = 4;
public int ledCounter = 0;


public ElapsedTime timer = new ElapsedTime();
double waitTime = 2.0;

public DcMotor launcher;
public DcMotor camLift;
public Servo camPivot;
public Servo trapDoor;





}
