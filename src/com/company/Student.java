package com.company;

public class Student {
    private int id;
    private static int nextId;
    private String name;
    private String surname;
    private String group;
    private Subject[] subjects = new Subject[5];
    public static enum NameSubjects {Maths, English, Physics, Biology, Literature};


    public Student(String name, String surname, String group) {
        this.id = nextId;
        nextId++;
        addSubjects();
        this.name = name;
        this.surname = surname;
        this.group = group;
    }

    void addSubjects(){
        NameSubjects[] names = NameSubjects.values();
        int temp = 0;
        for(NameSubjects name : names) {
            subjects[temp] = new Subject();
            subjects[temp].setNameSubject(name.toString());
            temp++;
        }
    }

    public float getAverageMark(){
        float avg = 0;
        for(Subject a: subjects) {
            avg += a.getMark();
        }
        avg = avg / 5;
        avg = (float) roundAvoid((double) avg, 1);
        return avg;
    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }


    /**
     * NEW CLASS
     */

    public class Subject {
        private String nameSubject;
        private float mark;
        private boolean passed = false;

        public Subject(){
            calcMark();
            checkIfPassed();
        }

        public Subject(String nameSubject) {
            this.nameSubject = nameSubject;
        }

        private void checkIfPassed(){
            if (mark > 2) passed = true;
        }

        private void calcMark(){
            mark = (float) (Math.random() * 3 + 2);
            mark = (float)roundAvoid((double) mark, 1);
        }

        public String getNameSubject() {
            return nameSubject;
        }

        public void setNameSubject(String nameSubject) {
            this.nameSubject = nameSubject;
        }

        public float getMark() {
            return mark;
        }

        public void setMark(float mark) {
            this.mark = mark;
        }

        public boolean isPassed() {
            return passed;
        }

        public void setPassed(boolean passed) {
            this.passed = passed;
        }
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Student.nextId = nextId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }
}