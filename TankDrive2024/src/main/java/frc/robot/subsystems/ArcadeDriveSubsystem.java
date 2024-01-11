// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArcadeDriveSubsystem extends SubsystemBase {
  
  public ArcadeDriveSubsystem() {}

  private final CANSparkMax CAN1 = new CANSparkMax(1, MotorType.kBrushless);
  private final CANSparkMax CAN2 = new CANSparkMax(2, MotorType.kBrushless); 
  private final CANSparkMax CAN3 = new CANSparkMax(3, MotorType.kBrushless); 
  private final CANSparkMax CAN4 = new CANSparkMax(4, MotorType.kBrushless); 
  
  
  
  
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
