package prasartsri.yotsaphat.excersises;

public class ComEnStudent extends Student{
    public ComEnStudent(String name){
        this.name = name;
    }
    public ComEnStudent(String name, String favoriteCourse){
        this.name = name;
        this.favoriteCourse = favoriteCourse;
    }
    public void writePrograms(){
        System.err.println(name +" writes programs in Python and Java");

    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return name+" => favorite course ="+favoriteCourse;
    }
}
