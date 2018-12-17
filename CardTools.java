import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 张利兵
 */
public class CardTools {
    //定义存放的ArrayList
    private ArrayList<HashMap> cardList = new ArrayList<>();

    private String line = "-----------------------------";
    private String doubleLine = "=============================";

    Scanner sc = new Scanner(System.in);

    //显示菜单
    void showMenu() {
        System.out.println(line);
        System.out.println("欢迎使用【名片管理系统】V1.0");
        System.out.println("1.新增名片\t\t2.显示全部");
        System.out.println("3.搜索名片\t\t0.退出系统");

        System.out.println(line);
    }

    //新增名片
    void newCard() {
        System.out.println("\n\n***当前在使用：新增名片***");
        HashMap<String, String> cards = new HashMap<>();


        //提示用户输入名片详细信息,把信息放入HashMap
        System.out.print("请输入姓名：");
        String name = sc.next();
        cards.put("name", name);

        System.out.print("请输入电话：");
        cards.put("phone", sc.next());
        System.out.print("请输入QQ：");
        cards.put("qq", sc.next());
        System.out.print("请输入邮箱：");
        cards.put("email", sc.next());

        //2.把hashMap放入list
        cardList.add(cards);
        System.out.println(doubleLine);
        System.out.println("姓名\t\t电话\t\tQQ\t\t邮箱");
        System.out.println(cards.get("name") + "\t\t" + cards.get("phone") + "\t\t" + cards.get("qq") + "\t\t" + cards.get("email") + "\t\t");
        System.out.println(line);
        System.out.println("添加 " + name + " 的名片成功!\n");
    }

    //显示所有名片
    void showAll() {
        System.out.println("\n\n***当前在使用：显示所有名片***");

        // 判读是否存在记录，如没有提示用户
        if (cardList.isEmpty()) {
            System.out.println("当前没有任何记录，请使用新增功能添加！\n");
            return;
        }

        //打印表头
        System.out.println(doubleLine);
        System.out.println("姓名\t\t电话\t\tQQ\t\t邮箱");
        System.out.println(line);

        //遍历名片列表依次输出HashMap信息
        for (HashMap cards : cardList) {
            System.out.println(cards.get("name") + "\t\t" + cards.get("phone") + "\t\t" + cards.get("qq") + "\t\t" + cards.get("email") + "\t\t");
        }
        System.out.println();
    }

    //搜索名片
    void searchCard() {
        System.out.println("\n\n***当前在使用：搜索名片***");

        //1.提示用户输入搜索姓名
        System.out.print("请输入要查询的姓名：");
        String findName = sc.next();

        //2.遍历，查询，
        if (cardList.isEmpty()) {
            System.out.println("当前没有任何记录，请使用新增功能添加！\n");
            return;
        }

        int i = 0;
        while (true) {

            //如果某个HashMap里包含该name，则打印相应的信息
            if (i > cardList.size()) {
                System.out.println("抱歉，没有找到 " + findName);
                break;
            }
            if (cardList.get(i).containsValue(findName)) {
                System.out.println("姓名\t\t电话\t\tQQ\t\t邮箱");
                System.out.println(line);
                System.out.println(cardList.get(i).get("name") + "\t\t" + cardList.get(i).get("phone") + "\t\t" +
                        cardList.get(i).get("qq") + "\t\t" + cardList.get(i).get("email") + "\t\t");


                //针对找到的名片是否记录执行修改和删除操作
                dealCard(cardList.get(i));
                break;
            }
            i++;
        }
    }

    /**
     * 处理函数
     * @param findCard 要找的名字
     */
    private void dealCard(HashMap findCard) {
        System.out.print("请输入想对名片的操作\n1.修改 2.删除 0.返回上级：");
        String action = sc.next();

        //根据输入的操作进行不同的操作
        if (action.equals("1")) {
            System.out.println("正在修改 " + findCard.get("name") + " 的名片");
            findCard.put("name", inputInfo((String)findCard.get("name"), "请输入新姓名："));
            findCard.put("phone", inputInfo((String)findCard.get("phone"), "请输入新电话："));
            findCard.put("qq", inputInfo((String)findCard.get("qq"), "请输入新QQ："));
            findCard.put("email", inputInfo((String)findCard.get("email"), "请输入新邮箱："));

            System.out.println("修改名片成功！");
        } else if (action.equals("2")) {
            cardList.remove(findCard);
            System.out.println("删除名片 " + findCard.get("name") + " 成功！\n");
        }
    }

    /**
     *
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
