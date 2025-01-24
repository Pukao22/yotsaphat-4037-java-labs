package prasartsri.yotsaphat.excersises;

public class DmeEnStudent extends Student {
    public DmeEnStudent(String name){
        this.name = name;
    }
    public DmeEnStudent(String name, String favoriteCourse){
        this.name = name;
        this.favoriteCourse = favoriteCourse;
    }
    public void writePrograms(){
        System.out.println(name +" writes programs in Python and C#");
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return name+" => favorite course ="+favoriteCourse;
    }
}
