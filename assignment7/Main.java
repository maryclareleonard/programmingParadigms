public class Main {
    public static void main(String[] args) { 
        Race race1 = new Race(new SlowStart());
        Horse h1 = new Horse("Ayman",2,"Green");

        Race race2 = new Race(new EarlySprint());
        Horse h2 = new Horse("Becky",2,"Blue");
        
        Race race3 = new Race(new SteadyRun());
        Horse h3 = new Horse("John",3,"Pink");

        Race race4 = new Race(new SlowStart());
        Horse h4 = new Horse("Ben",3,"Red");
        
        Race race5 = new Race(new EarlySprint());
        Horse h5 = new Horse("Natalie",3,"Yellow");

        int dummy  = -1;
        int count = 0;
        
        while ( !(h1.getDone() && h2.getDone() && h3.getDone() && h4.getDone() && h5.getDone() )) {
            System.out.println();
            System.out.println("--------------");
            System.out.println(count + " Seconds");
            count = count + 1;
            int done1 = race1.executeStrategy(h1);
            int done2 = race2.executeStrategy(h2);
            int done3 = race3.executeStrategy(h3);
            int done4 = race4.executeStrategy(h4);
            int done5 = race5.executeStrategy(h5);

            if (dummy == -1) {
                if (done1 == 1)      { 
                    h1.setWinner(true);
                    dummy = 0;
                } 
                else if (done2 == 1) { 
                    h2.setWinner(true);
                    dummy = 0;
                }
                else if (done3 == 1) { 
                    h3.setWinner(true);
                    dummy = 0;
                }
                else if (done4 == 1) { 
                    h4.setWinner(true);
                    dummy = 0;
                }
                else if (done5 == 1) { 
                    h5.setWinner(true);
                    dummy = 0;
                } 
            }
            System.out.println("--------------");
            System.out.println();
        }

        //announce winner
        System.out.println();
        System.out.println("The race is complete");
        if (h1.getWinner()) {
            System.out.println(h1.getName() + " in " + h1.getColor() + " won!");
        }
        else if (h2.getWinner()) {
            System.out.println(h2.getName() + " in " + h2.getColor() + " won!"); 
        }
        else if (h3.getWinner()) {
            System.out.println(h3.getName() + " in " + h3.getColor() + " won!");
        }
        else if (h4.getWinner()) {
            System.out.println(h4.getName() + " in " + h4.getColor() + " won!");
        }
        else if (h5.getWinner()) {
            System.out.println(h5.getName() + " in " + h5.getColor() + " won!");
        }
        System.out.println();
    }
    
}
