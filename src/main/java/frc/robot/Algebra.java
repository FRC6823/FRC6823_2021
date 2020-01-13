package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

/**
 * This is a program used for repeated use of
 * trigonometry.
 */
public class Algebra extends TimedRobot {
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
}