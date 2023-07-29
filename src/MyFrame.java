import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Currency;


import com.neovisionaries.i18n.CountryCode;
import com.neovisionaries.i18n.CurrencyCode;

public class MyFrame extends JFrame implements ActionListener{
    
    MyFrame(){
        
        // https://www.youtube.com/watch?v=Kmgo00avvEw
        //! 1. JFrame = a GUI window to add components to
        //JFrame frame = new JFrame();                           // 1. Creates a frame
        
        
        this.setTitle("JFrame title");                    // 1. Sets title of this
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // 1. Exit out of application
        //frame.setResizable(true);                             // 1. Prevent frame from being resized
        this.setLayout(new BorderLayout());
        this.setSize(750, 750);                   // 1. Sets the X-dimension, and Y-dimension of frame
        this.setVisible(true);                                // 1. Make frame visible

        //ImageIcon image = new ImageIcon("Insert picture file here");                    // 1. Create an ImageIcon
        //frame.setIconImage(image.getImage());                  // 1. Change Icon of frame
        this.getContentPane().setBackground(Color.cyan);         // 1. Change color of background

        selection_list();
        
        
    }
    /* 
    public void MyLabel(){
        
        //! 2. JLabel = a GUI display area for a string of text, an image, or both
            
        Border border = BorderFactory.createLineBorder(Color.GREEN, 20);
        
        //ImageIcon image = new ImageIcon("Insert picture file here");
        JLabel label = new JLabel();
        label.setText("Hello yes kjnkljn");                            // 2. Set text of label
        // label.seticon(image);
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
            
            
        this.add(label);
        //this.pack();                                                       // 2. Resize the size of the frame to accommodate all of the components that I have
        // ! USE Pack() after adding label
    }
    */
    /* 
    public void MyPanel(){

        //! 3. JPanel = a GUI component that functions as a container to hold other components
        // ?
        JLabel label = new JLabel();
        
        label.setText("Hi kjncdjlknalksfgn");
        //ImageIcon image = new ImageIcon("Insert picture file name here");
        //label.seticon(image);
        //label.setHorizontalAlignment(JLabel.TOP);
        //label.setVerticalAlignment(JLabel.RIGHT);
        //label.setBounds(x, y, width, height);                         // 3. When panel's setLayout is set to null
        JPanel redpanel = new JPanel();
        redpanel.setBackground(Color.red);
        redpanel.setBounds(0, 0, 250, 250);

        JPanel bluepanel = new JPanel();
        bluepanel.setBackground(Color.BLUE);
        bluepanel.setBounds(250, 0, 250, 250);

        JPanel greenpanel = new JPanel();
        greenpanel.setBackground(Color.green);
        greenpanel.setBounds(0, 250, 500, 500);
        greenpanel.setLayout(new BorderLayout());
        //greenpanel.add(label);

        this.add(redpanel);
        this.add(bluepanel);
        this.add(greenpanel);
    }
    */
    JButton button;
    JLabel label;
    public void MyButton() {
        //! 4. JButton = a buttom that performs an action when clicked on
        //ImageIcon image = new ImageIcon("Insert picture file name here");
        //ImageIcon icon = new ImageIcon("Insert picture file name here");

        this.button = new JButton();
        this.label = new JLabel();

        //label.setIcon(icon);
        //label.setBounds(x, y, width, height);
        //label.setVisible(boolean);

        button.setBounds(100, 500, 100, 50);
        button.setText("dkojgnvkjl");
        button.setFocusable(false);
        //button.setIcon(image);
        //button.setHorizontalTextPosition(JButton.CENTER);
        //button.setVerticalTextPosition(JButton.BOTTOM);
        //button.setFont(new Font("Comic Sans", Font.BOLD, 25));
        button.setIconTextGap(-15);
        button.setForeground(Color.cyan);
        button.setBackground(Color.lightGray);
        button.setBorder(BorderFactory.createEtchedBorder());
        //button.setEnabled(false);                                 // 4. Disables button
        
        this.button.addActionListener(this);
        //this.button.addActionListener(e -> method(););            // 4. Without implement and override method.
        this.add(button);

    }

    public void BorderLayout() {
        //! 5. Layout Manager = Defines the natural layout for components whithin a container

        // 3 common managers

        //! 6. BorderLayout = A BorderLayout places componenrs in fivee areas: NORTH,SOUTH,WEST,EST,CENTER.
        //!                                                                     All extra spaces in the center area.
        this.setLayout(new BorderLayout());
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        panel1.setBackground(Color.red);
        panel2.setBackground(Color.BLUE);
        panel3.setBackground(Color.green);
        panel4.setBackground(Color.YELLOW);
        panel5.setBackground(Color.CYAN);
        
        panel1.setPreferredSize(new Dimension(100,100));
        panel2.setPreferredSize(new Dimension(100,100));
        panel3.setPreferredSize(new Dimension(100,100));
        panel4.setPreferredSize(new Dimension(100,100));
        panel5.setPreferredSize(new Dimension(100,100));
        
        this.add(panel1,BorderLayout.NORTH);
        this.add(panel2,BorderLayout.WEST);
        this.add(panel3,BorderLayout.EAST);
        this.add(panel4,BorderLayout.SOUTH);
        this.add(panel5,BorderLayout.CENTER);
        //panel.add(label);
    }
    public void FlowLayout(){
         
        //! 6. LayOut Manageer = Defines the natural layout for components within a container
        
        //! 6. FlowLayout      = Places components in a row, sized at their preferred size.
        //!                      If the horizontal spacw in the container is too small,
        //!                      the FlowLayout class uses the next available row. 

        
    }
    
    JComboBox<String> box;
    JComboBox<String> lekt;
    public void selection_list(){
        String[] country = new String[Currency_Exchange1.Rahaa().size()];
        int i = 0;
        for(String key: Currency_Exchange1.Rahaa().keySet()){
            country[i] = key;
            i++;
        }
        Arrays.sort(country);
        
        JPanel redpanel = new JPanel();
        redpanel.setBackground(Color.red);
        redpanel.setPreferredSize(new Dimension(100,100));
        this.add(redpanel,BorderLayout.SOUTH);

        box = new JComboBox<>(country);
        //box.setBounds(100, 300, 150, 20);
        box.setVisible(true);
        box.addActionListener(this);
        redpanel.add(box);
        
        lekt = new JComboBox<>(country);
        //lekt.setBounds(400, 300, 150, 20);
        lekt.setVisible(true);
        redpanel.add(lekt);
        
        
        

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            System.out.println("bgkjrfhbkjsnfvkls");
            //label.setVisible(boolean);                            // 4. When pressed label's icon appeares
        }else if(e.getSource() == box){

        }
    }
}
