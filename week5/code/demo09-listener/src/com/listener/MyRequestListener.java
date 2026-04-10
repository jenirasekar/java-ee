package com.listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyRequestListener implements ServletRequestListener, ServletRequestAttributeListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request scope has been initialized");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request scope has been destroyed");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        ServletContext req = srae.getServletRequest().getServletContext();

        String key = srae.getName();

        Object value = srae.getValue();

        System.out.println(req.hashCode() + " request scope added " + key + ": " + value);
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        ServletContext req = srae.getServletContext();

        String key = srae.getName();

        Object value = srae.getValue();

        System.out.println(req.hashCode() + " request scope removed " + key + ": " + value);
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        ServletContext req = srae.getServletRequest().getServletContext();

        String key = srae.getName();

        Object value = srae.getValue();

        Object newValue = req.getAttribute(key);

        System.out.println(req.hashCode() + " request scope changed " + key + ": " + value + " to: " + newValue);
    }
}
