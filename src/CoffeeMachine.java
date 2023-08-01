import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        String buy = "구매";
        String fill = "채우기";
        String take = "가져가기";
        String exit = "종료";
        Scanner sc = new Scanner(System.in);

        System.out.println("커피 머신이 가동되어습니다.");
        System.out.println();
        System.out.println("현재 커피머신 상태:");
        System.out.println("남은 재료와 돈 상태:");
        System.out.println("물: 400ml");
        System.out.println("우유: 540ml");
        System.out.println("원두: 120g");
        System.out.println("일회용 컵: 9개");
        System.out.println("돈: 50000원");

    public static void initialize(){
        buy = "구매";
        fill = "채우기";
        take = "가져가기";
        exit = "종료";
    }

    public static void user(){
        boolean first = true;
        int money = 50000;

            while(true) {
                System.out.println("==================================================");
                System.out.println("꽃 자판기 입니다. (번호:상품(재고))");
                // 번호:메뉴(가격) - 재고 출력
                for(int i = 0 ; i < 4000; i++) {
                    System.out.print((i+1) + ":" + buy + "(" + fill + "W)-" + take + "개   ");
                }

        }






    }
}

