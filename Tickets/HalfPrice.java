public final class HalfPrice extends Ticket {

    public HalfPrice(double amount, String movieName, String language, int numberOfTickets) {
        super(amount, movieName, language, numberOfTickets);
    }

    @Override
    public double getRealAmount() {
        double realAmount = getAmount() / 2;
        return realAmount * getNumberOfTickets();
    };
}