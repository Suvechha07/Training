import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class alphabetical_order 
{
    public static String sortString(String s) 
    {
        char[] ch = s.toCharArray();
        int n = ch.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (ch[j] > ch[j + 1]) 
                {
                    char temp = ch[j];
                    ch[j] = ch[j + 1];
                    ch[j + 1] = temp;
                }
            }
        }
        
        return new String(ch);
    }

    public static void main(String[] args) throws IOException
    {
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             System.out.println("Enter a sentence:");
             String sentence = reader.readLine();
             String[] ss = sentence.split("\\s+");
             StringBuilder result = new StringBuilder();
             for (String s : ss) 
             {
                String s_new = sortString(s);
                result.append(s_new).append(" ");
             }
            System.out.println("Sentence with each string sorted alphabetically:");
            System.out.println(result.toString().trim());

        }  
    }   

