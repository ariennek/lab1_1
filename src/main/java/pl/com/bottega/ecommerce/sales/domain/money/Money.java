package pl.com.bottega.ecommerce.sales.domain.money;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

/**
 * Created by grusz on 08.03.2017.
 */
public class Money {

    public static final Currency DEFAULT = Currency.getInstance("PLN");

    private String code;

    private BigDecimal denomination; //used to calculate value in given currency

    public Money(){

    }

    public Money(String code, BigDecimal denomination) {
        this.code = code;
        this.denomination = denomination.setScale(2, RoundingMode.HALF_EVEN);;
    }

    public Money(BigDecimal denomination) {
        this(DEFAULT,denomination);
    }

    public Money(Currency currency,BigDecimal denomination){
        this(currency.getCurrencyCode(),denomination);
    }

    public Money(String code, double denomination) {
        this(code,new BigDecimal(denomination));
    }

    public Money(double denomination) {
        this(new BigDecimal(denomination));
    }

    public Money(Currency currency,double denomination){
        this(currency.getCurrencyCode(),new BigDecimal(denomination));
    }

    public String getCode() {
        return code;
    }

    public Currency getCurrency() {
        return Currency.getInstance(code);
    }

    public Money multiply(BigDecimal multiplier){
        return new Money(code,denomination.multiply(multiplier));
    }



    public Money multiply(double multiplier){
        return new Money(code,denomination.multiply(new BigDecimal(multiplier)));
    }

    public Money substract(Money money){
        if(!isCompatibile(money)){
            throw new IllegalArgumentException("Currency you tried to substract doesn't match!");
        }
        return new Money(money.getCode(),denomination.subtract(money.denomination));
    }

    private boolean isZero(BigDecimal valueToTest) {
        	return BigDecimal.ZERO.compareTo(valueToTest) == 0;
    }

    private boolean isCompatibile(Money money) {
        return isZero(denomination) || isZero(money.denomination) || code.equals(money.getCode());
    }



    @Override
    public String toString() {
        return String.format("%0$.2f %s", denomination, getCurrency().getSymbol());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        return new EqualsBuilder()
                .append(code, money.code)
                .append(denomination, money.denomination)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(code)
                .append(denomination)
                .toHashCode();
    }


}
