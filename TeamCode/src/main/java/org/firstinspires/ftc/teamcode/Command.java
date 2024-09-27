package org.firstinspires.ftc.teamcode;

public abstract class Command {

    private Command nextCommand;

    public final void start() {
        CommandRunner.getInstance().startCommand(this);
    }

    public void init() {}
    public void loop() {}
    public boolean isFinished() {
        return false;
    }
    public void stop(boolean interrupted) {}

    public Command andThen(Command nextCommand) {
        if (this.nextCommand == null) {
            this.nextCommand = nextCommand;
        } else {
            this.nextCommand.andThen(nextCommand);
        }
        return this;
    }

    public final Command getNextCommand() {
        return nextCommand;
    }

}
