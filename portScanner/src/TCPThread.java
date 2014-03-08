
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TCPThread extends Thread{
	
	public static InetAddress hostAddress;
	
	//��С�Ķ˿ں�
	public static int MIN_port;
	//���Ķ˿ں�
	public static int MAX_port;
	
	//�߳�����
	private int threadnum;    

	//��ѯ��ʽ��0Ϊip��1Ϊ������
	public static int type;
	
	//�˿ڵ����
	String porttype = "0";
		
	/*
	 *���캯��
	 */
	public TCPThread(String name,int threadnum){
		super(name);        
		this.threadnum = threadnum;    
	}    
	
	/*
	 *���к���
	 */
	public void run() {
		
		//ip��ַ
		int h = 0;
		//�˿ں�
		int i = 0;
		Socket theTCPsocket;

		//����ip��ַ����ɨ��
		if(type == 0){
				//��ͬ�Ķ˿�ѭ��ɨ��
				for (i = MIN_port+threadnum; i < MAX_port + Integer.parseInt(PortScan.maxThread.getText()) && PortScan.StopFlag; i += Integer.parseInt(PortScan.maxThread.getText())){

					try{
						theTCPsocket=new Socket(hostAddress,i);
						theTCPsocket.close();
						
						//�ж϶˿ڵ����
						switch(i){
							case 21:
								porttype = "(FTP)";
								break;
							case 23:
								porttype = "(TELNET)";
								break;
							case 25:
								porttype = "(SMTP)";
								break; 
							case 80:
								porttype = "(HTTP)";	
								break;
							case 110:
								porttype = "(POP)";
								break;
							case 139:
								porttype = "(netBIOS)";
								break;
							case 1433:
								porttype = "(SQL Server)";
								break;
							case 3389:
								porttype = "(Terminal Service)";
								break;
							case 443:
								porttype = "(HTTPS)";
								break;
							case 1521:
								porttype = "(Oracle)";
								break;
							default :
								porttype = "(UnknownPort:Open)";
								break;
						}
						
						//�����Ŷ˿�������ӵ���ʾ����
						synchronized (PortScan.Result) {
							PortScan.Result.append(" "+i);
							PortScan.Result.append(":"+porttype+"\n");
						}
						synchronized (PortScan.ResultAll) {
							PortScan.ResultAll.append(" "+i);
							PortScan.ResultAll.append(":"+porttype+"\n");
						}
					}
					catch (IOException e){
						synchronized (PortScan.ResultAll) {
							//�����ж˿�������ӵ���ʾ����
							PortScan.ResultAll.append(" "+i);
							PortScan.ResultAll.append(":Closed"+"\n");
						}
					}
				}
			//}
			
			//ɨ����ɺ���ʾɨ����ɣ�������ȷ������ť����Ϊ����
			if (i==MAX_port+Integer.parseInt(PortScan.maxThread.getText())){
				try {Thread.sleep(1000);} catch (InterruptedException e) {}
				PortScan.Result.append("ɨ�����...");
				
				//��"ȷ��"��ť���ó�Ϊ����
				if(!PortScan.Submit.isEnabled()){
					PortScan.Submit.setEnabled(true);
				}
			}
		}
		
		//�������������ж˿�ɨ��
		if(type == 1){

			for (i = MIN_port+threadnum; i < MAX_port+Integer.parseInt(PortScan.maxThread.getText()) && PortScan.StopFlag; i += Integer.parseInt(PortScan.maxThread.getText())){

				try{
					theTCPsocket=new Socket(hostAddress,i);
					theTCPsocket.close();
					switch(i){
							case 21:
								porttype = "(FTP)";
								break;
							case 23:
								porttype = "(TELNET)";
								break;
							case 25:
								porttype = "(SMTP)";
								break; 
							case 80:
								porttype = "(HTTP)";	
								break;
							case 110:
								porttype = "(POP)";
								break;
							case 139:
								porttype = "(netBIOS)";
								break;
							case 1433:
								porttype = "(SQL Server)";
								break;
							case 3389:
								porttype = "(Terminal Service)";
								break;
							case 443:
								porttype = "(HTTPS)";
								break;
							case 1521:
								porttype = "(Oracle)";
								break;
							default :
								porttype = "(UnknownPort:Open)";
								break;
						}
						
						//�����Ŷ˿�������ӵ���ʾ����
						synchronized (PortScan.Result) {
							PortScan.Result.append(" "+i);
							PortScan.Result.append(":"+porttype+"\n");
						}
						synchronized (PortScan.ResultAll) {
							PortScan.ResultAll.append(" "+i);
							PortScan.ResultAll.append(":"+porttype+"\n");
						}
				}
				catch (IOException e){
					synchronized (PortScan.ResultAll) {
						//�����ж˿�������ӵ���ʾ����
						PortScan.ResultAll.append(" "+i);
						PortScan.ResultAll.append(":Closed"+"\n");
					}
				}
			}
			
			//ɨ����ɺ���ʾɨ����ɣ�������ȷ������ť����Ϊ����
			if (i==MAX_port+Integer.parseInt(PortScan.maxThread.getText())){
				try {Thread.sleep(1000);} catch (InterruptedException e) {}
				PortScan.Result.append("ɨ�����...");
				
				//����ȷ������ť���ó�Ϊ����
				if(!PortScan.Submit.isEnabled()){
					PortScan.Submit.setEnabled(true);
				}
			}
		}
	}
}