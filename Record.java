import java.lang.*;
import java.util.*;
import java.io.*;

public class Record {
	private int lineID = 0;
	private int empId;
	private String telephone;
	private String name;
	private int years_of_Work;
	
	public Record(String line) {
		lineID = lineID;
		lineID++;
		Scanner scanner = new Scanner(line);
		empId = scanner.nextInt();
		telephone = scanner.next();
		name = scanner.next();
		while(!scanner.hasNextInt()) {
			name = name + " " + scanner.next();
		}
		years_of_Work = scanner.nextInt();
		}
	
	public int getlineID() {return lineID;}
	public void updateRecord(String t, String n, int y) {
		setName(n);
		setTelephone(t);
		setYears(y);
		
	}
	public void setEmpId(int e) {
		empId = e;
	}
	public void setName(String n) {
		name = n;
	}
	public void setTelephone(String t) {
		telephone = t;
	}
	public void setYears(int y) {
		years_of_Work = y;
	}
	public int getEmpId() {
		return empId;
	}
	public String getName() {
		return name;
	}
	public String getTelephone() {
		return telephone;
	}
	public int getYears() {
		return years_of_Work;
	}
	public String toString() {
		return "ID:" + empId + " name: " +name + " phone=" + telephone + ", years of work=" + years_of_Work + "\n";
	}
	public String saveFile() {
		return empId + " " + telephone + " " + name + " " + years_of_Work + "\n"; 
	}
	
}