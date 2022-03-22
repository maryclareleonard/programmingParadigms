public class Race {
    private Strategy strategy;

    public Race (Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(Horse h) {
        strategy.runRace(h);
    }
    
    public static void addHorses() {  }
    
    public static void startRace() {  } 

    //public static void runRace() { }

    public static void announceWinner() { }

}
