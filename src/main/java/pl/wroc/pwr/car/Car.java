package pl.wroc.pwr.car;

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
    private Integer doors;
    private String photo = "/resources/img/mazda.jpeg";
    private List<Feature> features = new ArrayList<>();

    public Car(String make, String model, Double price, Double fuelConsumption, Integer maxSpeed, Double acceleration, Double horsePower, Double moment, Double capacity, Integer doors, Feature... features) {
        this.make = make;
        this.model = model;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
        this.horsePower = horsePower;
        this.moment = moment;
        this.capacity = capacity;
        this.doors = doors;
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

    public String getPhoto() {
        return photo;
    }

    public Integer getDoors() {
        return doors;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public boolean hasFeature(Feature f) {
        return features.contains(f);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (acceleration != null ? !acceleration.equals(car.acceleration) : car.acceleration != null) return false;
        if (capacity != null ? !capacity.equals(car.capacity) : car.capacity != null) return false;
        if (doors != null ? !doors.equals(car.doors) : car.doors != null) return false;
        if (features != null ? !features.equals(car.features) : car.features != null) return false;
        if (fuelConsumption != null ? !fuelConsumption.equals(car.fuelConsumption) : car.fuelConsumption != null)
            return false;
        if (horsePower != null ? !horsePower.equals(car.horsePower) : car.horsePower != null) return false;
        if (make != null ? !make.equals(car.make) : car.make != null) return false;
        if (maxSpeed != null ? !maxSpeed.equals(car.maxSpeed) : car.maxSpeed != null) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        if (moment != null ? !moment.equals(car.moment) : car.moment != null) return false;
        if (photo != null ? !photo.equals(car.photo) : car.photo != null) return false;
        if (price != null ? !price.equals(car.price) : car.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = make != null ? make.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (fuelConsumption != null ? fuelConsumption.hashCode() : 0);
        result = 31 * result + (maxSpeed != null ? maxSpeed.hashCode() : 0);
        result = 31 * result + (acceleration != null ? acceleration.hashCode() : 0);
        result = 31 * result + (horsePower != null ? horsePower.hashCode() : 0);
        result = 31 * result + (moment != null ? moment.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        result = 31 * result + (doors != null ? doors.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (features != null ? features.hashCode() : 0);
        return result;
    }
}
