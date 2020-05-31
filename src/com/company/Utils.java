package com.company;

public class Utils {


    public static String getTheBestSubject(Student[] students){
        float[] averageMarkForEverySub = new float[5];
        for(float avrMarks:averageMarkForEverySub)
            avrMarks = 0;

        for (Student a:students) {
            Student.Subject[] subjects = a.getSubjects();
            for (int i = 0; i < subjects.length; i++){
                averageMarkForEverySub[i] += subjects[i].getMark();
            }
        }
        int maxMark = 0;
        for (int i = 0; i < 5; i++){
            if (averageMarkForEverySub[maxMark] < averageMarkForEverySub[i])
                maxMark = i;
        }
        return Student.NameSubjects.values()[maxMark].toString();
    }




    public static String getTheBestStudent(Student[] students){
        float[] averageMarkForEveryStudent = new float[students.length];
        for(float avrMarks:averageMarkForEveryStudent)
            avrMarks = 0;

        for (int j = 0; j < students.length; j++) {
            Student.Subject[] subjects = students[j].getSubjects();
            for (Student.Subject subject : subjects) {
                averageMarkForEveryStudent[j] += subject.getMark();
            }
        }

        int bestStudentId = 0;
        for (int i = 0; i < students.length; i++){
            if (averageMarkForEveryStudent[bestStudentId] < averageMarkForEveryStudent[i])
                bestStudentId = i;
        }
        return students[bestStudentId].getName() + " " + students[bestStudentId].getSurname();
    }



    public static String getStudentsAndMarks(Student[] students){

        String result = "";

        for (Student student: students) {
            float avg = student.getAverageMark();
            result += student.getName() + " " + student.getSurname() + " (avg " + avg + ") ";

            if (avg == 5.0)
                result += "+increased grant\n";
            else if (avg >= 4.0 && avg <= 4.9)
                result += "+grant\n";
            else
                result += "\n";

            Student.Subject[] subjects = student.getSubjects();
            for (Student.Subject subject: subjects) {
                result += subject.getNameSubject() + " " + subject.getMark();
                if (subject.isPassed())
                    result += " passed\n";
                else
                    result += " not passed\n";
            }

            result += "\n";
        }

        return result;
    }

}
