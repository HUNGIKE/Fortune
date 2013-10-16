
public class divinatory {
	public final String c;
	public final boolean p1,p2,p3;
	public final static divinatory  °®=new divinatory("°®",true,true,true);
	public final static divinatory  §I=new divinatory("§I",true,true,false);
	public final static divinatory  Â÷=new divinatory("Â÷",true,false,true);
	public final static divinatory  ¾_=new divinatory("¾_",true,false,false);
	public final static divinatory  ´S=new divinatory("´S",false,true,true);
	public final static divinatory  §¢=new divinatory("§¢",false,true,false);    
	public final static divinatory  ¦á=new divinatory("¦á",false,false,true);
	public final static divinatory  ©[=new divinatory("©[",false,false,false);
	
	public boolean isDivinatory(boolean p1,boolean p2,boolean p3){
		return this.p1==p1&&this.p2==p2&&this.p3==p3;
	}
	public static divinatory getDivinatory(boolean p1,boolean p2,boolean p3){
		if(divinatory.°®.isDivinatory(p1,p2,p3))return divinatory.°®;
		if(divinatory.§I.isDivinatory(p1,p2,p3))return divinatory.§I;
		if(divinatory.Â÷.isDivinatory(p1,p2,p3))return divinatory.Â÷;
		if(divinatory.¾_.isDivinatory(p1,p2,p3))return divinatory.¾_;
		if(divinatory.´S.isDivinatory(p1,p2,p3))return divinatory.´S;
		if(divinatory.§¢.isDivinatory(p1,p2,p3))return divinatory.§¢;
		if(divinatory.¦á.isDivinatory(p1,p2,p3))return divinatory.¦á;
		return divinatory.©[;
	}
	
	
	
	private divinatory(String c,boolean p1,boolean p2,boolean p3){
		this.c=c;this.p1=p1;this.p2=p2;this.p3=p3;
	}
	
	public static class data{
		divinatory dd,du;
		data(divinatory dd,divinatory du){
			this.dd=dd;this.du=du;
		}
	}
	public static data mix(divinatory dd,divinatory du){
		
		return new data(divinatory.getDivinatory(dd.p2,dd.p3,du.p1),divinatory.getDivinatory(dd.p3,du.p1,du.p2));
	}

}
