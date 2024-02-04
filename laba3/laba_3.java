import java.util.Scanner;

public class laba_3 {
    public static void main(String[] args) {
        Hall[] halls = new Hall[1];
        Hall hall_1 = new Hall(1, 4, 5);
        halls[0] = hall_1;

        Seance[] seances = new Seance[1];
        Seance seance_1 = new Seance("Полтергейст", hall_1);
        seances[0] = seance_1;


        Cinema[] cinemas = new Cinema[1];
        Cinema cinema = new Cinema(halls, "Синема", seances);
        cinemas[0]= cinema;

        boolean flag = true;
        boolean admin = false;
        boolean user = false;
        while(flag){
            System.out.println("Представьтесь кто вы!");
            System.out.println(" 1. Admin \n" +
                               " 2. User \n" +
                               " 3. Выход \n");
            Scanner scanner = new Scanner(System.in);
            int choice1 = scanner.nextInt();
            if (choice1 == 1) admin = true;
            if (choice1 == 2) user = true;
            if (choice1 == 3) flag = false;

            while(admin){
                System.out.println("Выберите действие :\n" +
                                   " 1. Добавить кинотеатр.\n"+
                                   " 2. Добавить зал.\n"+
                                   " 3. Добавить сеанс.\n" +
                                   " 4. Вернуться назад.\n");
                int choice2 = scanner.nextInt();
                if (choice2 == 1) cinemas = creatCinema(cinemas);  //  создание кинотеатра
                if (choice2 == 2)  cinemas = creatHall(cinemas);   // создание зала
                if (choice2 == 3)  cinemas = creatSeance(cinemas);  // создание сеанса
                if (choice2 == 4) admin = false;
            }
            while(user){
                System.out.println("Выберите действие :\n" +
                        " 1. Купить билет.\n"+
                        " 2. Просмотреть все сеансы.\n"+
                        " 3. Вернуться назад.\n");
                int  choice3 = scanner.nextInt();
                if (choice3 == 1) cinemas = BuyTicket(cinemas); // Купить билет
                if (choice3 == 2) printSeances(cinemas);        // все сеансы
                if (choice3 == 3) user = false;
            }
        }


    }

    public static Cinema[] BuyTicket(Cinema[] cinemas){
        printSeances(cinemas);
        System.out.println("Выберите кинотеатр:");
        for(int i = 0; i < cinemas.length; i++){
            System.out.println((i+1) + " - " + cinemas[i].getName());
        }
        Scanner scanner = new Scanner(System.in);
        int number_c = scanner.nextInt();
        number_c = number_c - 1;
        for (int i = 0; i < cinemas[number_c].getSeances().length; i++){
            System.out.println((i+1) + ". Сеанс - " + cinemas[number_c].getSeances()[i].getName());
        }
        System.out.print("\n");
        System.out.println("Выберите номер сеанса");
        int number_s = scanner.nextInt();
        number_s -= 1;
        int[][] seats = cinemas[number_c].getSeances()[number_s].getSeats();
        System.out.println("Рассадка мест:");
        System.out.println("         Места:");
        System.out.print("         ");
        for (int k = 0; k < cinemas[number_c].getSeances()[number_s].getHall().getPlace(); k++){
            System.out.print((k+1) + " ");
        }
        System.out.println();
        for (int row =0; row < seats.length; row++ ) {
            System.out.print("Ряд - " + (row +1) + ": ");
            for (int place = 0; place < seats[row].length; place++) {
                System.out.print(seats[row][place] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(" Выберите ряд:\n");
        int buyRow = scanner.nextInt();
        System.out.println(" Выберите место:\n");
        int buyPlase = scanner.nextInt();
        seats[buyRow - 1][buyPlase - 1] = 1;
        System.out.println("Билет куплен!");
        System.out.println("--------------------------");
        return cinemas;
    }

    public static void printSeances(Cinema[] cinemas) {
        for(int i = 0; i < cinemas.length; i++ ){
            System.out.println("Кинотеатр - " + cinemas[i].getName());
            for(int j =0; j < cinemas[i].getSeances().length; j++){
                System.out.println("Зал №" + cinemas[i].getSeances()[j].getHall().getNumber());
                System.out.println("Сеанс - " + cinemas[i].getSeances()[j].getName());
                System.out.println();
                int[][] seats = cinemas[i].getSeances()[j].getSeats();
                System.out.println("Рассадка мест:");
                System.out.println("          Места:");
                System.out.print("         ");
                for (int k = 0; k < cinemas[i].getSeances()[j].getHall().getPlace(); k++){
                    System.out.print((k+1) + " ");
                }
                System.out.println();
                for (int row =0; row < seats.length; row++ ){
                    System.out.print("Ряд - " + (row +1) + ": ");
                    for (int place =0; place < seats[row].length; place++ ){
                        System.out.print(seats[row][place] + " ");
                    }
                    System.out.println();
                }
            }
            System.out.println("--------------------------");
        }
    }

    public static Cinema[] creatSeance(Cinema[] cinemas) {
        System.out.println("Выберите кинотеатр: ");
        for(int i = 0; i < cinemas.length; i++){
            System.out.println((i+1) + " - " + cinemas[i].getName());
        }
        Scanner scanner = new Scanner(System.in);
        int number_c = scanner.nextInt();
        number_c = number_c - 1;
        System.out.println("Выберите номер зал: ");
        for(int i = 0; i < cinemas[number_c].getHalls().length; i++){
            System.out.println(" № " + (i + 1));
        }
        int number_h = scanner.nextInt();
        number_h = number_h - 1;
        Seance[] seancesNew = stepUpS(cinemas[number_c].getSeances());
        System.out.print(" Название будущего сеанса - ");
        scanner.nextLine();
        String nameSeance = scanner.nextLine();
        Seance seance = new Seance(nameSeance, cinemas[number_c].getHalls()[number_h]);
        seancesNew[seancesNew.length - 1] = seance;
        cinemas[number_c].setSeances(seancesNew);
        System.out.println("Сеанс успешно создан!");
        System.out.println("--------------------------");
        return cinemas;


    }

    public static Seance[] stepUpS(Seance[] seances) {
       Seance[] clone = new Seance[seances.length + 1];
        for( int i = 0; i < seances.length; i++ ){
            clone[i] = seances[i];
        }
        return clone;
    }

    public static Cinema[] creatHall(Cinema[] cinemas) {
        System.out.println("Выберите кинотеатр:");
        for(int i = 0; i < cinemas.length; i++){
            System.out.println((i+1) + " - " + cinemas[i].getName());
        }
        Scanner scanner = new Scanner(System.in);
        int number_с = scanner.nextInt();
        number_с = number_с - 1;
        Hall[] halls = cinemas[number_с].getHalls();
        Hall[] hallsNew = stepUpH(halls);
        int number_hall = halls.length - 1;
        Scanner scanner1 = new Scanner(System.in);
        System.out.print(" Введите количество рядов  - ");
        int  row = scanner1.nextInt();
        System.out.print(" Введите количество мест  - ");
        int  place = scanner1.nextInt();
        Hall hall = new Hall(number_hall, row, place);
        hallsNew[halls.length] = hall;
        cinemas[number_с].setHalls(hallsNew);
        System.out.println("Зал успешно добавлен в кинотеатр!");
        System.out.println("--------------------------");
        return cinemas;
    }

    public static Hall[] stepUpH(Hall[] halls) {
        Hall[] clone = new Hall[halls.length + 1];
        for( int i = 0; i < halls.length; i++ ){
            clone[i] = halls[i];
        }
        return clone;
    }

    public static Cinema[] creatCinema(Cinema[] cinemas) {
        System.out.print("Введите название будущего кинотеатра - ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.print(" Введите количество залов  - ");
        int amount_h = scanner.nextInt();
        Hall[] halls = new Hall[amount_h];
        for( int i = 0; i < amount_h; i++){
            int number_hall = i + 1;
            Scanner scanner1 = new Scanner(System.in);
            System.out.print(" Введите количество рядов  - ");
            int  row = scanner1.nextInt();
            System.out.print(" Введите количество мест  - ");
            int  place = scanner1.nextInt();
            Hall hall = new Hall(number_hall, row, place);
            halls[i] = hall;
        }
        Seance[] seances = new Seance[0];
        Cinema cinema = new Cinema(halls, name, seances);
        cinemas = stepUpC(cinemas);
        cinemas[cinemas.length - 1] = cinema;
        System.out.println("Кинотератр " + name + " успешно создан!");
        System.out.println("--------------------------");
        return cinemas;

    }

    public static Cinema[] stepUpC(Cinema[] cinemas){
        Cinema[] clone = new Cinema[cinemas.length + 1];
        for( int i = 0; i < cinemas.length; i++ ){
            clone[i] = cinemas[i];
        }
        return clone;
    }

}
