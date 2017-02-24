package org.frc5687.steamworks.protobot.commands.actions;

import edu.wpi.first.wpilibj.command.Command;
import org.frc5687.steamworks.protobot.Constants;
import static org.frc5687.steamworks.protobot.Robot.climber;

/**
 * Created by Caleb on 1/28/2017.
 */
public class ReleaseFunnel extends Command {

    private long endTime;

    public ReleaseFunnel() {
        requires(climber);
    }

    protected void initialize(){
        endTime = System.currentTimeMillis() + Constants.Climber.FUNNEL_RELEASE_TIME;
    }

    protected void execute(){
        climber.setSpeed(Constants.Climber.FUNNEL_RELEASE_SPEED);
    }

    protected boolean isFinished(){
        return System.currentTimeMillis() > endTime;
    }

    protected void end() {
        climber.stop();
    }

}