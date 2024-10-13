package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
public class BasicAutoOpMode extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        // init
        DriveSubsystem driveSubsystem = new DriveSubsystem(hardwareMap, telemetry);

        waitForStart();

        // run
        driveSubsystem.drive(0.5, 0, 0, 1);
        Thread.sleep(1500);
        driveSubsystem.stop();
        Thread.sleep(1000);
        driveSubsystem.drive(0, -0.5, 0, 1);
        Thread.sleep(750);
        driveSubsystem.stop();
        Thread.sleep(1000);
        driveSubsystem.drive(-0.5, 0, 0, 1);
        Thread.sleep(1500);
        driveSubsystem.stop();
    }
}
