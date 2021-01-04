package service;

import external.trueaccord.model.Debt;
import external.trueaccord.model.Payment;
import external.trueaccord.model.PaymentPlan;
import external.trueaccord.service.TrueAccordService;

import java.util.ArrayList;
import java.util.List;

public class AdminService {

    private TrueAccordService trueAccordService;
    private List<Debt> debts;
    private List<Payment> payments;
    private List<PaymentPlan> paymentPlans;

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
                double amountOwed = calculateRemainingAmount(debt);
                System.out.println(debt.toString(isInPaymentPlan, amountOwed));
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

    public double calculateRemainingAmount(Debt debt) {
        double amountPaid = 0;
        double amountOwed = debt.getAmount();
        PaymentPlan foundPaymentPlan = null;
        for (PaymentPlan paymentPlan: paymentPlans) {
            if (paymentPlan.getDebt_id() == debt.getId()) {
                foundPaymentPlan = paymentPlan;
            }
        }
        if (foundPaymentPlan != null) {
            for (Payment payment: payments) {
                if (payment.getPayment_plan_id() == foundPaymentPlan.getId()) {
                    amountPaid += payment.getAmount();
                }
            }
            amountOwed -= amountPaid;
        }
        return amountOwed;
    }
}
