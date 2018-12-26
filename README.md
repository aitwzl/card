### 【名片管理系统】V1.0

##### 对Java SE的一个巩固

1.功能概述：

- 该系统可以在终端环境下，一次性的操作对名片的新增、查看、搜索、修改、删除等功能，有着人性化且优雅的交互。
- 可以存储员工名片的姓名、电话、QQ、邮箱和学生名片的姓名、班级、学号、性别。

2.核心实现：

- 主要使用了ArrayList与HashMap结合实现名片的存储与检索等
- ArrayList里的泛型是HashMap，每一个ArrayList里都含有一个HashMap<String, String>，利用了ArrayList的可索引的特性，而HashMap可以存储键值对并针对Key或Value进行增删改查的操作，此处并未对数字进行校验。

3.文件构成:  

- CardMain.java：程序入口
- Card.java：被继承的名片类
- EmployeeCard.java：员工名片
- StudentCard.java：学生名片    
- CardTools.java：功能实现 

5.测试环境:

- JDK：
  1.8.0_191  
- OS：
  Deepin 15.8

2018年12月17日20:25:16

2018-12-26 18:33:04 

非要我加一些类，没办法又写了点  。。