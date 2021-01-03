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
    public void out() {
        adminService.printDebts();
        assertEquals("[{ id : 0, amount : 123.46 }, { id : 1, amount : 100.0 }, { id : 2, amount : 4920.34 }, { id : 3, amount : 12938.0 }, { id : 4, amount : 9238.02 }]\n", outContent.toString());
    }
}
