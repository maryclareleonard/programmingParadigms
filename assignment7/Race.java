public class Race{ 
    //add horses

    int dummy = -1;
    int count = 0;

    Horse h;

    public Race() {
        //add horses with strategies
        Execution execution1 = new Execution(new SlowStart());
        ColoredHorse h1 = new ColoredHorse(h,"Ayman",2,"Green");

        Execution execution2 = new Execution(new EarlySprint());
        ColoredHorse h2 = new ColoredHorse(h,"Becky",2,"Blue");
            
        Execution execution3 = new Execution(new SteadyRun());
        ColoredHorse h3 = new ColoredHorse(h,"John",3,"Pink");

        Execution execution4 = new Execution(new SlowStart());
        ColoredHorse h4 = new ColoredHorse(h,"Ben",3,"Red");
            
        Execution execution5 = new Execution(new EarlySprint());
        ColoredHorse h5 = new ColoredHorse(h,"Natalie",3,"Yellow");
        
        //run race
        while ( !(h1.getDone() && h2.getDone() && h3.getDone() && h4.getDone() && h5.getDone() )) {
            System.out.println();
            System.out.println("--------------");
            System.out.println(count + " Seconds");
            count = count + 1;
            int done1 = execution1.executeStrategy(h1);
            int done2 = execution2.executeStrategy(h2);
            int done3 = execution3.executeStrategy(h3);
            int done4 = execution4.executeStrategy(h4);
            int done5 = execution5.executeStrategy(h5);

            if (dummy == -1) {
                if (done1 == 1) {
                    h1.setWinner(true);
                    dummy = 0;
                } else if (done2 == 1) {
                    h2.setWinner(true);
                    dummy = 0;
                } else if (done3 == 1) {
                    h3.setWinner(true);
                    dummy = 0;
                } else if (done4 == 1) {
                    h4.setWinner(true);
                    dummy = 0;
                } else if (done5 == 1) {
                    h5.setWinner(true);
                    dummy = 0;
                }
            }
            System.out.println("--------------");
            System.out.println();
        }

        // announce winner
        System.out.println();
        System.out.println("The race is complete");
        if(h1.getWinner()) {
            System.out.println(h1.getName() + " in " + h1.getColor() + " won!");
        } else if(h2.getWinner()){
            System.out.println(h2.getName() + " in " + h2.getColor() + " won!");
        } else if(h3.getWinner()){
            System.out.println(h3.getName() + " in " + h3.getColor() + " won!");
        } else if(h4.getWinner()){
            System.out.println(h4.getName() + " in " + h4.getColor() + " won!");
        } else if(h5.getWinner()){
            System.out.println(h5.getName() + " in " + h5.getColor() + " won!");
        }
        System.out.println();
    }
}
