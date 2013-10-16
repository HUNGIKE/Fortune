import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;




public class Fortune extends JFrame implements MouseListener{
	private P1 p1=new P1();private P2 p2=new P2();private P3 p3=new P3();private P4 p4=new P4();
	private P5 p5=new P5();private P6 p6=new P6();private P7 p7=new P7();private P8 p8=new P8();	
	
	private LayoutManager lm=new GridLayout(1,1);
	private Table1 t1=new Table1();
	private Table2 t2=new Table2();
	private JTabbedPane jtp=new JTabbedPane();

	public Fortune() throws IOException{
		super("Fortune");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(lm);
		this.setSize(870,600);
		this.setResizable(false);
		
		this.add(jtp);
		//this.jtp.add(new JPrintBoard());
		
		p1.addMouseListenerToJB(this);
		p1.setFortune(this);
		p1.setChoiceEnable(true);
		
		JPanel jpn1=new JPanel();jpn1.setLayout(null);jpn1.setBackground(Color.ORANGE);
		p1.setBounds(0,0,320,170);jpn1.add(p1);
		p2.setBounds(320,0,220,130);jpn1.add(p2);
		p3.setBounds(320,130, 220,40);jpn1.add(p3);
		p4.setBounds(630,0,220,130);jpn1.add(p4);
		p5.setBounds(630,130,220,40);jpn1.add(p5);
		p6.setBounds(0,170,220,360);jpn1.add(p6);
		p7.setBounds(220,170,300,390);jpn1.add(p7);
		p8.setBounds(520,170,330,390);jpn1.add(p8);
		
		
		this.jtp.addTab("",jpn1);
		//this.jtp.add(p2);
		//this.jtp.add(p3);
		//this.jtp.add(p4);
		
		//this.jtp.addTab("Test2",p5);
		//this.jtp.addTab("Test3",p6);
		//this.jtp.addTab("Test4",p7);
		//this.jtp.addTab("Test5",p8);
		
		this.t1.open();
		this.t2.open();
		
		
	
		this.setVisible(true);
		
		this.fc = new JFileChooser();
		
		
		
		
	}
	public void clearAll(){
		this.p1.clear();
		this.p2.clear();
		this.p3.clear();
		this.p4.clear();
		this.p5.clear();
		this.p6.clear();
		this.p7.clear();
		this.p8.clear();
		
		
	}
	
	private JFileChooser fc;
	public void print(){
		if(p1.isChoiceEnable())return;
		   
		try {
			fc.setSelectedFile(new File((System.getProperty("user.home") + "/Desktop/列印用檔案.txt").replace("\\", "/")));
			int returnVal = fc.showOpenDialog(this);
				File file=null;
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = fc.getSelectedFile();
			}

		
		
			BufferedWriter w=new BufferedWriter(new FileWriter(file));
			try{
				String str=(p1.toString()+p2+p3+p4+p5+p6+p7+p8);
				char[] ca=str.toCharArray();
				for(int i=0;i<ca.length;i++){
					if(ca[i]=='\n'){
						w.newLine();
					}else{
						w.write(ca[i]);
					}
				}
			}finally{
				w.close();
			}
			JOptionPane.showMessageDialog(this,"檔案輸出完成。");
		    
			
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			JOptionPane.showMessageDialog(this,"檔案輸出遇到某些錯誤。");
			
			
		}
		
		//System.out.println(p1.toString()+p2+p3+p4+p5+p6+p7+p8);
		
	}
	
	public static void main(String args[]) throws IOException{
		
		JFrame j=new Fortune();
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(!p1.isChoiceEnable())return;
		
		
		
		P1.data p1d=this.p1.getData();
		int[] i=new int[8];
		try {
		
		
		
		Table1.data
			t1d=t1.query(p1d.ty,p1d.dy);i[0]=t1d.A;i[4]=t1d.B;
			t1d=t1.query(p1d.tm,p1d.dm);i[1]=t1d.A;i[5]=t1d.B;
			t1d=t1.query(p1d.td,p1d.dd);i[2]=t1d.A;i[6]=t1d.B;		
			t1d=t1.query(p1d.th,p1d.dh);i[3]=t1d.A;i[7]=t1d.B;
			this.p1.setChoiceEnable(false);
			
			
			p2.setData(i);
			p3.setData(p1d);
			p4.setDate(p1d,t1);
			p5.setData(p1d);
			p6.setPreData(p1d);
			p7.setPreData(p1d);
			p8.setData(p1d,t2);
			
			
			
			
			
			
			
		} catch (Throwable e) {e.printStackTrace();}
		this.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}

class JCTG extends JComboBox{
	
	JCTG(){
		this.setSize(40,25);
		

		
		this.setMaximumRowCount(10);
		this.addItem(TG.甲);this.addItem(TG.乙);
		this.addItem(TG.丙);this.addItem(TG.丁);
		this.addItem(TG.戊);this.addItem(TG.己);
		this.addItem(TG.庚);this.addItem(TG.辛);
		this.addItem(TG.壬);this.addItem(TG.癸);
	}
	
	public TG getChoice(){
		return (TG)this.getSelectedItem();
		
	}
	public String toString(){
		return ((TG)this.getSelectedItem()).c;
		
	}
	
}
class JCDG extends JComboBox{
	
	JCDG(){
		this.setSize(40,25);
		this.setMaximumRowCount(12);
		this.addItem(DG.子);this.addItem(DG.丑);
		this.addItem(DG.寅);this.addItem(DG.卯);
		this.addItem(DG.辰);this.addItem(DG.巳);
		this.addItem(DG.午);this.addItem(DG.未);
		this.addItem(DG.申);this.addItem(DG.酉);
		this.addItem(DG.戌);this.addItem(DG.亥);
	}
	
	public DG getChoice(){
		return (DG)this.getSelectedItem();
	}
	
	public String toString(){
		return ((DG)this.getSelectedItem()).c;
		
	}
	
	
}

class BlockBase extends JPanel{
	public BlockBase(){
		//this.setIconifiable(true);
		this.setVisible(true);
		//this.setResizable(true);
		//this.setMaximizable(true);
	}
	
	
	
	public void clear(){
		Component[] ca=this.getComponents();
		for(int i=0;i<ca.length;i++){
			if(ca[i] instanceof NewJLabel){
				((NewJLabel)ca[i]).setText("");
				
			}else if(ca[i] instanceof JComboBox){
				((JComboBox)ca[i]).setSelectedIndex(0);
			}else if(ca[i] instanceof JTextField){
				((JTextField)ca[i]).setText("");
			}
			
			
			
			
			
		}
	}
	
	
	
}


class P1 extends BlockBase implements MouseListener,ActionListener{
	private JFormattedTextField inputName;
	
	
	
	
	private JCTG jc1=new JCTG(),jc3=new JCTG(),jc5=new JCTG(),jc7=new JCTG();
	private JCDG jc2=new JCDG(),jc4=new JCDG(),jc6=new JCDG(),jc8=new JCDG();
	private JRadioButton jr1,jr2;
	private JButton jb=new JButton("確認");
	private JComboBox jcb;
	private JLabel inynn=new JLabel("");
	
	
	
	private JButton printB=new JButton("列印"),clearB=new JButton("清空");
	
	
	public String toString(){
		String str=""; 
		str+="基本資料=======================\n";
		str+=("姓名："+inputName.getText().replace(' ','_')+"   "+((birthType)jcb.getSelectedItem()).str+"   "+inynn.getText()+"\n\n");
		str+="　　　時,日,月,年\n";
		str+="天干："+jc7.toString()+","+jc5.toString()+","+jc3.toString()+","+jc1.toString()+"\n"; 
		str+="地支："+jc8.toString()+","+jc6.toString()+","+jc4.toString()+","+jc2.toString()+"\n";
		return str;
	}
	
	
	
	private boolean isChoiceEnable=true;
	public boolean isChoiceEnable(){return this.isChoiceEnable;}
	public void setChoiceEnable(boolean t){
		printB.setEnabled(!t);
		inputName.setEnabled(t);
		jc1.setEnabled(t);
		jc2.setEnabled(t);
		jc3.setEnabled(t);
		jc4.setEnabled(t);
		jc5.setEnabled(t);
		jc6.setEnabled(t);
		jc7.setEnabled(t);
		jc8.setEnabled(t);
		jb.setEnabled(t);
		this.isChoiceEnable=t;
	}
	public void clear(){
		super.clear();
		this.setChoiceEnable(true);
	}
	
	public void addMouseListenerToJB(MouseListener ml){
		this.jb.addMouseListener(ml);
	}
	
	public Component add(Component c){
		c.addMouseListener(this);
		return super.add(c);
	}
	public P1(){
		
		this.setLayout(null);
		this.setBackground(Color.ORANGE);
		inynn.setBounds(185,10,50,30);this.add(inynn);inynn.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		jc1.setLocation(140,65);this.add(jc1);jc1.addActionListener(this);
		jc2.setLocation(140,95);this.add(jc2);jc2.addActionListener(this);
		jc3.setLocation(95,65);this.add(jc3);jc3.addActionListener(this);
		jc4.setLocation(95,95);this.add(jc4);jc4.addActionListener(this);
		jc5.setLocation(50,65);this.add(jc5);jc5.addActionListener(this);
		jc6.setLocation(50,95);this.add(jc6);jc6.addActionListener(this);
		jc7.setLocation(5,65);this.add(jc7);jc7.addActionListener(this);
		jc8.setLocation(5,95);this.add(jc8);jc8.addActionListener(this);
		
		JLabel jlb=new JLabel("時");jlb.setSize(50,30);jlb.setLocation(20,42);this.add(jlb);
		jlb=new JLabel("日");jlb.setSize(50,30);jlb.setLocation(65,42);this.add(jlb);
		jlb=new JLabel("月");jlb.setSize(50,30);jlb.setLocation(110,42);this.add(jlb);
		jlb=new JLabel("年");jlb.setSize(50,30);jlb.setLocation(155,42);this.add(jlb);
		jlb=new JLabel("天干");jlb.setSize(30,30);jlb.setLocation(185,65);this.add(jlb);		
		jlb=new JLabel("地支");jlb.setSize(30,30);jlb.setLocation(185,95);this.add(jlb);		
		
		//this.setBackground(Color.gray);
		jr1=new JRadioButton("男");jr2=new JRadioButton("女");
		jr1.setSize(45,30);jr1.setLocation(220,90);
		jr2.setSize(45,30);jr2.setLocation(265,90);
		ButtonGroup bg=new ButtonGroup();bg.add(jr1);bg.add(jr2);
		jr1.setSelected(true);
		this.add(jr1);this.add(jr2);
		
		
		jcb=new JComboBox();jcb.addItem(birthType.上元);jcb.addItem(birthType.中元);jcb.addItem(birthType.下元);
		jcb.setSize(60,30);jcb.setLocation(220,55);this.add(jcb);
		
		;jb.setSize(70,30);jb.setLocation(220,125);
		this.add(jb);
		
		
			try {//325-5=320 25-50=-25
				this.add(inputName=new NameJTextField()).setBounds(85,15,90,30);
				inputName.setFont(new Font(Font.SANS_SERIF,Font.ROMAN_BASELINE,25));
				JLabel jlT=new JLabel("姓名：");jlT.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
				this.add(jlT).setBounds(5,15,90,30);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		this.add(printB).setBounds(10,125,70,30);
		this.add(clearB).setBounds(90,125,70,30);
			
			
		this.setInynn();
	}
	
	private Fortune f;
	public void setFortune(Fortune f){this.f=f;}
	
	public static class birthType{
		public String toString(){return this.str;}
		
		public final static birthType 上元=new birthType("上元"),中元=new birthType("中元"),下元=new birthType("下元");
		
		public final String str;
		private birthType(String str){this.str=str;}
	}
	public static class data{
		TG ty,tm,td,th;DG dy,dm,dd,dh;
		boolean male;
		birthType bthTy;
		
		public boolean getIY(){
			return ty==TG.甲||ty==TG.丙||ty==TG.戊||ty==TG.庚||ty==TG.壬;
		}
		
	}
	
	public data getData(){
		data d=new data();
		d.bthTy=(birthType)jcb.getSelectedItem();
		d.male=jr1.isSelected();
		d.ty=jc1.getChoice();d.tm=jc3.getChoice();d.td=jc5.getChoice();d.th=jc7.getChoice();
		d.dy=jc2.getChoice();d.dm=jc4.getChoice();d.dd=jc6.getChoice();d.dh=jc8.getChoice();
		return d;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getComponent()==this.clearB){
			this.f.clearAll();
		}else if(arg0.getComponent()==this.printB){
			this.f.print();
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.setInynn();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.setInynn();
	}
	
	private void setInynn(){
		P1.data p1d=this.getData();
		this.inynn.setText((p1d.getIY()?"陽":"陰")+(p1d.male?"男":"女"));}
}


class P2 extends BlockBase{
	
	JLabel jt1=new JLabel("1-1"),jt2=new JLabel("1-2")
	,j1=new NewJLabel(),j2=new NewJLabel(),j3=new NewJLabel(),j4=new NewJLabel(),
	j5=new NewJLabel(),j6=new NewJLabel(),j7=new NewJLabel(),j8=new NewJLabel();
	public P2(){
		
		this.setBackground(Color.ORANGE);
		this.setLayout(null);
		this.setSize(240,260);
		
		jt1.setSize(30,30);jt1.setLocation(25,5);this.add(jt1);
		jt2.setSize(30,30);jt2.setLocation(120,5);this.add(jt2);
		
		j1.setLocation(25,25);this.add(j1);//天干年
		j2.setLocation(25,50);this.add(j2);
		j3.setLocation(25,75);this.add(j3);		
		j4.setLocation(25,100);this.add(j4);		
		j5.setLocation(120,25);this.add(j5);//地支年	
		j6.setLocation(120,50);this.add(j6);		
		j7.setLocation(120,75);this.add(j7);		
		j8.setLocation(120,100);this.add(j8);
		
		JLabel[] YearToHour=new JLabel[4];
		for(int i=0;i<4;i++){
			JLabel tj=(YearToHour[i]=new JLabel());
			tj.setSize(20,20);tj.setLocation(10,(i+1)*25);this.add(tj);
		}YearToHour[0].setText("年");YearToHour[1].setText("月");YearToHour[2].setText("日");YearToHour[3].setText("時");
		
		
		
		
		
		
	}
	public void setData(int[] d) throws Throwable{
		if(d.length!=8)throw new Throwable("輸入資料錯誤");
		this.j1.setText(new Integer(d[0]).toString());//天干年
		this.j2.setText(new Integer(d[1]).toString());
		this.j3.setText(new Integer(d[2]).toString());
		this.j4.setText(new Integer(d[3]).toString());
		this.j5.setText(new Integer(d[4]).toString());//地支年
		this.j6.setText(new Integer(d[5]).toString());
		this.j7.setText(new Integer(d[6]).toString());
		this.j8.setText(new Integer(d[7]).toString());
		
	}
	
	
	public String toString(){
		String str="";
		str+="1-1============================\n";
		str+=j1.getText()+" ";str+=j2.getText()+" ";
		str+=j3.getText()+" ";str+=j4.getText()+" \n";
		
		str+="1-2============================\n";
		str+=j5.getText()+" ";str+=j6.getText()+" ";
		str+=j7.getText()+" ";str+=j8.getText()+" \n";
		
		return str;
	}
	
	
}



class P3 extends BlockBase{
	private Map<TG,Integer> mp=new HashMap<TG,Integer>();
	private NewJLabel njb=new NewJLabel();
	public P3(){
		JLabel jt1=new JLabel("2-1");

		this.setBackground(Color.ORANGE);
		jt1.setSize(30,20);jt1.setLocation(25,0);this.add(jt1);
		this.setLayout(null);
		this.setSize(90,170);
		
		mp.put(TG.甲,1);mp.put(TG.乙,6);mp.put(TG.丙,2);mp.put(TG.丁,7);
		mp.put(TG.戊,3);mp.put(TG.己,8);mp.put(TG.庚,4);mp.put(TG.辛,9);
		mp.put(TG.壬,5);mp.put(TG.癸,0);
		
		njb.setLocation(25,15);this.add(njb);
	}
	
	public void setData(P1.data p1d){
		String d=""+mp.get(p1d.tm)+mp.get(p1d.td)+mp.get(p1d.th)+mp.get(p1d.ty);
		this.njb.setText(d);
		
	}
	
	
	public String toString(){
		String str="";
		str+="2-1============================\n";
		str+=njb.getText()+"\n";
		return str;
	}
	
}



class P4 extends BlockBase{
	private NewJLabel njb1=new NewJLabel(),njb2=new NewJLabel(),njb3=new NewJLabel(),njb4=new NewJLabel(),
	njb5= new NewJLabel(),njb6=new NewJLabel(),njb7=new NewJLabel(),njb8=new NewJLabel();
	
	
	public String toString(){
		String str="";
		str+="3-1============================\n";
		str+=njb1.getText()+" ";str+=njb2.getText()+" ";
		str+=njb3.getText()+" ";str+=njb4.getText()+" \n";
		
		str+="3-2============================\n";
		str+=njb5.getText()+" ";str+=njb6.getText()+" ";
		str+=njb7.getText()+" ";str+=njb8.getText()+" \n";
		
		return str;
	}
	
	private divinatory[] dv=new divinatory[10];
	public P4(){
		this.setLayout(null);
		this.setBackground(Color.ORANGE);
		JLabel jt1=new JLabel("3-1"),jt2=new JLabel("3-2");
		jt1.setSize(50,20);jt1.setLocation(25,10);this.add(jt1);
		jt2.setSize(50,20);jt2.setLocation(120,10);this.add(jt2);
		
		
		
		njb1.setLocation(25,25);this.add(njb1);
		njb2.setLocation(25,50);this.add(njb2);
		njb3.setLocation(25,75);this.add(njb3);
		njb4.setLocation(25,100);this.add(njb4);
		
		
		njb5.setLocation(120,25);this.add(njb5);
		njb6.setLocation(120,50);this.add(njb6);
		njb7.setLocation(120,75);this.add(njb7);
		njb8.setLocation(120,100);this.add(njb8);
		
		
		dv[1]=divinatory.坎;dv[2]=divinatory.坤;dv[3]=divinatory.震;dv[4]=divinatory.巽;
		dv[6]=divinatory.乾;dv[7]=divinatory.兌;dv[8]=divinatory.艮;dv[9]=divinatory.離;
	}
	private boolean iny(TG t){
		return t==TG.甲||t==TG.丙||t==TG.戊||t==TG.庚||t==TG.庚||t==TG.壬;
	}

	private divinatory getDV(P1.data p){
		if(p.bthTy==P1.birthType.上元){
			if(p.male)return divinatory.艮;return divinatory.坤;
		}else if(p.bthTy==P1.birthType.中元){
			if(p.male&&p.getIY()||!p.male&&!p.getIY())return divinatory.艮;return divinatory.坤;
		}else{
			if(p.male)return divinatory.離;return divinatory.兌;
		}
	}
	
	private int minus9(int i){
		return i>9?minus9(i-9):i;
	}
	
	public void setDate(P1.data p1d,Table1 tb1){
		int[] d=new int[4];
		try {
			njb1.setText("");njb2.setText("");njb3.setText("");njb4.setText("");
			njb5.setText("");njb6.setText("");njb7.setText("");njb8.setText("");
			
			
			d[0]=minus9(transform(p1d.ty)+transform(p1d.dy));
			d[1]=minus9(transform(p1d.tm)+transform(p1d.dm));
			d[2]=minus9(transform(p1d.td)+transform(p1d.dd));
			d[3]=minus9(transform(p1d.th)+transform(p1d.dh));
			
			if(d[0]==5&&d[1]==5){
				divinatory d11=getDV(p1d),d12=divinatory.巽//d[0]，年是5時，d11=遇5取，d12=取個位數
				          ,d21=getDV(p1d),d22=divinatory.巽;//d[1]，月是5時，d21=遇5取，d22=取個位數
				
				njb1.setText(new Integer(tb1.query(d11,d21).A).toString()+d11.c+""+d21.c);
				njb2.setText(new Integer(tb1.query(d11,d22).A).toString()+d11.c+""+d22.c);
				njb3.setText(new Integer(tb1.query(d12,d21).A).toString()+d12.c+""+d21.c);
				njb4.setText(new Integer(tb1.query(d12,d22).A).toString()+d12.c+""+d22.c);
				
			}else if(d[0]==5){
				divinatory d11=getDV(p1d),d12=divinatory.巽,d2=dv[d[1]];
				njb1.setText(new Integer(tb1.query(d11,d2).A).toString()+d11.c+""+d2.c);
				njb2.setText(new Integer(tb1.query(d12,d2).A).toString()+d12.c+""+d2.c);
			

			}else if(d[1]==5){
				divinatory d21=getDV(p1d),d22=divinatory.巽,d1=dv[d[0]];
				njb1.setText(new Integer(tb1.query(d1,d21).A).toString()+d1.c+""+d21.c);
				njb2.setText(new Integer(tb1.query(d1,d22).A).toString()+d1.c+""+d22.c);
								
			}else{
				njb1.setText(new Integer(tb1.query(dv[d[0]],dv[d[1]]).A).toString()+dv[d[0]].c+dv[d[1]].c);
			}
			
			
			

			
			if(d[2]==5&&d[3]==5){
				divinatory d31=getDV(p1d),d32=divinatory.巽
				          ,d41=getDV(p1d),d42=divinatory.巽;
				njb5.setText(new Integer(tb1.query(d31,d41).A).toString()+d31.c+""+d41.c);
				njb6.setText(new Integer(tb1.query(d31,d42).A).toString()+d31.c+""+d42.c);
				njb7.setText(new Integer(tb1.query(d32,d41).A).toString()+d32.c+""+d41.c);
				njb8.setText(new Integer(tb1.query(d32,d42).A).toString()+d32.c+""+d42.c);
				

			}else if(d[2]==5){
				divinatory d31=getDV(p1d),d32=divinatory.巽,d4=dv[d[3]];
				njb5.setText(new Integer(tb1.query(d31,d4).A).toString()+d31.c+""+d4.c);
				njb6.setText(new Integer(tb1.query(d32,d4).A).toString()+d32.c+""+d4.c);
				

			}else if(d[3]==5){
				divinatory d41=getDV(p1d),d42=divinatory.巽,d3=dv[d[2]];
				njb5.setText(new Integer(tb1.query(d3,d41).A).toString()+d3.c+""+d41.c);
				njb6.setText(new Integer(tb1.query(d3,d42).A).toString()+d3.c+""+d42.c);
				

			}else{
				njb5.setText(new Integer(tb1.query(dv[d[2]], dv[d[3]]).A).toString()+dv[d[2]].c+""+dv[d[3]].c);
			}
			
		} catch (Throwable e) {e.printStackTrace();}
		
	}
	private int transform(TG t) throws Throwable{
		if(t==TG.甲||t==TG.己)return 9;
		if(t==TG.乙||t==TG.庚)return 8;
		if(t==TG.丙||t==TG.辛)return 7;
		if(t==TG.丁||t==TG.壬)return 6;
		if(t==TG.戊||t==TG.癸)return 5;
		throw new Throwable ("輸入的資料可能有錯誤");
	}
	
	private int transform(DG d) throws Throwable{
		if(d==DG.子||d==DG.午)return 9;
		if(d==DG.丑||d==DG.未)return 8;
		if(d==DG.寅||d==DG.申)return 7;
		if(d==DG.卯||d==DG.酉)return 6;
		if(d==DG.辰||d==DG.戌)return 5;
		if(d==DG.巳||d==DG.亥)return 4;
		throw new Throwable("輸入的資料可能有錯誤");   
		
	}
	
	
	
	private static class P4JLabel extends JLabel{
		P4JLabel(){
			this.setSize(30,30);
		}
		
	}
	
	
}



class P6 extends BlockBase implements MouseListener{
	JLabel NumLabel=new JLabel("5-1");
	JList jlist;DefaultListModel dl;
	JCTG tg=new JCTG();JCDG dg=new JCDG();
	JButton jb=new JButton("確認"),jdo=new JButton("刪除全部"),jd=new JButton("刪除單筆");
	JScrollPane listScr;
	public P6(){
		Font f=new Font(Font.SANS_SERIF,Font.ROMAN_BASELINE,16);
		this.setLayout(null);this.setOpaque(true);this.setBackground(Color.orange);
		this.NumLabel.setSize(60,20);this.NumLabel.setLocation(5,5);this.add(this.NumLabel);
		
		//jlist.setSize(120,30);jlist.setLocation(0,0);
		jlist=new JList(dl=new DefaultListModel());
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlist.setLayoutOrientation(JList.VERTICAL);jlist.setVisibleRowCount(-1);
		jlist.setOpaque(true);jlist.setForeground(Color.RED);jlist.setFont(f);
		
		listScr = new JScrollPane(jlist);
		//listScr.setPreferredSize(new Dimension(250, 80));
		listScr.setSize(200,220);listScr.setLocation(5,25);
		this.add(listScr);
		
		
		tg.setLocation(5,250);this.add(tg);
		dg.setLocation(5,280);this.add(dg);
		
		jd.setSize(90,30);jd.setLocation(5,310);jd.addMouseListener(this);
		this.add(jd);
		jdo.setSize(90,30);jdo.setLocation(105,310);jdo.addMouseListener(this);
		this.add(jdo);
		jb.setSize(90,30);jb.setLocation(105,250);jb.addMouseListener(this);
		this.add(jb);
		
		
	}
	public String toString(){
		String str=NumLabel.getText()+"============================\n";
		int t=dl.getSize();
		for(int i=0;i<t;i++){
			str+=dl.getElementAt(i)+"\n";	
		}
		
		return str;	
	}
	
	public void clear(){
		super.clear();
		this.dl.removeAllElements();
		this.setPreData(null);
	}
	
	private P1.data preDate=null;
	public void setPreData(P1.data p1d){
		this.preDate=p1d;
		this.dl.removeAllElements();
	}
	
	
	private static class data{
		int a,b;
		data(int a,int b){this.a=a;this.b=b;}
	}
	
	private data trs(DG d) throws Throwable{
		if(d==DG.子)return new data(1,6);
		if(d==DG.丑)return new data(5,10);
		if(d==DG.寅)return new data(3,8);
		if(d==DG.卯)return new data(3,8);
		if(d==DG.辰)return new data(5,10);
		if(d==DG.巳)return new data(2,7);
		if(d==DG.午)return new data(2,7);
		if(d==DG.未)return new data(5,10);
		if(d==DG.申)return new data(4,9);
		if(d==DG.酉)return new data(4,9);
		if(d==DG.戌)return new data(5,10);
		if(d==DG.亥)return new data(1,6);
		
		throw new Throwable("輸入的資料可能有誤");
	}
	private int trs(TG t) throws Throwable{
		if(t==TG.甲||t==TG.己)return 4;
		if(t==TG.乙||t==TG.庚)return 4;
		if(t==TG.丙||t==TG.辛)return 6;
		if(t==TG.丁||t==TG.壬)return 3;
		if(t==TG.戊||t==TG.癸)return 3;
		throw new Throwable("輸入資料可能有錯誤");
	}
	//private int trs(DG d){}
	public void setData(P1.data p1d){
		try {
			int i=trs(p1d.tm)*1000+trs(p1d.td)*100+trs(p1d.th)*10+trs(p1d.ty);
			int[] d=new int[2];
			
			d[0]=i+trs(this.tg.getChoice())*1000+trs(this.dg.getChoice()).a;
			d[1]=i+trs(this.tg.getChoice())*1000+trs(this.dg.getChoice()).b;
			dl.addElement(new Integer(d[0]).toString()+","+new Integer(d[1]).toString()+"("+tg.getChoice()+dg.getChoice()+")");
			/*d[2]=i+trs(this.tg.getChoice())*1000+trs(this.jda[1].getChoice()).a;
			d[3]=i+trs(this.tg.getChoice())*1000+trs(this.jda[1].getChoice()).b;
			
			d[4]=i+trs(this.jta[2].getChoice())*1000+trs(this.jda[2].getChoice()).a;
			d[5]=i+trs(this.jta[2].getChoice())*1000+trs(this.jda[2].getChoice()).b;
			
			d[6]=i+trs(this.jta[3].getChoice())*1000+trs(this.jda[3].getChoice()).a;
			d[7]=i+trs(this.jta[3].getChoice())*1000+trs(this.jda[3].getChoice()).b;
			*/
			
		
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(this.preDate==null)return;
		if(arg0.getComponent()==this.jb){
			this.setData(this.preDate);
		}else if(arg0.getComponent()==this.jd){
			int i=jlist.getSelectedIndex();
			if(i!=-1){this.dl.remove(i);if(i>jlist.getLastVisibleIndex())i-=1;;jlist.setSelectedIndex(i);}
		}else if(arg0.getComponent()==this.jdo){
			this.dl.removeAllElements();
		}
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}



class P5 extends BlockBase{
	
	private NewJLabel njl1=new NewJLabel(),njl2=new NewJLabel();
	private JLabel jt1=new JLabel("4-1"),jt2=new JLabel("4-2");
	
	//八字的數字 
	private divinatory trns1(int i) throws Throwable{
		if(i==1)return divinatory.乾;
		if(i==2)return divinatory.兌;
		if(i==3)return divinatory.離;
		if(i==4)return divinatory.震;
		if(i==5)return divinatory.巽;
		if(i==6)return divinatory.坎;
		if(i==7)return divinatory.艮;
		if(i==8)return divinatory.坤;
		
		throw new Throwable("輸入的資料可能有錯誤");
	}
	private divinatory trns2_1(int i){
		if(i==1)return divinatory.乾;
		if(i==2)return divinatory.兌;
		if(i==3)return divinatory.離;
		if(i==4)return divinatory.震;
		if(i==5)return divinatory.巽;
		if(i==6)return divinatory.坎;
		if(i==7)return divinatory.艮;
		return divinatory.坤;
	}
	private divinatory trns2_2(P1.data p1d,int i) throws Throwable{//依數字傳回卦像  
		if(i==0)return divinatory.坎;//如果4-2 取個位數部份 , 個位數是0的話 傳回 坎
		if(i==1)return divinatory.坎;
		if(i==2)return divinatory.坤;
		if(i==3)return divinatory.震;
		if(i==4)return divinatory.巽;
		if(i==6)return divinatory.乾;
		if(i==7)return divinatory.兌;
		if(i==8)return divinatory.艮;
		if(i==9)return divinatory.離;
		if(i==5)return this.getDV(p1d);
		throw new Throwable("輸入的資料可能有錯誤");
	}
	private int trns2_3(P1.data p,int i){//如果輸入值不是5 傳回原數，是5的話  依規則傳回值  
		if(i==0)return 1;
		if(i!=5)return i;

		if(p.bthTy==P1.birthType.上元){
			if(p.male)return 8;return 2;
		}else if(p.bthTy==P1.birthType.中元){
			if(p.male&&p.getIY()||!p.male&&!p.getIY())return 8;return 2;
		}else{
			if(p.male)return 9;return 7;
		}
		
	}
	
	
	private int trns3(divinatory d){//4-1的卦象轉回數字
		if(d==divinatory.乾)return 1;
		if(d==divinatory.兌)return 2;
		if(d==divinatory.離)return 3;
		if(d==divinatory.震)return 4;
		if(d==divinatory.巽)return 5;
		if(d==divinatory.坎)return 6;
		if(d==divinatory.艮)return 7;
		return 8;
	}
	

	private int trns4(divinatory d){//4-2的卦象轉回數字  
		if(d==divinatory.乾)return 6;
		if(d==divinatory.兌)return 7;
		if(d==divinatory.離)return 9;
		if(d==divinatory.震)return 3;
		if(d==divinatory.巽)return 4;
		if(d==divinatory.坎)return 1;
		if(d==divinatory.艮)return 8;
		return 2;
	}
	public P5(){
		this.setLayout(null);this.setSize(200,200);this.setBackground(Color.orange);
		this.jt1.setSize(30,20);this.jt1.setLocation(25,0);this.add(jt1);
		this.jt2.setSize(30,20);this.jt2.setLocation(120,0);this.add(jt2);
		this.njl1.setLocation(25,15);this.add(njl1);
		this.njl2.setLocation(120,15);this.add(njl2);
		
	}

	private boolean iny(TG t){
		return t==TG.甲||t==TG.丙||t==TG.戊||t==TG.庚||t==TG.庚||t==TG.壬;
	}
	public int minus8(int i){
		return i>8?minus8(i-8):i;//一直減8直到小於等於8
	}	
	public void setData(P1.data p1d){
		int[] d=new int[8];
		try {
			d[0]=minus8(trns(p1d.ty)+trns(p1d.dy));//d[0]=年干+年支，再減8直到不超過8
			d[1]=minus8(trns(p1d.tm)+trns(p1d.dm));
			System.out.println(trns(p1d.ty)+trns(p1d.dy));
			divinatory.data da=divinatory.mix(trns2_1(d[1]),trns2_1(d[0]));
			
			
			d[2]=trns3(da.du);d[3]=trns3(da.dd);
			this.njl1.setText(new Integer(d[0]*1000+d[1]*100+d[2]*10+d[3]).toString());
			
			
			d[4]=trns2_3(p1d,(trns(p1d.td)+trns(p1d.dd))%10);d[5]=trns2_3(p1d,(trns(p1d.th)+trns(p1d.dh))%10);
			da=divinatory.mix(trns2_2(p1d,d[5]),trns2_2(p1d,d[4]));
			d[6]=trns4(da.du);d[7]=trns4(da.dd);
			this.njl2.setText(new Integer(d[4]*1000+d[5]*100+d[6]*10+d[7]).toString());
			
			
			
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	private divinatory getDV(P1.data p){
		if(p.bthTy==P1.birthType.上元){
			if(p.male)return divinatory.艮;return divinatory.坤;
		}else if(p.bthTy==P1.birthType.中元){
			if(p.male&&p.getIY()||!p.male&&!p.getIY())return divinatory.艮;return divinatory.坤;
		}else{
			if(p.male)return divinatory.離;return divinatory.兌;
		}
	}
	
	private int trns(TG t) throws Throwable{
		if(t==TG.甲||t==TG.己)return 9;
		if(t==TG.乙||t==TG.庚)return 8;
		if(t==TG.丙||t==TG.辛)return 7;
		if(t==TG.丁||t==TG.壬)return 6;
		if(t==TG.戊||t==TG.癸)return 5;
		throw new Throwable ("輸入的資料可能有錯誤");
	}
	
	private int trns(DG d) throws Throwable{
		if(d==DG.子||d==DG.午)return 9;
		if(d==DG.丑||d==DG.未)return 8;
		if(d==DG.寅||d==DG.申)return 7;
		if(d==DG.卯||d==DG.酉)return 6;
		if(d==DG.辰||d==DG.戌)return 5;
		if(d==DG.巳||d==DG.亥)return 4;
		throw new Throwable("輸入的資料可能有錯誤");   
		
	}
	public String toString(){
		String str="";
		str+="4-1============================\n";
		str+=njl1.getText()+"\n";
		str+="4-2============================\n";
		str+=njl2.getText()+"\n";
		return str;
	}
}


class P7 extends P6{
	private JCTG tgy=new JCTG();
	private JCDG dgy=new JCDG();
	public P7(){
		this.NumLabel.setText("6-1");
		listScr.setSize(280,220);
		this.jb.setLocation(105,260);this.jd.setLocation(5, 320);this.jdo.setLocation(105,320);
		
		JLabel jtemp1=new JLabel("年"),jtemp2=new JLabel("子數");
		jtemp1.setBounds(10,245,30,20);this.add(jtemp1);
		jtemp2.setBounds(60,245,30,20);this.add(jtemp2);
		this.tg.setLocation(55,260);this.dg.setLocation(55,290);
		this.tgy.setLocation(5,260);this.dgy.setLocation(5,290);this.add(tgy);this.add(dgy);
	}

	private static class data{
		int a,b;
		data(int a,int b){this.a=a;this.b=b;}
	}
	
	
	private data trs(DG d) throws Throwable{
		if(d==DG.子)return new data(1,6);
		if(d==DG.丑)return new data(5,10);
		if(d==DG.寅)return new data(3,8);
		if(d==DG.卯)return new data(3,8);
		if(d==DG.辰)return new data(5,10);
		if(d==DG.巳)return new data(2,7);
		if(d==DG.午)return new data(2,7);
		if(d==DG.未)return new data(5,10);
		if(d==DG.申)return new data(4,9);
		if(d==DG.酉)return new data(4,9);
		if(d==DG.戌)return new data(5,10);
		if(d==DG.亥)return new data(1,6);
		
		throw new Throwable("輸入的資料可能有誤");
	}
	private int trs(TG t) throws Throwable{
		if(t==TG.甲||t==TG.己)return 4;
		if(t==TG.乙||t==TG.庚)return 4;
		if(t==TG.丙||t==TG.辛)return 6;
		if(t==TG.丁||t==TG.壬)return 3;
		if(t==TG.戊||t==TG.癸)return 3;
		throw new Throwable("輸入資料可能有錯誤");
	}
	
	private int HerHow(TG ta,TG tb) throws Throwable{
		if(ta==TG.甲&&tb==TG.己||tb==TG.甲&&ta==TG.己)return 1;
		if(ta==TG.乙&&tb==TG.庚||tb==TG.乙&&ta==TG.庚)return 2;
		if(ta==TG.丙&&tb==TG.辛||tb==TG.丙&&ta==TG.辛)return 5;
		if(ta==TG.戊&&tb==TG.癸||tb==TG.戊&&ta==TG.癸)return 4;
		
		throw new Throwable("不用合化");
	}
	public int getBaseNum(P1.data p) throws Throwable{
		int y=trs(tgy.getChoice()),m=trs(p.tm),d=trs(p.td),h=trs(p.th);//把天干年月日時化成數字
		
		try{
			int herhow=HerHow(tgy.getChoice(),p.tm);
			y=(m=herhow);//判斷是否要合化
		}catch(Throwable t){}
		return m*1000+d*100+h*10+y;
	}
	public void setData(P1.data p1d){
		//把天干化成數字 考慮合化  加上另數  
		try {
			int l=trs(this.tg.getChoice());//另數l
			int mNum=getBaseNum(p1d)+l*1000;
			data subNum=trs(dgy.getChoice());//依年支  得二數 
			
			int aNum=mNum+subNum.a,bNum=mNum+subNum.b;
			String str=new Integer(aNum).toString()+","+new Integer(bNum).toString()+"(年="+tgy.getChoice().c+dgy.getChoice().c+",子數="+tg.getChoice().c+dg.getChoice().c+")";
			dl.addElement(str);
			
			
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		//
	}
	
}



class P8 extends BlockBase{
	private P8Label p8l[],pu;
	private JLabel njl1=new NewJLabel(),njl2=new NewJLabel(),njl1_c=new NewJLabel(),njl2_c=new NewJLabel();
	
	public String toString(){
		String str="7-1============================\n";
		str+="初始掛   "+pu.toString()+"\n";
		str+="第一掛   "+p8l[0].toString()+"     ";
		str+="第二掛   "+p8l[1].toString()+"     ";
		str+="第三掛   "+p8l[2].toString()+"     ";
		str+="第四掛   "+p8l[3].toString()+"     \n";
		str+="第五掛   "+p8l[4].toString()+"     ";
		str+="第六掛   "+p8l[5].toString()+"     ";
		str+="第七掛   "+p8l[6].toString()+"     ";
		str+="第八掛   "+p8l[7].toString()+"     \n";
		str+="子數 "+JsubNt.getText()+","+JsubNd.getText()+"\n";
		return str;
	}
	
	public void clear(){
		super.clear();
		for(int i=0;i<p8l.length;i++){
			p8l[i].clear();
		}pu.clear();
		this.JsubNt.setText("----");
		this.JsubNd.setText("----");
		
		
	}
	
	
	private class P8Label extends JLabel{
		private divinatory dv1,dv2;
		private String S64;
		private int df,d1,d2,d3;
		
		public String toString(){
			String str="";
			str+=Jdv1.getText()+"  "+Jdv2.getText();
			if(isShowBaseNum){str+="("+Jd1.getText()+","+Jd2.getText()+","+Jd3.getText()+")";}
			return str;
		}
		
		private JLabel Jdv1,Jdv2,JS64,Jdf,Jd1,Jd2,Jd3;
		
		private boolean isShowBaseNum=true;
		public void setShowBaseNum(boolean b){
			if(isShowBaseNum=b){
				this.setSize(60,140);
				this.Jdv1.setSize(50,50);this.Jdv1.setFont(f1);
				this.Jdv2.setSize(50,50);this.Jdv2.setFont(f1);this.Jdv2.setLocation(5,60);
				this.Jd1.setVisible(false);this.Jd2.setVisible(false);this.Jd3.setVisible(false);
				this.Jdf.setVisible(true);
				
				
			}else{
				this.setSize(55,125);
				this.Jdv1.setSize(45,45);this.Jdv1.setFont(f1_2);
				this.Jdv2.setSize(45,45);this.Jdv2.setFont(f1_2);this.Jdv2.setLocation(5,55);
				this.Jd1.setVisible(true);this.Jd2.setVisible(true);this.Jd3.setVisible(true);
				this.Jdf.setVisible(false);
				
				
			}
		}
		
		Font f1=new Font(Font.SERIF,Font.ROMAN_BASELINE,28),f1_2=new Font(Font.SERIF,Font.ROMAN_BASELINE,24);
		Font f2=new Font(Font.SERIF,Font.ROMAN_BASELINE,14);
		Font f3=new Font(Font.SERIF,Font.ROMAN_BASELINE,18);
		
		public divinatory getDV1(){return dv1;}public divinatory getDV2(){return dv2;}
		
		public P8Label(){
			this.setLayout(null);
			this.setOpaque(true);
			this.setBackground(Color.WHITE);
			
			this.Jdv1=new JLabel();this.Jdv1.setSize(50,50);this.Jdv1.setLocation(5,5);
			this.Jdv1.setHorizontalAlignment(JLabel.CENTER);this.Jdv1.setVerticalAlignment(JLabel.CENTER);
			this.Jdv1.setFont(f1);this.add(Jdv1);this.Jdv1.setOpaque(true);this.Jdv1.setBackground(Color.ORANGE);
			
			this.Jdv2=new JLabel();this.Jdv2.setSize(50,50);this.Jdv2.setLocation(5,60);
			this.Jdv2.setHorizontalAlignment(JLabel.CENTER);this.Jdv2.setVerticalAlignment(JLabel.CENTER);
			this.Jdv2.setFont(f1);this.add(Jdv2);this.Jdv2.setOpaque(true);this.Jdv2.setBackground(Color.ORANGE);
			
			this.JS64=new JLabel();this.JS64.setSize(30,30);this.JS64.setLocation(25,115);
			this.JS64.setHorizontalAlignment(JLabel.CENTER);this.JS64.setVerticalAlignment(JLabel.CENTER);
			this.JS64.setFont(f2);this.add(JS64);this.JS64.setOpaque(true);this.JS64.setBackground(Color.ORANGE);
			this.JS64.setVisible(false);//把顯示六十四卦的字的格子先藏起來  
			
			
			this.Jd1=new JLabel();this.Jd1.setSize(14,14);this.Jd1.setLocation(3,105);
			this.Jd1.setHorizontalAlignment(JLabel.CENTER);this.Jd1.setVerticalAlignment(JLabel.CENTER);
			this.Jd1.setFont(f2);this.add(Jd1);this.Jd1.setOpaque(true);this.Jd1.setBackground(Color.ORANGE);
			
			this.Jd2=new JLabel();this.Jd2.setSize(14,14);this.Jd2.setLocation(20,105);
			this.Jd2.setHorizontalAlignment(JLabel.CENTER);this.Jd2.setVerticalAlignment(JLabel.CENTER);
			this.Jd2.setFont(f2);this.add(Jd2);this.Jd2.setOpaque(true);this.Jd2.setBackground(Color.ORANGE);
			
			this.Jd3=new JLabel();this.Jd3.setSize(14,14);this.Jd3.setLocation(37,105);
			this.Jd3.setHorizontalAlignment(JLabel.CENTER);this.Jd3.setVerticalAlignment(JLabel.CENTER);
			this.Jd3.setFont(f2);this.add(Jd3);this.Jd3.setOpaque(true);this.Jd3.setBackground(Color.ORANGE);
			
			this.Jdf=new JLabel();this.Jdf.setSize(50,20);this.Jdf.setLocation(5,115);
			this.Jdf.setHorizontalAlignment(JLabel.CENTER);this.Jdf.setVerticalAlignment(JLabel.CENTER);
			this.Jdf.setFont(f3);this.add(Jdf);this.Jdf.setOpaque(true);this.Jdf.setBackground(Color.ORANGE);
			
			Jdv1.setText("-");Jdv2.setText("-");JS64.setText("--");this.Jdf.setText("----");
			Jd1.setText("--");Jd2.setText("--");Jd3.setText("--");
			this.setShowBaseNum(true);
		}
		
		
		public void clear(){
			this.Jdv1.setText("-");this.Jdv2.setText("-");
			try {
				Table2.data t2d=null;
				JS64.setText("--");Jdf.setText("----");
				Jd1.setText("--");
				Jd2.setText("--");
				Jd3.setText("--");
				
				
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public void setData(divinatory d1,divinatory d2,Table2 t2){
			
			this.Jdv1.setText(d2.c);this.Jdv2.setText(d1.c);
			try {
				Table2.data t2d=t2.query(d2,d1);
				JS64.setText(t2d.str);Jdf.setText(new Integer(t2d.df).toString());
				Jd1.setText(new Integer(t2d.d1).toString());
				Jd2.setText(new Integer(t2d.d2).toString());
				Jd3.setText(new Integer(t2d.d3).toString());
				
				
				
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
	}

	private boolean iny(TG t){
		if(t==TG.甲||t==TG.丙||t==TG.戊||t==TG.庚||t==TG.庚||t==TG.壬)return true;
		return false;
	}
	
	
	private divinatory getDiv(P1.data p1d,int i) throws Throwable{
		if(i==1)return divinatory.坎;
		if(i==2)return divinatory.坤;
		if(i==3)return divinatory.震;
		if(i==4)return divinatory.巽;
		if(i==6)return divinatory.乾;
		if(i==7)return divinatory.兌;
		if(i==8)return divinatory.艮;
		if(i==9)return divinatory.離;
		
		if(i==5){
			if(p1d.bthTy==P1.birthType.上元){return p1d.male?divinatory.艮:divinatory.坤;}
			else if(p1d.bthTy==P1.birthType.中元){
				if(p1d.male&&iny(p1d.ty)||!p1d.male&&!iny(p1d.ty))return divinatory.艮;
				return divinatory.坤;
				
			}
			else{return p1d.male?divinatory.離:divinatory.兌;}
		};
		
		throw new Throwable("輸入的資料可能有錯誤:"+i);
		
	}
	
	private int trs(TG t) throws Throwable{
		if(t==TG.甲)return 6;
		if(t==TG.乙)return 2;
		if(t==TG.丙)return 8;
		if(t==TG.丁)return 7;
		if(t==TG.戊)return 1;
		if(t==TG.己)return 9;
		if(t==TG.庚)return 3;
		if(t==TG.辛)return 4;
		if(t==TG.壬)return 6;
		if(t==TG.癸)return 2;
		
		throw new Throwable("輸入資料可能有錯誤");
	}
	
	
	private data trs(DG d) throws Throwable{
		if(d==DG.子)return new data(1,6);
		if(d==DG.丑)return new data(5,10);
		if(d==DG.寅)return new data(3,8);
		if(d==DG.卯)return new data(3,8);
		if(d==DG.辰)return new data(5,10);
		if(d==DG.巳)return new data(2,7);
		if(d==DG.午)return new data(2,7);
		if(d==DG.未)return new data(5,10);
		if(d==DG.申)return new data(4,9);
		if(d==DG.酉)return new data(4,9);
		if(d==DG.戌)return new data(5,10);
		if(d==DG.亥)return new data(1,6);
		
		throw new Throwable("輸入的資料可能有誤");
	}
	
	private int trs2(TG t) throws Throwable{
		if(t==TG.甲)return 9;
		if(t==TG.乙)return 8;
		if(t==TG.丙)return 7;
		if(t==TG.丁)return 6;
		if(t==TG.戊)return 5;
		if(t==TG.己)return 9;
		if(t==TG.庚)return 8;
		if(t==TG.辛)return 7;
		if(t==TG.壬)return 6;
		if(t==TG.癸)return 5;
		
		throw new Throwable("輸入資料可能有錯誤");
	}
	
	private Integer trs3_u(P1.data p1d,divinatory d) throws Throwable{
		if(d==divinatory.乾&&!p1d.getIY())return 9; 
		if(d==divinatory.坤&&!p1d.getIY())return 8; 
		if(d==divinatory.乾&&p1d.getIY())return 6; 
		if(d==divinatory.坤&&p1d.getIY())return 5;
		if(d==divinatory.艮)return 7; 
		if(d==divinatory.兌)return 6; 
		if(d==divinatory.坎)return 5; 
		if(d==divinatory.離)return 9; 
		if(d==divinatory.震)return 8;
		if(d==divinatory.巽)return 7; 
		
		throw new Throwable("輸入資料可能有錯誤。");
	}
	private Integer trs3_d(P1.data p1d,divinatory d) throws Throwable{
		if(d==divinatory.震&&!p1d.getIY())return 6; 
		if(d==divinatory.乾&&!p1d.getIY())return 6;
		if(d==divinatory.離&&!p1d.getIY())return 4;
		if(d==divinatory.坎&&!p1d.getIY())return 4;
		if(d==divinatory.坎&&p1d.getIY())return 9; 
		if(d==divinatory.震&&p1d.getIY())return 7;
		if(d==divinatory.離&&p1d.getIY())return 9; 
		if(d==divinatory.乾&&p1d.getIY())return 7;
		if(d==divinatory.坤)return 8; 
		if(d==divinatory.兌)return 5; 
		if(d==divinatory.艮)return 8; 
		if(d==divinatory.巽)return 5; 
		
		throw new Throwable("輸入資料可能有錯誤。");
	}
	
	private int trs2(DG d) throws Throwable{
		if(d==DG.子)return 9;
		if(d==DG.丑)return 8;
		if(d==DG.寅)return 7;
		if(d==DG.卯)return 6;
		if(d==DG.辰)return 5;
		if(d==DG.巳)return 4;
		if(d==DG.午)return 9;
		if(d==DG.未)return 8;
		if(d==DG.申)return 7;
		if(d==DG.酉)return 6;
		if(d==DG.戌)return 5;
		if(d==DG.亥)return 4;
		
		throw new Throwable("輸入的資料可能有誤");
	}
	
	public static class data{
		int a,b;
		public data(int a,int b){this.a=a;this.b=b;}
		
	}
	public static class data2{
		int j,o;
		public data2(int j,int o){this.j=j;this.o=o;}
		
	}
	public static class data3{//功能7的一對卦 
		public static data3 getData(boolean p1,boolean p2,boolean p3,boolean p4,boolean p5,boolean p6){
			divinatory d1=divinatory.getDivinatory(p1,p2,p3),d2=divinatory.getDivinatory(p4,p5,p6);
			return new data3(d1,d2);
		}
		public final divinatory dvu,dvd;
		data3(divinatory dvd,divinatory dvu){this.dvd=dvd;this.dvu=dvu;}//dv1是底下,dv2是上面的   
		
		public data3 getCross(){
			divinatory.data da=divinatory.mix(dvd,dvu);
			return new data3(da.dd,da.du);
		}
		
		public data3 getChangeAndUpSideDown(int i){
			divinatory vu=null,vd=null;
			if(i==1){
				vu=this.dvu;vd=divinatory.getDivinatory(!dvd.p1,dvd.p2,dvd.p3);
			}else if(i==2){
				vu=this.dvu;vd=divinatory.getDivinatory(dvd.p1,!dvd.p2,dvd.p3);
			}else if(i==3){
				vu=this.dvu;vd=divinatory.getDivinatory(dvd.p1,dvd.p2,!dvd.p3);
			}else if(i==4){
				vu=divinatory.getDivinatory(!dvu.p1,dvu.p2,dvu.p3);vd=this.dvd;
			}else if(i==5){
				vu=divinatory.getDivinatory(dvu.p1,!dvu.p2,dvu.p3);vd=this.dvd;
			}else{
				vu=divinatory.getDivinatory(dvu.p1,dvu.p2,!dvu.p3);vd=this.dvd;
			}
			
			return new data3(vu,vd);//上下對調
		}
		
	}
	
	public P8(){
		JLabel jt1=new JLabel("7-1");
		jt1.setSize(30,20);jt1.setLocation(5,5);this.add(jt1);
		this.setBackground(Color.ORANGE);
		this.setLayout(null);
		
		this.njl1.setSize(65,20);this.njl1.setLocation(5,245);this.add(njl1);
		this.njl2.setSize(65,20);this.njl2.setLocation(5,270);this.add(njl2);
		this.njl1_c.setSize(65,20);this.njl1_c.setLocation(5,220);this.add(njl1_c);
		this.njl2_c.setSize(65,20);this.njl2_c.setLocation(5,295);this.add(njl2_c);
		
		p8l=new P8Label[8];
		for(int i=0;i<4;i++){
			p8l[i]=new P8Label();p8l[i].setLocation(i*65+75,35);this.add(p8l[i]);p8l[i].setShowBaseNum(false);
			JLabel j=new JLabel("第"+(i+1)+"卦");j.setSize(60,15);j.setLocation(i*65+80,20);this.add(j);
			
			p8l[i+4]=new P8Label();p8l[i+4].setLocation(i*65+75,190);this.add(p8l[i+4]);p8l[i+4].setShowBaseNum(false);
			j=new JLabel("第"+(i+5)+"卦");j.setSize(60,15);j.setLocation(i*65+80,175);this.add(j);
		}pu=new P8Label();pu.setLocation(5,35);this.add(pu);
		
		JLabel original=new JLabel("初始卦");//original.setFont(new Font(Font.SERIF,Font.ROMAN_BASELINE,12));
		original.setSize(60,15);original.setLocation(10,20);this.add(original);
		
		JsubNt=new JLabel("----");this.add(JsubNt).setBounds(170,320,30,20);JsubNt.setOpaque(true);JsubNt.setForeground(Color.RED);
		JsubNd=new JLabel("----");this.add(JsubNd).setBounds(130,320,30,20);JsubNd.setOpaque(true);JsubNd.setForeground(Color.RED);
	}
	
	private data3 preP(P1.data p1d) throws Throwable{
		divinatory dvJ=null,dvO=null;
		data2 d=new data2(0,0);
		int i=trs(p1d.ty);if(i%2==0)d.o+=i;else d.j+=i;//奇數、偶數各相加
			i=trs(p1d.tm);if(i%2==0)d.o+=i;else d.j+=i;
			i=trs(p1d.td);if(i%2==0)d.o+=i;else d.j+=i;
			i=trs(p1d.th);if(i%2==0)d.o+=i;else d.j+=i;

			i=trs(p1d.dy).a;if(i%2==0)d.o+=i;else d.j+=i;
			i=trs(p1d.dm).a;if(i%2==0)d.o+=i;else d.j+=i;
			i=trs(p1d.dd).a;if(i%2==0)d.o+=i;else d.j+=i;
			i=trs(p1d.dh).a;if(i%2==0)d.o+=i;else d.j+=i;
			i=trs(p1d.dy).b;if(i%2==0)d.o+=i;else d.j+=i;
			i=trs(p1d.dm).b;if(i%2==0)d.o+=i;else d.j+=i;
			i=trs(p1d.dd).b;if(i%2==0)d.o+=i;else d.j+=i;
			i=trs(p1d.dh).b;if(i%2==0)d.o+=i;else d.j+=i;//奇數、偶數各相加  
			
			d.j-=25;d.o-=30;//二組各減25、30
			if(d.j==10||d.j==20){
				dvJ=this.getDiv(p1d,(d.j/10)%10);
			}else if(d.j<0){//如果減常數後小於0 加回常數取個位數 (那如果個位數是0???)
				int i2=(d.j+25)%10;if(i2==0){i2=(d.j+25)/10;}
				dvJ=this.getDiv(p1d,i2);
			}else if(d.j==0){
				dvJ=this.getDiv(p1d,5);
			}else {dvJ=this.getDiv(p1d,d.j%10);}
			
			if(d.o==10||d.o==20||d.o==30){
				dvO=this.getDiv(p1d,(d.o/10)%10);
			}else if(d.o<0){
				dvO=this.getDiv(p1d,(d.o+30)%10);
			}else if(d.o==0){
				dvO=this.getDiv(p1d,3);
			}else {dvO=this.getDiv(p1d,d.o%10);}
			
			
			
				data3 d3=null;
			if(p1d.male&&iny(p1d.ty)||!p1d.male&&!iny(p1d.ty)){//陽男陰女的話 奇數在上(偶1奇2)
				d3=new data3(dvO,dvJ);
			}else{
				d3=new data3(dvJ,dvO);
			}
			
			
		return d3;
	}
	private data3 getChange(data3 d3,int i){
		data3 d3N=null;
		if(i==0){
			d3N=data3.getData(d3.dvd.p1,d3.dvd.p2,!d3.dvd.p3,d3.dvu.p1,d3.dvu.p2,!d3.dvu.p3);
		}else if(i==1){
			d3N=data3.getData(!d3.dvd.p1,d3.dvd.p2,d3.dvd.p3,d3.dvu.p1,d3.dvu.p2,d3.dvu.p3);
		}else if(i==2){
			d3N=data3.getData(d3.dvd.p1,!d3.dvd.p2,d3.dvd.p3,d3.dvu.p1,d3.dvu.p2,d3.dvu.p3);
		}else if(i==3){
			d3N=data3.getData(d3.dvd.p1,d3.dvd.p2,!d3.dvd.p3,d3.dvu.p1,d3.dvu.p2,d3.dvu.p3);
		}else if(i==4){
			d3N=data3.getData(d3.dvd.p1,d3.dvd.p2,d3.dvd.p3,!d3.dvu.p1,d3.dvu.p2,d3.dvu.p3);
		}else if(i==5){
			d3N=data3.getData(d3.dvd.p1,d3.dvd.p2,d3.dvd.p3,d3.dvu.p1,!d3.dvu.p2,d3.dvu.p3);
		}else if(i==6){
			d3N=data3.getData(d3.dvd.p1,d3.dvd.p2,d3.dvd.p3,d3.dvu.p1,d3.dvu.p2,!d3.dvu.p3);
		}else if(i==7){
			d3N=data3.getData(!d3.dvd.p1,d3.dvd.p2,d3.dvd.p3,!d3.dvu.p1,d3.dvu.p2,d3.dvu.p3);
		}else if(i==8){
			d3N=data3.getData(d3.dvd.p1,!d3.dvd.p2,d3.dvd.p3,d3.dvu.p1,!d3.dvu.p2,d3.dvu.p3);
		}
			
		
		
		return d3N;
	}
	
	private data3 preP2(P1.data p1d,Table2 t2,data3 g0,data3 g1) throws Throwable{
		int df=t2.query(g0.dvd,g0.dvu).df,dft=trs2(p1d.ty),dfd=trs2(p1d.dy);
		if(p1d.bthTy==P1.birthType.上元){
			dft*=10;
		}else if(p1d.bthTy==P1.birthType.下元){
			dfd*=10;
		}else {
			if(p1d.male&&iny(p1d.ty)||!p1d.male&&!iny(p1d.ty)){
				dft*=100;dfd*=10;
			}else {
				dft*=10;dfd*=100;
			}
		}
		//System.out.println(g0.dv1.c+g0.dv2.c+df);
		int i=(df+dft+dfd)%9;//看要變第幾卦  來得到第二卦
		
		return getChange(g1,i);
	}
	private data3 preP3(P1.data p1d,Table2 t2,data3 g0,data3 g1,data3 gch) throws Throwable{
		int df=t2.query(g0.dvd,g0.dvu).df,dft=trs2(p1d.ty),dfd=trs2(p1d.dy);
		if(p1d.bthTy==P1.birthType.上元){
			dft*=10;
		}else if(p1d.bthTy==P1.birthType.下元){
			dfd*=10;
		}else {
			if(p1d.male&&iny(p1d.ty)||!p1d.male&&!iny(p1d.ty)){
				dft*=100;dfd*=10;
			}else {
				dft*=10;dfd*=100;
			}
		}
		
		return gch.getChangeAndUpSideDown((df+dft+dfd)%6);
	}
	
	
	
	public void setData(P1.data p1d,Table2 t2) throws Throwable{
		data3 g0=preP(p1d),g1=g0.getCross();
		
		pu.setData(g0.dvd,g0.dvu,t2);
		
		p8l[0].setData(g1.dvd,g1.dvu,t2);
		
		
		data3 g2=preP2(p1d,t2,g0,g1),
			  g3=data3.getData(!g1.dvd.p1,!g1.dvd.p2,!g1.dvd.p3,!g1.dvu.p1,!g1.dvu.p2,!g1.dvu.p3),
			  g4=data3.getData(!g2.dvd.p1,!g2.dvd.p2,!g2.dvd.p3,!g2.dvu.p1,!g2.dvu.p2,!g2.dvu.p3);
		p8l[1].setData(g2.dvd,g2.dvu,t2);
		p8l[2].setData(g3.dvd,g3.dvu,t2);
		p8l[3].setData(g4.dvd,g4.dvu,t2);
		
		data3 g5=preP3(p1d,t2,g0,g1,g1);
		data3 g6=preP3(p1d,t2,g0,g1,g2);
		data3 g7=preP3(p1d,t2,g0,g1,g3);
		data3 g8=preP3(p1d,t2,g0,g1,g4);
		
		
		p8l[4].setData(g5.dvd,g5.dvu,t2);
		p8l[5].setData(g6.dvd,g6.dvu,t2);
		p8l[6].setData(g7.dvd,g7.dvu,t2);
		p8l[7].setData(g8.dvd,g8.dvu,t2);
		
		njl1_c.setText(g1.dvu.c+g2.dvu.c+g3.dvu.c+g4.dvu.c);
		njl1.setText(trs3_u(p1d,g1.dvu).toString()+"  "+trs3_u(p1d,g2.dvu).toString()+
			"  "+trs3_u(p1d,g3.dvu).toString()+"  "+trs3_u(p1d,g4.dvu).toString());
		njl2_c.setText(g1.dvd.c+g2.dvd.c+g3.dvd.c+g4.dvd.c);
		njl2.setText(trs3_d(p1d,g1.dvd).toString()+"  "+trs3_d(p1d,g2.dvd).toString()+
			"  "+trs3_d(p1d,g3.dvd).toString()+"  "+trs3_d(p1d,g4.dvd).toString());
		
		setSubN(p1d);
	}
	
	private void setSubN(P1.data p1d){
		int dft, dfd;
		try {
			dft = trs2(p1d.ty);
			dfd = trs2(p1d.dy);
			
			
		if(p1d.bthTy==P1.birthType.上元){
			dft*=10;
		}else if(p1d.bthTy==P1.birthType.下元){
			dfd*=10;
		}else {
			if(p1d.male&&iny(p1d.ty)||!p1d.male&&!iny(p1d.ty)){
				dft*=100;dfd*=10;
			}else {
				dft*=10;dfd*=100;
			}
		
		}
		
			JsubNt.setText(new Integer(dft).toString());
			JsubNd.setText(new Integer(dfd).toString());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private JLabel JsubNt,JsubNd;
	
	
}

class NewJLabel extends JLabel{
	private Font ft=new Font(Font.SANS_SERIF,Font.ROMAN_BASELINE,16);
	public NewJLabel(){
		this.setSize(90,20);
		this.setOpaque(true);
		this.setBackground(Color.WHITE);
		this.setForeground(Color.RED);
		this.setFont(this.ft);
		this.setVerticalAlignment(JLabel.CENTER);
		this.setHorizontalAlignment(JLabel.CENTER);
	}
	public void setText(String str){
		/*if(!horizontal){
			char[] c=str.toCharArray();
			String str2="<html>";
			for(int i=0;i<c.length;i++){
				str2+=c[i]+"<br>";
			}str=str2;
		}*/
		super.setText(str);
	}
	
	
	
	
}


