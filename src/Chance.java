//Understands how to calculate the probability of an event occurring.

public class Chance {

    public static final int SURECHANCE = 1;
    private final double outcome;

    public Chance(double outcome) {
        this.outcome = outcome;
    }


    public Chance not() {
        return new Chance(SURECHANCE - outcome);
    }

    public Chance and(Chance otherChance) {
        return new Chance(outcome * otherChance.outcome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chance chance = (Chance) o;

        return Double.compare(chance.outcome, outcome) == 0;

    }

    public Chance or(Chance otherChance) {
        return not().and(otherChance.not()).not();
    }
}
