public class SlowStart implements Strategy{
    double newPos;
    double startSpeed;
    double midSpeed;
    double maxSpeed;

    @Override
    public double runRace(ColoredHorse h) {
        System.out.println(h.getName() + " in " + h.getColor() + " is employing Slow Start strategy at speed " + h.getSpeed() + ".");
        if (h.getDone()) {  //if horse has reached the end
            newPos = h.getPosition();
        }
        
        else {
            if (h.getPosition() < 5) {
                startSpeed = 0.6 * h.getSpeed();
                System.out.println("Start speed: "+ startSpeed);
                newPos = h.getPosition() + startSpeed;
            }
            else if (h.getPosition() < 9) {
                midSpeed = 0.8 * h.getSpeed();
                System.out.println("Mid speed: "+ midSpeed);
                newPos = h.getPosition() + midSpeed;
            }
            else if (h.getPosition() <= 10) {
                maxSpeed = h.getSpeed();
                System.out.println("Max speed: "+ maxSpeed);
                newPos = h.getPosition() + maxSpeed;
            }
        }

        return newPos;
    }
    
}
