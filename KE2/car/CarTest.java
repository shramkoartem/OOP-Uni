package KE2.car;
import KE2.car.RealCar;
import KE2.car.Car;
import KE2.car.CarFactory;

public class CarTest{
  public static void main(String[] args){
    CarFactory factory = new CarFactory();
    Car car = factory.giveMeACar();
    car.realMotorPowerInKiloWatt();
    
    
    RealCar realCar = (RealCar) car;
    realCar.tunePower();
    System.out.println(car.realMotorPowerInKiloWatt());
  }
}