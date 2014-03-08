import java.lang.reflect.*; 

/**
 * 就列出了java.util.Stack 类的各方法名以及它们的限制符和返回类型。
 * @author stephenluu
 *
 */
public class DumpMethods { 
   public static void main(String args[]) { 
      try { 
           Class c = Class.forName("java.util.Stack"); 
           Method m[] = c.getDeclaredMethods(); 
            
           for (int i = 0; i < m.length; i++) 
               System.out.println(m[i].toString()); 
      } 
      catch (Throwable e){ 
            System.err.println(e); 
      } 
   } 
}