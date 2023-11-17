package com.orderapp.bo;

import java.util.List;

public class UserResponse {

	private Long userId;
	private String userName;
	private String emailId;
	private String userStatus;
		private List<UserAddressResp> addresses;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public List<UserAddressResp> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<UserAddressResp> addresses) {
		this.addresses = addresses;
	}
	
	
	
	
}
