import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Teacher {
    String student;
    int value;

    public boolean TorS(String name,String[]teachers)
    {
        for(int i=0;i<teachers.length;i++)
        {
            if(teachers[i].compareToIgnoreCase(name) == 0)
                return true;
        }
        return false;
    }
     public int Teacher_index(String[]teachers,String name)
     {
         for(int i=0;i<teachers.length;i++)
         {
             if(teachers[i].compareToIgnoreCase(name) == 0)
                 return i;
         }
         return 0;
     }
    public void Shift(String[] teachers, int index,int size)
    {if(size>2)
        for (int j = index; j < size - 1; j++) { //         сдвиг последующих элементов
            teachers[j] = teachers[j + 1];

        }
        else teachers[index] = teachers[index + 1];

    }

     public void Input_value(String[] stud_c,int size_stud, int size_mirror)
     {
         int count = 0;

         while(true ){
         Scanner in = new Scanner(System.in);
         System.out.print("Введите фамилию студента, которому хотите выставить оценку или введите 0 для выхода: ");
         this.student = in.nextLine();
         if((this.student).equals("0"))break;
         boolean count_same=true;
         for (int i = 0; i < size_stud; i++)
         {

             if (stud_c[i].compareToIgnoreCase(this.student) == 0)
             {
                 count_same=false;

                 this.student = stud_c[i];



                 while(true){
                     Scanner fin = new Scanner(System.in);
                     System.out.print("Введите оценку студенту " + stud_c[i] + ": ");
                     String str = fin.nextLine();
                     try {
                         this.value=Integer.parseInt(str);
                         if(this.value >= 0 && this.value <= 10)
                             break;
                         else { System.out.println("\tНеккоректный ввод");continue;}
                     }catch(NumberFormatException e)
                     {
                         System.out.println("\tНеккоректный ввод");
                         continue;
                     }
                 }
                 Archive();
                 count++;
                 Shift(stud_c,i,size_stud);
                 size_stud--;
             }

         }
         if(count_same) System.out.println("Вы уже выставили оценку этому студенту");

             if (count==size_mirror)
             {
                 System.out.println("Вы выставили оценки всем студентам!");
                 break;
             }
         }
         if(count==0) {
             System.out.println("\tОценки не выставлены");
            Archive_zero();
         }
     }
    void Archive_zero(){
        try(FileWriter writer = new FileWriter("att.txt",true))
        {
            writer.write("\tОценки не выставлены ");
            writer.write("\n");
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    void Archive_course( String course){
        try(FileWriter writer = new FileWriter("att.txt",true))
        {
            writer.write("Оценки за курс обучения по "+ course+": ");
            writer.write("\n");
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    void Archive(){
        try(FileWriter writer = new FileWriter("att.txt",true))
        {
            writer.write("\t"+this.student+" - "+this.value);
            writer.write("\n");
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
