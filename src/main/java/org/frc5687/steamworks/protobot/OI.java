package org.frc5687.steamworks.protobot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.frc5687.steamworks.protobot.commands.actions.*;
import org.frc5687.steamworks.protobot.commands.composite.DeployPincers;
import org.frc5687.steamworks.protobot.commands.composite.EjectMandibles;
import org.frc5687.steamworks.protobot.commands.composite.ReleasePincers;
import org.frc5687.steamworks.protobot.utils.Gamepad;
import org.frc5687.steamworks.protobot.utils.Helpers;

/**
 * The operator interface class handles communication with the driver station
 */
public class OI {

    public static final int GP_EJECT_MANDIBLES = 8;
    public static final int GP_RECEIVE_MANDIBLES = 7;

    public static final int OPEN_PINCERS = 5;
    public static final int CLOSE_PINCERS = 6;

    public static final int OC_DEPLOY_PINCERS = 3;
    public static final int GP_DEPLOY_PINCERS = Gamepad.Buttons.X.getNumber();

    public static final int OC_RELEASE_PINCERS = 5;
    public static final int GP_RELEASE_PINCERS = Gamepad.Buttons.Y.getNumber();

    public static final int RINGLIGHT_ON = 11;
    public static final int RINGLIGHT_OFF = 12;

    public static final int OC_RECEIVE_MANDIBLES = 4;
    public static final int OC_EJECT_MANDIBLES = 6;


    public static final int WIGGLE_MANDIBLES = 9;

    public static final int GIMME_LEFT = Gamepad.Buttons.LEFT_STICK.getNumber();
    public static final int GIMME_RIGHT = Gamepad.Buttons.RIGHT_STICK.getNumber();

    private Gamepad gamepad;
    private Joystick operatorConsole;

    public JoystickButton gpEjectMandiblesButton;
    public JoystickButton gpReceiveMandiblesButton;

    public JoystickButton ocReceiveMandiblesButton;
    public JoystickButton ocEjectMandiblesButton;

    public JoystickButton ocDeployPincers;
    public JoystickButton gpDeployPincers;

    public JoystickButton ocReleasePincers;
    public JoystickButton gpReleasePincers;

    private JoystickButton ascendClimber;
    private JoystickButton descendClimber;

    private JoystickButton shiftLow;
    private JoystickButton shiftHigh;

    private JoystickButton openPincers;
    private JoystickButton closePincers;

    private JoystickButton ringLightOn;
    private JoystickButton ringLightOff;

    private JoystickButton gearWiggle;

    private JoystickButton gimmeGearLeft;
    private JoystickButton gimmeGearRight;

    public OI() {
        gamepad = new Gamepad(0);
        operatorConsole = new Joystick(1);

        /*
         * X Box Gamepad Buttons
         */

        ascendClimber = new JoystickButton(gamepad, Gamepad.Buttons.Y.getNumber());
        descendClimber = new JoystickButton(gamepad, Gamepad.Buttons.X.getNumber());

        shiftLow = new JoystickButton(gamepad, Gamepad.Buttons.LEFT_BUMPER.getNumber());
        shiftHigh = new JoystickButton(gamepad, Gamepad.Buttons.RIGHT_BUMPER.getNumber());

        gpEjectMandiblesButton = new JoystickButton(gamepad, GP_EJECT_MANDIBLES);
        gpReceiveMandiblesButton = new JoystickButton(gamepad, GP_RECEIVE_MANDIBLES);

        gpDeployPincers = new JoystickButton(gamepad, GP_DEPLOY_PINCERS);
        gpReleasePincers = new JoystickButton(gamepad, GP_RELEASE_PINCERS);

        /*
         * Operator Console Buttons
         */

        openPincers = new JoystickButton(operatorConsole, OPEN_PINCERS);
        closePincers = new JoystickButton(operatorConsole, CLOSE_PINCERS);

        ringLightOn = new JoystickButton(operatorConsole, RINGLIGHT_ON);
        ringLightOff = new JoystickButton(operatorConsole, RINGLIGHT_OFF);

        ocReceiveMandiblesButton = new JoystickButton(operatorConsole, OC_RECEIVE_MANDIBLES);
        ocEjectMandiblesButton = new JoystickButton(operatorConsole, OC_EJECT_MANDIBLES);

        ocDeployPincers = new JoystickButton(operatorConsole, OC_DEPLOY_PINCERS);
        ocReleasePincers = new JoystickButton(operatorConsole, OC_RELEASE_PINCERS);


        /*
         * Button Functions
         */

        shiftHigh.whenPressed(new Shift(DoubleSolenoid.Value.kForward));
        shiftLow.whenPressed(new Shift(DoubleSolenoid.Value.kReverse));

        gpReceiveMandiblesButton.whenPressed(new ReceiveMandibles());
        gpEjectMandiblesButton.whenPressed(new EjectMandibles());

        ocReceiveMandiblesButton.whenPressed(new ReceiveMandibles());
        ocEjectMandiblesButton.whenPressed(new EjectMandibles());

//        openPincers.whenPressed(new ClosePincers());
//        closePincers.whenPressed(new OpenPincers());

        ocDeployPincers.whenPressed(new DeployPincers());
        gpDeployPincers.whenPressed(new DeployPincers());

        ocReleasePincers.whenPressed(new ReleasePincers());
        gpReleasePincers.whenPressed(new ReleasePincers());

        ringLightOn.whenPressed(new EnableRingLight());
        ringLightOff.whenPressed(new DisableRingLight());

        gimmeGearLeft = new JoystickButton(gamepad, GIMME_LEFT);
        gimmeGearRight = new JoystickButton(gamepad, GIMME_RIGHT);

        gimmeGearLeft.whenPressed(new GimmeGear());
        gimmeGearRight.whenPressed(new GimmeGear());

    }

    private double transformStickToSpeed(Gamepad.Axes stick) {
        double result = gamepad.getRawAxis(stick) * -1;
        result = Helpers.applyDeadband(result, Constants.Deadbands.DRIVE_STICK);
        result = Helpers.applySensitivityTransform(result);
        return result;
    }

    public double getLeftSpeed() {
        double result = transformStickToSpeed(Gamepad.Axes.LEFT_Y);
        SmartDashboard.putNumber("OI/LeftSpeed", result);
        return result;
    }

    public double getRightSpeed() {
        double result = transformStickToSpeed(Gamepad.Axes.RIGHT_Y);
        SmartDashboard.putNumber("OI/RIghtSpeed", result);
        return result;
    }

    public boolean isLeftTriggerPressed() {
        return (gamepad.getRawAxis(Gamepad.Axes.LEFT_TRIGGER) > Constants.OI.TRIGGER_THRESHHOLD);
    }

    public boolean isRightTriggerPressed() {
        return (gamepad.getRawAxis(Gamepad.Axes.RIGHT_TRIGGER) > Constants.OI.TRIGGER_THRESHHOLD);
    }

    public boolean isGearInPressed() {
        return gpReceiveMandiblesButton.get();
    }

    public boolean isGearOutPressed() {
        return gpEjectMandiblesButton.get();
    }

    public boolean isAscendClimberPressed() {
        return ascendClimber.get();
    }

    public boolean isDescendClimberPressed() {
        return descendClimber.get();
    }

    public boolean isGearWigglePressed() {
        return ocReceiveMandiblesButton.get() || gpReceiveMandiblesButton.get();
    }

    public boolean isDeployPincersPressed() {
        return ocDeployPincers.get();
    }

    public boolean isEjectMandiblesPressed() {
        return ocEjectMandiblesButton.get() || gpEjectMandiblesButton.get();
    }

    public double getPincerSpeed() {
        double result = -operatorConsole.getAxis(Joystick.AxisType.kY);
        result = Helpers.applyDeadband(result, Constants.Deadbands.DRIVE_STICK);
        result *= 0.5;
        return result;
    }

    public boolean isGimmeGearPressed() {
        return gimmeGearLeft.get() || gimmeGearRight.get();
    }

    public boolean isgpButtonPressed(int gpButton) {
        return gamepad.getRawButton(gpButton);
    }

    public boolean isocButtonPressed(int ocButton) {
        return operatorConsole.getRawButton(ocButton);
    }
}
