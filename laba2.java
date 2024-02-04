import java.util.Arrays;

public class laba2 {
    public static void main(String[] args) {
    //     laba2_1();     // 1. Наибольшая идентичная строка
    //     laba2_2();     // 2. Обьеинение массивов
    //     laba2_3();     // 3. Максимальная сумма подмассива
    //     laba2_4();     // 4. Поворот массива на 90 градусов по часовой
    //     laba2_5();     // 5. Поиск пары элементов в массиве, сумма которых равна заданному числу
    //     laba2_6();     // 6. Сумма всех элементов в двумерном массиве
    //     laba2_7();     // 7. Максимальный элемент каждой строки двумерного массива
    //     laba2_8();     // 8. Поворот двумерного массива на 90 градусов против часовой
    }
    public static void laba2_1(){
        String str = "dturdjddrwsgli";
        int len = str.length();
        int i = 0, j = 0, str1 = 0, str2 = 0;
        int res = 0;
        StringBuilder string_symbols = new StringBuilder();
        char arr[] = new char[len];
        for (int t = 0; t < len; t++)
        {
            arr[t] = str.charAt(t);
        }
        while (i < len && j < len)
        {
            if (string_symbols.toString().indexOf(arr[j]) == -1)
            {
                string_symbols.append(arr[j]);
                j++;
                if (j - i > res)
                {
                    str1 = i;
                    str2 = j;
                    res = j - i;
                }
            }
            else             // если символ пповторяется
            {
                if (i == j)
                {
                    j++;
                }
                string_symbols = new StringBuilder(string_symbols.toString().replace(arr[i], ' '));
                i++;
            }
        }
        System.out.println(str.substring(str1, str2));
    }

    public static void laba2_2()
    {
        int arr1[] = new int[] {31, 1, -666, 706, 1234};
        int arr2[] = new int[] {9,-8, 100, 200};
        int size1 = arr1.length, size2 = arr2.length, ResArray[] = new int[size1 + size2];
        System.arraycopy(arr1, 0, ResArray, 0, size1);
        int j = 0;
        for (int i = size1; i < size1 + size2; i++)
        {
            ResArray[i] = arr2[j];
            j++;
        }
        Arrays.sort(ResArray);
        for (int i = 0; i < size1 + size2; i++)
        {
            System.out.println(ResArray[i]);
        }

    }
    public static void laba2_3()
    {
        int arr[] = new int[] {1, 10, 12, -7, 65};
        int res = 0, sum = 0;
        for (int i : arr)
        {
            sum = sum + i;
            sum = Math.max(sum, 0);
            res = Math.max(res, sum);
        }
        int max = Arrays.stream(arr).max().getAsInt();
        if (max < 0)
        {
            res = max;
        }
        System.out.println(res);
    }
    public static void laba2_4()
    {
        int arr[][] = new int[][]{ {1, 4, 7}, {22, 44, 66}, {81, 101, 188}};
        int inverted_arr[][] = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[0].length; j++)
            {
                inverted_arr[j][arr.length - i - 1] = arr[i][j];
            }
        }
        for (int[] i : inverted_arr)
        {
            for (int num : i)
            {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public static void laba2_5()
    {
        int arr[] = new int[] {-2, 78, 22, -11, 7, 1};
        int sum =100 ;
        boolean couple = false;
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr.length; j++)
            {
                if (arr[i] + arr[j] == sum)
                {
                    System.out.println(arr[i] + " " + arr[j]);
                    couple = true;
                }
            }
        }
        if (!couple)
        {
            System.out.println("Not found");
        }
    }
    public static void laba2_6()
    {
        int arr[][] = new int[][]{{1, 2, 4}, {11, 16, 35}, {50, 111, 666}};
        int res = 0;
        for(int i=0; i < arr.length; i++)
        {
            for (int j = 0; j < arr.length; j++)
            {
                res += arr[i][j];
            }
        }
        System.out.println(res);
    }
    public static void laba2_7()
    {
        int arr[][] = new int[][]{{1, 8, 11}, {23, 44, 66}, {78, 100, 666}};
        int res[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
            {
                if (arr[i][j] > res[i])
                {
                    res[i] = arr[i][j];
                }
            }
            System.out.print(res[i] + " ");
        }
    }
    public static void laba2_8()
    {
        int arr[][] = new int[][] {{1, 2, 3}, {7, 8, 9}, {52, 53, 54}};
        int inverted_arr[][] = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[0].length; j++)
            {
                inverted_arr[j][i] = arr[i][arr[0].length - j - 1];
            }
        }
        for (int[] i : inverted_arr)
        {
            for (int num : i)
            {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}