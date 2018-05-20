import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.lang.NullPointerException;
import java.util.Scanner;

public class Faculty {
    public static void main(String[] args) {

        int size = 3;
        String[] teachers = {"Бойко", "Иванов", "Петревич"};
        String[] course = {"Алгебра", "Геометрия", "Программирование"};
        ArrayList<String> courseStud = new ArrayList<String>();
        ArrayList<String> students = new ArrayList<String>();
        ArrayList<String> algebra = new ArrayList<String>();
        ArrayList<String> geometry = new ArrayList<String>();
        ArrayList<String> programming = new ArrayList<String>();

        HashMap<String, ArrayList<String>> hashMapStud = new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<String>> hashMapCourse = new HashMap<String, ArrayList<String>>();
        Authorization autor = new Authorization();

        while (true) {
            String surname = autor.login;
            Scanner in = new Scanner(System.in);
            System.out.print("Input oper ");
            String oper = in.nextLine();
            if (oper.equals("выход")) break;
            if (autor.authorizations(teachers)) {
                String[] mirror = {"Алгебра", "Геометрия", "Программирование"};
                // HashMap<String, String> infoOfStudent = new HashMap<String, String>();
                Student std = new Student();
                // infoOfStudent.put(surname, surname + std.inputInfo());
                System.out.println("Преподаватель  -   Курс");
                System.out.println("--------------------------");
                for (int i = 0; i < size; i++) {
                    System.out.println(teachers[i] + "    -   " + course[i]);
                }
                System.out.println("--------------------------");

                Course crs = new Course();
                crs.courseStudent(size, course, mirror, algebra, geometry, programming, surname);


                students.add(surname);
                course = mirror;


                if (students.size() > 0)
                    crs.courseS(students, hashMapCourse, course);
                course = mirror;

            } else {
                for (int i = 0; i < course.length; i++) {
                    switch (i) {
                        case 0:
                            hashMapCourse.put(course[i], algebra);
                            break;
                        case 1:
                            hashMapCourse.put(course[i], geometry);
                            break;
                        case 2:
                            hashMapCourse.put(course[i], programming);
                            break;
                    }
                }
                Teacher tch = new Teacher();
                int index = tch.teacherIndex(teachers, surname);

                        System.out.println(hashMapCourse.get(course[index]));


            }
        }
    }

//                Teacher tch = new Teacher();
//                int index =tch.teacherIndex(teachers, surname);
//                System.out.println(index);
//                if(hashMapCourse.get(course[index]).isEmpty()){
//                    int sizeCS = hashMapCourse.get(course[index]).size();
//
//                    for (int i = 0; i < sizeCS; i++) {
//                        System.out.print(hashMapCourse.get(course[index]).get(i) + " ");
//                    }
//                } else {
//                    System.out.println("Никто не записался на ваш курс");
//                    continue;
//                }


    private static Object deserData(String file_name) {
        Object retObject = null;

        try {
            FileInputStream fileIn = new FileInputStream(file_name);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            retObject = in.readObject();
            fileIn.close();
            in.close();
        } catch (FileNotFoundException var4) {
            System.out.println("File not founded");
            System.exit(1);
        } catch (IOException var5) {
            System.out.println("Error input/output");
            System.exit(2);
        } catch (ClassNotFoundException var6) {
            System.out.println("Class not founded");
            System.exit(3);
        }

        return retObject;
    }

    private static void serData(String file_name, Object obj) {
        try {
            FileOutputStream fileOut = new FileOutputStream(file_name);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            fileOut.close();
            out.close();
        } catch (FileNotFoundException var4) {
            System.out.println("File not founded");
            System.exit(1);
        } catch (IOException var5) {
            System.out.println("Error input/output");
            System.exit(2);
        }

    }
}