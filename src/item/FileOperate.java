package item;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileOperate {
	//新建一个文件
	File efile1 = new File("src/idinfo.txt");
	boolean flag = false;
	boolean isRight = false;
	/**
	 * 实现对账号信息的写入
	 * @param str
	 */
	public void createfile1(String str){
		//创建类的对象
		FileOperate cf = new FileOperate();
		
		//判断文件是否创建的方法
		cf.isExit1(efile1);
		//使用FileWriter类实现文件的写入
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(efile1,true);
			bw = new BufferedWriter(fw);
			bw.write(str);
			bw.newLine();
			bw.flush();
			System.out.println("写入完毕！");
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally{
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
/**
 * 完成账户的登录
 */
	public boolean readFile(String str) {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			//创建一个FileReader对象
			fr = new FileReader("src/idinfo.txt");
			//创建一个BufferedReader对象
			br = new BufferedReader(fr);
			String line = str;
			String[] str1 = line.split("@");
			String str11 = str1[1];
			String str12 = str1[3];
			String str21 = null;
			String str22 = null;
			line = br.readLine();
			while(line!=null){
				String []str2 = line.split("@");
				str21 = str2[1];
				str22 = str2[3];
				if(str11.equals(str21)){
					flag =true;
				}
				if((str11.equals(str21))&&(str12.equals(str22))){
					isRight = true;
					break;
				}
				line = br.readLine();
			}
			System.out.println(str11);
			System.out.println(str21);
			System.out.println(str12);
			System.out.println(str22);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public void isExit1(File efile) {
		if (!efile.exists()) {
			try {
				efile.createNewFile();
				System.out.println("账号信息文件已创建");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 出租信息汇总
	 * @param request
     */
	public static void saveStringToTxt(Request request){
		File file=new File("src/rentInfo");
		ForRentMessage rent= request.forRentMessage;
		String address= rent.address;
		String phoneNum= rent.phoneNumber;
		String roomType=rent.roomType;
		String rentOrNot = rent.RentOrNot;
		String res="roomType="+roomType+"@address="+address+"@phoneNumber="+phoneNum+"@rentOrNot="+rentOrNot+"\n";
		try {
			FileOutputStream fos=new FileOutputStream(file,true);
			OutputStreamWriter osw=new OutputStreamWriter(fos);
			BufferedWriter bw=new BufferedWriter(osw);
			bw.write(res);
			bw.newLine();
			bw.flush();
			System.out.println("写入成功！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}

