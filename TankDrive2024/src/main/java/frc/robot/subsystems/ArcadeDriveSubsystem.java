// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;





import java.security.spec.EncodedKeySpec;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArcadeDriveSubsystem extends SubsystemBase {
  
  public ArcadeDriveSubsystem() {}

  private final CANSparkMax LEFT1 = new CANSparkMax(13, MotorType.kBrushed);
  private final CANSparkMax LEFT2 = new CANSparkMax(11, MotorType.kBrushed); 
  private final CANSparkMax RIGHT1 = new CANSparkMax(9, MotorType.kBrushed); 
  private final CANSparkMax RIGHT2 = new CANSparkMax(14, MotorType.kBrushed); 

  private final Encoder encoder1 = new Encoder(0, 1);

  public void arcadeDrive (double speed, double rotation){
   LEFT1.set(speed - rotation);    LEFT2.set(speed - rotation);
   RIGHT1.set(speed + rotation);    RIGHT2.set(speed + rotation);
  }
  
  public double getPosition()
  {
    return -encoder1.getDistance();
  }

  public void resetEncoders()
  {
    encoder1.reset();
  }
  
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
