package Assignment23Student;

import assignment23EmployeePrepared.Records;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        records r = new records();

        while(true){

            System.out.println("Press 0 to exit");
            System.out.println("Press 1 to alter table and add Gender column in it");
            System.out.println("Press 2 to fetch those records who are in third year and having percentage greter than 70");
            System.out.println("Press 3 to fetch those record whose id is in range of 1 to 10");
            System.out.println("Press 4 to insert record ,update student and remove");

            int choice = sc.nextInt();
            switch(choice){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                     r.alter();
                    break;
                case 2:
                    r.fetch();
                    break;
                case 3:
                      r.details();
                    break;
                case 4:
                    r.perform();
                    break;

                default:
                    System.out.println("Enter the right choice");

            }

        }

    }





}




//Press 0 to exit
//        Press 1 to alter table and add Gender column in it
//        Press 2 to fetch those records who are in third year and having percentage greter than 70
//        Press 3 to fetch those record whose id is in range of 1 to 10
//        Press 4 to insert record ,update student and remove
//        1
//        Press 0 to exit
//        Press 1 to alter table and add Gender column in it
//        Press 2 to fetch those records who are in third year and having percentage greter than 70
//        Press 3 to fetch those record whose id is in range of 1 to 10
//        Press 4 to insert record ,update student and remove
//        4
//        1 to add data
//        2 to update data
//        3 to remove data
//        0 to exit
//        1
//        Enter number of data you want to enter
//        3
//        Enter Id
//        1
//        Enter Name
//        Shreya
//        Enter year
//        3
//        Enter percentage
//        80
//        Enter city
//        Pune
//        Enter gender
//        F
//        Enter Id
//        2
//        Enter Name
//        Krati
//        Enter year
//        4
//        Enter percentage
//        80
//        Enter city
//        Pune
//        Enter gender
//        F
//        Enter Id
//        3
//        Enter Name
//        Yash
//        Enter year
//        4
//        Enter percentage
//        76
//        Enter city
//        Pune
//        Enter gender
//        M
//        Data has been inserted
//        1 to add data
//        2 to update data
//        3 to remove data
//        0 to exit
//        0
//        Press 0 to exit
//        Press 1 to alter table and add Gender column in it
//        Press 2 to fetch those records who are in third year and having percentage greter than 70
//        Press 3 to fetch those record whose id is in range of 1 to 10
//        Press 4 to insert record ,update student and remove
//        2
//        1 Shreya 3 80 Pune F
//        Press 0 to exit
//        Press 1 to alter table and add Gender column in it
//        Press 2 to fetch those records who are in third year and having percentage greter than 70
//        Press 3 to fetch those record whose id is in range of 1 to 10
//        Press 4 to insert record ,update student and remove
//        3
//        1 Shreya
//        2 Krati
//        3 Yash
//        Press 0 to exit
//        Press 1 to alter table and add Gender column in it
//        Press 2 to fetch those records who are in third year and having percentage greter than 70
//        Press 3 to fetch those record whose id is in range of 1 to 10
//        Press 4 to insert record ,update student and remove
//        4
//        1 to add data
//        2 to update data
//        3 to remove data
//        0 to exit
//        2
//        1 to add data
//        2 to update data
//        3 to remove data
//        0 to exit
//        3
//        1 to add data
//        2 to update data
//        3 to remove data
//        0 to exit