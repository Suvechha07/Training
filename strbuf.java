public class strbuf
{
    public static void main(String args[])
    {  
    String s="Java is my favourite programming language";
    StringBuffer sb=new StringBuffer(40);
    StringBuffer str=sb.append(s).append(" Completely");
    System.out.println("Appended string: "+str);
    StringBuffer sb1=new StringBuffer("Java is my favourite programming language");
    System.out.println(sb1.insert(5,"also "));
    System.out.println(sb1.delete(9,12));
    System.out.println("Capacity : "+sb1.capacity());
    System.out.println("Reverse : "+sb1.reverse());
    }
}