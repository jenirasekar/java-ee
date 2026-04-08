package com.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class MySessionListenter implements HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Called when a new session is created
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Called when a session is destroyed
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        // Called when an attribute is added to the session
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        // Called when an attribute is removed from the session
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        // Called when an attribute in the session is replaced
    }



//    // Get the current session
//    HttpSession session = req.getSession();
//
//// Invalidate the session manually
//// After this, the session becomes invalid and its stored data is removed
//session.invalidate();
}
