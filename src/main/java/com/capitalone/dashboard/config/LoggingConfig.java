package com.capitalone.dashboard.config;

import com.capitalone.dashboard.logging.DatabaseLoggingCondition;
import com.capitalone.dashboard.logging.KeyValueLoggingCondition;
import com.capitalone.dashboard.logging.KeyValueLoggingFilter;
import com.capitalone.dashboard.logging.LoggingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfig {
    
    @Bean
    @Conditional(KeyValueLoggingCondition.class)
    public KeyValueLoggingFilter splunkConnectionLoggingFilter() {
        return new KeyValueLoggingFilter();
    }
    
    @Bean
    @Conditional(DatabaseLoggingCondition.class)
    public LoggingFilter loggingFilter() {
        return new LoggingFilter();
    }

}
