package com.collections.implementation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class T3 {
	
	public static int j = 0; 

	public static void main(String[] args) throws Exception
	{
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		String fromdate = "15/06/2013";
		String toDate = "15/06/2016";
		Date startDate = myFormat.parse(fromdate); 
		Date endDate = myFormat.parse(toDate);
		gethistoricalTxn(startDate, endDate);
	}

	private static void gethistoricalTxn(Date startDate, Date endDate) throws Exception
	{
		Date previousdate;
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		String todate=sdf.format(endDate);
		String fromdate=sdf.format(startDate);
		Calendar cal=Calendar.getInstance();
		if(1096>90){
			int years=1096/365;
			cal.setTime(endDate);
			startDate=cal.getTime();
			for (int trans=1; trans<=years+1; trans++)
			{
				System.out.println("Loop ::"+trans);
				todate=sdf.format(startDate);
				cal.add(GregorianCalendar.YEAR,-1);
				cal.add(GregorianCalendar.DAY_OF_YEAR,1);
				previousdate=cal.getTime();
				fromdate=sdf.format(previousdate);
				System.out.println("To Date ::"+todate);
				System.out.println("From Date ::"+fromdate);
				
				scrapetransactions(fromdate,todate,previousdate,startDate,cal, trans);
				cal.add(GregorianCalendar.DAY_OF_YEAR,-1);
				startDate=cal.getTime();
			}
		}
	}

	private static void scrapetransactions(String fromdate,String todate, Date startDate,Date endDate,Calendar cal, int i) throws Exception
	{
		
		long numofdays = (endDate.getTime() - startDate.getTime());
		numofdays = TimeUnit.DAYS.convert(numofdays, TimeUnit.MILLISECONDS);
		System.out.println("Number of Days ::"+numofdays);
		if (i==1 && j<2){
			j++;
			setdaterange(startDate, cal, endDate, (int)numofdays);
		}
	}

	private static void setdaterange(Date startDate,Calendar cal,Date endDate,int numofdays) throws Exception
	{
		cal.setTime(endDate);
		for (int i =1; i <=2; i++) {
			System.out.println("Loop i::"+i);
			System.out.println("Loop j::"+j);
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			String todate=null;
			String fromdate=null;
			Date previousdate;

			startDate=cal.getTime();
			todate=sdf.format(startDate);
			/* For the first retry to download transactions we are downloading transactions for 6 months
			 * by taking number of days between startdate and enddate and divided by 30 days we will get number of months,
			 * for the first retry divideTxnDuration will be 2 hence we are getting 6 months of transactions
			 * if user have for 1000 more transactions for the 6 months also we are getting transactions for 4 months by retrying again.
			 * 
			 */
			int month_value=(numofdays/30)/2;
			cal.add(GregorianCalendar.MONTH,-month_value);
			previousdate=cal.getTime();
			fromdate=sdf.format(previousdate);
			
			System.out.println("To Date in setDateRange::"+todate);
			System.out.println("From Date in setDateRange::"+fromdate);
			scrapetransactions(fromdate,todate,previousdate,startDate,cal, i);  
		}
	}

}
