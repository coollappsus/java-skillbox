public class Account {
    private long money;
    private String accNumber;
    private boolean isBlock;

    public Account(long money, String accNumber, boolean isBlock) {
        this.money = money;
        this.accNumber = accNumber;
        this.isBlock = isBlock;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public boolean isBlock() {
        return isBlock;
    }

    public void setBlock(boolean block) {
        isBlock = block;
    }
}
