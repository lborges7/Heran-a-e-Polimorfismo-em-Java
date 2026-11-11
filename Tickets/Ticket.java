public abstract sealed class Ticket permits HalfPrice, Family {

    private double amount;
    private String movieName;
    private String language;
    private int numberOfTickets;

    public Ticket(double amount, String movieName, String language, int numberOfTickets) {
        this.amount = amount;
        this.movieName = movieName;
        this.language = language;
        this.numberOfTickets = numberOfTickets;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String moviename) {
        this.movieName = moviename;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    // Metodo para gerar o valor real do ingresso
    public abstract double getRealAmount();
}