/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
//test change
package frc.robot;


/**
 * Do NOT add any static variables to this class, or any initialization at all.
 * Unless you know what you are doing, do not modify this file except to
 * change the parameter class to the startRobot call.
 */
public final class Main {
  private Main() {
    
  }
  public double SineVar(double theta) {
    double answer = Math.sin(theta);
    return answer;
  }
  public double CosineVar(double theta) {
    double answer = Math.cos(theta);
    return answer;
  }
  public double TangentVar(double theta) {
      double answer = Math.tan(theta);
      return answer;
  }
  public double ArctangentVar(double theta) {
      double answer = Math.atan(theta);
      return answer;
  }
  public double RootVar(double theta, double base) {
      double answer = Math.pow(theta, (1/base));
      return answer;
  }
  public double ExponentVar(double theta, double power) {
      double answer = Math.pow(theta, power);
      return answer;
  }
  /**
   * Main initialization function. Do not perform any initialization here.
   *
   * <p>If you change your main robot class, change the parameter type.
   */
}
