package com.example.playroom.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.thymeleaf.util.StringUtils;

import java.util.regex.Pattern;

public class PageTrackingInterceptor implements HandlerInterceptor {
    // 除外するパスのパターン
    private static final Pattern EXCLUDED_PATHS = Pattern.compile(".*(\\.(css|js|png|jpg|jpeg|gif|svg|ico|woff|woff2|ttf|eot|map))$");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HttpSession session = request.getSession();
        String currentUrl = request.getRequestURL().toString();

        if (!currentUrl.contains("/back") && !EXCLUDED_PATHS.matcher(currentUrl).matches()) {
            String referer = request.getHeader("Referer");

            String prevPage = !StringUtils.isEmpty(referer) ? referer : (String) session.getAttribute("lastPage");

            if (prevPage != null && !prevPage.equals(currentUrl)) {
                session.setAttribute("lastPage", prevPage);
            }
        }

        return true;
    }
}


