import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoginTest {
    private DBMgr db = DBMgr.getInstance();
    private String[] emails = {"johnledford@gmail.com", "whowhatwhere@yahoo.com"};
    private String[] passwords = {"123456789", "xxyww2"};

    @Test
    public void TestUC1() {
        assertEquals(false, db.validUser(emails[0], passwords[0]));
    }

    @Test
    public void TestUC2() {
        assertEquals(false, db.validUser(emails[0], passwords[1]));
    }

    @Test
    public void TestUC3() {
        assertEquals(false, db.validUser(emails[1], passwords[0]));
    }
}