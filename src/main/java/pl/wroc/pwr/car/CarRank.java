package pl.wroc.pwr.car;

/**
 * Created by Pawel on 09.01.14.
 */
public class CarRank{

    private Car car;
    private Integer rank;

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
}
