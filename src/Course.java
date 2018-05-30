import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import java.lang.String;

public class Course implements Serializable {
    private String name;
    private Teacher teacher;
    private List<Student> students;



    private LocalDate start;
    private LocalDate end;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudent(Student student) {
        if (this.students == null) {
            this.students = new ArrayList<>();
        }
        this.students.add(student);
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }
}
/*
    private String inputCourse() //ввод курса, на который хочет записаться студент
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название курса,на который вы хотите записаться, или введите 0 для выхода:");
        return in.nextLine();
    }

    private boolean already(int size, String[] course_mirror, String course) {
        boolean count = false;
        for (int i = 0; i < size; i++) {
            if (course_mirror[i].compareToIgnoreCase(course) == 0)
                count = true;
        }
        return count;
    }

    public void courseStudent(int size, String[] course, String[] mirror, ArrayList alg,ArrayList geo,ArrayList progr, String name) {// проверка на ввод курса
        while (true) {
            String str = inputCourse();
            if (str.equals("0")) break;
            int count = 0;
            for (int i = 0; i < size; i++) {
                if (course[i].compareToIgnoreCase(str) == 0)//проверка - является ли введенная строка курсом
                {
                    System.out.println("Вы записались на курс " + course[i]);
                    this.course = course[i];// курс, который выбрал студент

                   if(i==0){ alg.add(name);System.out.println("+");}
                    else if(i==1) {geo.add(name);System.out.println("-");}
                    else if(i==2)  {progr.add(name);System.out.println("=");}



                    System.arraycopy(course, i + 1, course, i, size - 1 - i);
                    count--;
                    size--;
                    break;

                } else {
                    count++;
                    if (count == size)
                        if (already(mirror.length, mirror, str))// проверка - повторная запись на курс
                            System.out.println("Вы уже записались на этот курс");
                        else System.out.println("Такого курса нету");
                }
            }
            if (size == 0)// запись на все курсы
            {
                System.out.println("Вы выбрали все курсы");
                break;
            }
        }
    }
    public void courseS(ArrayList students,HashMap hashMap, String[] course) {

        for(int i=0;i<course.length;i++){
            ArrayList<String> list = new ArrayList<String>();
            for(int j=0;j<students.size();j++)
            {
                if( course[i].equals(hashMap.get(students.get(j)))) {
                    String str = students.get(j).toString();
                    list.add(str);
                }
            }
            hashMap.put(course[i],list);
        }
    }


}*/