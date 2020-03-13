package main.bigshop;

import main.bigshop.model.ProductType;

public class CalculationStrategyFactory {

    private final InterestCalculationStrategy insuranceInterestCalculationStrategy = new InsuranceStrategyCalculation();
    private final InterestCalculationStrategy productInterestCalculationStrategy = new ProductStrategyCalculation();

    public InterestCalculationStrategy getInterestCalculationStrategy(final ProductType type) {
        switch (type) {
            case PRODUCT: return productInterestCalculationStrategy;
            case INSURANCE: return insuranceInterestCalculationStrategy;
            default: return null;
        }
    }
}
