package com.company;

import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentsAvgTest extends Throwable{
    @Test
    void WhiteSpaceSeparatorOnly_ReturnStudentsWithAvgMarks() throws MultipleSeparatorUsedException, SeparatorDoesntExists {
        //Arrange
        String[] dataSet = {"Marysia Mikołaj 9 3 6 3 1"};
        var students = new StudentsAvg();

        //Act
        var result = students.calculateAvgMarkForStudents(dataSet);

        //Assert
        String expection = "Marysia Mikołaj-4.4";
        assertEquals(expection,result.stream().findFirst().get());
    }

    @Test
    void twoDataWithWhiteSpaceSeparatorOnly_ReturnStudentsWithAvgMarks() throws MultipleSeparatorUsedException, SeparatorDoesntExists {
        //Arrange
        String[] dataSet = {"Marysia Mikołaj 9 3 6 3 1","Andrzej Kij 11 3 5 10"};
        var students = new StudentsAvg();

        //Act
        List<String> result = students.calculateAvgMarkForStudents(dataSet);

        //Assert
        String[] expection = {"Marysia Mikołaj-4.4","Andrzej Kij-6.0"};
        for (int i =0;i<dataSet.length;i++) {
            assertEquals(expection[i], result.get(i));
        }
    }

    @Test
    void fourDataWithDiffrentSeparator_ReturnStudentsWithAvgMarks() throws MultipleSeparatorUsedException, SeparatorDoesntExists {
        //Arrange
        String[] dataSet = {"Marysia Mikołaj 9 3 6 3 1","Andrzej Kij 11 3 5 10","Andrzej;Kij;11;3;5;10",
                "Andrzej-Kij-11-3-5-10"};
        var students = new StudentsAvg();

        //Act
        List<String> result = students.calculateAvgMarkForStudents(dataSet);

        //Assert
        String[] expection = {"Marysia Mikołaj-4.4","Andrzej Kij-6.0","Andrzej Kij-6.0","Andrzej Kij-6.0"};
        for (int i =0;i<dataSet.length;i++) {
            assertEquals(expection[i], result.get(i));
        }
    }

    @Test
    void NotSupportedSeparator_ThrowsSeparatorDoesntExists(){
        //Arrange
        String[] dataSet = {"Marysia%Mikołaj%9%3%6%3%1"};
        var students = new StudentsAvg();

        //Act
        //Assert
        assertThrows(SeparatorDoesntExists.class,
                () -> {
                    students.calculateAvgMarkForStudents(dataSet);
                });

    }

    @Test
    void MultipleSeparator_ThrowsMultipleSeparatorUsedException(){
        //Arrange
        String[] dataSet = {"Marysia-Mikołaj 9-3 6;3;1"};
        var students = new StudentsAvg();

        //Act
        //Assert
        assertThrows(MultipleSeparatorUsedException.class,
                () -> {
                    students.calculateAvgMarkForStudents(dataSet);
                });
    }
}