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
    public Integer totalQuestions = 0;
    public Integer amountGames = 0;
    public String nickname = "Incognito";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        nickname(request);


        System.out.println("answer: " + request.getParameter("answer"));



        request.setAttribute("counter", totalQuestions);



        Questions questions = new Questions();
        request.setAttribute("question", questions.questions1);
        request.setAttribute("answer1", questions.answer1);
        session.setAttribute("answer2", questions.answer2);

        if (request.getParameter("answer") != null) {
            String ansverRequest = request.getParameter("answer");
            if (ansverRequest.equals("1") && totalQuestions == 1) {
                request.setAttribute("question", questions.questions2);
                request.setAttribute("answer1", questions.answer3);
                session.setAttribute("answer2", questions.answer4);
                totalQuestions++;
            } else if (ansverRequest.equals("1") && totalQuestions == 2) {
                request.setAttribute("question", questions.questions3);
                request.setAttribute("answer1", questions.answer5);
                session.setAttribute("answer2", questions.answer6);
                totalQuestions++;
            }
        }
        if (totalQuestions==0) {
            totalQuestions++;
            amountGames++;
        }
        request.setAttribute("amountGames", amountGames);


        getServletContext().getRequestDispatcher("/startQuest.jsp").forward(request, response);
    }
    public void nickname(HttpServletRequest request){
        if (request.getParameter("nicName") != null) {
            nickname = request.getParameter("nicName");
        }
        request.setAttribute("nicknames", nickname);
    }

}





