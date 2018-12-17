import java.util.Scanner;

/**
 * @author 张利兵
 *
 */
public class CardMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CardTools ct = new CardTools();
        while (true) {
            //显示功能菜单
            ct.showMenu();
            System.out.print("请选择希望执行的操作：");
            String action = sc.next();
            System.out.print("您选择的操作是 " + action);

            //1, 2, 3是对名片的操作
            if (action.equals("0")) {
                System.out.println("\n欢迎再次使用【名片管理系统】 再见");
                break;
            } else {
                switch (action) {
                    case "1":
                        ct.newCard();
                        break;
                    case "2":
                        ct.showAll();
                        break;
                    case "3":
                        ct.searchCard();
                        break;
                    default:
                        System.out.println("\n您输入的不正确，请重新选择");
                }

            }
        }
    }
}
