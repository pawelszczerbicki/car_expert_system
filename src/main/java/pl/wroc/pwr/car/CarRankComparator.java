package pl.wroc.pwr.car;

import java.util.Comparator;

/**
 * Created by Pawel on 09.01.14.
 */
public class CarRankComparator implements Comparator<CarRank> {
    @Override
    public int compare(CarRank o1, CarRank o2) {
        Double rank = o1.getRank() - o2.getRank();
        if (rank < 0)
            return -1;
        else if (rank > 0) return 1;

        return 0;
    }
}
