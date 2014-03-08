
import javax.swing.*;
import javax.swing.event.AncestorListener;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;


/*
 **��IPɨ�衱����
 */
public class SysDialog extends JDialog
{
	JPanel jMainPane = new JPanel();
	
	public static JTextArea Result = new JTextArea("",6,20);

	/*
	 **���캯��
	 */
	/**
	 * 
	 */
	public SysDialog()
	{
		
		Result.setText(getSys());
		setTitle("ϵͳ��Ϣ");
		setSize(300,300);
		setLocation(400, 100);
		setResizable(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		  this.addWindowListener(new WindowAdapter(){
		   public void windowClosing(WindowEvent e) {
		    dispose();
		    Result.setText(null);
		            }
		  }); 
		
		Container c = this.getContentPane();
	
		
		jMainPane.add(Result);
		c.add(jMainPane);

		pack();
		this.setVisible(true);
	}

	private String getSys() {
		
		OperatingSystemMXBean osm = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
		String str = "ϵͳ���ͣ�"+osm.getName();
		str += "\n�汾        ��"+osm.getVersion();
		str += "\n���ݽṹ��"+osm.getArch();
		
		return str;
		
	}
} 
