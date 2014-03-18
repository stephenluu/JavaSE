import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JLabel;


public class  IPScan
{
	static String hostAddress ;
	static int onlineNum = 0;
	
	IPScan (){
		
		// ����IP ���
		String ip1 = ""; 	// ��Χ 1
		String ip2 = "";	// ��Χ 2


		try
		{
			InetAddress localAddress = InetAddress.getLocalHost();
			hostAddress = localAddress.getHostAddress();		// ��ȡ����IP��ַ
			int dotPos = hostAddress.lastIndexOf(".");
			ip1 = hostAddress.substring(0, dotPos + 1);				// ����IP��ͷǰ��
			ip2 = hostAddress.substring(0, dotPos + 1);				// ����IP��ͷ���

		}
		catch (UnknownHostException e1)
		{
			e1.printStackTrace();
		}
		// new testOpenPortThread("192.168.1.106").scanPort();


	ExecuteServices service = ExecuteServices.getInstance();
		service.startup(255); // ����Ĭ���̳߳ش�С
		
		try
		{
			for (int i = 1; i < 255; i++)
			{
				final String ipaddress = ip1 + i;
				service.exeuteTask(new Thread1(ipaddress));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		 
		

	}
	
	
	public synchronized static void countOnline(){
		onlineNum++;
		//System.out.println(onlineNum);
		IPDialog.onlineNumlabel.setText("��ԾIP��"+onlineNum);
	}
}


 

class ExecuteServices
{
	private static ExecutorService service = null;
	private static Lock write_lock = new ReentrantLock();


	private static int threadPool = 255;	//�̳߳ش�С


	public void startup(int threadPool)
	{
		this.threadPool = threadPool;
		service = Executors.newFixedThreadPool(threadPool);			//�����̳߳�	
	}


	private static ExecuteServices instance = new ExecuteServices();


	public static ExecuteServices getInstance()
	{
		if (instance == null)
		{
			instance = new ExecuteServices();
		}
		return instance;
	}


	public static void exeuteTask(Runnable task)
	{
		service.execute(task);	
	}


}


class Thread1 implements Runnable
{
	private String hostaddress;


	public Thread1(String hostaddress)
	{
		this.hostaddress = hostaddress;
	}


	@Override
	public void run()
	{
		try
		{
			InetAddress address = InetAddress.getByName(hostaddress);


			if (address.isReachable(3000))	// ����3�����Ƿ��ܹ�����˵�ַ
			{
				System.out.println(address.getHostAddress() + ":on line");
				IPScan.countOnline();
				IPDialog.Result.append("on line :   "+ address.getHostAddress() + "\n");
				//new Thread(new testOpenPortThread(hostaddress)).start();	// ɨ�迪�Ŷ˿�
			}
			else
			{
				//System.out.println(address.getHostAddress() + ":connection time out");
			}
		}
		catch (UnknownHostException e)
		{
		}
		catch (IOException e)
		{
		}
	}
}


class testOpenPortThread implements Runnable
{
	private String hostaddress;


	testOpenPortThread(String hostaddress)
	{
		this.hostaddress = hostaddress;
	}


	// ���Կ��Ŷ˿�
	public void run()
	{
		for (int i = 20; i < 3389; i++)
		{
			Socket socket;
			try
			{
				socket = new Socket(hostaddress, i);
				if (socket.isConnected())
				{
					System.out.println(hostaddress + ":" + i + "�˿� :open");
				}
			}
			catch (Exception e)
			{
				System.out.println(hostaddress + ":" + i + "�˿� :close");
			}


		}
	}


}