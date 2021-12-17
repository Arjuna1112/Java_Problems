package com.str.simplepro;

import java.util.Date;

/*This Java class is immutable, because its state can not be changed once created. You can see that all of it’s fields are final. 
This is one of the most simple way of creating immutable class in Java, where all fields of class also remains immutable like 
String in above case*/

/*In above example of creating immutable class, Date is a mutable object. If getRemindingDate() returns actual Date object than 
despite remindingDate being final variable, internals of Date can be modified by client code. By returning clone() or copy of 
remindingDate, we avoid that danger and preserves immutability of class*/

public final class MyImmutable {
	
	private final Date remindingDate;
	private final String name;
    private final String mobile;

    public MyImmutable(String name, String mobile,Date remindingDate) {
        this.name = name;
        this.mobile = mobile;
        if(remindingDate.getTime() < System.currentTimeMillis()){
            throw new IllegalArgumentException("Can not set reminder for past time: " + remindingDate);
        }
        this.remindingDate = new Date(remindingDate.getTime());
    }
  
    public String getName(){
        return name;
    }
  
    public String getMobile(){
        return mobile;
    }

    public Date getRemindingDate() {
        return (Date) remindingDate.clone();
    }

}
