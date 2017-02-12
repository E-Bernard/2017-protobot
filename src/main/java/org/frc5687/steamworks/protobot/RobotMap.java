package org.frc5687.steamworks.protobot;

/**
 * Created by Ben Bernard on 1/12/2017.
 */

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    /**
     * Drive Train ports
     */
    public static class Drive {

        public static final int RIGHT_MOTOR_FRONT = 0;
        public static final int RIGHT_MOTOR_REAR = 1;
        public static final int RIGHT_MOTOR_TOP = 2;

        public static final int LEFT_MOTOR_FRONT = 3;
        public static final int LEFT_MOTOR_REAR = 4;
        public static final int LEFT_MOTOR_TOP = 5;

        public static final int PDP_RIGHT_MOTOR_FRONT = 12;
        public static final int PDP_RIGHT_MOTOR_TOP = 12;
        public static final int PDP_RIGHT_MOTOR_REAR = 13;

        public static final int PDP_LEFT_MOTOR_FRONT = 14;
        public static final int PDP_LEFT_MOTOR_TOP = 14;
        public static final int PDP_LEFT_MOTOR_REAR = 15;

        // Encoder channel ports as of 03/02, left reversed with right
        public static final int LEFT_ENCODER_CHANNEL_A = 6;
        public static final int LEFT_ENCODER_CHANNEL_B = 7;
        public static final int RIGHT_ENCODER_CHANNEL_A = 8;
        public static final int RIGHT_ENCODER_CHANNEL_B = 9;
        public static final int IR_DRIVE_SENSOR = 1;
    }

    /**
     * Gear Handler ports
     */
    public static class GearHandler {
        public static final int GEAR_MOTOR = 6;
        public static final int MAX_EXTENSION_HALL = 2; //TODO Change to ports on robot
        public static final int MIN_EXTENSION_HALL = 1;
        public static final int GEAR_POTENTIOMETER = 3;
        public static final int PDP_GEAR_MOTOR = 12;
     }

    /**
     * Pneumatics ports
     */
    public static class Pneumatics {
        public static final int PISTON_EXTENDER = 1;
        public static final int PISTON_RETRACTOR = 0;
    }

    public static class Shifter {
        public static final int PISTON_EXTENDER = 5;
        public static final int PISTON_RETRACTOR = 4;
    }

    /**
     * Climber ports
     */
    public static class Climber {
        public static final int CLIMBER_MOTOR = 7;
        public static final int PDP_CLIMBER_MOTOR = 0;
    }
}
