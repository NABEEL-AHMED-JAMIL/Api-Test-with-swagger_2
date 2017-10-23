package com.example.demo.util.common;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nabeel on 9/24/2017.
 */
@Component
public class DeviceProvider {

    public Device getCurrentDevice(HttpServletRequest request) {
        return DeviceUtils.getCurrentDevice(request);
    }
}
