import java.util.Arrays;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;                                            

public class SortBuble {
    static Logger LOGGER;
    static {
        try(FileInputStream ins = new FileInputStream("log.config")){ 
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Calc.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }
    public static void main(String[] args) {
        int[] buble = {1,5,6,8,7,4,2,3,9};
        for(int i=buble.length-1; i>0;i--){
            for (int j = 0; j < i; j++) {       
                if (buble[j] > buble[j + 1]) { 
                    LOGGER.log(Level.INFO, Arrays.toString(buble)); 
                    int temp = buble[j];                          
                    buble[j] = buble[j + 1];                    
                    buble[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(buble)); 
    }
}
