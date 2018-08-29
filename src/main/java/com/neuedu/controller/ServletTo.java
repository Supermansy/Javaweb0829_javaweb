package com.neuedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Hello")
public class ServletTo extends HttpServlet {

    public ServletTo(){
        //当服务器启动后当有Servlet容器时不用创建，当没有时就创建
        //一般情况下当陈序中有销毁时，服务器再次启动时需要再次创建Servlet容器
        System.out.println(" ========创建Servlet容器======== ");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println(" ========初始化======== ");
    }
     //doPost和doGet是两种不同的请求方式，当get请求时调用doGet，当post请求时则调用doPost
    //
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("========doPost请求=======");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("========doGet请求=======");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + "   " +password);

    }

    @Override
    public void destroy() {
        super.destroy();
        //当服务器关闭之后销毁
        System.out.println("=========销毁======== ");
    }
}
