public class Execution {
    private Strategy strategy;

    public Execution (Strategy strategy) {
        this.strategy = strategy;
    }

    //ability to change strategy
    public void setStrategy(Strategy newStrategy) {
        this.strategy = newStrategy;
    }
    
    public int executeStrategy(ColoredHorse h) {
        h.setPosition(strategy.runRace(h));
        System.out.println(h.getName() + " current position: " + h.getPosition());
        System.out.println();

        if (h.getPosition() >= 10) {
            h.setDone(true);
            return 1;
        }
        else {
            return 0;
        }

    }

}
