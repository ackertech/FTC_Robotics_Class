package org.firstinspires.ftc.teamcode.iLab.Bot_Connor;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class WalleBot extends Tank_FourMotorDrive_Connor {
        //define Mechinism Varibles
        //Set Lazy Susan movement values


        //Hardware Mapping Variable used by robot controller
        public HardwareMap hwBot = null;

        //Robot Physical Constructor used in TeleOp and Autonomous
        public WalleBot() {
        }

        // Custom Method that will initilize the robot hardware in TeleOp and Autonomous
        public void initRobot(HardwareMap hwMap) {
            hwBot = hwMap;

            //Define the name of the motors used in the control hub configuation
            frontLeftMotor = hwBot.dcMotor.get("frontLeftMotor"); //Port 0
            frontRightMotor = hwBot.dcMotor.get("frontRightMotor");// Port 2
            rearLeftMotor = hwBot.dcMotor.get("rearLeftMotor");// Port 1
            rearRightMotor = hwBot.dcMotor.get("rearRightMotor");// Port 3

            //Sets the direction of the robot's motors based on physical placement
            frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
            frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
            rearLeftMotor.setDirection(DcMotor.Direction.REVERSE);
            rearRightMotor.setDirection(DcMotor.Direction.FORWARD);


            //Define this robot run modes
            setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            //Define this robot's braking modes
            frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);


            /**  ********  Tankbot_Connor Mechanisms ************     **/

            //Expansion Hub Port 2


            /** Linear Actuatiors*********    **/


        }



}
