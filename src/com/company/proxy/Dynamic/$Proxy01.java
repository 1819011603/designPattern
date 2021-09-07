package com.company.proxy.Dynamic;
import com.company.proxy.Dynamic.Fine;
import com.company.prototype.AsiaSheep;
import com.company.proxy.Dynamic.Employee;
import java.lang.reflect.InvocationHandler;
import com.company.Decorator.Bread;
import java.lang.reflect.Method;
import java.io.InputStream;
public class $Proxy01 implements Employee,Fine{ 
    private InvocationHandler h; 

    public $Proxy01(InvocationHandler h){ 
		System.out.println("代理类初始化成功");
		this.h = h; 
   } 

    @Override
    public void yyy(){ 
    try{ 
	    Method m = Employee.class.getMethod("yyy");
	    h.invoke(this, m,(Object[])null); 
    }catch(Throwable t){} 
   } 


    @Override
    public void work(String arg0){ 
    try{ 
	    Method m = Employee.class.getMethod("work");
	    h.invoke(this, m,new Object[]{arg0}); 
    }catch(Throwable t){} 
   } 


    @Override
    public int hhh(String arg0, int arg1, String arg2){ 
    try{ 
	    Method m = Employee.class.getMethod("hhh");
	    return (Integer)h.invoke(this, m,new Object[]{arg0,arg1,arg2}); 
    }catch(Throwable t){} 
   return 0;
} 


    @Override
    public void ttt(AsiaSheep arg0, InputStream arg1){ 
    try{ 
	    Method m = Employee.class.getMethod("ttt");
	    h.invoke(this, m,new Object[]{arg0,arg1}); 
    }catch(Throwable t){} 
   } 


    @Override
    public void finettt(AsiaSheep arg0, InputStream arg1){ 
    try{ 
	    Method m = Fine.class.getMethod("finettt");
	    h.invoke(this, m,new Object[]{arg0,arg1}); 
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




}