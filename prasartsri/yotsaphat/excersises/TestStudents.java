package prasartsri.yotsaphat.excersises;

import java.util.*;

public class TestStudents {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new DmeEnStudent("Manee","Interaction Design"));
        students.add(new ComEnStudent("Mana","Advanced Computer Programming"));
        students.add(new ComEnStudent("Piti","Linear Circuit Analysis"));
        System.out.println(students);
        Collections.sort(students, new FavoriteCourseCoparator());
        System.out.println(students);
    }
    
}