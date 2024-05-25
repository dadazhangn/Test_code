package org.example;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        guessTheNumber();
//        knockTable();
//        bubbleSort();
//        landlords();
//        imgCopy();
//        weighing();
//        daffodilsNumber();
        rabbit();

    }


    //1 Guess the number
    //系统随机生成一个1到100之间的数字，玩家进行猜测，如果猜错，提示玩家数字过大
    //或过小，如果猜对恭喜玩家胜利，并且退出游戏。
    public static void guessTheNumber() {
        Random r = new Random();
        int i = r.nextInt(100) + 1;
        System.out.println(i);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("输入值：> ");
            int num = sc.nextInt();

            if (num > i) {
                System.out.println("大了");
            } else if (num < i) {
                System.out.println("小了");
            } else {
                System.out.println("正好");
                break;
            }
        }
    }

    // knock on the table
    // 从1开始数到数字100， 如果数字个位含有7，或者数字十位含有7，或者该数字是7的
    // 倍数，我们打印敲桌子，其余数字直接打印输出
    public static void knockTable() {
        for (int i = 0; i < 100; i++) {
            if (i < 10) {
                if (i % 10 == 7) {
                    System.out.println("敲桌子");
                } else System.out.println(i);
            } else {
                if (i % 10 == 7) {
                    System.out.println("敲桌子");
                } else if ((i / 10) % 10 == 7) {
                    System.out.println("敲桌子");
                } else if (i % 7 == 0) {
                    System.out.println("敲桌子");
                } else System.out.println(i);
            }
        }
    }

    // 冒泡排序
    // ：给定一串数组 {4,2,7,5,9,1,8};，要求按照从小到大的顺序排列出来
    public static void bubbleSort() {
        int[] array = {4, 2, 7, 5, 9, 1, 8};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (int i : array) {
            System.out.println(i);
        }
    }

    // 发牌斗地主
    // ：按照斗地主的规则，完成洗牌发牌的动作。具体规则：使用54张牌打乱顺序,三个玩家
    //参与游戏，三人交替摸牌，每人17张牌，最后三张留作底牌。要求将每位玩家的牌和底牌输出在
    //控制台
    public static void landlords() {
        //牌盒
        List<String> Pokers = new ArrayList<>();
        //组装牌
        String[] s1 = {"方块", "梅花", "红桃", "黑桃"};
        String[] s2 = {"3", "4", "5", "6", "7", "8", "9", "10",
                "j", "p", "k", "1", "2"};
        for (String string2 : s2) {
            for (String string1 : s1) {
                String poker = string1 + string2;
                Pokers.add(poker);
            }
        }
        Pokers.add("大王");
        Pokers.add("小王");
        //洗牌
        Collections.shuffle(Pokers);
//        System.out.println(Pokers);

        //三个人和对应底牌的牌盒
        List<String> zspoker = new ArrayList<String>();
        List<String> lspoker = new ArrayList<String>();
        List<String> wwpoker = new ArrayList<String>();
        List<String> dppoker = new ArrayList<String>();

        //发牌
        for (int i = 0; i < Pokers.size(); i++) {
            if (i >= Pokers.size() - 3) {
                dppoker.add(Pokers.get(i));
            } else {
                if (i % 3 == 0) {
                    zspoker.add(Pokers.get(i));
                } else if (i % 3 == 1) {
                    lspoker.add(Pokers.get(i));
                } else if (i % 3 == 2) {
                    wwpoker.add(Pokers.get(i));
                }
            }
        }
        //打印牌的信息
        zspoker.forEach(str -> {
            System.out.print(str + " ");
        });
        lspoker.forEach(str -> {
            System.out.print(str + " ");
        });
        wwpoker.forEach(str -> {
            System.out.print(str + " ");
        });
        dppoker.forEach(str -> {
            System.out.print(str + " ");
        });
    }

    //图片复制
    //使用字节流完成一张图片的复制，假设D盘下有一张jay.jpg图片，要求复制到E盘下
    public static void imgCopy() {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(new File("C:\\Users\\20884\\Pictures\\Camera Roll\\头像\\dingzhen.jpg"));
            os = new FileOutputStream(new File("E:\\dingzhen.jpg"));
            int i;
            while ((i = is.read()) != -1) {
                os.write(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //三只松鼠称体重
    //三只松鼠ABC，请分别输入三只松鼠的体重，求最重的松鼠体重是多少？
    public static void weighing() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入第一只松鼠体重>: ");
        int i = sc.nextInt();
        System.out.println("输入第二只松鼠体重>: ");
        int j = sc.nextInt();
        System.out.println("输入第三只松鼠体重>: ");
        int k = sc.nextInt();

        int max = i;
//        max = Math.max(i, j);
        if (max < j) max = j;
        if (max < k) max = k;
        System.out.println("最重的松鼠体重是：" + max);
    }

    //水仙花数
    // ：水仙花数是指一个 3 位数，它的每个位上的数字的 3次幂之和等于它本身
    //例如：1^3 + 5^3+ 3^3 = 153;求出所有3位数中的水仙花数
//    public static void daffodilsNumber() {
//
//    }


    //兔子问题
    //需求描述：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月
    //又生一对兔子，假如兔子都不死，问第N个月后的兔子总数为多少？N的值从控制台获取
    public static void rabbit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入月份>: ");
        int num = sc.nextInt();
        int[] array = new int[num];
        array[0]=1;
        array[1]=1;
        for (int i = 2; i < num; i++) {
            array[i] = array[i-1]+array[i-2];
        }
        for (int i = 0; i < num; i++) {
            System.out.println("第"+(i+1)+"个月的兔子总量为："+ array[i]);
        }
    }
}



