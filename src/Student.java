import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Student {
    String name;
   public String Input_name()
   {
       boolean count=true;
       while(count) {
           Scanner in = new Scanner(System.in);
           System.out.print("\nАвторизация\n\tВведите вашу фамилию или введите exit для выхода: ");
           this.name = in.nextLine();
           if (this.name.length()>1)
           {
               boolean digit=false;
               for(int i=0;i<this.name.length();i++)
                   if(this.name.charAt(i)>='0' && this.name.charAt(i)<='9')
                       digit=true;
               if(digit)
               {
               System.out.println("Неккоретный ввод");
               continue;
               }else count=false;
           }
           else{
               System.out.println("Неккоретный ввод");
               continue;
           }

       }
       return this.name;
   }
   public void Input_info()
   {
       boolean count=true;
       String str="";
       while(count) {
           Scanner in = new Scanner(System.in);
           System.out.print("Введите ваше имя: ");
           str =in.nextLine();
           if (str.length() > 1) {
               boolean digit = false;
               for (int i = 0; i < str.length(); i++)
                   if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                       digit = true;
               if (digit) {
                   System.out.println("Неккоретный ввод");
                   continue;
               } else count = false;
           } else {
               System.out.println("Неккоретный ввод");
               continue;
           }
       }
       this.name +=" ";
       this.name += str;
   }


    void Archive(){
        try(FileWriter writer = new FileWriter("archive.txt",true))
        {
            writer.write("\n"+this.name);
            writer.write("\n\t Перечень выбранных курсов: ");
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

}
