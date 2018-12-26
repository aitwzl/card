import java.util.Scanner;

public class CardMain {
    static String line = "-----------------------------";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StudentCard sCard = new StudentCard();
        EmployeeCard eCard = new EmployeeCard();

        while (true) {
            showMenu();
            System.out.print("请选择希望执行的操作：");
            String select = sc.next();
            System.out.print("您选择的操作是 " + select);

            if (select.equals("0")) {
                System.out.println("\n欢迎再次使用【名片管理系统】 再见");
                break;
            } else {
                switch (select) {
                    case "1":
                        System.out.println("\n1.员工名片\t\t2.学生名片");
                        System.out.print("\n请选择希望添加的名片类型：");
                        while (true) {
                            String select2 = sc.next();
                            if (select2.equals("1")) {
                                eCard.newCard();
                                break;
                            } else if (select2.equals("2")) {
                                sCard.newCard();
                                break;
                            } else {
                                System.out.println("您输入的不正确，请重新选择1");
                            }
                        }
                        break;
                    case "2":
                        eCard.showAll();
                        sCard.showAll();
                        break;
                    case "3":
                        System.out.println("\n1.员工名片\t\t2.学生名片");
                        System.out.print("请选择希望搜索的名片类型：");

                        while (true) {
                            String select3 = sc.next();
                            if (select3.equals("1")) {
                                eCard.searchCard();
                                break;
                            } else if (select3.equals("2")) {
                                sCard.searchCard();
                                break;
                            } else {
                                System.out.println("\n您输入的不正确，请重新选择2");
                            }
                        }
                        break;
                    default:
                        System.out.println("\n您输入的不正确，请重新选择3");
                }
            }
        }
    }

    //显示菜单
    static void showMenu() {
        System.out.println(line);
        System.out.println("欢迎使用【名片管理系统】V1.0");
        System.out.println("1.新增名片\t\t2.显示全部");
        System.out.println("3.搜索名片\t\t0.退出系统");

        System.out.println(line);
    }
}
