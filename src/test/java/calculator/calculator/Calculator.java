package calculator.calculator;



import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class Calculator extends JFrame implements ActionListener {
	
	public static final int WIDTH = 350;
    public static final int HEIGHT = 350;
    private static JTextField display;
    private JTextField infix;
    private JTextField posfix;
    
    // JPanel of calculator 
    public JPanel displayPanel;
	public JPanel controlPanel;
	public JPanel controlPanel1;
	public JPanel controlPanelEqual;
	public Container contentPane; 
	 
	String str = "";
	double result = 0;
	String [] tokens;    
	
	static Stack<Double> operands = new Stack<Double>();
	static Stack<String> operators = new Stack<String>();
	
//	InfixToPostfix change = new InfixToPostfix();
	
	public Calculator(){
		setSize(WIDTH, HEIGHT);
        setTitle (" Calculator ");
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        
        
        displayPanel = new JPanel ( );
		controlPanel = new JPanel ( );
        controlPanel1 = new JPanel( );
        controlPanelEqual = new JPanel( );
        
        contentPane = getContentPane ( );
        contentPane.add (displayPanel, BorderLayout.NORTH);
        contentPane.add (controlPanel, BorderLayout.CENTER);
        contentPane.add (controlPanel1, BorderLayout.EAST);
        contentPane.add (controlPanelEqual, BorderLayout.SOUTH);
		
		displayPanel.setLayout(new GridLayout(3,1));
       
        display = new JTextField(15);
        displayPanel.add(display);
		display.setText("");
        Font font = display.getFont(); 
        font = font.deriveFont(font.getSize()*1.7f); 
        display.setFont(font); 
        display.setHorizontalAlignment(SwingConstants.TRAILING); 
        display.setFocusable(false); 
        
        // Textfield for showing infix
        infix = new JTextField(15);
        displayPanel.add(infix);
		infix.setText("");
        Font font0 = infix.getFont(); 
        font0 = font0.deriveFont(font0.getSize()*1.7f); 
        infix.setFont(font0); 
        infix.setHorizontalAlignment(SwingConstants.TRAILING); 
        infix.setFocusable(false);
        
        // Text field for showing post fix 
        
        posfix = new JTextField(15);
        displayPanel.add(posfix);
		posfix.setText("");
        Font font2 = display.getFont(); 
        font = font2.deriveFont(font2.getSize()*1.7f); 
        posfix.setFont(font2); 
        posfix.setHorizontalAlignment(SwingConstants.TRAILING); 
        posfix.setFocusable(false);
        
		controlPanel.setLayout (new GridLayout (4,4));
		
	        JButton seven = new JButton("7");
	        seven.addActionListener(this);
	        controlPanel.add(seven);
			
	        JButton eight = new JButton("8");
	        eight.addActionListener(this);
	        controlPanel.add(eight);
	        
	        JButton nine = new JButton("9");
	        nine.addActionListener(this);
	        controlPanel.add(nine);
	        
	        JButton backSlash = new JButton("/");
	        backSlash.addActionListener(this);
	        controlPanel.add(backSlash);
	        
	        JButton four = new JButton("4");
	        four.addActionListener(this);
	        controlPanel.add(four);
	        
	        JButton five = new JButton("5");
	        five.addActionListener(this);
	        controlPanel.add(five);
	        
	        JButton six = new JButton("6");
	        six.addActionListener(this);
	        controlPanel.add(six);
	        
	        JButton star = new JButton("*");
	        star.addActionListener(this);
	        controlPanel.add(star);
	        
	        JButton one = new JButton("1");
	        one.addActionListener(this);
	        controlPanel.add(one);
	        
	        JButton two = new JButton("2");
	        two.addActionListener(this);
	        controlPanel.add(two);
	        
	        JButton three = new JButton("3");
	        three.addActionListener(this);
	        controlPanel.add(three);
	        
	        JButton subtrac = new JButton("-");
	        subtrac.addActionListener(this);
	        controlPanel.add(subtrac);
	        
	        JButton zero = new JButton("0");
	        zero.addActionListener(this);
	        controlPanel.add(zero);
	        
	        JButton period = new JButton(".");
	        period.addActionListener(this);
	        controlPanel.add(period);
	 
	        JButton clear = new JButton("Clear");
	        clear.addActionListener(this);
	        controlPanel.add(clear);
	        
	        JButton addition = new JButton("+");
	        addition.addActionListener(this);
	        controlPanel.add(addition);

        controlPanel1.setLayout (new GridLayout (3,1));
        
	        JButton power = new JButton("^"); 
	        power.addActionListener(this); 
	        controlPanel1.add(power);
	        
	        JButton openParants = new JButton("(");
	        openParants.addActionListener(this);
	        controlPanel1.add(openParants);
	        
	        JButton closeParants = new JButton(")");
	        closeParants.addActionListener(this);
	        controlPanel1.add(closeParants);
        
        controlPanelEqual.setLayout(new GridLayout(1,1));
        
	        JButton equals = new JButton("="); 
	        equals.addActionListener(this); 
	        controlPanelEqual.add(equals);
       
        
	}

	int count = 0;
	public void actionPerformed(ActionEvent e) {
			
			String actionCommand = e.getActionCommand( );
						
			if (actionCommand.equals("0"))
	        zero();	
	 	    else if (actionCommand.equals("1"))	
			one();
			else if (actionCommand.equals("2"))
        	two();
			else if (actionCommand.equals("3"))
	     	three();
			else if (actionCommand.equals("4"))       
            four();
			else if (actionCommand.equals("5"))
            five();
			else if (actionCommand.equals("6"))
		    six();
			else if (actionCommand.equals("7"))
	        seven();
			else if (actionCommand.equals("8"))
		    eight();
			else if (actionCommand.equals("9"))
            nine();
			else if (actionCommand.equals("."))
	        period();
			else if (actionCommand.equalsIgnoreCase("Clear"))
            clear();
			else if(actionCommand.equals("+"))
        	plus();   
			else if(actionCommand.equals("-"))
            negative();
			else if(actionCommand.equals("*"))
        	multi();
			else if(actionCommand.equals("^"))
			powerNumber();
			else if(actionCommand.equals("/"))
        	divide();
			else if(actionCommand.equals("("))
	        openParants();
			else if(actionCommand.equals(")"))
	        closeParants();	
			
			else if(actionCommand.equals("="))
			{ 
				String postfix = "";			
                
				str = display.getText();  
                infix.setText("Infix " + str);
              
                Convert ans = new Convert();
                
                postfix =  ans.convert(str);
                posfix.setText("Postfix " + postfix);
               
                Evaluate answer = new Evaluate(); 
                double Result =  answer.evaluate(postfix);
                display.setText("" + Result);
               
                count++;                    
               
			}
			if (count > 0 && !actionCommand.equals("="))
			{
				count = 0;				 
				clear();
			}
		
	}
	
	public void one( ){
		 str = display.getText(); 
		 display.setText(str + "1");
         operands.push((double) 1);	  
	 }
	 public void two( ){
		 str = display.getText(); 
		 display.setText(str + "2");
	     operands.push( (double) 2);	   
	 } 
	 public void three( ){
		 str = display.getText(); 
		 display.setText(str+"3");
	     operands.push((double) 3);	   
	 }
	 public void four( ){
		 str = display.getText(); 
		 display.setText(str + "4");
         operands.push((double) 4);	   
	 }
	 public void five( ){
		 str = display.getText(); 
		 display.setText(str + "5");
         operands.push((double) 5);	   
	 }
	 public void six( ){
		 str = display.getText(); 
		 display.setText(str + "6");
         operands.push((double) 6);	   
	 } 
	 public void seven( ){
		 str = display.getText(); 
		 display.setText(str + "7");
         operands.push((double) 7);	 
	 }
	 public void eight( ){
		 str = display.getText(); 
		 display.setText(str + "8");
         operands.push((double) 8);	  
	 }
	 public void nine( ){
		 str = display.getText(); 
		 display.setText(str + "9");
         operands.push((double) 9);	   
	 }
	 public void zero( ){
		 str = display.getText(); 
		 display.setText(str + "0");
         operands.push((double) 0);	  
	 }
	 public void period( ){
		 str = display.getText(); 
		  display.setText(str + ".");
         operators.push(str);	 
	 }
	 public void plus( ){
		 str = display.getText(); 
		  display.setText(str + " + ");
         operators.push(str);	  
	 }
	 public void negative( ){
		 str = display.getText(); 
		  display.setText(str + " - ");
         operators.push(str);	 
	 }
	 public void divide( ){
		 str = display.getText(); 
		  display.setText(str + " / ");
         operators.push(str);	  
	 }
	 public void multi( ){
		 str = display.getText(); 
		 display.setText(str +  " * ");
         operators.push(str);	  
	 }
	 
	 public void powerNumber()
	 {
		 str = display.getText();
		 display.setText(str + " ^ ");
		 operators.push(str);		 
	 }
	 
	 public void openParants( ){
		 str = display.getText();
		 display.setText(str + " ( ");
         operators.push(str);	  
	 }
	 public void closeParants( ){
		 str = display.getText(); 
		 display.setText(str + " ) ");
         operators.push(str);	  
	 }
	 public void clear( ){
		str = display.getText();
     	display.setText("");
     	infix.setText("");
     	posfix.setText("");
     	operators.empty();
     	operands.empty();
	 }
	 
	public static void main(String[] args)
	 {
		Calculator gui= new Calculator( );
		gui.setVisible(true);
	 }	 
	
}
