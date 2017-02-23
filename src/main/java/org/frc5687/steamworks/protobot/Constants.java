package org.frc5687.steamworks.protobot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * Created by Admin on 1/16/2017.
 */
public class Constants {

    public static boolean isTony = true;


    public class GearHandler {
        public static final double openSpeed = -.5;
        public static final double closeSpeed = .1;
        public static final double clampSpeed = .1;
        public static final long OPEN_TIME = 250;
        public static final double TONY_MAX_POT_LIMIT = 0.5;
        public static final double PROTOBOT_MAX_POT_LIMIT = 0.5;
        public static final double wiggleSpeed = 0.1; //TODO callibrate better speed and time
        public static final double wiggleTime = 60;
        public static final double wiggleTotalTime = 250;
    }

    public class Drive {
        public static final boolean LEFT_MOTORS_INVERTED = true;

        public static final boolean RIGHT_MOTORS_INVERTED = false;

        public static final double FULL_FORWARDS_SPEED = -1;
        public static final double FULL_BACKWARDS_SPEED = 1;
    }

    public class Deadbands {
        /**
         * Deadband threshold for drive joysticks
         */
        public static final double DRIVE_STICK = 0.15;
    }

    public class Limits {
        /***
         * Minimum time (in milliseconds) it should take to go from 0 to 1 (stop to full)
         */
        public static final int CYCLES_PER_SECOND = 50;
        public static final double TIME_OF_ACCEL = 250;

        /***
         * Maximum accelerations per cycle
         */
        public static final double ACCELERATION_CAP = TIME_OF_ACCEL / CYCLES_PER_SECOND * 100;
    }

    public class Calibration {
        /***
         * Controls the sensitivity algorithm.
         * 0 results in a linear control-to-speed relationship, while 1 results in cubed.
         *
         * NEVER SET ABOVE 1 OR BELOW 0
         */
        public static final double SENSITIVITY_FACTOR = .2;
    }

    public class Encoders {

        public class Defaults {
            public static final boolean REVERSED = true; //TODO change to new robot specifications
            public static final int SAMPLES_TO_AVERAGE = 20;
            public static final int PULSES_PER_ROTATION = 1440;
            public static final double WHEEL_DIAMETER = 6;
            public static final double INCHES_PER_ROTATION = Math.PI * WHEEL_DIAMETER;
            public static final double SCALAR_RATIO = 8;
            public static final double INCHES_PER_PULSE = INCHES_PER_ROTATION * SCALAR_RATIO / PULSES_PER_ROTATION;
            public static final double MAX_PERIOD = 5;
        }

        public class RightDrive {
            public static final boolean REVERSED = Defaults.REVERSED;
            public static final double INCHES_PER_PULSE = Encoders.Defaults.INCHES_PER_PULSE;
        }

        public class LeftDrive {
            public static final boolean REVERSED = Defaults.REVERSED;
            public static final double INCHES_PER_PULSE = Defaults.INCHES_PER_PULSE;
        }

    }

    public class Climber {
        public static final boolean MOTOR_INVERTED = true;
        public static final double ASCEND_SPEED = 1;
        public static final double FUNNEL_RELEASE_SPEED = 1;
        public static final long FUNNEL_RELEASE_TIME = 167;
    }

    public class OI{
        public static final double triggerThreshhold = 0.5; //TODO find actual when pressed value
    }

    public class Shifter {
        public static final long STOP_MOTOR_TIME = 120; //TODO find correct values
        public static final long SHIFT_TIME = 120; //TODO find correct values
    }

    public class Pincers {
        public static final double potentiometerLiftedTony = .006;
        public static final double potentiometerLiftedRhody = 0.386;
        public static final double potentiometerLoweredTony = .270;
        public static final double potentiometerLoweredRhody = 0.64;
        public static final double maxSpeed = 0.25;
        public class PID {
            public static final double MIN_INPUT = 0;
            public static final double MAX_INPUT = 1;
            public static final double kP = 1.5;
            public static final double kI = 0;
            public static final double kD = 0;
            public static final double TOLERANCE = 0.002;
        }
    }
    public class Misc {
        public static final double minProtobotIndicator = 1000;
        public static final double maxProtobotIndicator = 2000;
    }

    public class Auto {

        public static final double MIN_IMU_ANGLE = 0;
        public static final double MAX_IMU_ANGLE = 360;

        public class AnglesAndDistances {
            public static final double CROSS_BASELINE_DISTANCE = 100;
            public static final double CROSS_FIELD_DISTANCE = 0;
            public static final double RETREAT_DISTANCE = 18;
            public static final double DEPOSIT_GEAR_INITIAL_DISTANCE = 0;
            public static final double DEPOSIT_GEAR_TURN = 0;
            public static final double DEPOSIT_GEAR_FINAL_DISTANCE = 0;
            public static final double DEPOSIT_GEAR_CENTER_DISTANCE = 98;
            public class Rhody {
                public static final double TARGET_IR_READING = 700;
            }
            public class Tony {
                public static final double TARGET_IR_READING = 700;
            }
        }

        public class Align {
            public static final double kP = 0;
            public static final double kI = 0;
            public static final double kD = 0;
            public static final double TOLERANCE = 0;
            public static final double MAX_OUTPUT = 0;
            /*
             *time the angle must be on target for to be considered steady
             */
            public static final double STEADY_TIME = 200;
        }

        public class Drive {
            public static final double kP = -0.1;
            public static final double kI = 0;
            public static final double kD = -0.05;
            public static final double TOLERANCE = 0;
            public static final double MAX_OUTPUT = 0.1;
            public static final double SPEED = -0.7;
        }

        public class PositionRotor {
            public static final double zeroTarget = 0;
            public static final double oneTarget = 0;
            public static final double twoTarget = 0;
            public static final double threeTarget = 0;
            public static final double fourTarget = 0;
            public static final double fiveTarget = 0;
            public static final double tolerance = 0;
        }

        public class GearRotor {
            public static final double zeroTarget = 0;
            public static final double oneTarget = 0;
            public static final double twoTarget = 0;
            public static final double threeTarget = 0;
            public static final double tolerance = 0.1;
        }

        public class HopperRotor {
            public static final double zeroTarget = 0;
            public static final double oneTarget = 0;
            public static final double tolerance = 0;
        }

    }


    public static double pickConstant(double tonyValue, double protobotValue) {
        return isTony ? tonyValue : protobotValue;
    }

    public static int pickConstant(int tonyValue, int protobotValue) {
        return isTony ? tonyValue : protobotValue;
    }

    public static boolean pickConstant(boolean tonyValue, boolean protobotValue) {
        return isTony ? tonyValue : protobotValue;
    }

    public static long pickConstant(long tonyValue, long protobotValue) {
        return isTony ? tonyValue : protobotValue;
    }

}
