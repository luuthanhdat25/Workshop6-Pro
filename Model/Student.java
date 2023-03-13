package Model;

public class Student{
    private String code;
    private int mark;
    private String name;
    //Constructors
    public Student() {
    }

    public Student(String code, String name, int mark) {
        this.code = code.toUpperCase();
        this.mark = (mark >=  0 && mark <= 10)? mark:0;
        this.name = name.toUpperCase();
    }

    public String getCode() {
        return code;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        if(mark >= 0 && mark <= 10) this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.trim().toUpperCase();
        if(name.length() > 0) this.name = name;
    }

    @Override
    public String toString() {
        return code + ", " + mark + ", " + name;
    }
}// Model.Student class
