package Bank;
class User{
private int id,mobileNo;
private String name,address,email;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", mobileNo=" + mobileNo +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

class Login{

    private int loginId;
    private String password,username;

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Login{" +
                "loginId=" + loginId +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

class Account{

    private int accountId;
    private String accountType,accountBalance;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountType='" + accountType + '\'' +
                ", accountBalance='" + accountBalance + '\'' +
                '}';
    }
}

class Loan{
    private int loanId,loanAmount;

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", loanAmount=" + loanAmount +
                '}';
    }
}



public class BankSystem {

    public static void main(String[] args) {
       Loan loan = new Loan();
       loan.setLoanId(1219);
       loan.setLoanAmount(5000);
       System.out.println(loan);

       Account account = new Account();
       account.setAccountId(126);
       account.setAccountType("Savings");
       account.setAccountBalance("800000");
       System.out.println(account);

       Login login = new Login();
       login.setLoginId(7890);
       login.setUsername("ShreyaKal");
       login.setPassword("Shreya289");
       System.out.println(login);

       User user= new User();
       user.setId(125678);
       user.setName("Shreya");
       user.setAddress("Pune");
       user.setEmail("shreya@coditas.com");
       user.setMobileNo(1234568);
       System.out.println(user);



    }
}
