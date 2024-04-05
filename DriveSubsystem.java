// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveMotors;

public class DriveSubsystem extends SubsystemBase {

private final CANSparkMax rF = new CANSparkMax(DriveMotors.rFMotor, MotorType.kBrushed);
private final CANSparkMax rR = new CANSparkMax(DriveMotors.rRMotor, MotorType.kBrushed);
private final CANSparkMax lF = new CANSparkMax(DriveMotors.lFMotor, MotorType.kBrushed);
private final CANSparkMax lR = new CANSparkMax(DriveMotors.lRMotor, MotorType.kBrushed);

private final DifferentialDrive drive = new DifferentialDrive(rR, lR);

  public DriveSubsystem() {
    lF.follow(lR);
    rF.follow(rR);
  }

  public void arcadeDrive(double throttle, double rotation) {
    drive.arcadeDrive(-throttle, rotation, true);
  }
  
  
  
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
