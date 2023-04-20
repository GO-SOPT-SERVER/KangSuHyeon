package controller;

import service.AccountService;

public class AccountController {
    AccountService accountService = new AccountService();
    private int select;

    public void run(int select) {
        this.select = select;
        switch (select) {
            case 1:
                loginAccount();
                break;
            case 2:
                createAccount();
        }
    }

    public void loginAccount() {
        System.out.println("<기존 계좌 입력>");
        accountService.run(select);
    }

    public void createAccount() {
        System.out.println("<신규 계좌 생성>");
        accountService.run(select);
    }
}
