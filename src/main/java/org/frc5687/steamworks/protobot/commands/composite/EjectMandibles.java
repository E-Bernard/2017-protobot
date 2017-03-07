package org.frc5687.steamworks.protobot.commands.composite;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc5687.steamworks.protobot.OI;
import org.frc5687.steamworks.protobot.commands.actions.HoldMandiblesOpen;
import org.frc5687.steamworks.protobot.commands.actions.OpenMandibles;
import org.frc5687.steamworks.protobot.commands.actions.WaitForButtonRelease;

import static org.frc5687.steamworks.protobot.Robot.mandibles;

public class EjectMandibles extends CommandGroup {

    public EjectMandibles() {
        addSequential(new OpenMandibles());
        addSequential(new HoldMandiblesOpen(250));
    }
}