import java.io.*;


public class Table1 {
	private boolean isOpen=false;
	private data[][] t;
	public static class data{
		public int A,B;
		public data(int A,int B){this.A=A;this.B=B;}
	}
	public Table1(){//10*12
		t=new data[8][];
		for(int i=0;i<t.length;i++){
			t[i]=new data[8];
		}
	}
	public void open() throws IOException{
		//FileReader fr=new FileReader(new File("table1_data"));
		
		Reader fr=new InputStreamReader(this.getClass().getResourceAsStream("table1_data"));
		
		
		
		for(int i=0;i<8;i++){
		for(int j=0;j<8;j++){
			char[] c=new char[4];fr.read(c);
			int v1=new Integer(new String(c)).intValue();
			fr.read();//��ť�Ū��  
			
			c=new char[4];fr.read(c);
			int v2=new Integer(new String(c)).intValue();
			fr.read();//��ť�Ū��  
			
			t[i][j]=new data(v1,v2);
			
		}fr.read();fr.read();//�⴫��Ū��  
		}
		
		fr.close();
		this.isOpen=true;
	}

	
	public data query(divinatory d1,divinatory d2) throws Throwable{
		if(!this.isOpen)throw new Throwable("���|������Ū����ưʧ@");
		
		return this.t[transform(d1)][transform(d2)];
	}
	
	
	public data query(TG t,DG d) throws Throwable{
		if(!this.isOpen)throw new Throwable("���|������Ū����ưʧ@");
		int d1=transform(transform(t)),d2=transform(transform(d));
		
		return this.t[d1][d2];
	}
	
	private divinatory transform(TG t) throws Throwable{
		if(t==TG.��||t==TG.��)return divinatory.��;
		if(t==TG.�B)return divinatory.�I;
		if(t==TG.�v)return divinatory.��;
		if(t==TG.��)return divinatory.�_;
		
		if(t==TG.��)return divinatory.�S;
		if(t==TG.��)return divinatory.��;
		if(t==TG.��)return divinatory.��;
		if(t==TG.�A||t==TG.��)return divinatory.�[;
		throw new Throwable("��J����ƥi�঳�~");
	}
	
	
	private divinatory transform(DG d) throws Throwable{
		if(d==DG.�f||d==DG.��)return divinatory.��;
		if(d==DG.��)return divinatory.�I;
		if(d==DG.�x||d==DG.��)return divinatory.��;
		if(d==DG.�G)return divinatory.�_;
		
		if(d==DG.��)return divinatory.�S;
		if(d==DG.��||d==DG.�l)return divinatory.��;
		if(d==DG.��||d==DG.��)return divinatory.��;
		if(d==DG.��)return divinatory.�[;   
		
		throw new Throwable("��J����ƥi�঳�~");
	}
	
	private int transform(divinatory v) throws Throwable{
		if(v==divinatory.��)return 0;
		if(v==divinatory.�I)return 1;
		if(v==divinatory.��)return 2;
		if(v==divinatory.�_)return 3;
		if(v==divinatory.�S)return 4;
		if(v==divinatory.��)return 5;
		if(v==divinatory.��)return 6;
		if(v==divinatory.�[)return 7;		
		
		
		throw new Throwable("��J����ƥi�঳�~");
	}
	

}
