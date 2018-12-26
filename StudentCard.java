import java.util.HashMap;

public class StudentCard extends Card {
    @Override
    void newCard() {
        super.newCard();

        //提示用户输入名片详细信息,把信息放入HashMap
        System.out.print("请输入姓名：");
        String name = sc.next();
        cards.put("name", name);

        System.out.print("请输入班级：");
        cards.put("class", sc.next());
        System.out.print("请输入学号：");
        cards.put("sno", sc.next());
        System.out.print("请输入性别：");
        cards.put("gender", sc.next());

        //2.把hashMap放入list
        cardList.add(cards);
        System.out.println("添加 " + name + " 的名片成功!\n");
    }

    void showAll() {
        // 判读是否存在记录，如没有提示用户
        if (cardList.isEmpty()) {
            System.out.println("学生名片表没有任何记录，请使用新增功能添加！\n");
            return;
        }
        //打印表头
        System.out.println(doubleLine);
        System.out.println("【学生名片表】");
        System.out.println("姓名\t\t班级\t\t学号\t\t性别");
        System.out.println(line);

        //遍历名片列表依次输出HashMap信息
        for (HashMap cards : cardList) {
            System.out.println(cards.get("name") + "\t\t" + cards.get("class") + "\t\t" + cards.get("sno") + "\t\t" + cards.get("gender") + "\t\t");
        }
        System.out.println();
    }

    @Override
    void searchCard() {
        super.searchCard();

        int i = 0;
        while (true) {

            //如果某个HashMap里包含该name，则打印相应的信息
            if (i > cardList.size()) {
                System.out.println("抱歉，没有找到 " + findName);
                break;
            }
            if (cardList.get(i).containsValue(findName)) {
                System.out.println("姓名\t\t班级\t\t学号\t\t性别");
                System.out.println(line);
                System.out.println(cardList.get(i).get("name") + "\t\t" + cardList.get(i).get("class") + "\t\t" +
                        cardList.get(i).get("sno") + "\t\t" + cardList.get(i).get("gender") + "\t\t");

                //针对找到的名片是否记录执行修改和删除操作
                dealCard(cardList.get(i));
                break;
            }
            i++;
        }
    }

    @Override
    void dealCard(HashMap findCard) {
        super.dealCard(findCard);

        //根据输入的操作进行不同的操作
        if (action.equals("1")) {
            System.out.println("正在修改 " + findCard.get("name") + " 的名片");
            findCard.put("name", inputInfo((String)findCard.get("name"), "请输入新姓名："));
            findCard.put("class", inputInfo((String)findCard.get("class"), "请输入新班级："));
            findCard.put("sno", inputInfo((String)findCard.get("sno"), "请输入新学号："));
            findCard.put("gender", inputInfo((String)findCard.get("gender"), "请输入新性别："));

            System.out.println("修改名片成功！");
        } else if (action.equals("2")) {
            cardList.remove(findCard);
            System.out.println("删除名片 " + findCard.get("name") + " 成功！\n");
        }

    }
}
