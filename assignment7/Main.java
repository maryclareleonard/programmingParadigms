public class Main {
    public static void main(String[] args) { 
        Race race1 = new Race(new SlowStart());
        Horse h1 = new Horse("Ayman",2,"Green");

        Race race2 = new Race(new EarlySprint());
        Horse h2 = new Horse("Becky",2,"Blue");
        
        Race race3 = new Race(new SteadyRun());
        Horse h3 = new Horse("John",3,"Pink");

        Race race4 = new Race(new SteadyRun());
        Horse h4 = new Horse("Ben",3,"Red");
        
        Race race5 = new Race(new EarlySprint());
        Horse h5 = new Horse("Natalie",4,"Yellow");
        

        race1.executeStrategy(h1);
        race2.executeStrategy(h2);
        race3.executeStrategy(h3);
        race4.executeStrategy(h4);
        race5.executeStrategy(h5);

        race1.executeStrategy(h1);
        race2.executeStrategy(h2);
        race3.executeStrategy(h3);
        race4.executeStrategy(h4);
        race5.executeStrategy(h5);

    }
    
}
