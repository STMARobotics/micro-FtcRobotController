package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TeleopOpMode extends OpMode {

    private DriveSubsystem driveSubsystem;

    @Override
    public void init() {
        driveSubsystem = new DriveSubsystem(hardwareMap, telemetry);
    }

    @Override
    public void init_loop() {

    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {
        // Read controller input
        double forward = -gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double turn = gamepad1.right_stick_x;
        double reductionFactor = gamepad1.right_bumper ? 4.0 : 1.0;

        // Square forward, strafe, and turn inputs while keeping their sign
        forward *= Math.abs(forward);
        strafe *= Math.abs(strafe);
        turn *= Math.abs(turn);

        driveSubsystem.drive(forward, strafe, turn, reductionFactor);
    }

    @Override
    public void stop() {
        driveSubsystem.stop();
    }
}
