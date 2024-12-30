package    prasartsri.yotsaphat.excersises;

public class TestKKUStudent {
    public static void main(String[] args) {
        KKUStudent manee = new KKUStudent();
        manee.setName("Manee");
        manee.setGPA(3.2);
        System.out.println("Name: " + manee.getName() + " GPA is " +
                manee.getGPA());
        KKUStudent mana = new KKUStudent();
        mana.setName("Mana");
        mana.setGPA(3.4);
        System.out.println("Num students is " + KKUStudent.getNumStudents());
        System.out.println("Name: " + mana.getName() +
                " GPA is " + mana.getGPA());
        System.out.println("Mana's university name is " +
                KKUStudent.getUniName());
    }

}