package prasartsri.yotsaphat.excersises;

import java.util.Comparator;

public class FavoriteCourseCoparator implements Comparator<Student> {
    public int compare(Student a, Student b){
        return a.favoriteCourse.compareTo(b.favoriteCourse);
    }}
    

