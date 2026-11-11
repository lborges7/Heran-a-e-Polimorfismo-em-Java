public final class Cashier extends User implements CashView {
    private double cash;
    private int countPayments;
    private boolean isOpen;

    public Cashier(String name, String email, String password, double initalCash, int initalCount, boolean isOpen) {
        super(name, email, password, false);
        this.cash = initalCash;
        this.countPayments = initalCount;
        this.isOpen = isOpen;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public boolean addPayment(double amount) {
        if (!isOpen()) {
            return false;
        }
        this.cash += amount;
        this.countPayments++;
        return true;
    }

    public boolean close() {
        if (!isOpen()) {
            return false;
        }
        return true;
    }

    @Override
    public int getCountPayments() {
        return this.countPayments;
    }

    @Override
    public double getCash() {
        return this.cash;
    }

}

// Para o relatório financeiro
interface CashView {
    int getCountPayments();

    double getCash();

}
