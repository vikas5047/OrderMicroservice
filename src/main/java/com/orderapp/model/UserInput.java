package com.orderapp.model;

import java.util.List;



/*public record UserInput(String userName,
 String emailId, String userStatus) {*/

public class UserInput{
		
		private String userName;
		private String emailId;
		private String userStatus;
		private List<AddressInput> addresses;
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
		public List<AddressInput> getAddresses() {
			return addresses;
		}
		public void setAddresses(List<AddressInput> addresses) {
			this.addresses = addresses;
		}
		
		
	
}
