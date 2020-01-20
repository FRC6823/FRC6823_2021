package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

/**
 * This is a program used for repeated use of
 * trigonometry.
 */
public class Algebra extends TimedRobot {
    static public double ArcCalculation1 () { //lengths in feet
        double pd = 7/12; //Projectile diameter
        double dh = 6; //Horizontal Distance
        double h = 98.25/12; //height of target
        double th = 29.25/12; //Gap between holes
        double td = 2.5; //Diameter of Outer hole
        double g = 32.1740; //gravity
        double v = 10; //Launch velocity in ft/sec
        double h90 = ExponentVar(v, 2)/2*g; //height at 90 degree launch angle
        double rm = ExponentVar(v, 2)/g;
        double p = ExponentVar(h90, 2)/rm;
        double xd = (RootVar(h90-h, 2)/RootVar(p, 2));
        double theta1 = ArctangentVar((ExponentVar(v,2)+RootVar(ExponentVar(v,4)-g*(g*ExponentVar(xd, 2)+2*h*ExponentVar(v, 2)), 2))/g*xd);
        //double ymax = -1*p*ExponentVar(xmax, 2)*h90;
        double xd1 = xd - th;
        double xd1f = xd1 - dh;
        double d = xd1f;
        double a = -1*g/2*ExponentVar(v, 2)*ExponentVar(CosineVar(theta1), 2);
        double b = 2*(a*xd1f+TangentVar(theta1));
        double c = -(b*xd1f);
        double v1x = -1*(2*a*d+b)/2*a;
        double v1y = TangentVar(theta1)*(v1x-xd1f)+a*ExponentVar(v1x-xd1f, 2);
        //double ypath = TangentVar(theta1)*(x-xd1f)+a*ExponentVar(x-xd1f, 2);
        double a1 = theta1;
        double b1 = d*CosineVar(a1);
        double A1 = d*SineVar(a1);
        double Uwy = h+(td/2);
        double Uwx = xd1;
        double Lwy = h+(td/2);
        double Lwx = xd1;
        double Lpy1 = v1y - (pd/2);
        double Upy1 = v1y + (pd/2);
        double Lpx1 = xd1f + b1;
        double Upx1 = xd1f - b1;
        double Lp1 = -1 * ((A1+Lpy1)/ExponentVar(-1*v1x+Lpx1, 2))*ExponentVar(xd1-v1x, 2)+Lpy1;
        double Up1 = -1 * ((Upy1-A1)/ExponentVar(-1*v1x+Upx1, 2))*ExponentVar(xd1-v1x, 2)+Upy1;
        if(Lp1 > Lwy || Up1 < Uwy){
            return theta1;
        }else{
            return 0;
        }
    }
    static public double ArcCalculation2 () { //lengths in feet
        double pd = 7/12; //Projectile diameter
        double dh = 6; //Horizontal Distance
        double h = 98.25/12; //height of target
        double th = 29.25/12; //Gap between holes
        double td = 2.5; //Diameter of Outer hole
        double g = 32.1740; //gravity
        double v = 10; //Launch velocity in ft/sec
        double h90 = ExponentVar(v, 2)/2*g; //height at 90 degree launch angle
        double rm = ExponentVar(v, 2)/g;
        double p = ExponentVar(h90, 2)/rm;
        double xd = (RootVar(h90-h, 2)/RootVar(p, 2));
        double theta2 = ArctangentVar((ExponentVar(v,2)-RootVar(ExponentVar(v,4)-g*(g*ExponentVar(xd, 2)+2*h*ExponentVar(v, 2)), 2))/g*xd);
        //double ymax = -1*p*ExponentVar(xmax, 2)*h90;
        double xd1 = xd - th;
        double xd1f = xd1 - dh;
        double d = xd1f;
        double a = -1*g/2*ExponentVar(v, 2)*ExponentVar(CosineVar(theta2), 2);
        double b = 2*(a*xd1f+TangentVar(theta2));
        double c = -(b*xd1f);
        double v1x = -1*(2*a*d+b)/2*a;
        double v1y = TangentVar(theta2)*(v1x-xd1f)+a*ExponentVar(v1x-xd1f, 2);
        //double ypath = TangentVar(theta1)*(x-xd1f)+a*ExponentVar(x-xd1f, 2);
        double a1 = theta2;
        double b1 = d*CosineVar(a1);
        double A1 = d*SineVar(a1);
        double Uwy = h+(td/2);
        double Uwx = xd1;
        double Lwy = h+(td/2);
        double Lwx = xd1;
        double Lpy1 = v1y - (pd/2);
        double Upy1 = v1y + (pd/2);
        double Lpx1 = xd1f + b1;
        double Upx1 = xd1f - b1;
        double Lp1 = -1 * ((A1+Lpy1)/ExponentVar(-1*v1x+Lpx1, 2))*ExponentVar(xd1-v1x, 2)+Lpy1;
        double Up1 = -1 * ((Upy1-A1)/ExponentVar(-1*v1x+Upx1, 2))*ExponentVar(xd1-v1x, 2)+Upy1;
        if(Lp1 > Lwy || Up1 < Uwy){
            return theta2;
        }else{
            return 0;
        }
    }
    static public double SineVar(double theta) {
      double answer = Math.sin(theta);
      return answer;
    }
    static public double CosineVar(double theta) {
      double answer = Math.cos(theta);
      return answer;
    }
    static public double TangentVar(double theta) {
        double answer = Math.tan(theta);
        return answer;
    }
    static public double ArctangentVar(double theta) {
        double answer = Math.atan(theta);
        return answer;
    }
    static public double RootVar(double base, double n) {
        double answer = Math.pow(base, (1/n));
        return answer;
    }
    static public double ExponentVar(double theta, double power) {
        double answer = Math.pow(theta, power);
        return answer;
    }
}