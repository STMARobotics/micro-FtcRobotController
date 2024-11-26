package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TeleopOpMode extends OpMode {

    private DriveSubsystem driveSubsystem;
    private ArmSubsystem armSubsystem;
    private boolean climb;

    @Override
    public void init() {
        driveSubsystem = new DriveSubsystem(hardwareMap, telemetry);
        armSubsystem = new ArmSubsystem(hardwareMap);
        climb = false;
    }

    @Override
    public void init_loop() {

    }

    @Override
    public void start() {
        driveSubsystem.resetYaw();
    }

    @Override
    public void loop() {
        // Read controller input
        double translationY = -gamepad1.left_stick_y;
        double translationX = gamepad1.left_stick_x;
        double rotation = gamepad1.right_stick_x;
        double reductionFactor = gamepad1.right_bumper ? 4.0 : 1.0;

        // Square forward, strafe, and turn inputs while keeping their sign
        translationY *= Math.abs(translationY);
        translationX *= Math.abs(translationX);
        rotation *= Math.abs(rotation);

        driveSubsystem.drive(translationY, translationX, rotation, reductionFactor);

        if (gamepad1.back) {
            driveSubsystem.resetYaw();
        }

        if (gamepad2.a) {
            climb = true;
        } else if (gamepad2.b) {
            climb = false;
        }

        armSubsystem.drivePivot(climb ? -1 : -gamepad2.left_stick_y);
        armSubsystem.driveWrist(-gamepad2.right_stick_y * 0.25);
        double extensionSpeed = 0.0;
        if (gamepad2.dpad_up) {
            extensionSpeed = -0.5;
        } else if (gamepad2.dpad_down) {
            extensionSpeed = 0.5;
        }
        armSubsystem.driveExtension(extensionSpeed);
        double intakeSpeed = 0.0;
        if (gamepad2.right_trigger > 0.8) {
            intakeSpeed = -1;
        } else if (gamepad2.left_trigger > 0.8) {
            intakeSpeed = 1;
        }
        armSubsystem.driveIntake(intakeSpeed);
    }

    @Override
    public void stop() {
        driveSubsystem.stop();
    }
}
