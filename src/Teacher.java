import java.io.*;
import java.util.Scanner;

public class Teacher {
    private String student;
    private int value;

    public boolean torS(String name, String[] teachers) {
        for (String teacher : teachers) {
            if (teacher.compareToIgnoreCase(name) == 0)
                return true;
        }
        return false;
    }

    public int teacherIndex(String[] teachers, String name) {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i].compareToIgnoreCase(name) == 0)
                return i;
        }
        return 0;
    }

    private void shift(String[] teachers, int index, int size) {
        if (size > 2)
            System.arraycopy(teachers, index + 1, teachers, index, size - 1 - index);
        else teachers[index] = teachers[index + 1];

    }

    public void inputValue(String[] stud_c, int size_stud, int size_mirror) {
        int count = 0;

        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите фамилию студента, которому хотите выставить оценку или введите 0 для выхода: ");
            this.student = in.nextLine();
            if ((this.student).equals("0")) break;
           // boolean count_same = true;
            for (int i = 0; i < size_stud; i++) {

                if (stud_c[i].compareToIgnoreCase(this.student) == 0) {
                    //count_same = false;

                    this.student = stud_c[i];


                    while (true) {
                       // count_same = false;
                        Scanner fin = new Scanner(System.in);
                        System.out.print("Введите оценку студенту " + stud_c[i] + ": ");
                        String str = fin.nextLine();
                        try {
                            this.value = Integer.parseInt(str);
                            if (this.value >= 0 && this.value <= 10)
                                break;
                            else {
                                System.out.println("\tНеккоректный ввод");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("\tНеккоректный ввод");
                        }
                    }
                    archive();
                    count++;
                    shift(stud_c, i, size_stud);
                    size_stud--;
                } else {
                    System.out.println("Вы уже выставили оценку этому студенту либо такого студента нету");
                    break;

                }

            }

            if (count == size_mirror) {
                System.out.println("Вы выставили оценки всем студентам!");
                break;
            }


        }
        if (count == 0) {
            System.out.println("\tОценки не выставлены");
            archiveZero();
        }
    }

    private void archiveZero() {
        try (FileWriter writer = new FileWriter("att.txt", true)) {
            writer.write("\tОценки не выставлены ");
            writer.write("\n");
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    void archiveCourse(String course) {
        try (FileWriter writer = new FileWriter("att.txt", true)) {
            writer.write("Оценки за курс обучения по " + course + ": ");
            writer.write("\n");
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    private void archive() {
        try (FileWriter writer = new FileWriter("att.txt", true)) {
            writer.write("\t" + this.student + " - " + this.value);
            writer.write("\n");
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}

   /* //a =(arraylist<>) desrerdata(filename)  s4itbivanie
    //serdata(filename, class)
    Object deserData(String file_name) {
        Object retObject=null;
        try {
            FileInputStream fileIn=new FileInputStream(file_name);
            ObjectInputStream in=new ObjectInputStream(fileIn);
            retObject=in.readObject();
            fileIn.close();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not founded");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Error input/output");
            System.exit(2);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not founded");
            System.exit(3);
        }
        return retObject;
    }
     void serData(String file_name,Object obj) {
        try {
            FileOutputStream fileOut=new FileOutputStream(file_name);
            ObjectOutputStream out=new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            fileOut.close();
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not founded");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Error input/output");
            System.exit(2);
        }

    }*/

