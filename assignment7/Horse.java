public class Horse {
    String name;
    int speed;
    String color;
    double position;
    
    //constructor
    public Horse(String name, int speed, String color) {
        this.name = name;
        this.speed = speed;
        this.color = color;
        this.position = 0;
    }
    
    public String getName()     { return this.name; } 
    public int getSpeed()       { return this.speed;}
    public String getColor()    { return this.color; }
    public double getPosition()  { return this.position; }

    public void setPosition(double pos)  { this.position = pos; }
}
