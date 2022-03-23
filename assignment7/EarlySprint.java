public class EarlySprint implements Strategy{
    double newPos;
    double maxSpeed;
    double reducedSpeed;

    @Override
    public double runRace(Horse h) {
        maxSpeed = h.getSpeed();
        reducedSpeed = h.getSpeed() * .7;
        System.out.println(h.getName() + " in " + h.getColor() + " is employing Early Sprint strategy at speed " + h.getSpeed() + ".");
        
        if (h.getDone()) {  //if horse has reached the end
            newPos = h.getPosition();
        }
        else {
            if (h.getPosition() < 4) { //before 4km
                System.out.println("Max Speed: " + maxSpeed);
                newPos = h.getPosition() + maxSpeed;
            }
            else if (h.getPosition() < 10){ //after 4km
                System.out.println("Reduced Speed: " + reducedSpeed);
                newPos = h.getPosition() + reducedSpeed;
            }
        }
        
        return newPos;
    }
    
}
