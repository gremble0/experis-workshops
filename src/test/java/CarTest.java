package com.booleanuk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {
  @Test
  public void testCarIsGreen() {
    Car car = new Car("green", new Battery(false), new Controls(false));
    Assertions.assertEquals(car.getColor(), "green");
  }

  @Test
  public void testCarBatteriesRechargability() {
    Car car = new Car("green", new Battery(false), new Controls(false));
    Assertions.assertFalse(car.getBattery().isRechargable());

    Car car = new Car("green", new Battery(true), new Controls(false));
    Assertions.assertTrue(car.getBattery().isRechargable());
  }

  @Test
  public void testCarAdvancedControls() {
    Car car = new Car("green", new Battery(false), new Controls(false));
    Assertions.assertFalse(car.getControls().isAdvanced());

    Car car = new Car("green", new Battery(false), new Controls(true));
    Assertions.assertTrue(car.getControls().isAdvanced());
  }

  @Test
  public void testCarBatteryCharge() {
    Car car = new Car("green", new Battery(false), new Controls(false));
    Assertions.assertEquals(100, car.getBattery().getRemainingCharge());
  }

  @Test
  public void testCarDrive() {
    Car car = new Car("green", new Battery(false), new Controls(false));
    Location start = car.getLocation();
    car.getControls().setDirection(Direction.Right);
    car.getControls().drive(100, car.getLocation());
    Assertions.assertEquals(start.x + 100, car.getLocation().x);
    Assertions.assertEquals(start.y, car.getLocation().y);
    Assertions.assertEquals(start.z, car.getLocation().z);
  }

  @Test
  public void testCarBrakes() {
    Car car = new Car("green", new Battery(false), new Controls(false));
    Location start = car.getLocation();
    car.getControls().brake();
    Assertions.assertFalse(car.getControls().isMoving());
    Assertions.assertEquals(start.x, car.getLocation().x);
    Assertions.assertEquals(start.y, car.getLocation().y);
    Assertions.assertEquals(start.z, car.getLocation().z);
  }

  @Test
  public void testCarTurning() {
    Car car = new Car("green", new Battery(false), new Controls(false));
    car.getControls().turnLeft();
    Assertions.assertEquals(car.getControls().getDirection(), Direction.Left);
    car.getControls().turnLeft();
    Assertions.assertEquals(car.getControls().getDirection(), Direction.Down);
    car.getControls().turnRight();
    Assertions.assertEquals(car.getControls().getDirection(), Direction.Left);
  }

  @Test
  public void testCarReplaceBattery() {
    Battery oldBattery = new Battery(false);
    Battery newBattery = new Battery(false);
    Car car = new Car("green", oldBattery, new Controls(false));
    Assertions.assertEquals(car.getBattery(), oldBattery);
    car.replaceBattery(newBattery);
    Assertions.assertEquals(car.getBattery(), newBattery);
  }
}
