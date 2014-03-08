import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JLabel;


public class IPScan
{
	static String hostAddress ;
	static int onlineNum = 0;
	
	
	
	IPScan (){
		
		// 定义IP 区段
		String ip1 = ""; 	// 范围 1
		String ip2 = "";	// 范围 2


		try
		{
			InetAddress localAddress = InetAddress.getLocalHost();
			hostAddress = localAddress.getHostAddress();		// 获取本机IP地址
			int dotPos = hostAddress.lastIndexOf(".");
			ip1 = hostAddress.substring(0, dotPos + 1);				// 设置IP区头前段
			ip2 = hostAddress.substring(0, dotPos + 1);				// 设置IP区头后段

		}
		catch (UnknownHostException e1)
		{
			e1.printStackTrace();
		}
		// new testOpenPortThread("192.168.1.106").scanPort();


	ExecuteServices service = ExecuteServices.getInstance();
		service.startup(255); // 设置默认线程池大小
		
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
		IPDialog.onlineNumlabel.setText("活跃IP数："+onlineNum);
	}
}


 

class ExecuteServices
{
	private static ExecutorService service = null;
	private static Lock write_lock = new ReentrantLock();


	private static int threadPool = 255;	//线程池大小


	public void startup(int threadPool)
	{
		this.threadPool = threadPool;
		service = Executors.newFixedThreadPool(threadPool);			//创建线程池	
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


			if (address.isReachable(3000))	// 测试3秒内是否能够到达此地址
			{
				System.out.println(address.getHostAddress() + ":on line");
				IPScan.countOnline();
				IPDialog.Result.append("on line :   "+ address.getHostAddress() + "\n");
				//new Thread(new testOpenPortThread(hostaddress)).start();	// 扫描开放端口
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


	// 测试开放端口
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
					System.out.println(hostaddress + ":" + i + "端口 :open");
				}
			}
			catch (Exception e)
			{
				System.out.println(hostaddress + ":" + i + "端口 :close");
			}


		}
	}


}