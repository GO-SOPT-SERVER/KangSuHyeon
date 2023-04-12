package controller;

import java.util.Scanner;

public class MainController {
    public void run() {
        Scanner scanner = new Scanner(System.in);

        AccountController accountController = new AccountController();

        int select = 0;
        while(select != 3) {
            System.out.println("<은행>\n" +
                    "1. 기존 계좌 입력   2. 신규 계좌 생성  3. 종료\n"
            + "원하시는 거래를 선택하세요.");
            select = scanner.nextInt();
            accountController.run(select);
        }
    }
}
