import java.awt.*;
import javax.swing.*;
public class calculator extends Frame
{ 
    public boolean setClear=true;  
    double number, memValue;  
    char op;
    String digitButtonText[] = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", "+/-", "." };  
    String operatorButtonText[] = {"/", "sqrt", "*", "%", "-", "1/X", "+", "=" };  
    MyDigitButton digitButton[]=new MyDigitButton[digitButtonText.length];  
    MyOperatorButton operatorButton[]=new MyOperatorButton[operatorButtonText.length];  
}
