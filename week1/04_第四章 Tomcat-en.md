## 2.2 Tomcat Server

### 2.2.1 Introduction

<img src="images/1681452377469.png" alt="1681452377469" style="zoom:50%;" />

> Tomcat is a core project in the Jakarta project of the Apache Software Foundation, jointly developed by Apache, Sun, and other companies and individuals.  The latest Servlet and JSP specifications are always reflected in Tomcat. Because Tomcat is technologically advanced, has stable performance, and is free, it is deeply loved by Java enthusiasts and recognized by some software developers, making it a relatively popular Web application server at present.

### 2.2.2 Installation

> Versions

- Versions: 8.0 and 9.0 are widely used in enterprises. Currently, the relatively new officially released version is Tomcat 10.0, while Tomcat 11 is still in the testing phase.
- The correspondence between JAVA EE versions and Servlet version numbers: [Jakarta EE Releases](https://jakarta.ee/release/)

| **Servlet** Version | EE Version       |
| :------------------------ | ---------------- |
| 6.1                       | Jakarta EE ?     |
| 6.0                       | Jakarta EE 10    |
| 5.0                       | Jakarta EE 9/9.1 |
| 4.0                       | JAVA EE 8        |
| 3.1                       | JAVA EE 7        |
| 3.1                       | JAVA EE 7        |
| 3.0                       | JAVAEE 6         |

+ Correspondence between Tomcat versions and Servlet versions

| **Servlet** Version | **Tomcat** Version | **JDK** Version                   |
| :------------------------ | :----------------------- | :-------------------------------------- |
| 6.1                       | 11.0.x                   | 17 and later                            |
| 6.0                       | 10.1.x                   | 11 and later                            |
| 5.0                       | 10.0.x (superseded)      | 8 and later                             |
| 4.0                       | 9.0.x                    | 8 and later                             |
| 3.1                       | 8.5.x                    | 7 and later                             |
| 3.1                       | 8.0.x (superseded)       | 7 and later                             |
| 3.0                       | 7.0.x (archived)         | 6 and later (7 and later for WebSocket) |

> Download

- Official Tomcat website: [http://tomcat.apache.org/](http://tomcat.apache.org/ "http://tomcat.apache.org/")
- Installer version: Requires installation, generally not considered for use.
- Unzipped version: Used directly after unzipping, which is the version we use.

<img src="images/1681442513261.png" alt="1681442513261" style="zoom:67%;" />

> Installation

1. Install the JDK correctly and configure JAVA_HOME (taking JDK 17 as an example; you can download various versions of the JDK at https://injdk.cn).

<img src="images/1681442778503.png" alt="1681442778503" style="zoom:67%;" />

2. Unzip Tomcat to a directory without Chinese characters or spaces.

<img src="images/1681442849940.png" alt="1681442849940" style="zoom: 80%;" />

3. Click bin/startup.bat to start.

<img src="images/1681442946756.png" alt="1681442946756" style="zoom: 80%;" />

<img src="images/1681442998407.png" alt="1681442998407" style="zoom: 60%;" />

4. Open a browser and enter http://localhost:8080 to test the access.

<img src="images/1681443038911.png" alt="1681443038911"  />

5. Close the window directly or run bin/shutdown.bat to shut down Tomcat.

<img src="images/1681442946756.png" alt="1681442946756" style="zoom: 80%;" />

6. Handle the issue of Chinese garbled characters in the DOS window logs: Modify conf/logging.properties and change all UTF-8 to GBK.

<img src="images/1681443124315.png" alt="1681443124315" style="zoom: 80%;" />

+ Before modification

<img src="images/1681443202115.png" alt="1681443202115" style="zoom:50%;" />

+ After modification

<img src="images/1681443273573.png" alt="1681443273573" style="zoom:50%;" />

+ Restart and test

<img src="images/1681443314432.png" alt="1681443314432"  />

## 2.3 Tomcat Directory and Testing

> The directory C:\Program4java\apache-tomcat-10.1.7 directly contains Tomcat's bin directory, conf directory, etc., and we call it the **Tomcat installation directory or root directory**.

- bin: This directory stores binary executable files. If it is the installer version, there will be two exe files in this directory: tomcat10.exe and tomcat10w.exe. The former starts Tomcat in the console, while the latter pops up a GUI window to start Tomcat. If it is the unzipped version, there will be startup.bat and shutdown.bat files. startup.bat is used to start Tomcat, but you need to configure the JAVA_HOME environment variable first to start it, and shutdown.bat is used to stop Tomcat.
- conf: This is a very, very important directory, containing the four most important files:

  - **server.xml: Configures the entire server information. For example, modifying the port number. The default port number for HTTP requests is: 8080**
  - tomcat-users.xml: The file that stores Tomcat users. This saves the Tomcat usernames and passwords, as well as the users' role information. You can add Tomcat users according to the commented information in this file, and then you can enter the Tomcat Manager page from the Tomcat homepage.

    ```html
    <tomcat-users xmlns="[http://tomcat.apache.org/xml](http://tomcat.apache.org/xml)"
                  xmlns:xsi="[http://www.w3.org/2001/XMLSchema-instance](http://www.w3.org/2001/XMLSchema-instance)"
                  xsi:schemaLocation="[http://tomcat.apache.org/xml](http://tomcat.apache.org/xml) tomcat-users.xsd"
                  version="1.0">  
        <role rolename="admin-gui"/>
        <role rolename="admin-script"/>
        <role rolename="manager-gui"/>
        <role rolename="manager-script"/>
        <role rolename="manager-jmx"/>
        <role rolename="manager-status"/>
        <user   username="admin" 
                password="admin" 
                roles="admin-gui,admin-script,manager-gui,manager-script,manager-jmx,manager-status"
        />
    </tomcat-users>
    ```

    web.xml: The deployment descriptor file. Many MIME types, i.e., document types, are registered in this file. These MIME types are used to specify the document type between the client and the server. For instance, if a user requests an HTML webpage, the server will tell the client browser that the responding document is of type text/html, which is a MIME type. The client browser knows how to handle it through this MIME type. Naturally, it displays the HTML file in the browser. But if the server's response is an exe file, the browser cannot display it; instead, it should pop up a download window. MIME is used to describe what type of content the document is!
  - context.xml: Unified configuration for all applications; usually we will not configure it.
- lib: Tomcat's class library, which contains a bunch of jar files. If you need to add jar files that Tomcat depends on, you can put them in this directory. Of course, you can also put the jar files that your application depends on in this directory. All projects can share the jars in this directory, but then your application cannot share the jar packages in this directory when placed under other Tomcats. Therefore, it is recommended to only put the jar packages required by Tomcat in this directory.
- logs: This directory contains log files that record Tomcat startup and shutdown information. If there is an error when starting Tomcat, the exception will also be recorded in the log files.
- temp: Stores Tomcat's temporary files. The contents of this directory can be deleted after stopping Tomcat!
- **webapps: The directory for storing web projects, where each folder represents a project.** If there are already directories under this directory, they are all projects included with Tomcat. Among them, ROOT is a special project. When you access http://127.0.0.1:8080 in the address bar without specifying a project directory, it corresponds to the ROOT project. Accessing http://localhost:8080/examples enters the example project, where "examples" is the project name, i.e., the folder name.
- work: Files generated during runtime; the final executed files are here. Generated by projects in webapps! You can delete the contents of this directory, and the work directory will be regenerated upon the next run. When a client user accesses a JSP file, Tomcat will generate a Java file via JSP, then compile the Java file into a class file, and both the generated java and class files will be stored in this directory.
- LICENSE: License.
- NOTICE: Instruction file.

## 2.4 Standard Structure of a WEB Project

> A standard WEB project structure that can be used for deployment is as follows:

![1681453620343](images/1681453620343.png)

+ app: The root directory of this application.
  + static: Non-essential directory, conventionally named. Static resources (css, js, img) are generally placed here.
  + WEB-INF: Essential directory, MUST be named WEB-INF. It is a protected resource directory that cannot be accessed directly by the browser via URL.
    + classes: Essential directory. Source code and configuration files under src will be in this directory after compilation. If there is no source code in the web project, this directory will not appear.
    + lib: Essential directory. The jars depended on by the project will appear in this directory after compilation. If the web project does not depend on any jars, this directory will not appear.
    + web.xml: Essential file. The basic configuration file for the web project. Newer versions may not have this file, but it is still needed during the learning process.
  + index.html: Non-essential file. index.html/index.htm/index.jsp serve as the default welcome page.

> Correspondence between URL components and resources in the project

![1681456161723](images/1681456161723.png)

## 2.5 Methods for Deploying WEB Projects

> Method 1: Place the compiled project directly into the webapps directory (already demonstrated).

> Method 2: Package the compiled project into a war file and place it in the webapps directory. Tomcat will automatically unzip the war file after startup (this is actually the same as the first method).

> Method 3: The project can be placed in other directories outside of webapps, and the actual disk path of the app can be pointed to via a configuration file in Tomcat.

+ Prepare an app in a custom directory on the disk.

![1681456447284](images/1681456447284.png)

+ Create a Catalina/localhost directory under Tomcat's conf directory, and prepare an app.xml file in that directory.

```xml
<Context path="/app" docBase="D:\mywebapps\app" />

```

* Just start Tomcat and access it for testing.

## 2.6 Developing, Deploying, and Running WEB Projects in IDEA

### 2.6.1 Associating IDEA with Local Tomcat

> You can set up the local Tomcat before creating a project, or you can find the settings while a project is open.

<img src="images/1681457611053.png" alt="1681457611053" style="zoom: 80%;" />

> Go to Build, Execution, Deployment -> Application Servers, and find the + sign.

<img src="images/1681457711914.png" alt="1681457711914"  />

> Select Tomcat Server.

<img src="images/1681457800708.png" alt="1681457800708"  />

> Select the Tomcat installation directory.

<img src="images/1681457879937.png" alt="1681457879937" style="zoom:50%;" />

> Click OK.

<img src="images/1681457921094.png" alt="1681457921094"  />

> Association complete.

<img src="images/1681458031957.png" alt="1681458031957" style="zoom:65%;" />

### 2.6.2 Creating a Web Project in IDEA

> It is recommended to create an empty project first, so that multiple modules can exist simultaneously under one empty project, saving you from switching back and forth between previous projects later. Of course, you can also skip this step and directly create a web project.

<img src="images/1681458194939.png" alt="1681458194939" style="zoom: 60%;" />

<img src="images/1681458273381.png" alt="1681458273381" style="zoom: 60%;" />

> Check the project's SDK, syntax version, and the output directory after project compilation.

<img src="images/1681458343921.png" alt="1681458343921" style="zoom:50%;" />

<img src="images/1681458393871.png" alt="1681458393871" style="zoom: 55%;" />

> First, create a standard JAVA project.

<img src="images/1681458485837.png" alt="1681458485837" style="zoom:63%;" />

> Check whether the various pieces of information are filled in incorrectly.

<img src="images/1681458599545.png" alt="1681458599545" style="zoom:60%;" />

> After creation, add Tomcat dependencies to the project.

<img src="images/1681458857830.png" alt="1681458857830" style="zoom: 67%;" />

<img src="images/1681458897017.png" alt="1681458897017" style="zoom: 95%;" />

<img src="images/1681458939400.png" alt="1681458939400" style="zoom:70%;" />

> Select modules and add Framework Support.

<img src="images/1681458672258.png" alt="1681458672258" style="zoom: 80%;" />

> Select Web Application. Pay attention to the Version, and check "Create web.xml".

<img src="images/1681459007273.png" alt="1681459007273" style="zoom:80%;" />

> Delete index.jsp and replace it with index.html.

<img src="images/1681459147133.png" alt="1681459147133" style="zoom: 67%;" />

> Handling configuration files

* Create a resources directory under the project, specifically for storing configuration files (putting them all under src is also fine; storing them separately minimizes the clutter caused by centralized file storage).
* Mark the directory as a Resources Root. If not marked, this directory will not participate in the compilation.

<img src="images/1681461443278.png" alt="1681461443278" style="zoom:67%;" />

* After marking, the display effect is as follows:

<img src="images/1681461513406.png" alt="1681461513406"  />

> Handling jar package dependencies

* Create a lib directory under WEB-INF.
* It MUST be under WEB-INF, and the directory MUST be named lib!!!
* Copy the jar files into the lib directory.
* Add the lib directory as a dependency for the current project; this can be uniformly resolved with Maven later.

<img src="images/1681461846178.png" alt="1681461846178" style="zoom:67%;" />

* For the environment level, it is recommended to select the module level to reduce the impact on other projects; the name can be left blank.
* View the environmental dependencies of the current project.

<img src="images/1681462179671.png" alt="1681462179671" style="zoom:50%;" />

* In this location, you can remove dependencies via the minus (-) sign.

<img src="images/1681462247973.png" alt="1681462247973" style="zoom:85%;" />

### 2.6.3 Deploying and Running Web Projects in IDEA

> Check if IDEA recognizes the modules as web projects and if there is a configuration to build the project into a release structure.

* This means checking whether the web directory under the project directory has a special identification mark.
* Also, check if there is a corresponding _war_exploded under artifacts. If not, click the + sign to add it.

<img src="images/1681462584524.png" alt="1681462584524" style="zoom: 50%;" />

> Click the downward arrow to reveal the Edit Configurations option.

<img src="images/1681462645070.png" alt="1681462645070" style="zoom:100%;" />

> The Run/Debug Configurations interface will appear.

<img src="images/1681462710108.png" alt="1681462710108" style="zoom: 67%;" />

> Click the + sign to add a local Tomcat server.

<img src="images/1681462754191.png" alt="1681462754191" style="zoom:67%;" />

> Because IDEA is only associated with one Tomcat, there is only one Tomcat option available in the red section.

<img src="images/1681462798933.png" alt="1681462798933" style="zoom: 65%;" />

> Select Deployment, and use the + sign to add the artifact to be deployed into Tomcat.

<img src="images/1681463011546.png" alt="1681463011546" style="zoom:65%;" />

> The applicationContext contains the default project context path, which is the path you need to enter in the URL. You can define it yourself here; it can be different from the project name, or left empty, but the / must be retained. We will temporarily use the default one here.

<img src="images/1681463049807.png" alt="1681463049807" style="zoom:80%;" />

> After clicking Apply, return to the Server tab. "After Launch" configures whether to automatically open the browser and enter the URL address by default after a successful startup. "HTTP port" is the port number currently occupied by the HTTP connector.

<img src="images/1681463212587.png" alt="1681463212587" style="zoom:80%;" />

> After clicking OK, start the project and test the access.

* The green arrow indicates normal run mode.
* The "little bug" indicates debug run mode.

<img src="images/1681463386274.png" alt="1681463386274" style="zoom:80%;" />

* After clicking, check if there are any exceptions in the log status.

<img src="images/1681463361795.png" alt="1681463361795" style="zoom:100%;" />

* The browser automatically opens and accesses the index.html welcome page.

<img src="images/1681520068936.png" alt="1681520068936" style="zoom:50%;" />

> The directory correspondence between the project structure and the deployable project structure

> The Principle Behind Deploying and Running Projects in IDEA

* IDEA does not directly place the compiled project into Tomcat's webapps folder.
* Based on the associated Tomcat, IDEA creates a Tomcat replica and deploys the project into this replica.
* IDEA's Tomcat replica is located in C:\Users\Current_User\AppData\Local\JetBrains\IntelliJIdea2022.2\tomcat.
* IDEA's Tomcat replica is not a complete Tomcat; the replica only prepares configuration files related to the current project.
* When IDEA starts Tomcat, it runs the local Tomcat program according to the configuration files in the Tomcat replica.
* IDEA's Tomcat replica deploys the project through the conf/Catalina/localhost/*.xml configuration files.

```

Would you like me to translate any other tutorials related to Tomcat, Java EE, or web deployment?

```
