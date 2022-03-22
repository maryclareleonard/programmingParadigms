public class Race {
    private Strategy strategy;

    public Race (Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(Horse h) {
        h.setPosition(strategy.runRace(h));
        System.out.println(h.getPosition());

        if (h.getPosition() >= 10) {
            announceWinner(h);
        }

    }

    //public static void runRace() { }

    public static void announceWinner(Horse h) {
        System.out.println(h.getName() + " in " + h.getColor() + "  won!");

    }

}
