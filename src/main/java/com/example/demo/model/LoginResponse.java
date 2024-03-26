package com.example.demo.model;

public class LoginResponse {
    private String accessToken;

    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public static LoginResponseBuilder builder() {
        return new LoginResponseBuilder();
    }

    @Override
    public String toString() {
        return "LoginResponse [accessToken=" + accessToken + "]";
    }

    public static class LoginResponseBuilder {
        private String accessToken;

        public LoginResponseBuilder accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public LoginResponse build() {
            return new LoginResponse(accessToken);
        }
    }
}
