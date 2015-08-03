package com.sciencie.datasource;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.aop.TargetSource;

import com.sciencie.configuration.ClientRequestFactory;

public class DataSourceTargetSource implements TargetSource{

	
	private Map<String, DataSource> dataSources;
	
	public void addDataSource(String key, DataSource value){
		if (this.getDataSources() == null){
			this.dataSources = new HashMap<String, DataSource>();
		}
		
		this.dataSources.put(key, value);
		
	}
	
	public Object getTarget() throws Exception {
		
		String clientCode = ClientRequestFactory.getClientCode();
		
		if (this.dataSources.containsKey(clientCode)){
			return dataSources.get(clientCode);
    	}else{
    		throw new Exception("Data source is not configured for " + clientCode + " database");
    	}
	}

	public Class<DataSource> getTargetClass() {
		return DataSource.class;
	}

	public boolean isStatic() {
		return false;
	}
	
	
	public void releaseTarget(Object arg0) throws Exception {
		//do nothing
	}

	public Map<String, DataSource> getDataSources() {
		return dataSources;
	}

	public void setDataSources(Map<String, DataSource> dataSources) {
		this.dataSources = dataSources;
	}

}
