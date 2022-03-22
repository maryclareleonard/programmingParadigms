public class EarlySprint implements Strategy{
    @Override
    public void runRace(Horse h) {
        System.out.println(h.getName() + " in " + h.getColor() + " is employing Early Sprint strategy at speed " + h.getSpeed() + ".");
    }
    
}
