import RegLogin.Account;
import item.ForRentMessage;
import item.Request;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Lodger {
	public static void main(String [] args) throws UnknownHostException, IOException{

		request.type = "������Ϣ";
		switch(request.type){
		case "��¼":
			Account account = new Account();
			account.userName = "Tomcatter";
			account.password = "123456789";
			request.account = account;
			break;
		case "��ʾ������Ϣ":
			break;
		case "������Ϣ":
			ForRentMessage forRentMessage = new ForRentMessage();
			forRentMessage.roomType = "����һ��";
			forRentMessage.address = "���·328��";
			forRentMessage.phoneNumber = "18293145325";
			forRentMessage.RentOrNot = "����";
			request.forRentMessage = forRentMessage;
			break;
	case "������Ϣ":
			ForRentMessage forRentMessage1 = new ForRentMessage();
			forRentMessage1.roomType = "���Ҷ���";
			forRentMessage1.address = "���·328��";
			forRentMessage1.phoneNumber = "18293145325";
			forRentMessage1.RentOrNot = "����";
			request.forRentMessage = forRentMessage1;
			break;
		}
		//���Ϳͻ�����Ϣ���������д����Ϣ

	}
		public void ClientSocket(){

		}
		public void ClientSend(Request request){
			//�����ͻ���Socket���ӣ�ָ����������λ��Ϊ�����Լ��˿�8800
			Socket socket = null;
			try {
				socket = new Socket("localhost",2000);
			//������/�����
				OutputStream os = socket.getOutputStream();
				InputStream is = socket.getInputStream();
				request = new Request();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(request);
			//������������Ӧ
				socket.shutdownOutput();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
		
//		ObjectOutputStream oos = new ObjectOutputStream(os);
//		oos.writeObject(request);
		
	/*	//���Ϳͻ���������Ϣ���������д����Ϣ
		String info2 = "roomType@����һ��address@���·phoneNumber@18293145325";
		os.write(info1.getBytes());
		//os.write(info2.getBytes());
		socket.shutdownOutput();*/
		//���ܷ���˵���Ӧ��������������ȡ��Ϣ
//		String replay = null;
//		BufferedReader br = new BufferedReader(new InputStreamReader(is));
//
//		br.close();
//		is.close();
//		os.close();
		
	}
	

