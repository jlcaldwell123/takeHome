package external.trueaccord.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import external.trueaccord.model.Debt;
import external.trueaccord.model.DebtList;
import external.trueaccord.model.Payment;
import external.trueaccord.model.PaymentPlan;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TrueAccordService {

    private String endPoint = "https://my-json-server.typicode.com/druska/trueaccord-mock-payments-api";
    private String debtURI = "/debts";
    private String paymentsURI = "/payments";
    private String paymentPlansURI = "/payment_plans";

    public TrueAccordService() {
        Unirest.setObjectMapper(new ObjectMapper() {
            com.fasterxml.jackson.databind.ObjectMapper mapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public String writeValue(Object value) {
                try {
                    return mapper.writeValueAsString(value);
                } catch (Exception e) {
                    return null;
                }
            }

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return mapper.readValue(value, valueType);
                } catch (Exception e) {
                    return null;
                }
            }
        });
    }

    public List<Debt> getDebts() {
        List<Debt> debts = new ArrayList<>();
        try {
            HttpResponse<Debt[]> debtsResponse = Unirest.get(endPoint + debtURI).asObject(Debt[].class);
            debts = Arrays.asList(debtsResponse.getBody());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return debts;
    }

    public List<PaymentPlan> getPaymentPlans() {
        List<PaymentPlan> paymentPlans = new ArrayList<>();
        try {
            HttpResponse<PaymentPlan[]> paymentPlansResponse = Unirest.get(endPoint + paymentPlansURI).asObject(PaymentPlan[].class);
            paymentPlans = Arrays.asList(paymentPlansResponse.getBody());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return paymentPlans;
    }

    public List<Payment> getPayments() {
        List<Payment> payments = new ArrayList<>();
        try {
            HttpResponse<Payment[]> paymentsResponse = Unirest.get(endPoint + paymentsURI).asObject(Payment[].class);
            payments = Arrays.asList(paymentsResponse.getBody());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return payments;
    }
}
