package com.example.Controllers;

import org.springframework.context.annotation.Bean;

public class NBIOTFORM {
 private String deviceId;
 private PayLoadClass payload;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public PayLoadClass getPayload() {
        return payload;
    }

    public void setPayload(PayLoadClass payload) {
        this.payload = payload;
    }
}
