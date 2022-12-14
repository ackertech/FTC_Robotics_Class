package org.firstinspires.ftc.teamcode.Base.Drivetrains;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

public class MecanumDrive {

    // Declare Variables for the Motors
    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor rearLeftMotor;
    public DcMotor rearRightMotor;
    double powerPIDFactor = 1.0;

    // This is just required as part of the FIRST SDK.  Memorize it!!!
    public LinearOpMode linearOp = null;

    public void setLinearOp(LinearOpMode linearOp) {

        this.linearOp = linearOp;
    }

    // These are motor variables from running with encoders (not power)
    public static final double TICKS_PER_ROTATION = 386.3;  //386.3 is defined from the specs of the motor

    // Default Constructors

    public MecanumDrive(){

    }

    // Constructor with parameters.

    public MecanumDrive(DcMotor fl, DcMotor fr, DcMotor rl, DcMotor rr) {

        frontLeftMotor = fl;
        frontRightMotor = fr;
        rearLeftMotor = rl;
        rearRightMotor = rr;

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);     //Forward and reverse depends on builder and manufacture
        rearLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
        rearRightMotor.setDirection(DcMotor.Direction.FORWARD);

        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);   //memorize
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER); // MUST HAVE RUN MODE

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    }


    // Reusuable Method to Set the Motor Behavior or Run Modes from the Robot Class
    public void setMotorRunModes(DcMotor.RunMode mode) {

        frontLeftMotor.setMode(mode);
        frontRightMotor.setMode(mode);
        rearLeftMotor.setMode(mode);
        rearRightMotor.setMode(mode);
    }

    public void stopMotors() {
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        rearLeftMotor.setPower(0);
        rearRightMotor.setPower(0);
    }

    public void driveForward(double speed) {
        frontLeftMotor.setPower(Math.abs(speed));
        frontRightMotor.setPower(Math.abs(speed));
        rearLeftMotor.setPower(Math.abs(speed));
        rearRightMotor.setPower(Math.abs(speed));
    }

    public void driveBackward(double speed) {
        frontLeftMotor.setPower(-Math.abs(speed));
        frontRightMotor.setPower(-Math.abs(speed));
        rearLeftMotor.setPower(-Math.abs(speed));
        rearRightMotor.setPower(-Math.abs(speed));

    }

    public void rotateLeft(double speed) {
        frontLeftMotor.setPower(-Math.abs(speed));
        frontRightMotor.setPower(Math.abs(speed));
        rearLeftMotor.setPower(-Math.abs(speed));
        rearRightMotor.setPower(Math.abs(speed));

    }

    public void rotateRight(double speed) {
        frontLeftMotor.setPower(Math.abs(speed));
        frontRightMotor.setPower(-Math.abs(speed));
        rearLeftMotor.setPower(Math.abs(speed));
        rearRightMotor.setPower(-Math.abs(speed));

    }

    public void strafeLeft(double speed) {
        frontLeftMotor.setPower(-Math.abs(speed));
        frontRightMotor.setPower(Math.abs(speed));
        rearLeftMotor.setPower(Math.abs(speed));
        rearRightMotor.setPower(-Math.abs(speed));

    }

    public void strafeRight(double speed) {
        frontLeftMotor.setPower(Math.abs(speed));
        frontRightMotor.setPower(-Math.abs(speed));
        rearLeftMotor.setPower(-Math.abs(speed));
        rearRightMotor.setPower(Math.abs(speed));
    }

    // Consolidated Method (in Beta Testing) for combinining all mecanum movements
    public void driveDirection(double speed, double rotations, String direction) {

        double ticks = rotations * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        if (direction.equals("FWD") ) {
            while ( (Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks) && linearOp.opModeIsActive() ){
                driveForward(speed);
            }
            stopMotors();
        }
        else if (direction.equals("RWD") ) {
            while ( (Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks) && linearOp.opModeIsActive() ){
                driveBackward(speed);
            }
            stopMotors();
        }
        else if (direction.equals("STR")) {
            while ( (Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks) && linearOp.opModeIsActive() ){
                strafeRight(speed);
            }
            stopMotors();
        }
        else if (direction.equals("STL")) {
            while ( (Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks) && linearOp.opModeIsActive() ){
                strafeLeft(speed);
            }
            stopMotors();
        }
        else if (direction.equals("RR")) {
            while ( (Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks) && linearOp.opModeIsActive() ){
                rotateRight(speed);
            }
            stopMotors();
        }
        else if (direction.equals("RL")) {
            while ( (Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks) && linearOp.opModeIsActive() ){
                rotateLeft(speed);
            }
            stopMotors();
        }
    }

    public void accelerate(double speed, double rotations) {

        double ticks = rotations * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        double currentPower = 0;
        double tolerance = 0.95;

        while ( (Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks) && linearOp.opModeIsActive() ){
            if (currentPower < (speed * tolerance) ) {
                driveForward(currentPower);
                currentPower += .001;
                linearOp.telemetry.addData("Front Lef Motor: ", frontLeftMotor.getPower());
                linearOp.telemetry.addData("Current Power Var: ", currentPower);
                linearOp.telemetry.addData("Encoder Counts: ", frontLeftMotor.getCurrentPosition());
                linearOp.telemetry.update();
            }
            else {
                driveForward(speed);
            }
        }
        stopMotors();

    }

    public void drivePID(double rotations, double Kp, double Ki, double Kd) {

        //Set Motor Run Modes
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Timer Varianles
        ElapsedTime timer = new ElapsedTime();
        timer.reset();

        // Declare and Initialize variables
        double error = Math.abs(frontLeftMotor.getCurrentPosition());
        double targetPosition = rotations * TICKS_PER_ROTATION;

        // PID Terms: Proportional Term, Integral Term, Derivative Term
        double P = 0;
        double I = 0;
        double D = 0;

        //Current Variables
        double currentPosition = Math.abs(frontLeftMotor.getCurrentPosition());
        double currentError;
        double currentTime;

        // Previous Variables
        double previousPosition = 0;
        double previousError = 0;
        double previousTime = 0;

        while ( currentPosition < targetPosition && linearOp.opModeIsActive() ) {

            currentTime = timer.time();
            currentPosition = frontLeftMotor.getCurrentPosition();
            currentError = currentPosition - targetPosition;

            // Proportional Term
            P = Kp * currentError;

            // Integral Term ( the sum of all errors over time )
            I += Ki * ( currentError * (currentPosition - previousPosition) );
            // integral +=  errorChange * timer.time();

            // Derivative Term (rate of change in the error based on time factor)
            //if (previousTime == 0) { previousTime = currentTime;}
            D = Kd * (currentError - previousError) / (currentTime - previousTime);

            //double derivative = errorChange / timer.time();

            //Increasing Kp makes robot approach target faster and lead to overshooting target
            powerPIDFactor = ( P + I + D ) ;

            //Min-Max Data Normalization to ensure values are between 0 and 1  (Value - Min) / (Max - Min)
            powerPIDFactor = (powerPIDFactor - 0) / ( targetPosition - 0);

            driveForward(powerPIDFactor);
            linearOp.telemetry.addData("PID Power:", powerPIDFactor);
            linearOp.telemetry.addData("FL Power:", frontLeftMotor.getPower());
            linearOp.telemetry.addData("RL Power:", rearLeftMotor.getPower());
            linearOp.telemetry.addData("Current Position:", currentPosition);
            linearOp.telemetry.addData("Target Positionr:", targetPosition);
            linearOp.telemetry.addData("Current Error:", currentError);
            linearOp.telemetry.addData("Previous Position:", previousPosition);
            linearOp.telemetry.addData("Previous Error:", previousError);
            linearOp.telemetry.update();

            // Reset the parameters
            previousTime = currentTime;
            previousError = currentError;
            previousPosition = currentPosition;

        }
        stopMotors();


    }




    //    public void drivePID(double speed, double rotations) {
//        double ticks = rotations * TICKS_PER_ROTATION;
//        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//
//        double k_p = 1;      //Proportional Constant
//        double k_i = 0;     // Integral Term
//        double previousDistance = 0;
//
//        while (Math.abs(frontLeftMotor.getCurrentPosition()) < ticks) {
//
//            double currentDistance = Math.abs(frontLeftMotor.getCurrentPosition());
//            double currentError = ticks-currentDistance;
//
//            double p = k_p * currentError;
//            double i= i + ( k_i * (currentError * (currentDistance - previousDistance)) );
//
////           if i > max_i:
////            i = max_i
////            elif i < -max_i:
////            i = -max_i
//////
////            D = k_d * (current_error - previous_error) / (current_time - previous_time)
////
////            output = p + i + d
////
////            previous_error = current_error
////            previous_time = current_time
//            driveForward(speed);
//        }
//        stopMotors();
//
//    }


}