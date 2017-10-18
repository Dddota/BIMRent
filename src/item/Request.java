package item;

import RegLogin.Account;

import java.io.Serializable;


public class Request implements Serializable{
	String type;
	Account account;
	ForRentMessage forRentMessage;//出租信息
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	public ForRentMessage getForRentMessage() {
		return forRentMessage;
	}

	public void setForRentMessage(ForRentMessage forRentMessage) {
		this.forRentMessage = forRentMessage;
	}



}
