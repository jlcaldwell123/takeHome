package external.trueaccord.model;

import java.math.BigDecimal;

public class Debt {

    private int id;
    private BigDecimal amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "{ id : " + id
                + ", amount : " + amount + " }";
    }

    public String toString(boolean paymentPlan, BigDecimal amountOwed, String nextPaymentDate) {
        return "{ id : " + id
                + ", amount : " + amount
                + ", is_in_payment_plan : " + paymentPlan
                + ", remaining_amount : " + amountOwed
                + ", next_payment_due_date : " + nextPaymentDate + " }";
    }
}
