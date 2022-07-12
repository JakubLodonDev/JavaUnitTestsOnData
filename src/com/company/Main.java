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
}