public class SteadyRun implements Strategy{
    @Override
    public void runRace(Horse h) {
        System.out.println(h.getName() + " in " + h.getColor() + " is employing Steady Run strategy at speed " + h.getSpeed() + ".");
    }
    
}
