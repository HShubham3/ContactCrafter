package com.scm.helpers;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

@Component
public class SessionHelper {

    public static void removeMassage() {
        try {
            System.out.println(
                    ",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
            HttpSession session = ((ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes())
                    .getRequest()
                    .getSession();

            session.removeAttribute("message");

        } catch (Exception e) {
            System.err.println("error in session helper=" + e.getMessage());
            e.printStackTrace();
        }
    }

}
