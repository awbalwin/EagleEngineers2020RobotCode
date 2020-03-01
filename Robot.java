

package frc.robot;

import com.revrobotics.*;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends TimedRobot {
  private static final int _1 = 1;
  // name the victor talons so they each have an id number, left1 means first
  // motor on left
  WPI_Spark left1 = new WPI_Spark(1);
  WPI_Spark left2 = new WPI_Spark(2);
  WPI_Spark right1 = new WPI_Spark(3);
  WPI_Spark right2 = new WPI_Spark(4);

  //hook left contrlloerstogether and righ controllers together
  SpeedControllerGroup left = new SpeedControllerGroup(left1, left2);
  SpeedControllerGroup right = new SpeedControllerGroup(right1, right2);

  DifferentialDrive mainDrive = new DifferentialDrive(left, right);

  Joystick driver = new Joystick(0);

  CameraServer camera = CameraServer.getInstance();
  {camera.startAutomaticCapture ("cam0",0);};
//code that runs only when the robot boots up
  @Override
  public void robotInit() {
  
  }
  
  @Override
  public void robotPeriodic() {
  }
  
  @Override
  public void autonomousInit() {
  
  }
  
  @Override
  public void autonomousPeriodic() {
    teleopPeriodic();
  }

  //code that runs when the robot is being driven
  @Override
  public void teleopPeriodic() {
    double x = driver.getRawAxis(0);
    int i = 1;
	double y = -driver.getRawAxis(i);
    if(Math.abs(x) >=0.1 || Math.abs(y) >=0.1) {
      mainDrive.arcadeDrive(y, x);
    } else {
      mainDrive.arcadeDrive(0,0);
    }
    if(driver.getRawButton(1)){
      middle1.set(0.5);
    }  else
    if(driver.getRawButton(2)){
      middle1.set(-0.5);
    } else {
      middle1.set(0);
    }
    
  }

  
  @Override
  public void testPeriodic() {
  }
}
