package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ArmSubsystem {

    private final DcMotor pivot;
    private final DcMotor extension;
    private final CRServo intake;
    private final CRServo wrist;

    public ArmSubsystem(HardwareMap hardwareMap) {
        this.pivot = hardwareMap.get(DcMotor.class, "pivot");
        this.extension = hardwareMap.get(DcMotor.class, "extension");
        this.intake = hardwareMap.get(CRServo.class, "intake");
        this.wrist = hardwareMap.get(CRServo.class, "wrist");

        pivot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void driveExtension(double speed) {
        extension.setPower(speed);
    }

    public void drivePivot(double speed) {
        pivot.setPower(speed);
    }

    public void driveIntake(double speed) {
        intake.setPower(speed);
    }

    public void driveWrist(double speed) {
        double bias = 0.05;
        wrist.setPower(speed + bias);
    }

}
