public class ColoredHorse extends Horse {
    public Horse horse;
    String name;
    int speed;
    String color;
    double position;
    boolean done;
    boolean winner;

    //constructor
    public ColoredHorse(Horse horse) {
        super();
        this.horse = horse;

        this.speed = -1; //to check if no winner
    }

    public ColoredHorse(Horse horse, String name, int speed, String color) {
        super();
        this.horse = horse;
        
        this.name = name;
        this.speed = speed;
        this.color = color;
        this.position = 0;
        this.done = false;
        this.winner = false;
    }
    
    public String getName()     { return this.name; } 
    public int getSpeed()       { return this.speed;}
    public String getColor() {
        horse.getColor(); 
        return this.color; 
    }
    public double getPosition() { return this.position; }
    public boolean getDone()    { return this.done; }  
    public boolean getWinner()  { return this.winner; } 

    public void setPosition(double pos)     { this.position = pos; }
    public void setDone(boolean done)       { this.done = done; }
    public void setSpeed(int speed)     { this.speed = speed; }
    public void setWinner(boolean winner)   { this.winner = winner;} 
}
