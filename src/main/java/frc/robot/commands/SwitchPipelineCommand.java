package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LimeLightSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class SwitchPipelineCommand extends CommandBase {
    private LimeLightSubsystem limeLightSubsystem;
    private boolean isFinished = false;
    private int pipeline;

    public SwitchPipelineCommand(LimeLightSubsystem limeLightSubsystem, int pipeline) {
        this.limeLightSubsystem = limeLightSubsystem;
        this.pipeline = pipeline;
        limeLightSubsystem.setPipeline(pipeline);
    }

    @Override
    public void execute() {
        limeLightSubsystem.setPipeline(pipeline);
        if (pipeline == 0)
            limeLightSubsystem.setServoAngle(65);
        else if (pipeline == 1)
            limeLightSubsystem.setServoAngle(15);
        isFinished = true;
    }

    @Override
    public void initialize() {
        limeLightSubsystem.setPipeline(pipeline);

    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

    @Override
    public void end(boolean inturrupted) {
        isFinished = false;
    }
}