package com.company;

import java.util.List;


public class Main {

    public static void main(String[] args) throws MultipleSeparatorUsedException, SeparatorDoesntExists {

    String[] dataSet = {"Marysia Mikołaj 9 3 6 3 1","Andrzej Kij 11 3 5 10","Andrzej;Kij;11;3;5;10",
            "Andrzej-Kij-11-3-5-10","Marysia Mikołaj 9 3 dupa 3 1"};
    StudentsAvg studentsAvg = new StudentsAvg();


    List<String> studentsWithAvgMark = studentsAvg.calculateAvgMarkForStudents(dataSet);
        for (var student : studentsWithAvgMark) {
            System.out.println(student);
        }
    }














/*

    public static String[] dataAnalists( String[] students ) {

        for (int i = 0; i< students.length;i++) {
            int avg = 0;
            int amount = 0;
            String currentPerson = students[i];
            String namePerson = null;
            int x =0;

            for (int j = 0; j<=currentPerson.length()-1;j++) {
                int currentChar = currentPerson.charAt(j);

                if(49<=currentChar && currentChar<=57 && x==0){
                    namePerson = currentPerson.substring(0,j);
                    x++;
                }

                if(50<=currentChar && currentChar<=57){
                    avg+=(currentChar-48);
                    amount++;
                }

                if(currentChar==49){
                    if(j==currentPerson.length()-1){
                        avg+=1;
                        amount++;
                    }
                    else if(currentPerson.charAt(j+1)==48 &&j!=currentPerson.length()){
                        avg+=10;
                        amount++;
                    }
                    else if(j!=currentPerson.length()&&(49>=currentPerson.charAt(j+1) && currentPerson.charAt(j+1)>=57)){
                        avg+=1;
                        amount++;
                    }
                    else {
                        j++;
                    }
                }

            }
            avg=avg/amount;
            namePerson+="-"+avg;
            students[i]= namePerson;
        }

        return students;
    }*/
}