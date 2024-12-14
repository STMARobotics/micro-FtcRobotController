package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
public class OneSampleAuto extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        DriveSubsystem driveSubsystem = new DriveSubsystem(hardwareMap, telemetry);
        ArmSubsystem armSubsystem = new ArmSubsystem(hardwareMap);

        driveSubsystem.resetYaw();

        waitForStart();

        armSubsystem.closeClaw();

        driveSubsystem.drive(0.5, 0, 0, 1);
        armSubsystem.drivePivot(0.7);
        armSubsystem.driveExtension(-0.2);
        Thread.sleep(2000);
        armSubsystem.drivePivot(0);
        armSubsystem.driveExtension(0);
        driveSubsystem.drive(-0.5, 0, 0, 1);
        Thread.sleep(500);
        armSubsystem.openClaw();
        Thread.sleep(1500);
        driveSubsystem.drive(0, 0.5, 0, 1);
        Thread.sleep(3000);
        driveSubsystem.stop();
    }

}
