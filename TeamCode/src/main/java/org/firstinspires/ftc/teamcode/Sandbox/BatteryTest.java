package org.firstinspires.ftc.teamcode.Sandbox;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.VoltageSensor;

@TeleOp (name = "Battery Test", group = "LAB")
public class BatteryTest extends OpMode {

    VoltageSensor voltageSensor;

    @Override
    public void init() {
        voltageSensor = hardwareMap.voltageSensor.iterator().next();
    }

    @Override
    public void loop() {
        telemetry.addLine(String.format("Voltage: %.1f", voltageSensor.getVoltage()));
        telemetry.update();
    }
}
