// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.Constants.DriveConstants.ShooterConstants;
import frc.robot.Constants.DriveConstants.XboxPorts;
import frc.robot.commands.Autos;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
private final DriveSubsystem robotDrive = new DriveSubsystem();
private final ShooterSubsystem shoot = new ShooterSubsystem();

  CommandXboxController xbox1 = new CommandXboxController(XboxPorts.xbox1);
  CommandXboxController xbox2 = new CommandXboxController(XboxPorts.xbox2);
  public RobotContainer() {
    configureBindings();

    robotDrive.setDefaultCommand(new RunCommand(
      () -> 
      robotDrive.arcadeDrive(
        -xbox1.getLeftY(),
        xbox1.getRightX()),
      robotDrive));
      
  

  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    (xbox1.rightTrigger()).onTrue(new InstantCommand(
      () -> {shoot.smTwo.set(1);}
      )).onTrue(new WaitCommand(3.0).andThen(
        new InstantCommand(() -> 
            {shoot.smOne.set(1);}))
      ).onFalse(new InstantCommand(() -> {
        shoot.smOne.set(0);
        shoot.smTwo.set(0);
      }));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  //   // An example command will be run in autonomous

  // }
}
