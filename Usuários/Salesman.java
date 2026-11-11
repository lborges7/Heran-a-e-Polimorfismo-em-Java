public final class Salesman extends User implements SalesView {
    private int salesCount;
    private double amountSales;

    public Salesman(String name, String email, String password, int initalCount, double initialAmount) {
        super(name, email, password, false);
        this.salesCount = initalCount;
        this.amountSales = initialAmount;
    }

    // Record para o metodo relatório de vendas
    public record SalesReport(int count, double total) {
    }

    public SalesReport salesReport() {
        return new SalesReport(getSalesCount(), getAmountSales());
    }

    public void addSale(int sales, double amount) {
        this.amountSales += amount;
        this.salesCount++;
    }

    @Override
    public int getSalesCount() {
        return this.salesCount;
    }

    @Override
    public double getAmountSales() {
        return this.amountSales;
    }
}

// Para o relatório financeiro
interface SalesView {
    int getSalesCount();

    double getAmountSales();

}