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
		//建立一个服务器Socket(ServerSocket),指定端口8800并开始监听
		ServerSocket serverSocket = new ServerSocket(2000);
		//使用accept()方法等待客户端触发通信
		Socket socket = serverSocket.accept();
		//打开输入输出流
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		ObjectInputStream ois = new ObjectInputStream(is);
		Request request = (Request)ois.readObject();
		FileOperate fo = new FileOperate();
		String replay;
		switch(request.type){
		case "登录":
			Account account = request.account;
			String password = account.getPassword();
			String userName = account.getUserName();
			fo.readFile("userName@"+userName+"@password@"+password);
		if(fo.isRight){
			 replay = "欢迎您！登录成功";
		}
		else{
			 replay = "账号或密码错误，登录失败";
		}
		os.write(replay.getBytes());
			break;
		case "求租信息":
			FileOperate.saveStringToTxt(request);
			socket.close();
			break;
		case "出租信息":
			FileOperate.saveStringToTxt(request);
			socket.close();
			break;
		}
		ois.close();
		os.close();
		is.close();
	}
}
