package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

/**
 * User: Klaudia
 * Date: 11.03.2017
 * Time: 23:21
 */
public class Discount {
    private String discountCause;
    private BigDecimal valueDiscount;
    private BigDecimal discountValue;

    public Discount(String discountCause, BigDecimal valueDiscount) {
        this.discountCause = discountCause;
        this.valueDiscount = valueDiscount;
        this.discountValue = new BigDecimal(0);
        if (valueDiscount != null)
            discountValue = discountValue.subtract(valueDiscount);

    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Discount discount1 = (Discount) o;

        if (discountCause != null ? !discountCause.equals(discount1.discountCause) : discount1.discountCause != null)
            return false;
        return valueDiscount != null ? valueDiscount.equals(discount1.valueDiscount) : discount1.valueDiscount == null;
    }

    @Override
    public int hashCode() {
        int result = discountCause != null ? discountCause.hashCode() : 0;
        result = 31 * result + (valueDiscount != null ? valueDiscount.hashCode() : 0);
        return result;
    }

    public String getDiscountCause() {
        return discountCause;
    }

    public void setDiscountCause(String discountCause) {
        this.discountCause = discountCause;
    }


}
