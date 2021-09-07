package com.company.proxy.Dynamic;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.*;
import java.util.*;

/**
 * @author 18190
 * @Date: 2021/9/6  16:39
 * @VERSION 1.0
 */
public class MyProxy {

    private static int index = 0;
    private static int proxyOrder = 0;
    public static String getParameterName(){
        return "arg" + index++;
    }
    private static HashMap<String,String> baseType = new HashMap<>();

    private static HashSet<String> ClassType = null;

    static {
        baseType.put("int","Integer");
        baseType.put("double","Double");
        baseType.put("float","Float");
        baseType.put("boolean","Boolean");
        baseType.put("char","Character");
        baseType.put("byte","Byte");
        baseType.put("short","Short");
        baseType.put("long","Long");

    }

    // 参数类型的全路径名称改为简写
    public static void getSimpleParameter(StringBuilder para,Class c){
        String parameterType = c.getName();
        // 去掉java.lang.
        String s = null;



        if(c.isArray()){
            if(!baseType.containsKey(s = c.getComponentType().getName())){

                parameterType = c.getSimpleName();
                if (!s.startsWith("java.lang")){
                    ClassType.add(s);
                }
            }else if(s.startsWith("java.lang")){
                parameterType = parameterType.substring(10);
            }
        }else {
            if(!baseType.containsKey(parameterType)){
                if(!parameterType.startsWith("java.lang")){

                    ClassType.add(parameterType);
                }
                parameterType = c.getSimpleName();
            }
        }

        //    Double[] argn
        para.append(parameterType).append(" ").append(getParameterName());


    }


    public static Object newInstance(ClassLoader loader, Class<?>[] infaces, InvocationHandler h,Class ct){
        if(proxyOrder == 1){
            return new $Proxy0(h);
        }
        ClassType = new HashSet<>();
        ClassType.add("java.lang.reflect.InvocationHandler");
        ClassType.add("java.lang.reflect.Method");
//        ClassType.add("java.lang.reflect.Proxy");
        StringBuilder methodContent = new StringBuilder();
        StringBuilder str = new StringBuilder("package com.company.proxy.Dynamic;\n");
        StringBuilder interfaceArray =new StringBuilder();
        String proxyName = "$Proxy" + proxyOrder++;
        // 获得该真实类的所有接口 遍历
        for (Class c:infaces){
            // implement 接口1，接口2，...，  最后再删除掉最后一个，号
            interfaceArray.append(c.getSimpleName()).append(",");
            // 如果接口没有导入，加入到Set中导入
            if(!c.getName().startsWith("java.lang")){
                    ClassType.add(c.getName());
            }
            // 获得一个接口的所有方法
            Method[] methods = c.getMethods();


            for (Method method: methods){

                // index 是参数序号 从0开始
                index = 0;

                // 获得参数的数量
                int parameterCount = method.getParameterCount();
                // 每个方法的的所有参数
                StringBuilder methodsType = new StringBuilder("(Object[])null");
                // 获得参数的简写形式 不是全路径
                StringBuilder para = new StringBuilder();

                StringBuilder ps = new StringBuilder();
                if(parameterCount >= 1){
                    Parameter[] parameters = method.getParameters();
                    ps= new StringBuilder("," + parameters[0].getType().getSimpleName()).append(".class");

                    getSimpleParameter(para,parameters[0].getType());
                    methodsType = new StringBuilder("new Object[]{arg0");
                    for (int i = 1; i < parameters.length; i++){

                        para.append(",");
                        ps.append(",").append(parameters[i].getType().getSimpleName()).append(".class");
                        getSimpleParameter(para,parameters[i].getType());
                        methodsType.append(",arg").append(i);
                    }
                    methodsType.append("}");

                }

                Class<?> returnType = method.getReturnType();
                String simpleName = returnType.getSimpleName();

                if(baseType.containsKey(simpleName)){
                    methodContent.append("    @Override\n    public ").append(simpleName).append(" ").append(method.getName()).append("(").append(para) .append("){ \r\n").append("    try{ \r\n").append("	    Method m = ").append(c.getSimpleName()).append(".class.getMethod(\"").append(method.getName()).append("\"").append(ps).append(");\r\n").append("	    return (").append(baseType.get(simpleName)).append(")h.invoke(this, m,")
                            .append( methodsType).append("); \r\n").append("    }catch(Throwable t){} \r\n").append("   return 0;\r\n} \r\n\r\n\r\n");
                }else if("void".equals(simpleName)){
                    methodContent.append("    @Override\n    public ").append(simpleName).append(" ").append(method.getName()).append("(").append(para) .append("){ \r\n").append("    try{ \r\n").append("	    Method m = ").append(c.getSimpleName()).append(".class.getMethod(\"").append(method.getName()).append("\"").append(ps).append(");\r\n").append("	    h.invoke(this, m,")
                            .append( methodsType).append("); \r\n").append("    }catch(Throwable t){} \r\n").append("   } \r\n\r\n\r\n");
                }else {
                    if(!returnType.isArray()){
                        if(!returnType.getName().startsWith("java.lang")){
                            ClassType.add(returnType.getName());
                        }
                    }
                    else {
                        if(!returnType.getComponentType().getName().startsWith("java.lang")){

                            ClassType.add(returnType.getComponentType().getName());
                        }
                    }
                    methodContent.append("    @Override\n    public ").append(simpleName).append(" ").append(method.getName()).append("(").append(para) .append("){ \r\n").append("    try{ \r\n").append("	    Method m = ").append(c.getSimpleName()).append(".class.getMethod(\"").append(method.getName()).append("\"").append(ps).append(");\r\n").append("	    return (").append(simpleName).append(")h.invoke(this, m,")
                            .append( methodsType).append("); \r\n").append("    }catch(Throwable t){} \r\n").append("   return null;\n} \r\n\r\n\r\n");
                }


            }
//        System.out.println(methodContent);
        }



        for (String s: ClassType){
            str.append("import ").append(s).append(";\n");
        }
        interfaceArray.delete(interfaceArray.length()-1,interfaceArray.length());
        str.append("public class ").append(proxyName).append(" extends ").append(ct.getSimpleName()).append(" implements ").append(interfaceArray).append("{ \r\n").
                append("    private InvocationHandler h; \r\n").append("\r\n").append("    public ").append(proxyName).append("(InvocationHandler h){ \r\n\t\tSystem.out.println(\"代理类初始化成功\");\n")
                .append("		this.h = h; \r\n").append("   } \r\n").append("\r\n").append(methodContent).append("\r\n").append("\r\n").append("}");

        System.out.println(str);

        String dir = System.getProperty("user.dir");

        String folder = "/src/com/company";
        String fileName =  dir + folder + "/proxy/Dynamic/"+proxyName+".java";
        File f = new File(fileName);
        FileWriter fw = null;
        StandardJavaFileManager fileMgr = null;
        try{
            f.createNewFile();
            fw = new FileWriter(f);
            fw.write(String.valueOf(str));
            fw.flush();

            //编译 获取到编译器，执行编译任务
            //options的作用是指定编译好的class文件存放位置，如果不指定，会放到与java文件同目录下
            //编译这一块也可以替换成Runtime.exec("javac ...")来执行java编译指令的形式
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            fileMgr = compiler.getStandardFileManager(null, null, null);

            List<String> options = new ArrayList<>(4);
            options.add("-d");
            options.add(dir + "/target/classes");
            Iterable<? extends JavaFileObject> iter = fileMgr.getJavaFileObjects(fileName);
            JavaCompiler.CompilationTask task = compiler.getTask(null, fileMgr, null, options, null, iter);
            task.call();

            //加载到内存（此时就可以使用了）
            ClassLoader classLoader = loader;
            Class<?> clazz = classLoader.loadClass("com.company.proxy.Dynamic."+proxyName);
            Constructor<?> c1 = clazz.getConstructor(InvocationHandler.class);
            return c1.newInstance(h);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            IoUtil.close(fw, fileMgr);
        }

        return null;
    }
}
