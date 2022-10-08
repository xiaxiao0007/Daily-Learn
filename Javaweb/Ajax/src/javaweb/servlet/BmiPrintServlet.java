package javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/bmiPrint")
public class BmiPrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 接收请求参数,接收表单中name的value
        String name = request.getParameter("name");
        String height = request.getParameter("h");
        String weight = request.getParameter("w");

        // 计算：bmi = 体重/身高的平方
        float h = Float.valueOf(height);
        float w = Float.valueOf(weight);
        float bmi = w / (h * h);

        //判断bmi的范围
        String msg = "";
        if (bmi <= 18.5){
            msg = "瘦";
        }else if (bmi > 18.5 && bmi <= 23.9){
            msg = "正常";
        }else if(bmi > 24 && bmi <= 27){
            msg = "胖";
        }else {
            msg = "很胖";
        }

        // System.out.println("msg="+msg);
        msg = "你好："+name+"你的bmi值是："+bmi+","+msg;

        // 使用HttpServletResponse输出数据
        response.setContentType("text/html;charset=utf-8");
        // 获取PrintWriter
        PrintWriter out = response.getWriter();
        // 输出数据
        out.print(msg);
        // 清空缓存
        out.flush();
        // 关闭close
        out.close();
    }
}
