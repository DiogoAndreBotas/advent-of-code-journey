package twentytwentyone.day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoordinateRange {
    Coordinate coordinateStart;
    Coordinate coordinateEnd;

    public CoordinateRange(Coordinate coordinateStart, Coordinate coordinateEnd) {
        this.coordinateStart = coordinateStart;
        this.coordinateEnd = coordinateEnd;
    }

    public List<Coordinate> getCoordinateRange() {
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(coordinateStart);
        coordinates.add(coordinateEnd);

        int xStart = coordinateStart.x, xEnd = coordinateEnd.x;
        int yStart = coordinateStart.y, yEnd = coordinateEnd.y;

        if (xStart == xEnd) {
            if (yStart > yEnd) {
                for (int idx = yStart - 1; idx > yEnd; idx--) {
                    coordinates.add(new Coordinate(xStart, idx));
                }
            }
            else {
                for (int idx = yStart + 1; idx < yEnd; idx++) {
                    coordinates.add(new Coordinate(xStart, idx));
                }
            }
        }
        else if (yStart == yEnd) {
            if (xStart > xEnd) {
                for (int idx = xStart - 1; idx > xEnd; idx--) {
                    coordinates.add(new Coordinate(idx, yStart));
                }
            }
            else {
                for (int idx = xStart + 1; idx < xEnd; idx++) {
                    coordinates.add(new Coordinate(idx, yStart));
                }
            }
        }
        else
            return Collections.emptyList();

        return coordinates;
    }

}
