package com.samar.bootcamp;

import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "wa")
@ConfigurationPropertiesScan
@Component
@Validated
public class SmsConfig {
    private Hostname hostname;
    private String token;

    public Hostname getHostname() {
        return hostname;
    }

    public void setHostname(Hostname hostname) {
        this.hostname = hostname;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static class Hostname {
        @NotBlank
        private String companyName;
        private String companyType;

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getCompanyType() {
            return companyType;
        }

        public void setCompanyType(String companyType) {
            this.companyType = companyType;
        }

        @Override
        public String toString() {
            return "Hostname{" +
                    "companyName='" + companyName + '\'' +
                    ", companyType='" + companyType + '\'' +
                    '}';
        }
    }
}
