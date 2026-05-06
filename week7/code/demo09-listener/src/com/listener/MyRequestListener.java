package com.listener;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyRequestListener implements ServletRequestListener, ServletRequestAttributeListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
            }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {

    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
    }
}
