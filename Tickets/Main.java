public class Main {

    public static void main(String[] args) {
        Ticket halfPrice = new HalfPrice(30, "Interestelar", "dublado", 2);
        Ticket family = new Family(32, "Hope - Primeiro Impacto", "legendado", 4);

        System.out.printf(" %s - %s - Total Meia-Entrada: R$ %.2f%n", halfPrice.getMovieName(), halfPrice.getLanguage(),
                halfPrice.getRealAmount());
        System.out.printf(" %s - %s - Total Família (c/ desconto): R$ %.2f%n", family.getMovieName(),
                family.getLanguage(), family.getRealAmount());
    }
}