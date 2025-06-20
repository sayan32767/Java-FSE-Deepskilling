public class FinancialForecasting {
    private static double calculateFutureValue(double presentValue, double rate, int periods) {
        if (periods == 0) {
            return presentValue;
        }
        return (1 + rate) * calculateFutureValue(presentValue, rate, periods - 1);
    }

    public static void main(String[] args) {
        double initialValue = 1000.0;
        double growthRate = 0.05;
        int years = 10;
        
        double futureValue = calculateFutureValue(initialValue, growthRate, years);
        System.out.printf("Future value after %d years: $%.2f", years, futureValue);
    }
}