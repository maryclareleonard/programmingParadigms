public class SlowStart implements Strategy{
    @Override
    public void runRace(Horse h) {
        System.out.println(h.getName() + " in " + h.getColor() + " is employing Slow Start strategy at speed " + h.getSpeed() + ".");
    }
    
}
