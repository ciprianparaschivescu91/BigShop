package main.bigshop;

import main.bigshop.model.ProductType;

public class CalculationStrategyFactory {

    private final CalculationStrategy insuranceInterestCalculationStrategy = new InsuranceStrategyCalculation();
    private final CalculationStrategy productInterestCalculationStrategy = new ProductStrategyCalculation();

    public CalculationStrategy getInterestCalculationStrategy(final ProductType type) {
        switch (type) {
            case PRODUCT: return productInterestCalculationStrategy;
            case INSURANCE: return insuranceInterestCalculationStrategy;
            default: return null;
        }
    }
}
