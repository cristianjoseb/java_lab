package com.sciencie.configuration;

public class ClientRequest {
	
	private String loginId;
	private String clientCode;
	private String source;
	
	public ClientRequest(){
		
	}
	
	public ClientRequest(String loginId, String clientCode, String source){
		this(loginId, clientCode);
		this.source = source;
	}
	
	public ClientRequest(String loginId, String clientCode){
		this.setLoginId(loginId);
		this.setClientCode(clientCode);
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
		
}
