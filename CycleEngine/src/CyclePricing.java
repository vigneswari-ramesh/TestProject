// Done by Vigneswari Ramesh
// Input is taken as command line argument and the last argument should be the date
// Output will print the price of each high level component and total price of the cycle
// Date should be in th form dd/mm/yyyy
// All the inputs will be small letter and give a single component without spaces in between


import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


class Cycle extends Thread{
	
	public void run() {
		
		System.out.println("Thread running");
		
	}
	
	public float framePricicg(String data, String date) throws ParseException {
		 Date dateCheck= (Date) new SimpleDateFormat("dd/MM/yyyy").parse(date);  
		 Date defaultDate = (Date) new SimpleDateFormat("dd/MM/yyyy").parse("2016/12/31"); 
		if(dateCheck.compareTo(defaultDate) > 0) {
			switch(data) {
			case "toptube": return 173;
			case "headtube": return 299;
			case "seatstays": return 100;
			case "bottombracketshell": return 200;
			}
		}else {
			switch(data) {
			case "toptube": return 150;
			case "headtube": return 267;
			case "seatstays": return 83;
			case "bottombracketshell": return 185;
			}
			
		}
		return 0;
	}
	
	public float handlebarPricicg(String data, String date) throws ParseException {
		
		Date dateCheck= (Date) new SimpleDateFormat("dd/MM/yyyy").parse(date);  
		Date defaultDate = (Date) new SimpleDateFormat("dd/MM/yyyy").parse("2016/12/31"); 
		
		if(dateCheck.compareTo(defaultDate) > 0) {
			switch(data) {
			case "frontlight": return 350;
			case "backlight": return 80;
			case "breaks": return 50;
			case "reflector": return 20;
			case "ballbearing": return 120;
			}
		}else {
			switch(data) {
			case "frontlight": return 300;
			case "backlight": return 63;
			case "breaks": return 40;
			case "reflector": return 13;
			case "ballbearing": return 100;
			}
			
		}
		return 0;
	}
	
	public float seatingPricicg(String data, String date) throws ParseException {
		 
		Date dateCheck= (Date) new SimpleDateFormat("dd/MM/yyyy").parse(date);  
		Date defaultDate = (Date) new SimpleDateFormat("dd/MM/yyyy").parse("2016/12/31"); 
		
		if(dateCheck.compareTo(defaultDate) > 0) {
			switch(data) {
			case "platform": return 140;
			case "fabric": return 55;
			case "rods": return 70;
			}
		}else {
			switch(data) {
			case "platform": return 132;
			case "fabric": return 42;
			case "rods": return 63;
			}
			
		}
		return 0;
	}
	
	public float wheelsPricicg(String data, String date) throws ParseException {

		Date dateCheck= (Date) new SimpleDateFormat("dd/MM/yyyy").parse(date);  
		Date defaultDate = (Date) new SimpleDateFormat("dd/MM/yyyy").parse("2016/12/31"); 
		
		if(dateCheck.compareTo(defaultDate) > 0) {
			switch(data) {
			case "spokes": return 430;
			case "rim": return 450;
			case "tube": return 110;
			case "tyre": return 200;
			}
		}else {
			switch(data) {
			case "spokes": return 400;
			case "rim": return 425;
			case "tube": return 95;
			case "tyre": return 230;
			}
			
		}
		return 0;
	}
	
	public float chainassemblyPricicg(String data, String date) throws ParseException {

		Date dateCheck= (Date) new SimpleDateFormat("dd/MM/yyyy").parse(date);  
		Date defaultDate = (Date) new SimpleDateFormat("dd/MM/yyyy").parse("2016/12/31"); 
		
		if(dateCheck.compareTo(defaultDate) > 0) {
			switch(data) {
			case "outerplate": return 173;
			case "innerplate": return 299;
			case "roller": return 100;
			case "assembly": return 200;
			}
		}else {
			switch(data) {
			case "outerplate": return 173;
			case "innerplate": return 299;
			case "roller": return 100;
			case "assembly": return 200;
			}
			
		}
		return 0;
	}
	

}

public class CyclePricing {
	
	public static void main(String args[]) throws ParseException {
		
		Cycle obj=new Cycle();
		obj.start();
		
		float framePrice=0.0f, handlePrice=0.0f,seatingPrice=0.0f,wheelPrice=0.0f,chainPrice=0.0f,totalPrice=0.0f;
		int count = args.length;
		
		
		for(int i=0; i < count; i++) {
			if(args[i].equals("toptube") || args[i].equals("headtube") || args[i].equals("seatstays") || args[i].equals("bottombracketshell")  ) {
				framePrice= framePrice + (obj.framePricicg(args[i], args[count-1])); // assuming that date will be the last argument
			}else if(args[i].equals("frontlight") || args[i].equals("backlight") || args[i].equals("breaks") || args[i].equals("reflector") || args[i].equals("ballbearing")  ) {
				handlePrice= handlePrice + (obj.handlebarPricicg(args[i], args[count-1])); // assuming that date will be the last argument
			}else if(args[i].equals("platform" ) || args[i].equals("fabric") || args[i].equals("rods") ) {
				seatingPrice= seatingPrice + (obj.seatingPricicg(args[i], args[count-1])); // assuming that date will be the last argument
			}else if(args[i].equals( "spokes") || args[i] .equals( "rim") || args[i].equals( "tube") || args[i].equals("tyre") ) {
				wheelPrice= wheelPrice + (obj.wheelsPricicg(args[i], args[count-1])); // assuming that date will be the last argument
			}else if(args[i].equals("outerplate") || args[i].equals("innerplate") || args[i].equals("roller") || args[i].equals( "assembly") ) {
				chainPrice= chainPrice + (obj.chainassemblyPricicg(args[i], args[count-1])); // assuming that date will be the last argument
			}
		}
		
		if(!(framePrice == 0)) {
			System.out.println("Price of frame component:"+framePrice);
		}else if(!(handlePrice == 0)) {
			System.out.println("Price of handlebar component:"+handlePrice);
		}else if(!(seatingPrice == 0)) {
			System.out.println("Price of seating component:"+seatingPrice);
		}else if(!(wheelPrice == 0)) {
			System.out.println("Price of wheel component:"+wheelPrice);
		}else if(!(chainPrice == 0)) {
			System.out.println("Price of chain assembly component:"+chainPrice);
		}
		totalPrice = framePrice + handlePrice + wheelPrice + chainPrice + seatingPrice;
		System.out.println("Price of the Cycle:"+totalPrice);
		
	}
	
}
