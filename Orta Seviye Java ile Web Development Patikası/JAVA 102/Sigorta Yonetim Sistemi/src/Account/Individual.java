package Account;

public class Individual extends Account {

    private static final double RATE=1.15;

    protected Individual(User user) {
        super(user, RATE);
    }
}
