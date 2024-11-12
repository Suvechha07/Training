public class OuterClass 
{
    private int outvar=20;
    class InnerClass
    {
        private int innvar=30;
        public void display()
        {
            System.out.println("Outer class variable : "+outvar);
            System.out.println("Inner class variable : "+innvar);
        }

    }
    public void useinner()
    {
       InnerClass ob=new InnerClass();
       ob.display();
    }
    

  public static void main(String args[])
    {
       OuterClass obj=new OuterClass();
       obj.useinner();

    }
}