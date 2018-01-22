package com.cisdi.security.securitydemo;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * project_name: securitydemo
 * package:      com.cisdi.security.securitydemo
 * describe:     TODO
 *
 * @author: yaozhiyang
 * creat_date:   2018/1/22
 * creat_time:   9:26
 **/
public class SecurityUtils {
    public static String getCurrentUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof SecurityProperties.User) {
            return ((SecurityProperties.User) authentication.getPrincipal()).getName();
        } else {
            return null;
        }
    }

}
