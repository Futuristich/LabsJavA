import java.util.Scanner;
import static java.lang.Integer.MAX_VALUE;

public class laba1 {
    public static void main(String[] args) {
        laba1_1();   // 1. Сиракузская последовательность
        laba1_2();   // 2. Сумма Ряда
        laba1_3();   // 3. Ищем клад
        laba1_4();   // 4. Логистический максимин
        laba1_5();   // 5. Дважды четное число
    }

    private static void laba1_1() {
        System.out.println("Введите n1 =");
        Scanner in = new Scanner(System.in);
        int step = 0, n = in.nextInt();
        if (n==1){
            step = 3;
        }
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            step++;
        }

        System.out.println(step);
    }

    private static void laba1_2() {
        System.out.print("Введите n2 = ");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt(), result = 0;

        int array_num[] = new int[number];
        for (int i = 0; i < number; i++)
        {
            array_num[i] = in.nextInt();
        }
        for (int i = 0; i < number; i++)
        {
            result += (int) (array_num[i] * Math.pow(-1, i));  // знакочередующийся ряд
        }
        System.out.println(result);
    }

    private static void laba1_3() {
        int x = 0, y = 0;
        boolean play = true, found = false;
        System.out.println("Введите координаты x, y: ");
        Scanner in = new Scanner(System.in);
        int X = in.nextInt();
        int Y = in.nextInt();
        int number_of_steps;    // кол-во шагов
        int result = 0;         //необходимое кол-во указаний
        String movement = "";    // движение
        while (play)
        {
            movement = in.next();
            if (movement.equals("стоп") && found){
                play = false;      
                continue;
            }
            number_of_steps = in.nextInt();
            if (movement.equals("север") && !found)
            {
                y+=number_of_steps;
                result++;
            }
            if (movement.equals("юг") && !found)
            {
                y-=number_of_steps;
                result++;
            }
            if (movement.equals("запад") && !found)
            {
                x-=number_of_steps;
                result++;
            }
            if (movement.equals("восток") && !found)
            {
                x+=number_of_steps;
                result++;
            }
            if (x == X && y == Y && !found)
            {
                found = true;   
            }
        }
        System.out.println(result);
    }
    private static void laba1_4() {
        int  road = 0, result = 0;
        Scanner in = new Scanner(System.in);
        int number_of_roads = in.nextInt();
        for (int i = 0; i < number_of_roads; i++){
            int min = Integer.MAX_VALUE;
            int number_of_tunnels = in.nextInt();
            for (int j = 0; j < number_of_tunnels; j++){
                int height = in.nextInt();
                if (min > height){
                    min = height;
                }
            }
            if (result < min){
                result = min;
                road = i+1;
            }
        }
        System.out.println(road + " " + result);
    }
    private static void laba1_5() {
        System.out.println("Введите трехзначное число =");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = n % 10;
        int b = (n % 100) / 10;
        int c = n / 100;
        if (n > 0) {
            if (((a + b + c) % 2 == 0) && ((a * b * c) % 2 == 0)) {
                System.out.println("Дваджы четное число");
            } else System.out.println("Не дваджы четное число");
        }
    }

}
