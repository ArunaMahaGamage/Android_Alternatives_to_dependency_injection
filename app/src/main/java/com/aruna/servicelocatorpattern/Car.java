package com.aruna.servicelocatorpattern;

public class Car {

    private Engine engine = ServiceLocator.getInstance().getEngine();

    public void start() {
        engine.start();
    }
}
