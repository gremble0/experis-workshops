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
}
