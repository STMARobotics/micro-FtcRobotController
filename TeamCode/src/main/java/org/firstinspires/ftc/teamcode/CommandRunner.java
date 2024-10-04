package org.firstinspires.ftc.teamcode;

public class CommandRunner {

    private static CommandRunner instance;

    private Command runningCommand;

    private CommandRunner() {}

    public static CommandRunner getInstance() {
        if (instance == null) {
            instance = new CommandRunner();
        }
        return instance;
    }

    public void startCommand(Command command) {
        if (runningCommand != null) {
            runningCommand.stop(true);
        }
        runningCommand = command;
        command.init();
    }

    public void run() {
        if (runningCommand == null) {
            return;
        }
        runningCommand.loop();
        if (runningCommand.isFinished()) {
            runningCommand.stop(false);
            Command nextCommand = runningCommand.getNextCommand();
            runningCommand = null;
            startCommand(nextCommand);
        }
    }

    public void stopCommand() {
        if (runningCommand == null) {
            return;
        }
        runningCommand.stop(true);
        runningCommand = null;
    }

}
