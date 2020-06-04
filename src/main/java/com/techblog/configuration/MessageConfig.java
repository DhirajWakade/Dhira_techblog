package com.techblog.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:MessagesConfig.properties")
public class MessageConfig {
	
	@Value("${MSG_FAILED_TRY_AGAIN}")
	public String msgFailedTryAgain;
	
	@Value("${MSG_SUCCESSFULLY_INSERTED}")
	public String msgSuccessfullyInserted;

	public String getMsgFailedTryAgain() {
		return msgFailedTryAgain;
	}

	public void setMsgFailedTryAgain(String msgFailedTryAgain) {
		this.msgFailedTryAgain = msgFailedTryAgain;
	}

	public String getMsgSuccessfullyInserted() {
		return msgSuccessfullyInserted;
	}

	public void setMsgSuccessfullyInserted(String msgSuccessfullyInserted) {
		this.msgSuccessfullyInserted = msgSuccessfullyInserted;
	}
	

}
