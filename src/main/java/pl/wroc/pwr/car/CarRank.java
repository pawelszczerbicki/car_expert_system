package pl.wroc.pwr.car;

import java.util.List;

/**
 * Created by Pawel on 09.01.14.
 */
public class CarRank {

    private Car car;
    private Integer rank;
    private List<String> pluses;
    private List<String> minuses;

    public CarRank(Car car, Double rank) {
        this.car = car;
        this.rank = rank.intValue();
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public List<String> getPluses() {
        return pluses;
    }

    public void setPluses(List<String> pluses) {
        this.pluses = pluses;
    }

    public List<String> getMinuses() {
        return minuses;
    }

    public void setMinuses(List<String> minuses) {
        this.minuses = minuses;
    }

    public void addPlus(String plus) {
        pluses.add(plus);
    }

    public void addMinus(String minus) {
        minuses.add(minus);
    }
}
