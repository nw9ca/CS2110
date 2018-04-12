// Source: docs.oracle.com
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* SimpleFrameDemo.java requires no other files. */
public class A_SimpleFrameDemo {
    /**
     * Create a simple GUI and show it.  
     */
    private static void createAndShowGUI() {
        // Start --- Create and set up the window.
        JFrame frame = new JFrame("SimpleFrameDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 300, 150);

        // 1 --- Create a JPanel
		JPanel jp = new JPanel(); 
		jp.setBackground(Color.GRAY); // Set the background to gray
		frame.add(jp); // Add the JPanel "jp" to the JFrame "frame"
		
        // 2 --- Create a JLabel
        JLabel nameLabel = new JLabel("HELLO THERE! THIS IS JUST A SIMPLE DEMO!");
//		//frame.add(nameLabel); // (could add directly to the frame if you want) 
		jp.add(nameLabel);  // Add the JLabel "nameLabel" to the JPanel
		//You can choose to add the label either on the frame or panel function. It depends on the variation you want to use
		//look like panel has more functions (ลูกเล่น)

		// 3 --- Position the JPanel within the frame using BorderLayout
//		frame.add(jp,BorderLayout.SOUTH); // SOUTH means "at the bottom"
//		//frame.add(jp,BorderLayout.EAST); // EAST means "right"
		
		// 4 ---
        //Display the window
        //frame.pack(); //Despite the frame dimensions (300x150 above), window is tightly packed
        // comment and uncomment the above line to see what "pack()" does!
		
        frame.setLocationRelativeTo(null); // Center it on Screen
        frame.setVisible(true); // Set visibility to true
    }

    public static void main(String[] args) {
    	
    	createAndShowGUI();
    }
}