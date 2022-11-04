package org.firstinspires.ftc.teamcode.FixIts.Bot_Bob;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class FourMotorDrive_Caroline {

    //comment
    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor rearLeftMotor;
    public DcMotor rearRightMotor;

    //comment
    public LinearOpMode LinearOp = null;
    public void setLinearOp (LinearOpMode LinearOpModeOP)
    {this.LinearOp = LinearOp;}

    //comment
    public void setMotorRunModes (DcMotor.RunMode mode){frontLeftMotor.setMode(mode);
    frontRightMotor.setMode(mode);
    rearLeftMotor.setMode(mode);
    rearRightMotor.setMode(mode);}

    //comment
    public void stopMotors (){
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        rearLeftMotor.setPower(0);
        rearRightMotor.setPower(0);}

    //comment
    public void driveForward (double power) {
    frontLeftMotor.setPower(power);
    frontRightMotor.setPower(power);
    rearLeftMotor.setPower(power);
    rearRightMotor.setPower(power);}

    //comment
    public void driveBackwards (double power) {
        frontLeftMotor.setPower(-power);
        frontRightMotor.setPower(-power);
        rearLeftMotor.setPower(-power);
        rearRightMotor.setPower(-power);}

    //comment
    public void rotateLeft (double power){
        frontLeftMotor.setPower(-power);
        frontRightMotor.setPower(power);
        rearLeftMotor.setPower(-power);
        rearRightMotor.setPower(power);
    }

    //comment
public void rotateRight (double power) {
    frontLeftMotor.setPower(power);
    frontRightMotor.setPower(-power);
    rearLeftMotor.setPower(power);
    rearRightMotor.setPower(-power);}
}
