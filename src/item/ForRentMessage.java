package item;

import RegLogin.Account;

import java.io.Serializable;

/**
 *
 * @author Administrator
 *
 */
public class ForRentMessage implements Serializable{
	private String RentOrNot;//出租还是求租
	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	private String roomType;//户型
	private String address;//地址

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	private String phoneNumber;//电话号码

	public String getRentOrNot() {
		return RentOrNot;
	}

	public void setRentOrNot(String rentOrNot) {
		RentOrNot = rentOrNot;
	}
}