import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
public class changeBackground extends JFrame implements ActionListener {
    
    JFrame frame;
    JButton red, green, blue;
    
    changeBackground() {
        
        Font font = new Font("Lucida Calligraphy", Font.BOLD, 15);
        frame = new JFrame("Colourful window");
        Color c = new Color(255, 255, 255);
        
        red = new JButton("RED");
        red.setBounds(40, 100, 100, 40);
        red.setFont(font);
        red.setBackground(c);
        
        green = new JButton("GREEN");
        green.setBounds(110, 150, 100, 40);
        green.setFont(font);
        green.setBackground(c);
        
        blue = new JButton("BLUE");
        blue.setBounds(180, 200, 100, 40);
        blue.setFont(font);
        blue.setBackground(c);
        
     
        
        frame.add(red);
        frame.add(green);
        frame.add(blue);
       
        
        red.addActionListener(this);
        green.addActionListener(this);
        blue.addActionListener(this);
       
        frame.getContentPane().setBackground(Color.pink);
        frame.setLayout(null);
        frame.setSize(500, 500);
        frame.setVisible(true);      
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        
        if(ae.getSource() == red) 
            frame.getContentPane().setBackground(Color.RED);
        if(ae.getSource() == green)
            frame.getContentPane().setBackground(Color.GREEN);
        if(ae.getSource() == blue)
            frame.getContentPane().setBackground(Color.BLUE);
      
            
    }
    
    public static void main(String[] args) {
        
        new changeBackground();
        
    }
    
}