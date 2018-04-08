import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Course {
    String course_stud;

    public void Shift(String[] teachers, String[] course, int index,int size)
    {
        for (int j = index; j < size - 1; j++) { //         сдвиг последующих элементов
            teachers[j] = teachers[j + 1];
            course[j] = course[j + 1];
        }
    }
    public String Input_course() //ввод курса, на который хочет записаться студент
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название курса,на который вы хотите записаться, или введите 0 для выхода:");
        return in.nextLine();
    }

    public boolean Already(int size, String [] course_mirror, String course)
    { boolean count=false;
        for(int i=0;i<size;i++)
        {
            if(course_mirror[i].compareToIgnoreCase(course)==0)
                count=true;
        }
        return  count;
    }

    public void Course_student(int size, String []teachers, String[]course, String[]mirror, String name, Map map) {// проверка на ввод курса
        String mir = name;
        while (true) {
            String str =Input_course();
            if (str.equals("0")) break;
            int count = 0;
            for (int i = 0; i < size; i++)
            {
                name=mir;
                if (course[i].compareToIgnoreCase(str) == 0)//проверка - является ли введенная строка курсом
                {

                    System.out.println("Вы записались на курс " + course[i]);
                    this.course_stud=course[i];// курс, который выбрал студент
                    Archive(); // запись курса в файл

                    String name_map = (String)map.get(course[i]);
                    name+=" ";
                    name+=name_map;
                    map.put(course[i],name);

                    //сдвиг последующих элементов
                    Shift(teachers,course,i,size);
                    count--;
                    size--;
                    break;

                } else {
                    count++;
                    if (count == size)
                        if(Already(mirror.length, mirror, str))// проверка - повторная запись на курс
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
    void Archive(){
        try(FileWriter writer = new FileWriter("archive.txt",true))
        {
            writer.write("\n\t    "+this.course_stud);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
