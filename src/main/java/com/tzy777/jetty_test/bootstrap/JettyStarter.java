package com.tzy777.jetty_test.bootstrap;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyStarter {
    public static void main(String[] args) throws Exception{
        String port = System.getProperty("jetty.port");
        String contextPath = System.getProperty("jetty.web.context");
        if (port == null) {
            System.out.println("please set your app port by vm args -Djetty.port=8088");
            return;
        }
        if (contextPath == null) {
            System.out.println("please set your app context by vm args -Djetty.web.context=/jetty_test");
        }
        //服务器的监听接口
        Server server =new Server(Integer.valueOf(port));
        // 关联一个已经存在的上下文
        WebAppContext context = new WebAppContext();
        // 设置描述符位置
        context.setDescriptor("src/main/webapp/WEB-INF/web.xml");
        // 设置Web内容上下文路径
        context.setResourceBase("src/main/webapp");
        // 关闭文件保护 容器启动后可修改静态文件
        context.setInitParameter("org.eclipse.jetty.servlet.Default.useFileMappedBuffer", "false");
        // 启动 jsp jstl 解析
        Configuration.ClassList classlist = Configuration.ClassList.setServerDefault(server);
        classlist.addBefore(
                "org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
                "org.eclipse.jetty.annotations.AnnotationConfiguration");
        context.setAttribute(
                "org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",
                ".*/[^/]*servlet-api-[^/]*\\.jar$|.*/javax.servlet.jsp.jstl-.*\\.jar$|.*/[^/]*taglibs.*\\.jar$");
        // 设置上下文路径
        context.setContextPath(contextPath);
        context.setParentLoaderPriority(true);
        server.setHandler(context);
        // 启动
        server.start();
        server.join();
    }
}
