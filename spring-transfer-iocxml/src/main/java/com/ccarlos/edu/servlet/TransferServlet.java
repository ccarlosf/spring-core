package com.ccarlos.edu.servlet;

import com.ccarlos.edu.factory.BeanFactory;
import com.ccarlos.edu.factory.ProxyFactory;
import com.ccarlos.edu.pojo.Result;
import com.ccarlos.edu.service.TransferService;
import com.ccarlos.edu.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "transferServlet", urlPatterns = "/transferServlet")
public class TransferServlet extends HttpServlet {
    // 1. 实例化service层对象
//    private TransferService transferService = new TransferServiceImpl();

//    private TransferService transferService = (TransferService) BeanFactory.getBean("transferService");

    // 从⼯⼚获取委托对象（委托对象是增强了事务控制的功能）
    // ⾸先从BeanFactory获取到proxyFactory代理⼯⼚的实例化对象
//    private ProxyFactory proxyFactory = (ProxyFactory)
//            BeanFactory.getBean("proxyFactory");
//    private TransferService transferService = (TransferService)
//            proxyFactory.getJdkProxy(BeanFactory.getBean("transferService"));

    // 首先从BeanFactory获取到proxyFactory代理工厂的实例化对象
    private ProxyFactory proxyFactory = (ProxyFactory) BeanFactory.getBean("proxyFactory");
    private TransferService transferService = (TransferService) proxyFactory.getJdkProxy(BeanFactory.getBean("transferService")) ;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse
            resp) throws ServletException, IOException {
        // 设置请求体的字符编码
        req.setCharacterEncoding("UTF-8");
        String fromCardNo = req.getParameter("fromCardNo");
        String toCardNo = req.getParameter("toCardNo");
        String moneyStr = req.getParameter("money");
        int money = Integer.parseInt(moneyStr);
        Result result = new Result();
        try {
            // 2. 调⽤service层⽅法
            transferService.transfer(fromCardNo, toCardNo, money);
            result.setStatus("200");
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus("201");
            result.setMessage(e.toString());
        }
        // 响应
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().print(JsonUtils.object2Json(result));
    }
}