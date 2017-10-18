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

		request.type = "求租信息";
		switch(request.type){
		case "登录":
			Account account = new Account();
			account.userName = "Tomcatter";
			account.password = "123456789";
			request.account = account;
			break;
		case "显示所有信息":
			break;
		case "求租信息":
			ForRentMessage forRentMessage = new ForRentMessage();
			forRentMessage.roomType = "三室一厅";
			forRentMessage.address = "沈半路328号";
			forRentMessage.phoneNumber = "18293145325";
			forRentMessage.RentOrNot = "求租";
			request.forRentMessage = forRentMessage;
			break;
	case "出租信息":
			ForRentMessage forRentMessage1 = new ForRentMessage();
			forRentMessage1.roomType = "三室二厅";
			forRentMessage1.address = "沈半路328号";
			forRentMessage1.phoneNumber = "18293145325";
			forRentMessage1.RentOrNot = "出租";
			request.forRentMessage = forRentMessage1;
			break;
		}
		//发送客户端信息即向输出流写入信息

	}
		public void ClientSocket(){

		}
		public void ClientSend(Request request){
			//建立客户端Socket连接，指定服务器的位置为本机以及端口8800
			Socket socket = null;
			try {
				socket = new Socket("localhost",2000);
			//打开输入/输出流
				OutputStream os = socket.getOutputStream();
				InputStream is = socket.getInputStream();
				request = new Request();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(request);
			//接下来处理响应
				socket.shutdownOutput();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
		
//		ObjectOutputStream oos = new ObjectOutputStream(os);
//		oos.writeObject(request);
		
	/*	//发送客户端求租信息即向输出流写入信息
		String info2 = "roomType@三室一厅address@沈半路phoneNumber@18293145325";
		os.write(info1.getBytes());
		//os.write(info2.getBytes());
		socket.shutdownOutput();*/
		//接受服务端的响应，即从输入流读取信息
//		String replay = null;
//		BufferedReader br = new BufferedReader(new InputStreamReader(is));
//
//		br.close();
//		is.close();
//		os.close();
		
	}
	

