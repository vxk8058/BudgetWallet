import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    public static double amount = 0;
    public static String sender = "112445798874", receiver = "";

    @Test
    void transfer_TC_1() {
        amount = 410.50;
        receiver = "123456789";
        String formattedAmount = String.format("%.2f", amount);
        assertEquals(formattedAmount + " successfully transferred to Account " + receiver,
                ATM.transfer(sender, receiver, amount));
    }

    @Test
    void transfer_TC_2() {
        amount = 0;
        receiver = "123456789";
        assertEquals("Transfer amount must be between $1.00 and $5000.00.",
                ATM.transfer(sender, receiver, amount));
    }

    @Test
    void transfer_TC_3() {
        amount = -50;
        receiver = "123456789";
        assertEquals("Transfer amount must be between $1.00 and $5000.00.",
                ATM.transfer(sender, receiver, amount));
    }

    @Test
    void transfer_TC_4() {
        amount = 10.99;
        receiver = "1234567899999999990";
        assertEquals("Account Number must be between 8 and 17 digits in length.",
                ATM.transfer(sender, receiver, amount));
    }

    @Test
    void transfer_TC_7() {
        amount = 45;
        receiver = "$$%#)(@&;";
        assertEquals("Account Number must only contain digits.",
                ATM.transfer(sender, receiver, amount));
    }
}