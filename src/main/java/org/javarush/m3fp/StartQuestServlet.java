package org.javarush.m3fp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/start")
public class StartQuestServlet extends HttpServlet {
    public Integer totalQuestions = 1;
    public String nickname = "Incognito";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        nickname(request);


        String s = request.getParameter("question");
        System.out.println("question: " + s);
        request.setAttribute("counter", totalQuestions);
        totalQuestions++;

        Questions questions = new Questions();
        request.setAttribute("question", questions.questions1);

        if (request.getParameter("question") != null) {
            if (request.getParameter("question").equals("1")) {
                request.setAttribute("question", new Questions().questions1);

            }
        }

        request.setAttribute("requestAttribute", "Request attribute test");

        session.setAttribute("sessionAttribute", "Session attribute test");


        getServletContext().getRequestDispatcher("/startQuest.jsp").forward(request, response);
    }
    public void nickname(HttpServletRequest request){
        if (request.getParameter("nicName") != null) {
            nickname = request.getParameter("nicName");
        }
        request.setAttribute("nicknames", nickname);
    }
}



