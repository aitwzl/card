import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

abstract class Card {
    ArrayList<HashMap> cardList = new ArrayList<>();
    HashMap<String, String> cards = new HashMap<>();
    String findName;
    String action;
    String line = "-----------------------------";
    String doubleLine = "=============================";

    Scanner sc = new Scanner(System.in);

    void newCard() {
        System.out.println("\n***当前在使用：新增名片***");
    }

    void searchCard() {
        System.out.println("\n***当前在使用：搜索名片***");

        if (cardList.isEmpty()) {
            System.out.println("当前没有任何记录，请使用新增功能添加！if\n");
            return;
        }
        //1.提示用户输入搜索姓名
        System.out.print("请输入要查询的姓名：");
        findName = sc.next();

        //2.遍历，查询，
        if (cardList.isEmpty()) {
            System.out.println("当前没有任何记录，请使用新增功能添加！emp\n");
            return;
        }
    }

    void dealCard(HashMap findCard) {
        System.out.print("请输入想对名片的操作\n1.修改 2.删除 0.返回上级：");
        action = sc.next();
    }

    /**
     * @param oldValue 原有值
     * @param tipMessage 提示信息
     * @return 返回
     */
    String inputInfo(String oldValue, String tipMessage) {
        //1.提示用户输入内容
        System.out.print(tipMessage);
        return sc.next();
    }
}
