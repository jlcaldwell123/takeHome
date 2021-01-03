package external.trueaccord.model;

public class PaymentPlan {

    private int id;
    private int debt_id;
    private double amount_to_pay;
    private String installment_frequency;
    private double installment_amount;
    private String start_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDebt_id() {
        return debt_id;
    }

    public void setDebt_id(int debt_id) {
        this.debt_id = debt_id;
    }

    public double getAmount_to_pay() {
        return amount_to_pay;
    }

    public void setAmount_to_pay(double amount_to_pay) {
        this.amount_to_pay = amount_to_pay;
    }

    public String getInstallment_frequency() {
        return installment_frequency;
    }

    public void setInstallment_frequency(String installment_frequency) {
        this.installment_frequency = installment_frequency;
    }

    public double getInstallment_amount() {
        return installment_amount;
    }

    public void setInstallment_amount(double installment_amount) {
        this.installment_amount = installment_amount;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    @Override
    public String toString() {
        return "PaymentPlan{" +
                "id=" + id +
                ", debt_id=" + debt_id +
                ", amount_to_pay=" + amount_to_pay +
                ", installment_frequency='" + installment_frequency + '\'' +
                ", installment_amount=" + installment_amount +
                ", start_date='" + start_date + '\'' +
                '}';
    }
}
