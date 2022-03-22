public class SteadyRun implements Strategy{
    double newPos;
    double steadySpeed;

    @Override
    public double runRace(Horse h) {
        System.out.println(h.getName() + " in " + h.getColor() + " is employing Steady Run strategy at speed " + h.getSpeed() + ".");
        steadySpeed = 0.8 * h.getSpeed();
        System.out.println("Steady speed: "+ steadySpeed);
        newPos = h.getPosition() + steadySpeed;
        return newPos;
    }
    
}
