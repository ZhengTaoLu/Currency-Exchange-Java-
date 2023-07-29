import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;
import java.awt.Color;

public class MyLabel extends JLabel{
    MyLabel(){
        // 2. JLabel = a GUI display area for a string of text, an image, or both
            
        Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
            
        JLabel label = new JLabel();
        label.setText("Hello yes kjnkljn");                            // 2. Set text of label
        // label.setHorizontalTextPosition(JLabel.CENTER);                   // 2. Set text LEFT, CENTER, RIGHT of imageicon
        // label.setVerticalTextPosition(JLabel.TOP);                        // 2. Set text TOP, CENTER, BOTTOM of imageicon
        label.setForeground(Color.BLACK);                                    // 2. Set font color of color
        // label.setFont(new Font("Set Font type", Font.style, (size)int)); // 2. Set font of text
        // label.setIconTextGap(int);                                       // 2.  Set gap of text of image
        label.setBackground(Color.white);                                   // 2. Set bavkground color
        // label.setOpaque(Boolean);                                        // 2. Displays Label's background color method
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);                          // 2. Set Vertical position of icon+text within label
        label.setHorizontalAlignment(JLabel.CENTER);                        // 2. Set Horizontal position of icon+text within label
        // label.setBounds(x, y, width, height);                            // 2. Set x,y position within frame as well as dimensions
            
            
        MyFrame frame = new MyFrame();
        frame.add(label);
        //frame.pack();                                                       // 2. Resize the size of the frame to accommodate all of the components that I have
        // ! USE Pack() after adding label        
    }
}
