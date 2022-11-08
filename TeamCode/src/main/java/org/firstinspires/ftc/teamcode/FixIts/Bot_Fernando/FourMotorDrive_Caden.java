package org.firstinspires.ftc.teamcode.FixIts.Bot_Fernando;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class FourMotorDrive_Caden {

    //Variables

    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor rearLeftMotor;
    public DcMotor rearRightMotor;

    //SDK

    public LinearOpMode linearOp = null;
    public void setLinearOp (LinearOpMode LinearOpModeOP) {
        this.linearOp = linearOp;
    }

    public void setMotorRunModes (DcMotor.RunMode mode) {
        frontLeftMotor.setMode(mode);
        frontRightMotor.setMode(mode);
        rearLeftMotor.setMode(mode);
        rearRightMotor.setMode(mode);
    }

    //Stop

    public void stopMotors () {
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
    }

    //Drive Forward

    public void driveForward (double power) {

        frontLeftMotor.setPower(power);
        frontRightMotor.setPower(power);
        frontLeftMotor.setPower(power);
        frontRightMotor.setPower(power);
    }

    //Drive Backwards

    public void driveBackward (double power) {

        frontLeftMotor.setPower(-power);
        frontRightMotor.setPower(-power);
        frontLeftMotor.setPower(-power);
        frontRightMotor.setPower(-power);
    }

    //Rotate Left

    public void rotateLeft (double power) {

        frontLeftMotor.setPower(-power);
        frontRightMotor.setPower(power);
        frontLeftMotor.setPower(-power);
        frontRightMotor.setPower(power);
    }

    //Rotate Left

    public void rotateRight (double power) {

        frontLeftMotor.setPower(power);
        frontRightMotor.setPower(-power);
        frontLeftMotor.setPower(power);
        frontRightMotor.setPower(-power);
    }

}

