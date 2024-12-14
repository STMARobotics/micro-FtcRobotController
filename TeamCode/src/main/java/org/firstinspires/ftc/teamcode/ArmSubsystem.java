package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ArmSubsystem {

    private final DcMotor pivot;
    private final DcMotor extension;
    private final Servo claw;

    public ArmSubsystem(HardwareMap hardwareMap) {
        this.pivot = hardwareMap.get(DcMotor.class, "pivot");
        this.extension = hardwareMap.get(DcMotor.class, "extension");
        this.claw = hardwareMap.get(Servo.class, "claw");

        pivot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void driveExtension(double speed) {
        extension.setPower(speed);
    }

    public void drivePivot(double speed) {
        pivot.setPower(speed);
    }

    public void openClaw() {
        claw.setPosition(Servo.MAX_POSITION);
    }

    public void closeClaw() {
        claw.setPosition(Servo.MIN_POSITION);
    }

}
