import java.util.List;
import java.util.Random;

public class MoveRandomlyWithWind implements MoveStrategy {
  @Override
  public Cell chooseNextLoc(List<Cell> possibleLocs, Actor currActor, List<Actor> otherActors) {
    int windx = WeatherReader.getInstance().windX;
    int windy = WeatherReader.getInstance().windY;

    int i = ((new Random()).nextInt(possibleLocs.size()) + windx) + (5*windy); // add wind x because its horizontal, add 5*windy since babycat only moves two tiles so it's two tiles left and two right so 5 makes vertial movement.
    return possibleLocs.get(i);
  }

  public String toString() {
    return "random movement with wind influence";
  }
}
