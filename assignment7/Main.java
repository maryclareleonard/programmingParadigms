public class Main {
    public static void main(String[] args) { 
        Race race1 = new Race(new SlowStart());
        Horse h1 = new Horse("Ayman",4,"Green");
        race1.executeStrategy(h1);

        Race race2 = new Race(new EarlySprint());
        Horse h2 = new Horse("Becky",2,"Blue");
        race2.executeStrategy(h2);

        Race race3 = new Race(new SteadyRun());
        Horse h3 = new Horse("John",3,"Pink");
        race3.executeStrategy(h3);

        Race race4 = new Race(new SteadyRun());
        Horse h4 = new Horse("Ben",1,"Red");
        race4.executeStrategy(h4);

        Race race5 = new Race(new EarlySprint());
        Horse h5 = new Horse("Natalie",5,"Yellow");
        race5.executeStrategy(h5);
    }
    
}
