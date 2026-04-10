package com.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Called when a new session is created
        ServletContext session = se.getSession().getServletContext();

        System.out.println(session.hashCode() + " session scope has been initialized");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Called when a session is destroyed
        ServletContext session = se.getSession().getServletContext();

        System.out.println(session.hashCode() + " session scope has been destroyed");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        // Called when an attribute is added to the session
        ServletContext session = se.getSession().getServletContext();

        String key = se.getName();

        Object value = se.getValue();

        System.out.println(session.hashCode() + " session scope added " + key + ": " + value);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        // Called when an attribute is removed from the session
        ServletContext session = se.getSession().getServletContext();

        String key = se.getName();

        Object value = se.getValue();

        System.out.println(session.hashCode() + " session scope removed " + key + ": " + value);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        // Called when an attribute in the session is replaced
        ServletContext session = se.getSession().getServletContext();

        String key = se.getName();

        Object value = se.getValue();

        Object newValue = session.getAttribute(key);

        System.out.println(session.hashCode() + " session scope changed " + key + ": " + value + " to " + newValue);
    }



//    // Get the current session
//    HttpSession session = req.getSession();
//
//// Invalidate the session manually
//// After this, the session becomes invalid and its stored data is removed
//session.invalidate();
}
