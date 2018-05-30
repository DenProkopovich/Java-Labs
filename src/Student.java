import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student implements Serializable {
    private String name;
    private List<Course> courses;
    private List<Mark> marks;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setMark(int value, Course course) {
        if (this.marks == null) {
            this.marks = new ArrayList<>();
        }
        this.marks.add(new Mark(value, course));
    }

    public void setCourse(Course course) {
        if (this.courses == null) {
            this.courses = new ArrayList<>();
        }
        this.courses.add(course);
    }

    public List<Mark> getMarks() {
        return marks;
    }
}

    /*private String additionalInfo;


    public String inputInfo() {
        boolean bool = true;
        String str = "";
        String count=" ";
        while (bool) {
            Scanner in = new Scanner(System.in);
            System.out.print("Input name: ");
            count += in.nextLine();
            if (in.nextLine().length() > 1) {
                boolean digit = false;
                for (int i = 0; i < in.nextLine().length(); i++)
                    if (in.nextLine().charAt(i) >= '0' && in.nextLine().charAt(i) <= '9')
                        digit = true;
                    else if (in.nextLine().charAt(i) == ' ') digit = true;
                if (digit) {
                    System.out.println("Invalid input");
                } else bool = false;
            } else {
                System.out.println("Invalid input");
            }

        }
        str+=count;
        count=" ";
        bool = true;
        while (bool) {
            Scanner in = new Scanner(System.in);
            System.out.print("Input group ");
            count+= in.nextLine();
            if (in.nextLine().length() > 1) {
                bool = false;
            } else {
                System.out.println("Invalid input");
            }

        }
        str+=count;
        return str;
    }
}*/