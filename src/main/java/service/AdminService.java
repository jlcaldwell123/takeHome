package service;

import external.trueaccord.model.Debt;
import external.trueaccord.model.Payment;
import external.trueaccord.model.PaymentPlan;
import external.trueaccord.service.TrueAccordService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AdminService {

    private TrueAccordService trueAccordService;
    private List<Debt> debts;
    private List<Payment> payments;
    private List<PaymentPlan> paymentPlans;
    private String WEEKLY_CONSTANT = "WEEKLY";
    private String BI_WEEKLY_CONSTANT = "BI_WEEKLY";
    private int WEEKLY_NUM_CONSTANT = 7;
    private int BI_WEEKLY_NUM_CONSTANT = 14;

    public AdminService() {
        trueAccordService = new TrueAccordService();
        debts = this.trueAccordService.getDebts();
        paymentPlans = this.trueAccordService.getPaymentPlans();
        payments = this.trueAccordService.getPayments();
    }

    public void printDebts() {
        if (debts != null && !debts.isEmpty()) {
            for (Debt debt: debts) {
                boolean isInPaymentPlan = isInPaymentPlan(debt);
                BigDecimal amountOwed = calculateRemainingAmount(debt);
                String nextPaymentDate = null;
                if (isInPaymentPlan && (amountOwed.compareTo(BigDecimal.ZERO) > 0)) {
                    nextPaymentDate = getNextPaymentDate(debt);
                }
                System.out.println(debt.toString(isInPaymentPlan, amountOwed, nextPaymentDate));
            }
        }
    }

    public boolean isInPaymentPlan(Debt debt) {
        if (debt != null && paymentPlans != null
                && !paymentPlans.isEmpty()) {
            for (PaymentPlan paymentPlan: paymentPlans) {
                if (paymentPlan.getDebt_id() == debt.getId()) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public BigDecimal calculateRemainingAmount(Debt debt) {
        BigDecimal amountPaid = new BigDecimal(0);
        BigDecimal amountOwed = debt.getAmount();
        PaymentPlan foundPaymentPlan = null;
        for (PaymentPlan paymentPlan: paymentPlans) {
            if (paymentPlan.getDebt_id() == debt.getId()) {
                foundPaymentPlan = paymentPlan;
            }
        }
        if (foundPaymentPlan != null) {
            for (Payment payment: payments) {
                if (payment.getPayment_plan_id() == foundPaymentPlan.getId()) {
                    amountPaid = amountPaid.add(payment.getAmount());
                }
            }
            amountOwed = amountOwed.subtract(amountPaid);
        }
        return amountOwed;
    }

    public String getNextPaymentDate(Debt debt) {
        PaymentPlan foundPaymentPlan = null;
        for (PaymentPlan paymentPlan: paymentPlans) {
            if (paymentPlan.getDebt_id() == debt.getId()) {
                foundPaymentPlan = paymentPlan;
            }
        }
        if (foundPaymentPlan != null) {
            LocalDate latestDate = LocalDate.parse(foundPaymentPlan.getStart_date());
            for (Payment payment: payments) {
                if (payment.getPayment_plan_id() == foundPaymentPlan.getId()) {
                    LocalDate newDate = LocalDate.parse(payment.getDate());
                    if (newDate.isAfter(latestDate)) {
                        latestDate = newDate;
                    }
                }
            }
            if (latestDate.toString().equalsIgnoreCase(foundPaymentPlan.getStart_date())) {
                return latestDate.toString();
            } else if (WEEKLY_CONSTANT.equalsIgnoreCase(foundPaymentPlan.getInstallment_frequency())) {
                return latestDate.plusDays(WEEKLY_NUM_CONSTANT).toString();
            } else if (BI_WEEKLY_CONSTANT.equalsIgnoreCase(foundPaymentPlan.getInstallment_frequency())) {
                return latestDate.plusDays(BI_WEEKLY_NUM_CONSTANT).toString();
            }
        }
        return null;
    }
}
