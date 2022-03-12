package KE2.car;
import KE2.car.Car;

public class RealCar implements Car{
  private double power;

  public RealCar(double p){
    this.power = p;
  }

  public String realMotorPowerInKiloWatt(){
    return "Car: My power is " + power + " KW!";
  }

  public void tunePower(){
    this.power = power*1.2;
  }

}