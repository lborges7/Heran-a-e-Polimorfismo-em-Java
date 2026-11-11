
public final class Manager extends User {

    public Manager(String name, String email, String password) {
        super(name, email, password, true);
    }

    public record FinancialReport(int countSales, double amountSales, int countCash, double amountCash) {
    }

    public FinancialReport getfFinancialReport(SalesView salesView, CashView cashView) {
        return new FinancialReport(salesView.getSalesCount(), salesView.getAmountSales(), cashView.getCountPayments(),
                cashView.getCash());
    }

}