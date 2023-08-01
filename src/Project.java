package day08;

import java.util.Scanner;


public class Project {
    public static final int MAX = 10; // 메뉴의 최대 갯수 == 10

    // 전역변수 선언
    static String[] box = new String[MAX];
    static int[] price = new int[MAX];
    static int[] stock = new int[MAX];
    static int count = 4; // 메뉴의 갯수
    static int admin = 1004; // 관리자 메뉴로 가는 비밀번호
    static int profit = 0; // 총 수익
    static Scanner sc = new Scanner(System.in);

    // 처음 자판기를 초기화 하는 함수
    public static void initialize() {
        box[0] = "구매";
        price[0] = 500;
        stock[0] = 3;
        box[1] = "채우기";
        price[1] = 1000;
        stock[1] = 3;
        box[2] = "가져오기";
        price[2] = 3000;
        stock[2] = 3;
        box[3] = "종료";

    }

    // 관리자 페이지를 담당하는 함수
    public static void admin() {
        while(true) {
            System.out.println("==================================================");
            System.out.println("관리자 페이지 입니다.");
            System.out.println("1: 메뉴 변경 2: 가격 변경 3: 재고 추가 4: 메뉴 추가 5: 수익 확인 (종료는 -1)");
            System.out.print("번호를 입력하세요: ");
            int num = sc.nextInt();
            System.out.println("==================================================");

            // 1. 메뉴 변경
            if(num == 1) {
                System.out.print("변경하실 메뉴의 번호를 입력하세요(1~" + count + ") :");
                int i = sc.nextInt();
                System.out.print(box[i-1] + "를(을) 무엇으로 바꾸시겠습니까? :");
                sc.nextLine();
                String name = sc.next();
                System.out.print(name + "의 가격은 얼마입니까? ");
                int v = sc.nextInt();
                System.out.print(name + "의 재고를 몇 개 등록하시겠습니까? : ");
                int n = sc.nextInt();

                box[i-1] = name;
                price[i-1] = v;
                stock[i-1] = n;
                System.out.println("메뉴 변경이 완료되었습니다!");
            }
            // 2. 가격 변경
            else if(num == 2) {
                System.out.print("가격을 변경하실 메뉴의 번호를 입력하세요(1~" + count + ") :");
                int i = sc.nextInt();
                System.out.print(box[i-1] + "의 가격을 얼마로 바꾸시겠습니까? :");
                int j = sc.nextInt();
                price[i-1] = j;
                System.out.println("가격 변경이 완료되었습니다!");
            }
            // 3. 재고 추가
            else if(num == 3) {
                System.out.print("재고를 추가하실 메뉴의 번호를 입력하세요(1~" + count + ") :");
                int i = sc.nextInt();
                System.out.print(box[i-1] + "를(을) 몇 개 추가 하시겠습니까? :");
                int j = sc.nextInt();
                stock[i-1] += j;
                System.out.println("재고 추가가 완료되었습니다!");
            }
            // 4. 메뉴 추가
            else if(num == 4) {
                if(count >= MAX - 1) {
                    System.out.println("더 이상 메뉴가 들어갈 자리가 없습니다!");
                    continue;
                }
                else {
                    System.out.print("추가하실 메뉴의 가격을 입력하세요 : ");
                    int i = sc.nextInt();
                    System.out.print("추가하실 메뉴의 이름을 입력하세요 : ");
                    sc.nextLine();
                    String name = sc.next();
                    System.out.print(name + "의 재고는 몇 개 입니까? : ");
                    int j = sc.nextInt();

                    box[count] = name;
                    price[count] = i;
                    stock[count] = j;
                    count++;
                    System.out.println("메뉴 추가가 완료되었습니다!");
                }
            }

            // 5. 수익 확인
            else if(num == 5) {
                System.out.println("현재까지의 수익은 " + profit + "입니다.");
            }
            // -1을 입력하면 다시 자판기 메뉴로 돌아감
            else if(num == -1) {
                user();
                return;
            }
        }
    }

    // 유저 인터페이스를 담당하는 함수
    public static void user() {
        Boolean first = true;
        int money = 0;

        while(true) {
            System.out.println("커피 머신이 가동 되었습니다.");
            System.out.println("현재 커피머신 상태:");
            System.out.println("물: 400ml");
            System.out.println("우유: 540ml");
            System.out.println("원두: 120g");
            System.out.println("일회용 컵: 9개");
            System.out.println("돈: 50000원");
            // 번호:메뉴(가격) - 재고 출력
            for(int i = 0 ; i < count; i++) {
                System.out.print((i+1) + ":" + box[i] + "(" + price[i] + "W)-" + stock[i] + "개   ");
            }

            System.out.println();
            System.out.println("==================================================");

            // 처음에만 돈을 입력받고 잔돈 반환 전 까지는 돈을 입력받지 않는다.
            if(first){
                System.out.print("돈을 넣어주세요: ");
                money = sc.nextInt();
                first = false;
            }

            // 관리자 비밀번호는 1004, 입력하면 관리자 함수로 넘어감.
            if(money == 1004) {
                admin();
                return;
            }

            System.out.print("메뉴 입력: ");
            int num = sc.nextInt();

            // 돈이 충분한가?
            if(money >= price[num-1]) {
                // 재고가 충분한가?
                if(stock[num-1] > 0) {
                    money = money - price[num-1];
                    stock[num-1]--;
                    profit += price[num-1];
                    System.out.println(box[num-1] + "이(가) 나왔다!");
                }
                else {
                    System.out.println("현재 재고가 없습니다!");
                    continue;
                }
            }
            else {
                System.out.println("잔액이 부족합니다!");
            }

            System.out.println("잔액 : " + money);

            // 모든 돈을 사용하면 이용 종료 후 초기화면 진입
            if(money == 0) {
                System.out.println("감사합니다! 다음에 또 이용해주세요!!");
                first = true;
                continue;
            }

            // 돈이 남아있다면 선택지를 준다.
            System.out.println("1: 계속 구매하기 2: 금액 추가하기 3: 잔돈 반환하기 ");
            System.out.print("번호를 입력하세요: ");
            int num1 = sc.nextInt();

            if(num1 == 1) {
                continue;
            }
            else if (num1 == 2) {
                System.out.print("돈을 넣어주세요 : ");
                int extra = sc.nextInt();
                money += extra;
                System.out.println("금액이 추가되었습니다! 잔액: " + money);
            }

            else if(num1 == 3) {
                System.out.println("거스름돈 " + money + "원이 반환됩니다.");
                System.out.println("감사합니다! 다음에 또 이용해주세요!!");
                first = true;
            }

        }
    }

    public static void main(String[] args) {
        initialize();
        user();
        return;

    }
}

