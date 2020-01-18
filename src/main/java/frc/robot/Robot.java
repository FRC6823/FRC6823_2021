/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import com.revrobotics.ColorSensorV3;

public class ColorSensor {
  private Joystick driveStick;
  private I2C.Port i2cPort = I2C.Port.kOnboard;
  private ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
  private double red;
  private double green;
  private double blue;

  // wheel of fortune
  private PWMVictorSPX spinner;
  private boolean moving = false;

  //color sensor
  private double error = 0.09;
  private String[] colors = { "blue", "green", "red", "yellow" };
  private int colorSelection = 0;
  private double distanceMotorSpins = 0;

  // PID Controller Related Shit
  private PIDController pidcontroller;

  @Override
  public void robotInit() {
    pidcontroller = new PIDController(0.2, 0, 0);
    spinner = new PWMVictorSPX(5);
    driveStick = new Joystick(0);
    pidcontroller.enableContinuousInput(0, 1);
  }

  @Override
  public void teleopPeriodic() {
    Color detectedColor = colorSensor.getColor();
    red = detectedColor.red;
    green = detectedColor.green;
    blue = detectedColor.blue;
    // cycles through the colors
    if (driveStick.getRawButtonPressed(10) && !moving) {
      if (colorSelection == colors.length - 1) {
        colorSelection = 0;
      } else {
        colorSelection++;
      }

    }

    if (driveStick.getRawButtonPressed(11) || moving) {
      distanceMotorSpins = NextDistanceSpun();
      if (!colorSelected().equals("unknown"))
        spinner.set(distanceMotorSpins);// you can tell I have no idea what I am doing
      if (distanceMotorSpins != 0) {
        moving = true;
      } else {
        moving = false;
      }
    }
    SmartDashboard.putString("Looking for", colors[colorSelection]);
    SmartDashboard.putString("Color I see", colorSeen());
    SmartDashboard.putString("Color selected", colorSelected());
    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("Distance motor spins", distanceMotorSpins);

    // PID Color Controller
    if (driveStick.getRawButtonPressed(12)) {

    }
  }

  // returns if the rgb of two colors is within the errorValue
  public boolean closeEnough(String color) {
    if (color.equals("red")) {
      return Math.abs(red - 0.507568) <= error && Math.abs(green - 0.355225) <= error
          && Math.abs(blue - 0.136963) <= error;
    } else if (color.equals("green")) {
      return Math.abs(red - 0.163574) <= error && Math.abs(green - 0.584473) <= error
          && Math.abs(blue - 0.251953) <= error;
    } else if (color.equals("blue")) {
      return Math.abs(red - 0.118164) <= error && Math.abs(green - 0.426758) <= error
          && Math.abs(blue - 0.455078) <= error;
    } else {
      return Math.abs(red - 0.312256) <= error && Math.abs(green - 0.566162) <= error
          && Math.abs(blue - 0.121338) <= error;
    }
  }

  // returns the color the color sensor see
  public String colorSeen() {
    for (int i = 0; i < colors.length; i++) {
      if (closeEnough(colors[i])) {
        return colors[i];
      }
    }
    return "unknown";
  }

  public String colorSelected() {
    if (colorSeen().equals("red")) {
      return "blue";
    } else if (colorSeen().equals("blue")) {
      return "red";
    } else if (colorSeen().equals("green")) {
      return "yellow";
    } else if (colorSeen().equals("unknown")) {
      return "unknown";
    } else {
      return "green";
    }
  }

  public double convertToNumber(String color) {
    if (color.equals("yellow")) {
      return 0;
    } else if (color.equals("blue")) {
      return 0.25;
    } else if (color.equals("green")) {
      return 0.5;
    } else {
      return 0.75;
    }
  }

  public double NextDistanceSpun() {
    double setpoint = convertToNumber(colors[colorSelection]);
    pidcontroller.setSetpoint(setpoint);
    return pidcontroller.calculate(convertToNumber(colorSelected()), setpoint);
  }

  //ColorSensor Methods


}