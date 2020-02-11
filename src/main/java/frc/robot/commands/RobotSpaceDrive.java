package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.JoystickHandler;
import frc.robot.Robot;
import frc.robot.subsystems.SwerveDriveSubsystem;

import java.util.function.DoubleSupplier;

public class RobotSpaceDrive extends CommandBase {
    // The subsystem the command runs on
    private final SwerveDriveSubsystem swerveDrive;
    private JoystickHandler joystickHandler;

    public RobotSpaceDrive(SwerveDriveSubsystem subsystem, JoystickHandler joystickHandler) {
        this.swerveDrive = subsystem;
        this.joystickHandler = joystickHandler;

        addRequirements(swerveDrive);
    }

    @Override
    public void execute() {
        double speedRate = Robot.PREFS.getDouble("SpeedRate", 1);
        double turnRate = Robot.PREFS.getDouble("TurnRate", 1);

        double xval = joystickHandler.getAxis1() * speedRate;
        double yval = joystickHandler.getAxis0() * speedRate;
        double spinval = joystickHandler.getAxis2() * turnRate;

        swerveDrive.drive(xval, yval, spinval);// zoooooom
    }
}