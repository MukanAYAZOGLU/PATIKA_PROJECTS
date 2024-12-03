package Account;

public class Enterprise extends Account {

    private static final double RATE=1.50;

    protected Enterprise(User user) {
        super(user, RATE);
    }
}
