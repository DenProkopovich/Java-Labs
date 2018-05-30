import java.io.*;

import java.util.*;
import java.lang.NullPointerException;

public class Faculty {
    public static void main(String[] args) {



        Course[] course = new Course[3];
        course[0] = new Course("Mathematics");
        course[1] = new Course("Philosophy");
        course[2] = new Course("Politology");
        course= (Course[]) deserData("course1.xml");

        Teacher[] teacher = new Teacher[3];
        teacher[0] = new Teacher("Lox");
        teacher[1] = new Teacher("Lox2");
        teacher[2] = new Teacher("Lox3");
        //teacher= (Teacher[]) deserData("teachers.xml");

        for (int i = 0; i < 3; i++) {
            teacher[i].setCourse(course[i]);
            course[i].setTeacher(teacher[i]);
        }


        while (true) {
            int[] amount = new int[3];
            Scanner in = new Scanner(System.in);
            int k = 0;
            System.out.print("Введите фамилию: ");
            String name = in.nextLine();
            boolean bool=true;
            for (Teacher teache : teacher) {
                if (name.compareToIgnoreCase(teache.getName()) == 0)
                    bool = false;
            }
            if(name.equals("0")) break;
            if (bool) {



                Student student1 = new Student(name);

                while (true) {
                    System.out.print("Mathematics - 1, Philosophy - 2, Politology - 3, exit - 0 ");
                    int count=-1;
                    try{count = in.nextByte(); }
                    catch (InputMismatchException e)
                    {
                        System.out.println("Неккоректный ввод");
                        continue;
                    }
                    if (count == 0) break;
                    //// повтор курсов
                    boolean boolRepeat=false;
                    for(int i=0;i<amount.length;i++)
                        if (count == amount[i])boolRepeat=true;
                    if(boolRepeat) { System.out.println("Вы уже записались на этот курс");continue;}
                    /////
                    switch (count) {
                        case 1:
                            student1.setCourse(course[0]);
                            course[0].setStudent(student1);
                            student1.setCourse(course[0]);
                            amount[k] = count;
                            k++;
                            System.out.print("Course 1\n");
                            break;
                        case 2:
                            student1.setCourse(course[1]);
                            course[1].setStudent(student1);
                            student1.setCourse(course[1]);
                            amount[k] = count;
                            k++;
                            System.out.print("Course 2\n");
                            break;
                        case 3:
                            student1.setCourse(course[2]);
                            course[2].setStudent(student1);
                            student1.setCourse(course[2]);
                            amount[k] = count;
                            k++;
                            System.out.print("Course 3\n");
                            break;
                        default:
                            break;
                    }
                    if (k > 2) break;
                }
                int size = k;

                System.out.println("Курсы на которые вы записались");
                k = 0;
                while (k < size) {
                    System.out.printf("Teacher: %s | Course: %s \n",teacher[amount[k] - 1].getName(),course[amount[k] - 1].getName());
                    k++;
                }
                System.out.println("\n");

            } else {
                int amountC = 0;
                for (int i = 0; i < teacher.length; i++) {
                    if (name.compareToIgnoreCase(teacher[i].getName()) == 0)
                        amountC = i;
                }
                try {
                    System.out.println("Студенты которые записались на курс "+course[amountC].getName()+": ");
                    course[amountC].getStudents().forEach(student -> {
                        System.out.println("\t"+student.getName());
                    });
                    course[amountC].getStudents().forEach(student -> {
                        student.getMarks().forEach(mark ->
                                System.out.printf("Student: %s | Course: %s | Mark: %d \n",student.getName() ,mark.getCourse().getName(), mark.getValue()));
                    });

/*                          ПОВТОРНЫЙ ВВОД ОЦЕНОК
course[amountC].getStudents().forEach(student -> {
student.getMarks().remove(student);
});
*/


                    for (Student s : course[amountC].getStudents()) {
                        System.out.print(s.getName() + " - " + course[amountC].getName() + "    mark ->");
                        int mark = in.nextByte();
                        s.setMark(mark, course[amountC]);
                    }


                    course[amountC].getStudents().forEach(student -> {
                        student.getMarks().forEach(mark ->
                                System.out.printf("Student: %s | Course: %s | Mark: %d \n",student.getName() ,mark.getCourse().getName(), mark.getValue()));
                    });
                } catch(NullPointerException e) {
                    System.out.println("нету студентов");
                }
            }
        }

        serData("course1.xml",course);
        serData("teachers.xml",teacher);

    }
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