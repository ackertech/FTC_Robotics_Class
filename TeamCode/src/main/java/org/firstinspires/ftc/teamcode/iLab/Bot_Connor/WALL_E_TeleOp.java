package org.firstinspires.ftc.teamcode.iLab.Bot_Connor;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

//@Disabled
@TeleOp(name = "WALL-E_TeleOp_Connor")
public class WALL_E_TeleOp extends OpMode {

    public double speedMultiply = 0.50;

    public enum Style {
        ONESTICK, TWOSTICK, TANK
    }

    public Style driverStyle = Style.ONESTICK;

    public double leftSidePower;
    public double rightSidePower;

    public enum LazySusanControl {AUTO, MANUAL}

    public Tank_TeleOp_Connor.LazySusanControl lazySusanControl = Tank_TeleOp_Connor.LazySusanControl.MANUAL;

    public enum LazySusanEncoder {FORWARD, REVERSE, OFF}

    public Tank_TeleOp_Connor.LazySusanEncoder lazySusanEncoder = Tank_TeleOp_Connor.LazySusanEncoder.OFF;
    public double lazySusanTicks = 5000;
    public double lazySusanPower = 0.90;


    public enum ControlOfUpAndDownLinearMotor {FORWARD, REVERSE}
    public The_Mighty_and_All_Powerful_Hand Hand = new The_Mighty_and_All_Powerful_Hand();
    public Tank_TeleOp_Connor.ControlOfUpAndDownLinearMotor controlOfUpAndDownLinearMotor = Tank_TeleOp_Connor.ControlOfUpAndDownLinearMotor.FORWARD;
    public Tank_TeleOp_Connor.ControlOfSidewaysLinearMotor controlOfSidewaysLinearMotor = Tank_TeleOp_Connor.ControlOfSidewaysLinearMotor.FORWARD;
    public Tank_TeleOp_Connor.ControlOfLeftClaw controlOfLeftClaw = Tank_TeleOp_Connor.ControlOfLeftClaw.CLOSED;
    public Tank_TeleOp_Connor.ControlOfRightClaw controlOfRightClaw = Tank_TeleOp_Connor.ControlOfRightClaw.CLOSED;
    //hi 2
    double leftStickYVal;
    double leftStickXVal;
    double rightStickYVal;
    double rightStickXVal;

    public WalleBot WALL_E = new WalleBot();

    @Override
    public void init() {
        WALL_E.initRobot(hardwareMap);
    }

    public void loop() {
        speedControl();
        drivingStyle();
        drive();
        lazySusanControl();
        clawControl();
        LinearMotorControl();
        telementryOutput();


    }

    public void speedControl() {
        if (gamepad1.dpad_right == true) {
            speedMultiply = 0.50;
        } else if (gamepad1.dpad_down == true) {
            speedMultiply = 0.75;
        } else if (gamepad1.dpad_left == true) {
            speedMultiply = 1.00;
        } else if (gamepad1.dpad_up == true) {
            speedMultiply = 0.25;
        }

    }

    public void drive() {
        switch (driverStyle) {
            case ONESTICK:


                leftStickYVal = gamepad1.left_stick_y;
                leftStickYVal = Range.clip(leftStickYVal, -1, 1);

                leftStickXVal = gamepad1.left_stick_x;
                leftStickXVal = Range.clip(leftStickXVal, -1, 1);

                if (leftStickYVal < -0.1) {
                    WALL_E.driveForward(speedMultiply * leftStickYVal);
                } else if (leftStickYVal > 0.1) {
                    WALL_E.driveBackwards(speedMultiply * leftStickYVal);
                } else if (leftStickXVal > 0.1) {
                    WALL_E.rotateRight(speedMultiply * leftStickXVal);
                } else if (leftStickXVal < -0.1) {
                    WALL_E.rotateLeft(speedMultiply * leftStickXVal);
                } else {
                    WALL_E.stopMotors();

                }
                break;

            case TWOSTICK:
                leftStickYVal = gamepad1.left_stick_y;
                leftStickYVal = Range.clip(leftStickYVal, -1, 1);
                leftStickXVal = gamepad1.left_stick_x;
                leftStickXVal = Range.clip(leftStickXVal, -1, 1);
                rightStickYVal = gamepad1.right_stick_y;
                rightStickYVal = Range.clip(rightStickYVal, -1, 1);
                rightStickXVal = gamepad1.right_stick_x;
                rightStickXVal = Range.clip(rightStickXVal, -1, 1);

                if (leftStickYVal < -0.1) {
                    WALL_E.driveForward(speedMultiply * leftStickYVal);
                } else if (leftStickYVal > 0.1) {
                    WALL_E.driveBackwards(speedMultiply * leftStickYVal);
                } else if (rightStickXVal > 0.1) {
                    WALL_E.rotateRight(speedMultiply * rightStickXVal);
                } else if (rightStickXVal < -0.1) {
                    WALL_E.rotateLeft(speedMultiply * rightStickXVal);
                } else {
                    WALL_E.stopMotors();
                }
                break;


            case TANK:
                leftStickYVal = gamepad1.left_stick_y;
                leftStickYVal = Range.clip(leftStickYVal, -1, 1);

                rightStickYVal = gamepad1.right_stick_y;
                rightStickYVal = Range.clip(rightStickYVal, -1, 1);

                leftSidePower = speedMultiply * leftStickYVal * (-1);
                rightSidePower = speedMultiply * rightStickYVal * (-1);
                WALL_E.tankDrive(leftSidePower, rightSidePower);
                break;


        }
    }


    public void LinearMotorControl() {



        if (gamepad2.dpad_left) {
            if (controlOfUpAndDownLinearMotor == controlOfUpAndDownLinearMotor.REVERSE) {
                controlOfUpAndDownLinearMotor = controlOfUpAndDownLinearMotor.FORWARD;
            } else if (controlOfUpAndDownLinearMotor == controlOfUpAndDownLinearMotor.FORWARD) {
                controlOfUpAndDownLinearMotor = controlOfUpAndDownLinearMotor.REVERSE;
            }

        }

        if (gamepad2.dpad_right) {
            if (controlOfSidewaysLinearMotor == controlOfSidewaysLinearMotor.REVERSE) {
                controlOfSidewaysLinearMotor = controlOfSidewaysLinearMotor.FORWARD;
            }
            else if (controlOfSidewaysLinearMotor == controlOfSidewaysLinearMotor.FORWARD) {
                controlOfSidewaysLinearMotor = controlOfSidewaysLinearMotor.REVERSE;
            }
        }

        if (controlOfUpAndDownLinearMotor == controlOfUpAndDownLinearMotor.FORWARD) {
            if (Math.abs(WALL_E.upAndDownLinearMotor.getCurrentPosition()) < 1500) {
                WALL_E.upAndDownLinearMotor.setPower(0.4);
            } else {
                WALL_E.upAndDownLinearMotor.setPower(0);
            }
        } else if (controlOfUpAndDownLinearMotor == controlOfUpAndDownLinearMotor.REVERSE) {
            if (Math.abs(WALL_E.upAndDownLinearMotor.getCurrentPosition()) < 1500) {
                WALL_E.upAndDownLinearMotor.setPower(-0.4);
            } else {
                WALL_E.upAndDownLinearMotor.setPower(0);
            }
        }


        if (controlOfSidewaysLinearMotor == controlOfSidewaysLinearMotor.FORWARD) {
            if (Math.abs(WALL_E.sidewaysLinearMotor.getCurrentPosition()) < 1500) {
                WALL_E.sidewaysLinearMotor.setPower(0.4);
            } else {
                WALL_E.sidewaysLinearMotor.setPower(0);
            }
        } else if (controlOfSidewaysLinearMotor == controlOfSidewaysLinearMotor.REVERSE) {
            if (Math.abs(WALL_E.sidewaysLinearMotor.getCurrentPosition()) < 1500) {
                WALL_E.sidewaysLinearMotor.setPower(-0.4);
            } else {
                WALL_E.sidewaysLinearMotor.setPower(0);
            }
        }
    }


    public void clawControl()  {

        if (gamepad2.left_trigger >0.1) {
            Hand.clawOpen();
        }

        if (gamepad2.right_trigger >0.1) {
            Hand.rightClawOpen();
        }

       if (gamepad2.left_bumper) {
           Hand.clawClose();
       }

       if (gamepad2.right_bumper) {
           Hand.rightClawClose();
       }






    }



    public void drivingStyle() {

        if (gamepad1.a) {
            driverStyle = WALL_E_TeleOp.Style.ONESTICK;

        }
        if (gamepad1.b) {
            driverStyle = WALL_E_TeleOp.Style.TANK;

        }


    }


    public void lazySusanControl() {
        if (gamepad2.start) {
            if (lazySusanControl == lazySusanControl.MANUAL) {
                lazySusanControl = lazySusanControl.AUTO;
            } else {
                lazySusanControl = lazySusanControl.MANUAL;
            }
        }

        if (lazySusanControl == lazySusanControl.MANUAL) {
            if (gamepad2.right_stick_x > 0.1) {
                WALL_E.lazySusanLeft(lazySusanPower);
            } else if (gamepad2.right_stick_x < -0.1) {
                WALL_E.lazySusanRight(lazySusanPower);
            } else {
                WALL_E.lazySusanStop();
            }
        } else if (lazySusanControl == lazySusanControl.AUTO) {
            if (gamepad2.a) {
                lazySusanEncoder = lazySusanEncoder.FORWARD;
                WALL_E.lazy_Susan.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                WALL_E.lazy_Susan.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            }

            if (gamepad2.b) {
                lazySusanEncoder = lazySusanEncoder.REVERSE;
                WALL_E.lazy_Susan.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                WALL_E.lazy_Susan.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            }

            if (lazySusanEncoder == lazySusanEncoder.FORWARD) {
                if (Math.abs(WALL_E.lazy_Susan.getCurrentPosition()) < lazySusanTicks) {
                    WALL_E.lazy_Susan.setPower(lazySusanPower);
                } else {
                    WALL_E.lazy_Susan.setPower(0);
                }
            } else if (lazySusanEncoder == lazySusanEncoder.REVERSE) {
                if (Math.abs(WALL_E.lazy_Susan.getCurrentPosition()) < lazySusanTicks) {
                    WALL_E.lazy_Susan.setPower(-lazySusanPower);
                } else {
                    WALL_E.lazy_Susan.setPower(0);
                }
            }

        }
    }


        public void telementryOutput () {
            telemetry.addLine("Wall-E Control Panel");
            telemetry.addLine("LONG LIVE TACO");
            telemetry.addData("Speed: ", speedMultiply);
            telemetry.addData("Front Left Motor Power", WALL_E.frontLeftMotor.getPower());
            telemetry.addData("Front Right Motor Power", WALL_E.frontRightMotor.getPower());
            telemetry.addData("Rear Left Motor Power", WALL_E.rearLeftMotor.getPower());
            telemetry.addData("Rear Right Motor Power", WALL_E.rearRightMotor.getPower());

            if (driverStyle == WALL_E_TeleOp.Style.ONESTICK) {
                telemetry.addLine("OneStick Drive");
            } else if (driverStyle == WALL_E_TeleOp.Style.TANK) {
                telemetry.addLine("Tank Drive");
            } else if (driverStyle == WALL_E_TeleOp.Style.TWOSTICK) {
                telemetry.addLine(" TwoStick Drive");
            }
        }

        //Long Live Taco

//CNM REDD

}

