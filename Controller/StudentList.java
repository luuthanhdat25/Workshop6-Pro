package Controller;

import Model.Inputter;
import Model.Student;

import java.util.ArrayList;

public class StudentList extends ArrayList<Student>{
    public StudentList() {
        super();
    }

    // Search student base on student code. Return the student found
    //This method supports preventing code duplications
    public Student search(String code){
        code = code.trim().toUpperCase();
        // size of ArrayList
        for (int i = 0; i < this.size(); i++) // Linear search is use
            if(this.get(i).getCode().equals(code)) return this.get(i);

        return null; // not found
    }

    private boolean isCodeDuplicated(String code){
        code = code.trim().toUpperCase();
        return search(code) != null;
    }

    public void addStudent(){
        String newCode;
        String newName;
        int newMark;
        boolean codeDuplicated = false;

        do {// pattern s000 or S000 ==> Pattern: "[sS][\\d]{3}
            newCode = Inputter.inputPattern("St. code s000: ", "[sS][\\d]{3}");
            newCode = newCode.trim().toUpperCase();
            codeDuplicated = isCodeDuplicated(newCode);
            if(codeDuplicated) System.out.println("Code is duplicated!");
        }while (codeDuplicated == true);

        newName = Inputter.inputNonBlankStr("Name of the student: ");
        newName.toUpperCase();
        newMark = Inputter.inputInt("Mark: ", 0, 10);

        this.add(new Student(newCode, newName, newMark));
        System.out.println("Model.Student " + newCode + " has been added.");
    }

    public void searchStudent(){
        if(this.isEmpty()) System.out.println("Empty list. No search can be performed!");
        else{
            String sCode = Inputter.inputStr("Input student code for search: ");
            Student st = this.search(sCode);

            if(st == null) System.out.println("Model.Student " + sCode + " doesn't existed!");
            else System.out.println("Found: " + st);
        }
    }

    //Update student mark base on student code
    public void updateStudent(){
        if(this.isEmpty()) System.out.println("Empty list. No search can be performed!");
        else{
            String uCode = Inputter.inputStr("Input code  of updated student: ");
            Student st = this.search(uCode);

            if(st == null) System.out.println("Model.Student " + uCode + "doesn't existed!");
            else{
                //Update Name
                String oldName = st.getName();
                String msg = "Old name: " + oldName + ", new name: ";
                String newName = Inputter.inputNonBlankStr(msg);
                st.setName(newName);
                //Update Mark
                int oldMark = st.getMark();
                msg = "Old mark: " + oldMark + ", new mark 0...10: ";
                int newMark = Inputter.inputInt(msg, 0, 10);
                st.setMark(newMark);
                System.out.println("Model.Student " + uCode + " has been updated.");
            }
        }
    }

    public void removeStudent(){
        if(this.isEmpty()) System.out.println("Empty list. No remove can be performed!");
        else{
            String rCode = Inputter.inputStr("Input code of removed student: ");
            Student st = this.search(rCode);

            if(st == null)  System.out.println("Model.Student " + rCode + "doesn't existed!");
            else{
                this.remove(st);
                System.out.println("Model.Student " + rCode + " has been removed.");
            }
        }
    }

    public void printAll(){
        if(this.isEmpty()) System.out.println("Empty list!");
        else{
            System.out.println("Model.Student list: ");
            for (Student st: this) System.out.println(st);
            System.out.println("Total: " + this.size() + " student(s).");
        }
    }
}//Controller.StudentList
