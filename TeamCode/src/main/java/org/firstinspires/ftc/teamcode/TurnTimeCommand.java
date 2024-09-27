package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;

public class TurnTimeCommand extends Command {

    private DriveSubsystem driveSubsystem;
    private double time;
    private ElapsedTime timer;

    public TurnTimeCommand(DriveSubsystem driveSubsystem, double time) {
        this.driveSubsystem = driveSubsystem;
        this.time = time;
    }

    @Override
    public void init() {
        timer = new ElapsedTime();
    }

    @Override
    public void loop() {
        driveSubsystem.setPower(0, 0, 0.5f, 1);
    }

    @Override
    public boolean isFinished() {
        return timer.time() >= time;
    }

    @Override
    public void stop(boolean interrupted) {
        driveSubsystem.setPower(0, 0, 0, 0);
    }
}
