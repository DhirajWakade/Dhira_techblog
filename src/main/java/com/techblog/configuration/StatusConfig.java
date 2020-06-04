package com.techblog.configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:StatusConfig.properties")
public class StatusConfig {

	@Value("${RESPONSE_STATUS_SUCCESS}")
	public String responceStatusSuccess;
	
	@Value("${RESPONSE_STATUS_FAILED}")
	public String responceStatusFailed;

	public String getResponceStatusSuccess() {
		return responceStatusSuccess;
	}

	public void setResponceStatusSuccess(String responceStatusSuccess) {
		this.responceStatusSuccess = responceStatusSuccess;
	}

	public String getResponceStatusFailed() {
		return responceStatusFailed;
	}

	public void setResponceStatusFailed(String responceStatusFailed) {
		this.responceStatusFailed = responceStatusFailed;
	}
	
	
}
