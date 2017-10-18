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
	//�½�һ���ļ�
	File efile1 = new File("src/idinfo.txt");
	boolean flag = false;
	boolean isRight = false;
	/**
	 * ʵ�ֶ��˺���Ϣ��д��
	 * @param str
	 */
	public void createfile1(String str){
		//������Ķ���
		FileOperate cf = new FileOperate();
		
		//�ж��ļ��Ƿ񴴽��ķ���
		cf.isExit1(efile1);
		//ʹ��FileWriter��ʵ���ļ���д��
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(efile1,true);
			bw = new BufferedWriter(fw);
			bw.write(str);
			bw.newLine();
			bw.flush();
			System.out.println("д����ϣ�");
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
 * ����˻��ĵ�¼
 */
	public boolean readFile(String str) {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			//����һ��FileReader����
			fr = new FileReader("src/idinfo.txt");
			//����һ��BufferedReader����
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
				System.out.println("�˺���Ϣ�ļ��Ѵ���");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * ������Ϣ����
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
			System.out.println("д��ɹ���");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}

