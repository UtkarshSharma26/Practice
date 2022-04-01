package com.practice;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

class StudentMark {
    private String name;
    private String subject;
    private Integer mark;

    public StudentMark(String name, String subject, Integer mark) {
        this.name = name;
        this.subject = subject;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}

public class Test {

    public static void main(String[] args) {
        StudentMark s1 = new StudentMark("Archer", "English", 18);
        StudentMark s2 = new StudentMark("Archer", "Maths", 24);
        StudentMark s3 = new StudentMark("Archer", "Science", 13);
        StudentMark s4 = new StudentMark("Allison", "English", 17);
        StudentMark s5 = new StudentMark("Allison", "Maths", 22);
        StudentMark s6 = new StudentMark("Allison", "Science", 22);
        StudentMark s7 = new StudentMark("Mike", "English", 14);
        StudentMark s8 = new StudentMark("Mike", "Maths", 22);
        StudentMark s9 = new StudentMark("Mike", "Science", 23);
        List<StudentMark> studentMarks = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9);
        studentMarks.sort((o1, o2) -> o2.getMark().compareTo(o1.getMark()));
        Map<String, List<Integer>> studentMarksMap = new HashMap<>();
        studentMarks.forEach(stud -> {
            if (studentMarksMap.containsKey(stud.getName())) {
                List<Integer> marksList = studentMarksMap.get(stud.getName());
                marksList.add(stud.getMark());
                studentMarksMap.put(stud.getName(), marksList);
            } else {
                List<Integer> markList = new ArrayList<>();
                markList.add(stud.getMark());
                studentMarksMap.put(stud.getName(), markList);
            }
        });
        System.out.println(studentMarksMap);
        studentMarksMap.entrySet().forEach(map -> {
            AtomicReference<Long> avg = new AtomicReference<>(0L);
            AtomicInteger count = new AtomicInteger();
            map.getValue().stream().forEach(f -> {
                avg.updateAndGet(v -> v + f);
                count.getAndIncrement();
            });
            System.out.println(count);
            avg.set(avg.get() / count.get());
            System.out.println(map.getKey() + " " + avg.get());
        });
    }

}