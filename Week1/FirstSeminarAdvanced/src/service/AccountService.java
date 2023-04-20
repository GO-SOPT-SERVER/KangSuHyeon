package service;

import domain.Account;

import java.util.HashMap;
import java.util.Scanner;

public class AccountService {

    Scanner scanner = new Scanner(System.in);
    HashMap<Integer, Account> accountMap = new HashMap<>();
    public void run(int select) {
        switch (select) {
            case 1: loginAccount();
                break;
            case 2: createAccount();
        }
        System.out.println("-------------------------------------");
    }

    private void loginAccount() {
        System.out.println("계좌번호를 입력해주세요.");
        int account = scanner.nextInt();
        if(accountMap.get(account) == null) {
            System.out.println("존재하지 않는 계좌입니다. 초기화면으로 돌아갑니다.");
            return;
        }
        System.out.println("비밀번호를 입력해주세요.");
        int password = scanner.nextInt();
        int select = 0;
        if(accountMap.get(account).checkPassword(password)){
            while(select != 4) {
                System.out.println("1. 입금   2. 출금  3. 잔액조회  4.종료 \n"
                        + "원하시는 거래를 선택하세요 > ");
                select = scanner.nextInt();
                switch (select) {
                    case 1: deposit(accountMap.get(account)); break;
                    case 2: withdraw(accountMap.get(account)); break;
                    case 3: checkBalance(accountMap.get(account));
                }
                System.out.println("-------------------------------------");
            }
        }else {
            System.out.println("비밀번호가 일치하지 않습니다. 초기화면으로 돌아갑니다.");
        }
    }

    private void deposit(Account account) {
        System.out.println("입금을 원하시는 금액을 입력해주세요.");
        int amount = scanner.nextInt();
        account.deposit(amount);
        System.out.println(amount +"원을 입급했습니다.");
        checkBalance(account);
    }

    private void withdraw(Account account) {
        System.out.println("출금을 원하시는 금액을 입력해주세요.");
        int amount = scanner.nextInt();
        if(amount > account.getBalance()) {
            System.out.println("잔액이 부족합니다.");
        }else {
            account.deposit(-amount);
            System.out.println(amount +"원을 출금했습니다.");
        }
        checkBalance(account);
    }

    private void checkBalance(Account account) {
        System.out.println("현재 잔액은 " + account.getBalance() + "원 입니다.");
    }

    private void createAccount() {
        System.out.println("계좌번호를 입력해주세요.");
        int account = scanner.nextInt();
        if(accountMap.get(account) != null) {
            System.out.println("이미 존재하는 계좌입니다. 초기화면으로 돌아갑니다.");
        }else {
            System.out.println("비밀번호를 입력해주세요.");
            int password = scanner.nextInt();
            accountMap.put(account, new Account(account, password, 0));
        }
    }
}
