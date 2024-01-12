// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ArcadeDriveSubsystem;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class AutonDriveCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ArcadeDriveSubsystem m_subsystem;
  private final double setPoint;
  private final PIDController pidController = new PIDController(0.1, 0, 0);

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public AutonDriveCommand(ArcadeDriveSubsystem subsystem, double setPoint) {
    m_subsystem = subsystem;
    this.setPoint = setPoint;

    m_subsystem.resetEncoders();

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  @Override
  public void execute() {
    double speed = pidController.calculate(m_subsystem.getPosition() * Constants.OperatorConstants.ticksToFeet, setPoint);

    m_subsystem.arcadeDrive(speed, 0);

    SmartDashboard.putNumber("pid speed/error", speed);
    SmartDashboard.putNumber("Position", m_subsystem.getPosition() * Constants.OperatorConstants.ticksToFeet);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
