import RegLogin.Account;
import item.FileOperate;
import item.Request;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server implements Runnable{
	Socket socket=null;//服务器端口
	static boolean isExit=false;//用户是否退出。
	InputStream is =null;
	OutputStream os = null;
	ObjectInputStream ois =null;

	@Override
	public void run() {
		try {
				InputStream is =socket.getInputStream();
				OutputStream os =socket.getOutputStream();
				ObjectInputStream ois =new ObjectInputStream(is);
			 Request request = (Request)ois.readObject();
			 FileOperate fo = new FileOperate();
			 String reply;
			 switch(request.getType()){
				case "登录":
					Account account = request.getAccount();
					String password = account.getPassword();
					String userName = account.getUserName();
					fo.readFile("userName@"+userName+"@password@"+password);
					if(fo.isRight()){
						System.out.println(userName+"已登录");
						reply = "true";
		/*				ObjectOutputStream ots = new ObjectOutputStream(os);
						ots.writeObject(fo.readaccount(account.getUserName()));//传输对象BUG，无法同时使用os流传输回执和对象。
						ots.close();*/
					}
					else{
						reply = "false";
					}
					os.write(reply.getBytes());
					os.flush();
					break;
				case"注册":
					account=request.getAccount();
					password=account.getPassword();
					userName=account.getUserName();
					String phoneNumber=account.getPhoneNumber();
					String idnum=account.getIdnum();
					String type=account.getType();
					int cp=account.getCreditPoint();
					if(!fo.Regin(account)){
						reply = "false";
					}
					else {
						fo.createfile1("userName@" + userName + "@password@" + password + "@phoneNumber@" + phoneNumber + "@idnum@" + idnum+"@type@"+type
								+ "@CreditPoint@"+cp);
						System.out.println(userName+"已注册");
						reply = "true";
					}
						os.write(reply.getBytes());
					os.flush();
					break;
				case "发布信息":
					FileOperate.saveStringToTxt(request);
					reply=request.getAccount().getUserName()+"信息发布成功";
					os.write(reply.getBytes());
					os.flush();
					break;
				case "租赁信息":
					reply= FileOperate.readRentInfo(request.getForRentMessage().getRentOrNot()).toString();
					os.write(reply.getBytes());
					os.flush();
					break;
				case "退出":
					isExit=true;
					break;

			 }ois.close();
					os.close();
					is.close();
			 } catch (IOException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
	}


	public static void main(String [] args) throws IOException, ClassNotFoundException{
		ServerSocket serverSocket = new ServerSocket(2000);
		Socket socket=null;
		InputStream is =null;
		OutputStream os = null;
		ObjectInputStream ois =null;
		while (!isExit){
			socket= serverSocket.accept();
			Thread t=new Thread(new Server(socket));
			t.start();
	}
	}
	public Server(Socket socket){
		this.socket=socket;
	}
}
