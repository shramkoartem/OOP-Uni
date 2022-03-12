package KE2.car;
import KE2.car.Car;
import KE2.car.RealCar;

public class CarFactory{
  public Car giveMeACar(){
    return new RealCar(98);
  }
}