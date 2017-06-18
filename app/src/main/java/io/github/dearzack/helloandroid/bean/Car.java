package io.github.dearzack.helloandroid.bean;

/**
 * Created by Zack on 2017/6/18.
 */

public class Car implements ICarInject{
    private Wheel wheel;
    private Engine engine;

    public Car(Wheel wheel, Engine engine) {
        this.wheel = wheel;
        this.engine = engine;
    }

    @Override
    public void bindEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void bindWheel(Wheel wheel) {
        this.wheel = wheel;
    }
}
