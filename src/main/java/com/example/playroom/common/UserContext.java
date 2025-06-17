package com.example.playroom.common;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class UserContext {

    public static String getUserCode() {
        // TODO:認証用のオブジェクトまだ作れていないため、SpringセキュリティのDTOを使用
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails userDetails) {
            return userDetails.getUsername();
        } else {
            return authentication != null ? authentication.getPrincipal().toString() : null;
        }
    }
    
}
