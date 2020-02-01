/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;

import edu.wpi.first.wpilibj.Spark;

public class RGB {

  private Spark RGB;
// for testing purposes only remove this later

  private double test;

  /**
   * a constructer for the rgb which takes in a spark motor as a paramater
   * @param lights a spark motor
   */
  public RGB(Spark lights) {
    RGB = lights;
    test = -0.99;
  }
// for testing purposes only remove this later
  public void nextStep(){
    if (test == 0.99)
      test = -0.99;
    else
      test += 0.02;
    RGB.set(test);
  }
  public double getTest(){
      return test; 
  }


  public void setRed(){
      RGB.set(0.61 );
  }
    public void setBlue(){
      RGB.set(0.87);
  }
  public void setGreen(){
      RGB.set(0.77);
  }
  public void setYellow(){
      RGB.set(0.69);
  }
  public void setForestPallet(){
      RGB.set(-0.91);
  }
  public void setHeartbeatRed(){
      RGB.set(-0.25);
  }
  /**
   * Set the rgb to color1 color2 waves (look at the rev blinkin and they should be blue and yellow)
   */
  public void normalMode(){
    RGB.set(0.41);
  }
  public void setLimeLight(boolean locked){
      if(!locked)
        setForestPallet();
      else
        setHeartbeatRed();
  }
}