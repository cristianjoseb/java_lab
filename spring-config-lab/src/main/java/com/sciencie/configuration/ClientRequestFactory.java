package com.sciencie.configuration;


public class ClientRequestFactory {

    private static final ThreadLocal<ClientRequest> contextThreadLocal = new ThreadLocal<ClientRequest>();

   
    public static void setClientRequest(String loginId, String clientCode , String source) throws Exception {
    	if (source == null) {
            throw new IllegalArgumentException("Invalid source " + source);
        }
    	
    	setClientRequest(loginId, clientCode);
    	getClientRequest().setSource(source);
    }
    
    public static void setClientRequest(String loginId, String clientCode) throws Exception {
        
    	if (loginId == null) {
            throw new IllegalArgumentException("Invalid loginId " + loginId);
        }

        if (clientCode == null) {
            throw new IllegalArgumentException("Invalid client code " + clientCode);
        }

        ClientRequest clientRequest = new ClientRequest(loginId, clientCode);
       
        setClientRequest(clientRequest);
    }
    
   
    public static void setClientRequest(ClientRequest request) {
        contextThreadLocal.set(request);
    }

    public static ClientRequest getClientRequest() {

        return contextThreadLocal.get();
    }
    
    public static void clear() {
        contextThreadLocal.remove();
    }

    public static String getClientCode() {
        if (getClientRequest() != null) {
            return getClientRequest().getClientCode();
        }

        throw new NullPointerException("Client is not associated with this request.");
    }

    public static String getLoginId() {
        if (getClientRequest() != null) {
            return getClientRequest().getLoginId();
        }

        throw new NullPointerException("Client is not associated with this request.");
    }
    
//    public static String getSource() {
//        if (getClientRequest() != null) {
//            return getClientRequest().getSource();
//        }
//
//        throw new NullPointerException("Client is not associated with this request.");
//    }

    public static boolean isValidRequest() {
        return (getClientRequest() != null);
    }
}