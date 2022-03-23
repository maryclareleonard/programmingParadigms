public class Race {
    private Strategy strategy;

    public Race (Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(Horse h) {
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
