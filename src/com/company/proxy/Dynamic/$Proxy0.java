package com.company.proxy.Dynamic;
import com.company.proxy.Dynamic.Third;
import com.company.proxy.Dynamic.Fine;
import com.company.prototype.AsiaSheep;
import com.company.proxy.Dynamic.Employee;
import com.company.prototype.CloneSheep;
import com.company.prototype.Sheep;
import java.lang.reflect.InvocationHandler;
import com.company.Decorator.Bread;
import java.lang.reflect.Method;
import java.io.InputStream;
public class $Proxy0 extends BankEmployee implements Employee,Fine,Third{ 
    private InvocationHandler h; 

    public $Proxy0(InvocationHandler h){ 
		System.out.println("代理类初始化成功");
		this.h = h; 
   } 

    @Override
    public int hhh(String arg0,int arg1,String arg2){ 
    try{ 
	    Method m = Employee.class.getMethod("hhh",String.class,int.class,String.class);
	    return (Integer)h.invoke(this, m,new Object[]{arg0,arg1,arg2}); 
    }catch(Throwable t){} 
   return 0;
} 


    @Override
    public void yyy(){ 
    try{ 
	    Method m = Employee.class.getMethod("yyy");
	    h.invoke(this, m,(Object[])null); 
    }catch(Throwable t){} 
   } 


    @Override
    public void ttt(AsiaSheep arg0,InputStream arg1){ 
    try{ 
	    Method m = Employee.class.getMethod("ttt",AsiaSheep.class,InputStream.class);
	    h.invoke(this, m,new Object[]{arg0,arg1}); 
    }catch(Throwable t){} 
   } 


    @Override
    public void work(String arg0){ 
    try{ 
	    Method m = Employee.class.getMethod("work",String.class);
	    h.invoke(this, m,new Object[]{arg0}); 
    }catch(Throwable t){} 
   } 


    @Override
    public Bread fineyyy(){ 
    try{ 
	    Method m = Fine.class.getMethod("fineyyy");
	    return (Bread)h.invoke(this, m,(Object[])null); 
    }catch(Throwable t){} 
   return null;
} 


    @Override
    public void finettt(AsiaSheep arg0,InputStream arg1){ 
    try{ 
	    Method m = Fine.class.getMethod("finettt",AsiaSheep.class,InputStream.class);
	    h.invoke(this, m,new Object[]{arg0,arg1}); 
    }catch(Throwable t){} 
   } 


    @Override
    public Character ccc(Double arg0,long arg1){ 
    try{ 
	    Method m = Third.class.getMethod("ccc",Double.class,long.class);
	    return (Character)h.invoke(this, m,new Object[]{arg0,arg1}); 
    }catch(Throwable t){} 
   return null;
} 


    @Override
    public Byte[] bbb(Double[] arg0,Integer arg1){ 
    try{ 
	    Method m = Third.class.getMethod("bbb",Double[].class,Integer.class);
	    return (Byte[])h.invoke(this, m,new Object[]{arg0,arg1}); 
    }catch(Throwable t){} 
   return null;
} 


    @Override
    public Sheep[] fdw(CloneSheep[] arg0){ 
    try{ 
	    Method m = Third.class.getMethod("fdw",CloneSheep[].class);
	    return (Sheep[])h.invoke(this, m,new Object[]{arg0}); 
    }catch(Throwable t){} 
   return null;
} 




}