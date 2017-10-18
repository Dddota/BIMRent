package item;

import java.io.Serializable;

/**
 * 房客求租类，实现对房客信息的存储，并发送给服务器，利用服务器进行存储
 * @author Administrator
 *
 */
public class ForRentMessage implements Serializable{
	 String RentOrNot;
	 String roomType;//求租房屋类型
	 String address;//求租地址
	 String phoneNumber;//电话号码
}