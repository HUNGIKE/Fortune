import java.awt.*;
import java.io.IOException;

import javax.swing.*;



public class test {

	/**
	 * @param args
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		b i2=new b();
		a i1=i2;
		
		i1.getHello();i2.getHello();
		System.out.println(i1.name+" "+i2.name);
		
		
	}
	
	
	static class a{
		String name="a";
		void getHello(){System.out.println("hello, I'm "+name);}
	}
	
	static class b extends a{
		String name="b";
	}

}
