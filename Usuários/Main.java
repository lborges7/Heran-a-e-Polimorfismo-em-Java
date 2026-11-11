public class Main {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       SISTEMA DE GESTAO - TECHSTORE              ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // ATO 1: INICIALIZACAO E AUTENTICACAO
        // -----------------------------------------------------------------
        System.out.println("--- ATO 1: Inicializacao e Autenticacao ---");

        Manager manager = new Manager("Ana Beatriz", "ana.gerente@techstore.com", "admin123");
        Salesman salesman = new Salesman("Carlos Silva", "carlos.vendas@techstore.com", "vendas123", 0, 0.0);
        Cashier cashier = new Cashier("Mariana Souza", "mariana.caixa@techstore.com", "caixa123", 500.0, 0, true);

        System.out.printf("Funcionario: %s | Cargo: Gerente  | Admin? %b %n", manager.getName(), manager.isAdmin());
        System.out.printf("Funcionario: %s | Cargo: Vendedor | Admin? %b %n", salesman.getName(), salesman.isAdmin());
        System.out.printf("Funcionario: %s | Cargo: Caixa    | Admin? %b %n", cashier.getName(), cashier.isAdmin());

        // Testando tentativa de login invalido e depois valido
        System.out.println("\nTentando login com senha errada...");
        boolean loginInvalido = salesman.login("carlos.vendas@techstore.com", "senhaErrada");
        System.out.println("Login de Carlos com senha errada: " + (loginInvalido ? "SUCESSO" : "FALHA (Esperado)"));

        System.out.println("Tentando login com credenciais corretas...");
        boolean loginValido = salesman.login("carlos.vendas@techstore.com", "vendas123");
        System.out.println("Carlos logado com sucesso? " + loginValido);
        System.out.println("Status de sessao de Carlos: " + (salesman.isLoggedIn() ? "ONLINE" : "OFFLINE"));

        // -----------------------------------------------------------------
        // ATO 2: O DIA DE TRABALHO (VENDAS E RECEBIMENTOS)
        // -----------------------------------------------------------------
        System.out.println("\n--- ATO 2: Expediente de Vendas e Caixa ---");

        System.out.println("Caixa aberto com saldo inicial de: R$ " + cashier.getCash());

        // Carlos realiza 3 vendas durante o expediente
        System.out.println("\nCarlos realizando vendas no sistema...");
        salesman.addSale(1, 350.00); // Teclado Mecanico
        salesman.addSale(1, 1200.00); // Monitor Gamer
        salesman.addSale(1, 250.00); // Mouse Gamer

        // Mariana recebe os pagamentos dessas vendas no caixa
        cashier.addPayment(350.00);
        cashier.addPayment(1200.00);
        cashier.addPayment(250.00);

        // Carlos consulta o seu proprio resumo de vendas
        System.out.println("\nResumo individual do Vendedor:");
        System.out.println("Relatorio de Carlos: " + salesman.salesReport());

        // -----------------------------------------------------------------
        // ATO 3: ATUALIZACAO CADASTRAL
        // -----------------------------------------------------------------
        System.out.println("\n--- ATO 3: Alteracao Cadastral e de Seguranca ---");

        System.out.println("Carlos foi promovido e atualizou seu email institucional:");
        salesman.changeData("Carlos Silva Senior", "carlos.senior@techstore.com");
        System.out.println("Nome atualizado: " + salesman.getName() + " | Email atualizado: " + salesman.getEmail());

        System.out.println("\nMariana atualizando sua senha de seguranca...");
        cashier.changePassword("novaSenhaForte#2026");
        System.out.println("Senha do caixa atualizada com sucesso!");

        // -----------------------------------------------------------------
        // ATO 4: CONSOLIDACAO FINANCEIRA E FECHAMENTO DO DIA
        // -----------------------------------------------------------------
        System.out.println("\n--- ATO 4: Gerencia e Fechamento de Expediente ---");

        // A Gerente Ana gera o Relatorio Financeiro consolidando Vendas e Caixa
        System.out.println("Gerente Ana gerando o relatorio consolidado atraves das Interfaces...");
        Manager.FinancialReport relatorio = manager.getfFinancialReport(salesman, cashier);

        System.out.println("\n================ RELATORIO CONSOLIDADO ================");
        System.out.printf("Total de Vendas Realizadas:      %d pedidos%n", relatorio.countSales());
        System.out.printf("Faturamento Total das Vendas:    R$ %.2f%n", relatorio.amountSales());
        System.out.printf("Pagamentos Processados no Caixa: %d recebimentos%n", relatorio.countCash());
        System.out.printf("Saldo Final em Caixa (c/ troco): R$ %.2f%n", relatorio.amountCash());
        System.out.println("=======================================================");

        // Fechamento do caixa e saida dos funcionarios
        cashier.close();
        System.out.println("\nCaixa finalizado com sucesso.");
        salesman.logoff();
        System.out.println("Expediente finalizado para a equipe TechStore!");
    }
}
