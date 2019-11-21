package org.launchcode.demos.lsn4classes2;

import java.util.ArrayList;

public class Course {
    private String topic;
    private Teacher instructor;
    private ArrayList<Student> enrolledStudents;

    @Override
    public String toString() {
        return "Course{" +
                "topic='" + topic + '\'' +
                ", instructor=" + instructor +
                ", enrolledStudents=" + enrolledStudents +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;

        Course course = (Course) o;

        if (!topic.equals(course.topic)) return false;
        if (!instructor.equals(course.instructor)) return false;
        return enrolledStudents.equals(course.enrolledStudents);

    }

    @Override
    public int hashCode() {
        int result = topic.hashCode();
        result = 31 * result + instructor.hashCode();
        result = 31 * result + enrolledStudents.hashCode();
        return result;
    }
}
