package com.booleanuk;

public class TrafficLight {
    private TrafficLightColor previousColor;
    private TrafficLightColor color;

    private enum TrafficLightColor {
        Green,
        Yellow,
        Red,
    }

    public boolean canGo() {
        return this.color == TrafficLightColor.Green;
    }

    public void nextState() {
        switch (this.color) {
            case Green:
                this.color = TrafficLightColor.Yellow;
                break;
            case Red:
                this.color = TrafficLightColor.Yellow;
                break;
            case Yellow:
                if (this.previousColor == TrafficLightColor.Red)
                    this.color = TrafficLightColor.Green;
                else
                    this.color = TrafficLightColor.Red;
                break;
        }
    }
}
