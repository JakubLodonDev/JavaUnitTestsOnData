package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentsAvg {

    public StudentsAvg() {
    }

    public static List<String> calculateAvgMarkForStudents(String[] dataSet) throws MultipleSeparatorUsedException, SeparatorDoesntExists {
        List<String> result = new ArrayList<String>();
        for (var entry : dataSet) {
            var separator = getSeparator(entry);
            var splittedEntry = entry.split(separator);
            var markStrings = Arrays.copyOfRange(splittedEntry, 2, splittedEntry.length);

            var studentName = getStudentName(splittedEntry[0], splittedEntry[1]);
            var marks = getMarks(markStrings);
            var average = calculateAverage(marks);

            result.add(studentName + "-" + average);
        }


        return result;
    }

    public static String getStudentName(String name, String surname){
        return name + " " + surname;
    }

    public static Double calculateAverage(List<Integer> marks){
        double sumMarks = 0;
        double amountMarks=0;
        for (double singleMarks:marks) {
            sumMarks+=singleMarks;
            amountMarks++;
        }
        return sumMarks/amountMarks;
    }

    public static List<Integer> getMarks(String[] marks)
    {
        var result = new ArrayList<Integer>();

        for (var mark: marks) {
            try {
                var parsedMark = Integer.parseInt(mark);

                if(parsedMark > 10){
                    continue;
                }
                result.add(parsedMark);
            }
            catch (NumberFormatException ex){ //Assert Exception
               // throw ex;
            }
        }

        return result;
    }

    public static String getSeparator(String entry) throws MultipleSeparatorUsedException, SeparatorDoesntExists {
        var count = 0;
        var separator = " ";
        String[] allowedSeparators= {";","-"," "};
        for(int i =0;i<allowedSeparators.length;i++){
            if(entry.contains(allowedSeparators[i])){
                count++;
                separator=allowedSeparators[i];
            }
        }

        if(count==0) {
            throw new SeparatorDoesntExists();
        }
        if(count>1){
            throw new MultipleSeparatorUsedException();
        }
        return separator;

    }
}
