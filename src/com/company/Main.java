package com.company;

public class Main {
    static int nextId = 0;
    public static void main(String[] args) {

        Student[] students = new Student[5];
        students[0] = new Student("Yehor", "Shum", "KB-71");
        students[1] = new Student("Oleh", "Tsubin", "KB-71");
        students[2] = new Student("Dasha", "Kozlova", "KB-71");
        students[3] = new Student("Vlad", "Vydrygan", "IN-71");
        students[4] = new Student("Artem", "Koplyk", "IN-71");

        String studentsAndTheirMarks = Utils.getStudentsAndMarks(students);
        String bestStudent = Utils.getTheBestStudent(students);
        String bestSubject = Utils.getTheBestSubject(students);

        P.rint("\n" + studentsAndTheirMarks);
        P.rintln("Best student: " + bestStudent);
        P.rintln("Best subject: " + bestSubject);
    }
}
