/*
 * Version: Student Version
 * 
 * Initial code was obtained from http://codereview.stackexchange.com/questions/97430/calculator-in-java-using-jframe
 * Lab specific modifications made by Ben Greenawald and Cole Schafer
 * 
 * Assignment:
 *  - Implement the exponent button
 *  - If you run the code you will see a functioning 4 function calculator
 *  - notice the exponent button is on the GUI but the functionality has not been implemented
 *  - Study the rest of the code, and make the appropriate changes to make the exponent button work
 * 
 * Instructions:
 *  1. implement the static exp() method
 *   - line #103
 *  
 *  2. implement the ActionListener for the exponent button
 *   - line #325
 *   
 *  3. implement part of equals button ActionListener responsible for handling exponentiation
 *   - line #435
 * 
 */

//import statements 
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("unused")
public class Calculator extends JFrame {
	private static final long serialVersionUID = 1L;

	// Global Variables
	JTextField numDisplay;

	// Buttons
	JButton zero;
	JButton one;
	JButton two;
	JButton three;
	JButton four;
	JButton five;
	JButton six;
	JButton seven;
	JButton eight;
	JButton nine;
	JButton add;
	JButton subtract;
	JButton multiply;
	JButton divide;
	JButton percent;
	JButton equals;
	JButton exp;
	JButton clear;
	JButton decimalPoint;

	// Strings
	String addString;
	String subString;
	String multiString;
	String divString;
	String expString;
	String finalString;
	String answerAsString;
	String percentAsString;
	String prcntAnswerAsString;

	// Doubles
	double addDouble;
	double subDouble;
	double multiDouble;
	double divDouble;
	double finalDouble;
	double answer;
	double expDouble;
	double percentAsDouble;
	double prcntAnswerAsDouble;

	// Math Operation Methods
	public static double add(double num1, double num2) {
		return num1 + num2;
	}

	public static double subtract(double num1, double num2) {
		return num1 - num2;
	}

	public static double multiply(double num1, double num2) {
		return num1 * num2;
	}

	public static double divide(double num1, double num2) {
		return num1 / num2;
	}

	// IMPLEMENT THIS METHOD - return num1^num2
	public static double exp(double num1, double num2) {
		return Math.pow(num1, num2);
	}

	// GUI setup
	public Calculator() {

		// ************************FRAME
		// SETUP****************************************************************
		super("Calculator");
		setLayout(new GridBagLayout());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);

		GridBagConstraints gbc = new GridBagConstraints();

		numDisplay = new JTextField();
		numDisplay.setPreferredSize(new Dimension(130, 30));
		numDisplay.setEditable(false);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(numDisplay, gbc);

		// *********************BUTTON
		// SETUP******************************************************************

		// 0 button
		zero = new JButton("0");
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(zero, gbc);

		// 1 button
		one = new JButton("1");
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		add(one, gbc);

		// 2 button
		two = new JButton("2");
		gbc.gridx = 2;
		gbc.gridy = 2;
		add(two, gbc);

		// 3 button
		three = new JButton("3");
		gbc.gridx = 3;
		gbc.gridy = 2;
		add(three, gbc);

		// 4 button
		four = new JButton("4");
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(four, gbc);

		// 5 button
		five = new JButton("5");
		gbc.gridx = 2;
		gbc.gridy = 3;
		add(five, gbc);

		// 6 button
		six = new JButton("6");
		gbc.gridx = 3;
		gbc.gridy = 3;
		add(six, gbc);

		// 7 button
		seven = new JButton("7");
		gbc.gridx = 1;
		gbc.gridy = 4;
		add(seven, gbc);

		// 8 button
		eight = new JButton("8");
		gbc.gridx = 2;
		gbc.gridy = 4;
		add(eight, gbc);

		// 9 button
		nine = new JButton("9");
		gbc.gridx = 3;
		gbc.gridy = 4;
		add(nine, gbc);

		// addition button
		add = new JButton("+");
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(add, gbc);

		// subtraction button
		subtract = new JButton("-");
		gbc.gridx = 2;
		gbc.gridy = 1;
		add(subtract, gbc);

		// multiplication button
		multiply = new JButton("x");
		gbc.gridx = 3;
		gbc.gridy = 1;
		add(multiply, gbc);

		// division button
		divide = new JButton("÷");
		gbc.gridx = 4;
		gbc.gridy = 2;
		add(divide, gbc);

		// percentage button
		percent = new JButton("%");
		gbc.gridx = 4;
		gbc.gridy = 1;
		add(percent, gbc);

		// decimal point button
		decimalPoint = new JButton(".");
		gbc.gridx = 3;
		gbc.gridy = 5;
		add(decimalPoint, gbc);

		// equals button
		equals = new JButton("=");
		gbc.gridx = 4;
		gbc.gridy = 2;
		gbc.gridheight = 3;
		add(equals, gbc);

		// clear button
		clear = new JButton("AC");
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		add(clear, gbc);

		// exponent button
		exp = new JButton("^");// here
		gbc.gridx = 4;
		gbc.gridy = 4;
		add(exp, gbc);

		// ************************* ACTION LISTENERS
		// ************************************************************

		// ********************* NUMBER BUTTON
		// LISTENERS*****************************************************

		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				numDisplay.setText(numDisplay.getText() + "0");
			}
		});

		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				numDisplay.setText(numDisplay.getText() + "1");
			}
		});

		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				numDisplay.setText(numDisplay.getText() + "2");
			}
		});

		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				numDisplay.setText(numDisplay.getText() + "3");
			}
		});

		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				numDisplay.setText(numDisplay.getText() + "4");
			}
		});

		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				numDisplay.setText(numDisplay.getText() + "5");
			}
		});

		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				numDisplay.setText(numDisplay.getText() + "6");
			}
		});

		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				numDisplay.setText(numDisplay.getText() + "7");
			}
		});

		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				numDisplay.setText(numDisplay.getText() + "8");
			}
		});

		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				numDisplay.setText(numDisplay.getText() + "9");
			}
		});

		// ********************* NUMBER BUTTON
		// LISTENERS*****************************************************

		exp.addActionListener(new ActionListener() {// here
			public void actionPerformed(ActionEvent event) {
				addString = numDisplay.getText();
				addDouble = Double.parseDouble(addString);
				numDisplay.setText("");
				resetDecimalPoint();
				// ADD CODE HERE

			}
		});

		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				addString = numDisplay.getText();
				addDouble = Double.parseDouble(addString);
				numDisplay.setText("");
				resetDecimalPoint();
			}
		});

		subtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				subString = numDisplay.getText();
				subDouble = Double.parseDouble(subString);
				numDisplay.setText("");
				decimalPoint.setEnabled(true);
				resetDecimalPoint();
			}
		});

		multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				multiString = numDisplay.getText();
				multiDouble = Double.parseDouble(multiString);
				numDisplay.setText("");
				decimalPoint.setEnabled(true);
				resetDecimalPoint();
			}
		});

		divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				divString = numDisplay.getText();
				divDouble = Double.parseDouble(divString);
				numDisplay.setText("");
				decimalPoint.setEnabled(true);
				resetDecimalPoint();
			}
		});

		percent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				percentAsString = numDisplay.getText();
				percentAsDouble = Double.parseDouble(percentAsString);
				prcntAnswerAsDouble = percentAsDouble * 0.01;
				prcntAnswerAsString = Double.toString(prcntAnswerAsDouble);
				numDisplay.setText(prcntAnswerAsString);
				resetDecimalPoint();
			}
		});

		decimalPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String numDisplayContents = "";
				if (!numDisplay.getText().contains(".")) {
					numDisplay.setText(numDisplay.getText() + ".");
					numDisplayContents = numDisplay.getText();
				}
				if (numDisplayContents.contains(".")) {
					decimalPoint.setEnabled(false);
				}
			}
		});

		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				numDisplay.setText("");
				addString = null;
				subString = null;
				multiString = null;
				divString = null;
				finalString = null;
				expString = null;
				prcntAnswerAsString = null;
				resetDecimalPoint();
			}
		});

		equals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				finalString = numDisplay.getText();
				finalDouble = Double.parseDouble(finalString);
				resetDecimalPoint();

				if (addString != null) {
					answer = add(addDouble, finalDouble);
					answerAsString = Double.toString(answer);
					numDisplay.setText(answerAsString);

				} else if (subString != null) {
					answer = subtract(subDouble, finalDouble);
					answerAsString = Double.toString(answer);
					numDisplay.setText(answerAsString);

				} else if (multiString != null) {
					answer = multiply(multiDouble, finalDouble);
					answerAsString = Double.toString(answer);
					numDisplay.setText(answerAsString);

				} else if (divString != null) {
					answer = divide(divDouble, finalDouble);
					answerAsString = Double.toString(answer);
					numDisplay.setText(answerAsString);

				} else if (expString != null) { // here
					answer = exp(expDouble, finalDouble);
					answerAsString = Double.toString(answer);
					numDisplay.setText(answerAsString);

				} else {
					addString = null;
					subString = null;
					multiString = null;
					divString = null;
					expString = null;
				}
			}
		});
	}

	private void resetDecimalPoint() {
		if (!decimalPoint.isEnabled()) {
			decimalPoint.setEnabled(true);
		}
	}

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.pack();
	}
}