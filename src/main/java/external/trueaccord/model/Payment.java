package external.trueaccord.model;

import java.math.BigDecimal;

public class Payment {

    private int payment_plan_id;
    private BigDecimal amount;
    private String date;

    public int getPayment_plan_id() {
        return payment_plan_id;
    }

    public void setPayment_plan_id(int payment_plan_id) {
        this.payment_plan_id = payment_plan_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payment_plan_id=" + payment_plan_id +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }
}
