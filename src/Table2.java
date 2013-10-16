import java.io.*;




public class Table2 {
	private boolean isOpen=false;
	private data[][] t;
	
	
	public class data{
		public String str;
		public int df,d1,d2,d3;
		public data(String str,int df,int d1,int d2,int d3){
			this.str=str;this.df=df;this.d1=d1;this.d2=d2;this.d3=d3;
		}
	}
	
	public Table2(){
		t=new data[8][];
		for(int i=0;i<t.length;i++){
			t[i]=new data[8];
		}
		
	}
	

	public void open() throws IOException{
		//BufferedReader br=new BufferedReader(new FileReader(new File("table2_data")));
		BufferedReader br=new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("table2_data")));
		
		for(int i=0;i<8;i++){
			String[] sr=br.readLine().split(" +");
		for(int j=0;j<8;j++){
			String str=sr[j*5];
			int df=new Integer(sr[j*5+1]),d1=new Integer(sr[j*5+2]),
				d2=new Integer(sr[j*5+3]),d3=new Integer(sr[j*5+4]);
			t[i][j]=new data(str,df,d1,d2,d3);
		}
		}
		
		
		br.close();
		this.isOpen=true;
	}
	
	

	public data query(divinatory v1,divinatory v2) throws Throwable{
		if(!this.isOpen)throw new Throwable("表格尚未完成讀取資料動作");
		int d1=transform(v1),d2=transform(v2);
		
		return this.t[d1][d2];
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
