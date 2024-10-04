package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;

public class DriveTimeCommand extends Command {

    private DriveSubsystem driveSubsystem;
    private double time;
    private ElapsedTime timer;

    public DriveTimeCommand(DriveSubsystem driveSubsystem, double time) {
        this.driveSubsystem = driveSubsystem;
        this.time = time;
    }

    @Override
    public void init() {
        this.timer = new ElapsedTime();
    }

    @Override
    public void loop() {
        driveSubsystem.drive(0.5f, 0, 0, 1);
    }

    @Override
    public boolean isFinished() {
        return timer.time() >= time;
    }

    @Override
    public void stop(boolean interrupted) {
        driveSubsystem.drive(0, 0, 0, 1);
    }
}
