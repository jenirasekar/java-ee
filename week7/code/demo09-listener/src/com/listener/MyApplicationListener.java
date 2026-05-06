package com.listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyApplicationListener implements ServletContextListener, ServletContextAttributeListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Get the ServletContext object (application scope)
        ServletContext application = sce.getServletContext();

        // This method is called when the application scope is initialized
        System.out.println(application.hashCode() + " application scope has been initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Get the ServletContext object (application scope)
        ServletContext application = sce.getServletContext();

        // This method is called when the application scope is destroyed
        System.out.println(application.hashCode() + " application scope has been destroyed");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        // Get the application scope object
        ServletContext application = scae.getServletContext();

        // Get the attribute name
        String key = scae.getName();

        // Get the removed value
        Object value = scae.getValue();

        // Print the removal log
        System.out.println(application.hashCode() + " application scope added " + key + ": " + value);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        // Get the application scope object
        ServletContext application = scae.getServletContext();

        // Get the attribute name
        String key = scae.getName();

        // Get the removed value
        Object value = scae.getValue();

        // Print the removal log
        System.out.println(application.hashCode() + " application scope removed " + key + ": " + value);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        // Get the application scope object
        ServletContext application = scae.getServletContext();

        // Get the attribute name
        String key = scae.getName();

        // Get the old value
        Object value = scae.getValue();

        // Get the new value currently stored in the application scope
        Object newValue = application.getAttribute(key);

        // Print the replacement log
        System.out.println(application.hashCode() + " application scope changed " + key + ": " + value + " to: " + newValue);
    }


}