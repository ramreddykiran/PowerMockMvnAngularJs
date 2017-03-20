package com.pkrm.configuration;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;
@Configuration
public class MongoConfiguration {
	
	private static final int CONNECTION_PER_HOST = 5;
	private static final int SOCKET_TIMEOUT = 15000;
	private static final int W_TIMEOUT = 5000;
	private static final int MAX_CONNECT_RETRY = 15 * 1000;
	private static final int CONNECT_TIMEOUT = 2 * 1000;
	
	@Value("${mongo.host}")
	private String host;
	
	@Value("${mongo.port}")
	private String port;
	
	@Value("${mongo.database}")
	private String dbName;
	
	@Bean
	public Mongo getMongo() throws UnknownHostException {
		return new Mongo(new ServerAddress(host,Integer.valueOf(port)), createOptions());
	}

	public MongoOptions createOptions() {
		MongoOptions mongoOptions = new MongoOptions();
		mongoOptions.connectTimeout = CONNECT_TIMEOUT;
//		mongoOptions.autoConnectRetry = true;
//		mongoOptions.maxAutoConnectRetryTime = MAX_CONNECT_RETRY; // driver default as of 2.7.0
		mongoOptions.wtimeout = W_TIMEOUT;
		mongoOptions.socketTimeout = SOCKET_TIMEOUT; // SO_TIMEOUT - Longest read delay
		mongoOptions.connectionsPerHost = CONNECTION_PER_HOST;
		mongoOptions.w = 1;
		return mongoOptions;
	}

	@Bean
	public MongoTemplate getMongoTemplate(Mongo mongo) {
		return new MongoTemplate(mongo, dbName);
		
	}
	
}
	

