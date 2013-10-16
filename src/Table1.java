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
			fr.read();//把空白讀掉  
			
			c=new char[4];fr.read(c);
			int v2=new Integer(new String(c)).intValue();
			fr.read();//把空白讀掉  
			
			t[i][j]=new data(v1,v2);
			
		}fr.read();fr.read();//把換行讀掉  
		}
		
		fr.close();
		this.isOpen=true;
	}

	
	public data query(divinatory d1,divinatory d2) throws Throwable{
		if(!this.isOpen)throw new Throwable("表格尚未完成讀取資料動作");
		
		return this.t[transform(d1)][transform(d2)];
	}
	
	
	public data query(TG t,DG d) throws Throwable{
		if(!this.isOpen)throw new Throwable("表格尚未完成讀取資料動作");
		int d1=transform(transform(t)),d2=transform(transform(d));
		
		return this.t[d1][d2];
	}
	
	private divinatory transform(TG t) throws Throwable{
		if(t==TG.甲||t==TG.壬)return divinatory.乾;
		if(t==TG.丁)return divinatory.兌;
		if(t==TG.己)return divinatory.離;
		if(t==TG.庚)return divinatory.震;
		
		if(t==TG.辛)return divinatory.巽;
		if(t==TG.戊)return divinatory.坎;
		if(t==TG.丙)return divinatory.艮;
		if(t==TG.乙||t==TG.癸)return divinatory.坤;
		throw new Throwable("輸入的資料可能有誤");
	}
	
	
	private divinatory transform(DG d) throws Throwable{
		if(d==DG.卯||d==DG.酉)return divinatory.乾;
		if(d==DG.辰)return divinatory.兌;
		if(d==DG.巳||d==DG.午)return divinatory.離;
		if(d==DG.寅)return divinatory.震;
		
		if(d==DG.戌)return divinatory.巽;
		if(d==DG.亥||d==DG.子)return divinatory.坎;
		if(d==DG.未||d==DG.申)return divinatory.艮;
		if(d==DG.丑)return divinatory.坤;   
		
		throw new Throwable("輸入的資料可能有誤");
	}
	
	private int transform(divinatory v) throws Throwable{
		if(v==divinatory.乾)return 0;
		if(v==divinatory.兌)return 1;
		if(v==divinatory.離)return 2;
		if(v==divinatory.震)return 3;
		if(v==divinatory.巽)return 4;
		if(v==divinatory.坎)return 5;
		if(v==divinatory.艮)return 6;
		if(v==divinatory.坤)return 7;		
		
		
		throw new Throwable("輸入的資料可能有誤");
	}
	

}
