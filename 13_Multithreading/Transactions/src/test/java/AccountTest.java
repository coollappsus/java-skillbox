import junit.framework.TestCase;

public class AccountTest extends TestCase {
    Account account = new Account(143647659, "001010", false);

    @Override
    public void setUp() {

    }

    public void testAccount() {
        String actual = account.getAccNumber();
        String expected = "001010";
        assertEquals(expected, actual);
    }

    public void testGetMoney() {
        long actual = account.getMoney();
        long expected = 143647659;
        assertEquals(expected, actual);
    }

    public void testSetMoney() {
        account.setMoney(777);
        long actual = account.getMoney();
        assertEquals(777, actual);
    }

    public void testSetAccNumber() {
        account.setAccNumber("002010");
        String actual = account.getAccNumber();
        assertEquals("002010", actual);
    }

    public void testIsBlock() {
        boolean actual = account.isBlock();
        assertFalse(actual);
    }

    public void testSetBlock() {
        account.setBlock(true);
        boolean actual = account.isBlock();
        assertTrue(actual);
    }
}
