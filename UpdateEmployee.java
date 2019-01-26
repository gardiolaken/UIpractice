import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * @author Kenneth Gardiola
 *This class takes a file with records and saves it into an internal array
 *for modification and option to update file
 */
public class UpdateEmployee
{

	public static void main(String[] args) throws FileNotFoundException
	{
	//----------GUI------------------------------------------------
		//Error frame
		
		JFrame error = new JFrame("Error");
		error.setBackground(Color.blue);
		error.setSize(450,200);
		JPanel panelE = new JPanel();
		panelE.setLayout(new GridLayout(2,1));
		JTextArea errorTxt= new JTextArea();
		errorTxt.setText("");
	  
	//Save frame  
	  JFrame close = new JFrame("Exit");
	  close.setBackground(Color.black);
	  close.setSize(450,200);
	  JLabel txt = new JLabel("Would you like to save the modifictaitons made?", SwingConstants.CENTER);
	  close.add(txt, BorderLayout.CENTER);
	  //save frame buttons----
	  JButton canc = new JButton("Cancel");
	  JButton no = new JButton ("No");
	  JButton yes = new JButton("Yes");
	  JPanel buttonSave = new JPanel();
	  close.add(buttonSave, BorderLayout.SOUTH);
	  buttonSave.add(canc);
	  buttonSave.add(no);
	  buttonSave.add(yes);
	  
	//Main app Frame
	  JFrame frameMain = new JFrame("UpdateEmp Test Applet");
	  frameMain.setBackground(Color.blue);
	  frameMain.setSize(450,450);
	  JPanel panel = new JPanel();
	  panel.setLayout(new GridLayout(2,1));
	  JPanel north = new JPanel();
	  north.setLayout(new BorderLayout());

	  JLabel heading = new JLabel("UPDATE THE PROGRAM", SwingConstants.CENTER);

	  JPanel recordFields = new JPanel();
	  recordFields.setLayout(new GridLayout(0,2));
	  recordFields.setSize(5,5);
	  
	  JLabel emplidTEXT = new JLabel("Employee Identification");
	  JTextField empidField= new JTextField();
	  empidField.setEditable(false);

	  JLabel teltext = new JLabel("TelePhone Number");
	  JTextField teleField = new JTextField();

	  JLabel texTNAME = new JLabel("Employee Name");
	  JTextField nameField = new JTextField();

	  JLabel text_YOW = new JLabel("Years of Work");
	  JTextField yow_Field = new JTextField();
	  
	  //mainframe buttons
	  JButton prev = new JButton("<< Previous");
	  JButton next = new JButton ("Next >>");
	  JButton displayRecord = new JButton("Display All");
	  JButton exit = new JButton("Exit");
	  

	  recordFields.add(emplidTEXT);
	  recordFields.add(empidField);
	  recordFields.add(teltext);
	  recordFields.add(teleField);
	  recordFields.add(texTNAME);
	  recordFields.add(nameField);
	  recordFields.add(text_YOW);
	  recordFields.add(yow_Field);
	  
	  JPanel buttons = new JPanel();
	  buttons.add(prev);
	  buttons.add(next);
	  buttons.add(displayRecord);
	  buttons.add(exit);
	  
	  north.add(heading, BorderLayout.NORTH);
	  north.add(recordFields, BorderLayout.CENTER);
	  north.add(buttons, BorderLayout.SOUTH);
	  
	  JTextArea south= new JTextArea();
	  JScrollPane scrollPane =  new JScrollPane (south, 
			   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//----------------------------------------------------------------
	  
//----------------IO-------------------------------------	  
	  File fileRecord = new File("Emp.txt");
	  int fileSize = 0;
	  Scanner in = new Scanner(fileRecord);
	 try {
	  if(!in.hasNextInt() == true) {
	  throw new InputMismatchException();
	  }
	 
	  fileSize = in.nextInt();
	  String temp = in.nextLine();
	  Record [] recordsArray = new Record[fileSize];
	  for(int x = 0; x < recordsArray.length; x++) {
	  recordsArray[x] = new Record(in.nextLine());
	  
	  }
	 
	  panel.add(north);
	  panel.add(scrollPane);
	  
	  prev.setEnabled(false);
	  
	// displays records to text
			int ctr = 0;
			south.setText("");
			while(ctr < fileSize)
				{
					south.append(recordsArray[ctr].toString());
					ctr++;
				}
	//sets opening to first record values
	    empidField.setText(String.valueOf(recordsArray[0].getEmpId()));
		teleField.setText(String.valueOf(recordsArray[0].getTelephone()));
		nameField.setText(String.valueOf(recordsArray[0].getName()));
		yow_Field.setText(String.valueOf(recordsArray[0].getYears()));
		int numOfRec = fileSize;
		
		/**
		 * 
		 * when button is pressed this class takes action
		 *
		 */
	  class ButtonListener implements ActionListener
	  {  
		  /**
		   * display records to textarea
		   */
		  public void displayRecords() {
			// displays records to text
			  int ctr = 0;
				south.setText("");
				while(ctr < numOfRec)
				{
					south.append(recordsArray[ctr].toString());
					ctr++;
				}
		  };
		int current = 0;
		/**
		 * specific actions are done for each button pressed
		 */
	  	public void actionPerformed(ActionEvent e)
	  	{
	  		   //when << prev button is pressed
	  		    if(e.getSource() == prev) {
	  		    	//sets current to display
	  		    	recordsArray[current].updateRecord(teleField.getText(), nameField.getText(), Integer.parseInt(yow_Field.getText()));
	  		    	displayRecords();//display current to textarea
	  		    	if(recordsArray[current].getlineID()!=0) {
	  		    		current--;//changes current to previous record
	  		    		empidField.setText(String.valueOf(recordsArray[current].getEmpId()));
	  		    		teleField.setText(String.valueOf(recordsArray[current].getTelephone()));
	  		    		nameField.setText(String.valueOf(recordsArray[current].getName()));
	  					yow_Field.setText(String.valueOf(recordsArray[current].getYears()));
	  					if (current == 0) {// if at first record, disable prev button
	  	  		  			prev.setEnabled(false);
	  	  		  		}
	  					next.setEnabled(true);
	  					
	  			}
	  			
	  		}
	  		
	  		if(e.getSource() == next)
	  		{
	  			recordsArray[current].updateRecord(teleField.getText(), nameField.getText(), Integer.parseInt(yow_Field.getText()));
	  			displayRecords();
	  			if(current < numOfRec - 1) {
	  				current++; //next record to current
	  				empidField.setText(String.valueOf(recordsArray[current].getEmpId()));
	  				teleField.setText(String.valueOf(recordsArray[current].getTelephone()));
	  				nameField.setText(String.valueOf(recordsArray[current].getName()));
	  				yow_Field.setText(String.valueOf(recordsArray[current].getYears()));
	  				prev.setEnabled(true);
	  			}
	  			else
	  				next.setEnabled(false);//end of file no next file
	  		}
	  	  if (e.getSource() == displayRecord) {
	  		recordsArray[current].updateRecord(teleField.getText(), nameField.getText(), Integer.parseInt(yow_Field.getText()));
	  		displayRecords();
			  
		  }
	  	  //exit button pressed
	  	  if(e.getSource().equals(exit)) {
	  		close.setVisible(true);
	  	  }
	  	  //exit button panel------------------------------
	  	  if(e.getSource().equals(canc)) {
	  		close.setVisible(false);
	  	  }
	  	  if(e.getSource().equals(no)) {
	  		close.setVisible(false);	
	  		frameMain.setVisible(false);
		  	  }
	  	  if(e.getSource().equals(yes))  {
	  		  
	  		try {//prints current array of records into file
				PrintWriter out = new PrintWriter("Emp.txt");
				out.print(numOfRec +"\n");
				int ctr = 0;
				do{
					{
						out.printf(recordsArray[ctr].saveFile());
						ctr++;
					}
					}while(ctr < numOfRec);
				
				in.close();
				out.close();
			} catch (FileNotFoundException e1) {
				south.setText("");
				south.setText("Problem saving file");
			} 
	  		  
	  		close.setVisible(false);	
	  		frameMain.setVisible(false);
	  	  }
	  	  //--------------------------------------------------
	  	}
	  }
	  
	  ActionListener listener = new ButtonListener();

	     prev.addActionListener(listener);
	     next.addActionListener(listener);
	     displayRecord.addActionListener(listener);
	  	 exit.addActionListener(listener);
	  	 
	  	 canc.addActionListener(listener);
	     yes.addActionListener(listener);
	     no.addActionListener(listener);
	  	
	  	 
	  	 
	  
	     frameMain.add(panel);
		 frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frameMain.setVisible(true);
		 
		 close.add(txt);
		 close.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 

	

	  
	  
	 }
	  catch(InputMismatchException exception) {
		  errorTxt.append("First Character of File should be number of records");
		  error.setVisible(true);
		  }
	 catch(NullPointerException exception) {
		 errorTxt.append("Invalid number of records");
		 error.setVisible(true);
	 }
	 catch(NoSuchElementException exception) {
		 error.setVisible(true);
		 errorTxt.append("Invalid number of records");
	 }
	 
	  error.add(errorTxt);
	  error.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	  
		 }
		 

	     	
	}
