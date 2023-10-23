import java.util.Comparator;

public class Customer {
    int netWorth;
    int yearsWithCompany;
    int politeness;

    public Customer(int netWorth, int yearsWithCompany, int politeness) {
        this.netWorth = netWorth;
        this.yearsWithCompany = yearsWithCompany;
        this.politeness = politeness;
    }

    /**
     * Compares clients based on their net worth.
     */
    public static class WorthComparator implements Comparator<Customer> {
        @Override
        public int compare(Customer c1, Customer c2) {
            return c1.netWorth - c2.netWorth;
        }
    }

    /**
     * Compares clients based on their loyalty.
     */
    public static class LoyaltyComparator implements Comparator<Customer> {
        @Override
        public int compare(Customer c1, Customer c2) {
            return c1.yearsWithCompany - c2.yearsWithCompany;
        }
    }

    /**
     * Compares clients based on their net worth. If there is a tie, politeness is used.
     */
    public static class WorthPoliteComparator implements Comparator<Customer> {
        @Override
        public int compare(Customer c1, Customer c2) {
            int worthComparison = c1.netWorth - c2.netWorth;
            if (worthComparison != 0) {
                return worthComparison;
            }
            
            return c1.politeness - c2.politeness;
        }
    }
}
