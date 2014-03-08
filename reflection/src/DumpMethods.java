import java.lang.reflect.*; 

/**
 * ���г���java.util.Stack ��ĸ��������Լ����ǵ����Ʒ��ͷ������͡�
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