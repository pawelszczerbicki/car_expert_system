package pl.wroc.pwr;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Pawel on 04.01.14.
 */
public class Car {

    private String make;
    private String model;
    private Double price;
    private Double fuelConsumption;
    private Integer maxSpeed;
    private Double acceleration;
    private Double horsePower;
    private Double moment;
    private Double capacity;
    private Image photo;
    private List<Feature> features = new ArrayList<>();

    public Car(String make, String model, Double price, Double fuelConsumption, Integer maxSpeed, Double acceleration, Double horsePower, Double moment, Double capacity, Feature... features) {
        this.make = make;
        this.model = model;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
        this.horsePower = horsePower;
        this.moment = moment;
        this.capacity = capacity;
        this.features.addAll(Arrays.asList(features));
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Double getPrice() {
        return price;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public Double getAcceleration() {
        return acceleration;
    }

    public Double getHorsePower() {
        return horsePower;
    }

    public Double getMoment() {
        return moment;
    }

    public Double getCapacity() {
        return capacity;
    }

    public Image getPhoto() {
        return photo;
    }

    public List<Feature> getFeatures() {
        return features;
    }
}
