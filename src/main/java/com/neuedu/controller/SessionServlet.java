package com.neuedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建一个session跟踪
        HttpSession hsession =  request.getSession();
        //获取sessionID
        String sessionID = hsession.getId();
        //如果是第一次访问服务器会自动创建一个会话
        //第二次就不会创建了 因为在第一次访问时服务器端已经保存第一次sessionID
        //当距上一次访问时隔1800s后服务器自动销毁
        PrintWriter printWriter = response.getWriter();
        if (hsession.isNew()){
            printWriter.print("创建了一个会话");
        }
        printWriter.print("jsessionID"+sessionID);

    }
}
