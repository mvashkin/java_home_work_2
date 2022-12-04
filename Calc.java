import java.io.FileInputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;                                            

public class Calc {
    
    static Logger LOGGER;
    static {
        try(FileInputStream ins = new FileInputStream("log.config")){ //полный путь до файла с конфигами
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Calc.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }
    public static void main(String[] args) {                         
        try {
            LOGGER.log(Level.INFO,"Программа запущена");
            Scanner in = new Scanner(System.in);
            System.out.print("Введите первое число: ");
            int numb_a = in.nextInt();
            LOGGER.log(Level.INFO, "Введено первое число: " +numb_a);
            System.out.print("Введите второе число: ");
            int numb_b = in.nextInt();
            LOGGER.log(Level.INFO, "Введено второе число:" +numb_b);
            System.out.println("Введите операцию + - / *: ");
            char operation;
            operation = in.next().charAt(0);
            int res=0;
            
            LOGGER.log(Level.INFO, "Введён оператор: " +operation);
            switch (operation) {
                case '+':
                    res = numb_a + numb_b;
                    System.out.printf("Результат: %d",res);
                    break;
                case '-':
                    res = numb_a - numb_b;
                    System.out.printf("Результат: %d",res);
                    break;
                case '/':
                    res = numb_a / numb_b;
                    System.out.printf("Результат: %d",res);
                    break;
                case '*':
                    res = numb_a * numb_b;
                    System.out.printf("Результат: %d",res);
                    break;
    
            }
            in.close();
            LOGGER.log(Level.INFO, "Результат: "+ numb_a + operation + numb_b+"="+res);
            LOGGER.log(Level.INFO, "Программа успешно завершена.");

        }catch (Exception e){
            LOGGER.log(Level.WARNING,"что-то пошло не так" , e);
        }
    }
}