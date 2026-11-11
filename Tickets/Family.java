public final class Family extends Ticket {

    public Family(double amount, String movieName, String language, int numberOfTickets) {
        super(amount, movieName, language, numberOfTickets);
    }

    private static final int minTicketsDiscount = 3;
    private static final double percentageDiscount = 0.05;

    private boolean hasDiscount() {
        return (getNumberOfTickets() > minTicketsDiscount);
    }

    @Override
    public double getRealAmount() {
        double totalBase = getAmount() * getNumberOfTickets();
        if (hasDiscount()) {
            return totalBase * (1.0 - percentageDiscount); // Aplica 5% de desconto
        }
        return totalBase;
    };
}