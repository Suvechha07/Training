import java.awt.*;
import javax.swing.*;

public class cv 
{
    public static void main(String args[])
    {
       cv obj=new cv();
    }
    JFrame f1;
    JButton b1;
    JPanel p1;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3,t4,t5,t6;
	JTextArea jta1,jta2,jta3;
    JRadioButton jrb1,jrb2,jrb3,jrb4,jrb5;
	ButtonGroup bg1,bg2;
    JComboBox jcb1;
    public cv()
        {
            f1= new JFrame("Resume");
            f1.setVisible(true);
        	f1.setSize(500,500);
            b1=new JButton("Submit");
        	p1=new JPanel();
            f1.getContentPane().add(p1);
            p1.setBackground(Color.pink);
        	t1=new JTextField(15);
            t2=new JTextField(15);
            t3=new JTextField(15);
            t4=new JTextField(15);
            t5=new JTextField(15);
        	t1.setForeground(Color.blue);
            t2.setForeground(Color.blue);
            t3.setForeground(Color.blue);
            t4.setForeground(Color.blue);
            t5.setForeground(Color.blue);
            l1=new JLabel("First Name");
            l2=new JLabel("Last name");
            l3=new JLabel("Phone number");
            l4=new JLabel("Birth year");
        	l5=new JLabel("Address");
            l6=new JLabel("Qualifications");
        	jta1=new JTextArea(10,15);
            jta2=new JTextArea(10,15);
            jrb1=new JRadioButton("Male");
        	jrb2=new JRadioButton("Female");
        	bg1=new ButtonGroup();
        	bg1.add(jrb1);
        	bg1.add(jrb2);
            jrb3=new JRadioButton("ICSE");
        	jrb4=new JRadioButton("CBSE");
            jrb5=new JRadioButton("State board");
        	bg2=new ButtonGroup();
        	bg2.add(jrb3);
        	bg2.add(jrb4);
            bg2.add(jrb5);
            String x[]={"10", "+2", "B.Tech", "M.Tech", "Ph.D."};
            jcb1=new JComboBox(x);
            p1.add(l1);
            p1.add(t1);
            p1.add(l2);
            p1.add(t2);
            p1.add(l3);
            p1.add(t3);
            p1.add(l4);
            p1.add(t4);
            p1.add(l5);
        	p1.add(t5);
        	p1.add(l6);
        	p1.add(jta1);
        	p1.add(jrb1);
        	p1.add(jrb2);
            p1.add(jrb3);
            p1.add(jrb4);
            p1.add(jrb5);
        	p1.add(jcb1);
            p1.add(b1);
        }
}