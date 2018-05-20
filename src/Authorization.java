import java.util.Scanner;

public class Authorization {
    public String login;
    private int password;
    private void inputLogin()
    {
        boolean count = true;
        while (count) {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите вашу фамилию: ");
            this.login = in.nextLine();
            if (this.login.length() > 1) {
                boolean digit = false;
                for (int i = 0; i < this.login.length(); i++) {
                    if (this.login.charAt(i) >= '0' && this.login.charAt(i) <= '9')
                        digit = true;
                    else if (this.login.charAt(i) == ' ') digit = true;
                }
                if (digit) {
                    System.out.println("Неккоректный ввод");
                } else count = false;
            } else {
                System.out.println("Неккоректный ввод");
            }

        }
    }
    private boolean boolLogin(String[] teachers)
    {
        boolean bool = false;
        inputLogin();

        for (int i=0;i<teachers.length;i++) {
            if (this.login.compareToIgnoreCase(teachers[i])==0)
                bool = true;
        }
        return bool;
    }
    private void inputPassword()
    {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите пароль: ");
            this.password = in.nextInt();
            if(this.password==1111) break;
            else  if(this.password==1000) break;
            else System.out.println("Неправильный пароль");
        }

    }
    public boolean authorizations(String[] teachers)
    {
        boolean bool=false;

        if(boolLogin(teachers)) {inputPassword();
            if(this.password==1111) {
                System.out.println("Вы авторизировались как преподаватель");
                bool=false;
            }else System.out.println("Непй пароль");
        }
        else{inputPassword();
            if (this.password==1000){
                System.out.println("Вы авторизировались как студент");
                bool=true;
            }else System.out.println("Неправильный пароль");
        }
        return bool;
    }
}
