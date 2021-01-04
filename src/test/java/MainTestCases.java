import external.trueaccord.model.Debt;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.AdminService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class MainTestCases {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private AdminService adminService;
    private String expectedDebtsOutput = "{ id : 0, amount : 123.46, is_in_payment_plan : true }\n" +
            "{ id : 1, amount : 100.0, is_in_payment_plan : true }\n" +
            "{ id : 2, amount : 4920.34, is_in_payment_plan : true }\n" +
            "{ id : 3, amount : 12938.0, is_in_payment_plan : true }\n" +
            "{ id : 4, amount : 9238.02, is_in_payment_plan : false }\n";

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        adminService = new AdminService();
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void printDebts() {
        adminService.printDebts();
        assertEquals(expectedDebtsOutput, outContent.toString());
    }

    @Test
    public void debtInPaymentPlan() {
        Debt debt = new Debt();
        debt.setId(1);
        assertEquals(true, adminService.isInPaymentPlan(debt));
    }

    @Test
    public void debtNotInPaymentPlan() {
        Debt debt = new Debt();
        debt.setId(55);
        assertEquals(false, adminService.isInPaymentPlan(debt));
    }
}
