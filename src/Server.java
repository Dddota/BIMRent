import RegLogin.Account;
import item.FileOperate;
import item.Request;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	public static void main(String [] args) throws IOException, ClassNotFoundException{
		//����һ��������Socket(ServerSocket),ָ���˿�8800����ʼ����
		ServerSocket serverSocket = new ServerSocket(2000);
		//ʹ��accept()�����ȴ��ͻ��˴���ͨ��
		Socket socket = serverSocket.accept();
		//�����������
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		ObjectInputStream ois = new ObjectInputStream(is);
		Request request = (Request)ois.readObject();
		FileOperate fo = new FileOperate();
		String replay;
		switch(request.type){
		case "��¼":
			Account account = request.account;
			String password = account.getPassword();
			String userName = account.getUserName();
			fo.readFile("userName@"+userName+"@password@"+password);
		if(fo.isRight){
			 replay = "��ӭ������¼�ɹ�";
		}
		else{
			 replay = "�˺Ż�������󣬵�¼ʧ��";
		}
		os.write(replay.getBytes());
			break;
		case "������Ϣ":
			FileOperate.saveStringToTxt(request);
			socket.close();
			break;
		case "������Ϣ":
			FileOperate.saveStringToTxt(request);
			socket.close();
			break;
		}
		ois.close();
		os.close();
		is.close();
	}
}
