package com.neuedu.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + "   " +password);

    }

    /**
     * 请求域 < 会话域 < 全局域
     * 每个请求域中值私有不共享
     * 而 会话域和全局域都需要自己手动创建.
     * 会话域的作用范围是一种浏览器，当服务器不同时，数据就不会共享 创建会话域HttpSession session = request.getSession();
     * 全局域是跨浏览器是最大的作用域 创建全局域  ServletContext selrvletContext = this.getServletContext();
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + "   " +password);
        System.out.println("========doGet请求=======");
        //赋属性值
        request.setAttribute("username","admin");
        //重定向
        response.sendRedirect("login.jsp");
        //重新分配
        request.getRequestDispatcher("login.jsp").forward(request,response);
        ServletContext selrvletContext = this.getServletContext();
        HttpSession session = request.getSession();
    }
    @Override
    public void destroy() {
        super.destroy();
        //当服务器关闭之后销毁 对servlet容器进行销毁
        System.out.println("=========销毁======== ");
    }
}
