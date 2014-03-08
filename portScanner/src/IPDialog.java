
import javax.swing.*;
import javax.swing.event.AncestorListener;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/*
 **“IP扫描”窗口
 */
public class IPDialog extends JDialog
{
	JPanel jMainPane = new JPanel();
	
	public static JTextArea Result = new JTextArea("",6,20);
	public static JLabel localhostlabel ; 
	public static JLabel onlineNumlabel ; 

	/*
	 **构造函数
	 */
	/**
	 * 
	 */
	public IPDialog()
	{
		localhostlabel = new JLabel("本地IP："+ IPScan.hostAddress+"         ");
		onlineNumlabel = new JLabel("活跃IP数："+ IPScan.onlineNum);
		
		setTitle("IP扫描");
		setSize(300,300);
		setLocation(400, 100);
		setResizable(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		  this.addWindowListener(new WindowAdapter(){
		   public void windowClosing(WindowEvent e) {
		    dispose();
		    IPScan.onlineNum = 0;
		    Result.setText(null);
		            }
		  }); 
		
		Container c = this.getContentPane();
	
		
		jMainPane.add(localhostlabel);
		jMainPane.add(onlineNumlabel);
		jMainPane.add(Result);
		c.add(jMainPane);

		//pack();
		this.setVisible(true);
	}
} 
