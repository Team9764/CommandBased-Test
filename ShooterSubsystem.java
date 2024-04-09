// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */
  public final CANSparkMax smOne;
  public final CANSparkMax smTwo;

  public ShooterSubsystem() {
    smOne = new CANSparkMax(ShooterConstants.shootOne, MotorType.kBrushed);
    smTwo = new CANSparkMax(ShooterConstants.shootTwo, MotorType.kBrushed);
    
    smOne.setInverted(true);
    smTwo.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
