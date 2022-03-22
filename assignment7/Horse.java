public class Horse {
    String name;
    int speed;
    String color;
    
    //constructor
    public Horse(String name, int speed, String color) {
        this.name = name;
        this.speed = speed;
        this.color = color;
    }
    
    public String getName()     { return this.name; } 

    public int getSpeed()       { return this.speed;}

    public String getColor()    { return this.color; }
}
