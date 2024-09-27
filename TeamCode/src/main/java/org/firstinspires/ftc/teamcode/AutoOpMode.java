package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous
public class AutoOpMode extends OpMode {

    private DriveSubsystem driveSubsystem;

    @Override
    public void init() {
        driveSubsystem = new DriveSubsystem();
        driveSubsystem.init(hardwareMap, telemetry);
    }

    @Override
    public void init_loop() {

    }

    @Override
    public void start() {
        Command autoCommand = new DriveTimeCommand(driveSubsystem, 5)
                .andThen(new TurnTimeCommand(driveSubsystem, 2.5))
                .andThen(new DriveTimeCommand(driveSubsystem, 3));

        autoCommand.start();
    }

    @Override
    public void loop() {
        CommandRunner.getInstance().run();
    }

    @Override
    public void stop() {
        CommandRunner.getInstance().stopCommand();
    }
}
