package com.booleanuk;

public class TrafficLight {
    private TrafficLightColor color;

    private enum TrafficLightColor {
        Red,
        Yellow,
        Green,
    }

    public boolean canGo() {
        return this.color == TrafficLightColor.Green;
    }

    public void setGreen() {
        this.color = TrafficLightColor.Green;
    }

    public void setYellow() {
        this.color = TrafficLightColor.Yellow;
    }

    public void setRed() {
        this.color = TrafficLightColor.Red;
    }
}
