package com.strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

public class MySingleton {
	
	//Eager initialization
	/*In eager initialization, the instance of Singleton Class is created at the time of class loading, 
	this is the easiest method to create a singleton class but it has a drawback that instance is created 
	even though client application might not be using it.*/
	
	static class EagerInitializedSingleton {
		private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
		private EagerInitializedSingleton(){
			
		}
		
		public static EagerInitializedSingleton getInstance(){
			return instance;
		}
		
	}
	
	//Static block initialization
	/*Static block initialization implementation is similar to eager initialization, except that instance of 
	class is created in the static block that provides option for exception handling.*/
	
	static class StaticBlockSingleton {
		
		private static StaticBlockSingleton instane;
		private StaticBlockSingleton(){}
		static {
			try{
				instane = new StaticBlockSingleton();	
			}
			catch(Exception e){
				System.out.println("Issue in creating singleton");
			}
		}
		public static StaticBlockSingleton getInstance() {
			return instane;
		}
	}
	
	//Lazy initialization
	/*Lazy initialization method to implement Singleton pattern creates the instance in the global access method. 
	Here is the sample code for creating Singleton class with this approach.*/

	static class LazyInitialization{
		private LazyInitialization instance;
		private LazyInitialization(){}
		
		public LazyInitialization getInstance(){
			if(instance==null){
				instance = new LazyInitialization();
			} 
			return instance;
		}
	}
	
	//Thread Safe Singleton
	/*The easier way to create a thread-safe singleton class is to make the global access method synchronized, so 
	that only one thread can execute this method at a time. General implementation of this approach is like the below class.*/
	
	static class ThreadSafeSingleton{
		private static ThreadSafeSingleton instance;
		private ThreadSafeSingleton(){}
		
		public static ThreadSafeSingleton getInstance(){
			if(instance==null){
				synchronized (ThreadSafeSingleton.class) {
					if(instance==null){
						instance = new ThreadSafeSingleton();
					}
				}
			}
			return instance;
		}
	}
	
	//Using Reflection to destroy Singleton Pattern
	//Reflection can be used to destroy all the above singleton implementation approaches. Let’s see this with an example class.
	
	static class ReflectionSingletonTest{
		@SuppressWarnings("rawtypes")
		public static void main(String[] args) {
	        EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();
	        EagerInitializedSingleton instanceTwo = null;
	        try {
	            Constructor[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
	            for (Constructor constructor : constructors) {
	                //Below code will destroy the singleton pattern
	                constructor.setAccessible(true);
	                instanceTwo = (EagerInitializedSingleton) constructor.newInstance();
	                break;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        System.out.println(instanceOne.hashCode());
	        System.out.println(instanceTwo.hashCode());
	    }
	}
	
	//Enum Singleton
	/*To overcome this situation with Reflection, Joshua Bloch suggests the use of Enum to implement Singleton design pattern as Java 
	ensures that any enum value is instantiated only once in a Java program. Since Java Enum values are globally accessible, so is 
	the singleton. The drawback is that the enum type is somewhat inflexible; for example, it does not allow lazy initialization.*/
	
	static enum EnumSingleton {
		INSTANCE;
		public static void doSomething() {
			//do something
		}
	}
	
	//Serialization and Singleton
	/*Sometimes in distributed systems, we need to implement Serializable interface in Singleton class so that we can store it’s state in file 
	system and retrieve it at later point of time. Here is a small singleton class that implements Serializable interface also.*/
	
	static class SerializedSingleton implements Serializable{
		 
	    private static final long serialVersionUID = -7604766932017737115L;
	 
	    private SerializedSingleton(){}
	     
	    private static class SingletonHelper{
	        private static final SerializedSingleton instance = new SerializedSingleton();
	    }
	     
	    public static SerializedSingleton getInstance(){
	        return SingletonHelper.instance;
	    }
	}
	
	/*The problem with above serialized singleton class is that whenever we deserialize it, it will create a new instance of the class. Let’s see it 
	with a simple program.*/
	
	static class SingletonSerializedTest {
		 
	    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
	        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
	        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
	        out.writeObject(instanceOne);
	        out.close();
	         
	        //deserialization from file to object
	        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
	        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
	        in.close();
	         
	        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
	        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());
	         
	    }
	}
	
	//So it destroys the singleton pattern, to overcome this scenario all we need to do it provide the implementation of readResolve() method.
	
	/*protected Object readResolve() {
	    return getInstance();
	}*/

}
