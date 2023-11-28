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
        logicGame(request, response);

        request.setAttribute("counter", totalQuestions);
        request.setAttribute("amountGames", amountGames);

        getServletContext().getRequestDispatcher("/startQuest.jsp").forward(request, response);
    }

    public void nickname(HttpServletRequest request) {
        if (request.getParameter("nicName") != null) {
            nickname = request.getParameter("nicName");
        }
        request.setAttribute("nicknames", nickname);
    }

    public HttpServletRequest logicGame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String answerRequest = request.getParameter("answer");
        Questions questions = new Questions();


        if (answerRequest == null) {
            request.setAttribute("question", questions.questions1);
            request.setAttribute("answer1", questions.answer1);
            session.setAttribute("answer2", questions.answer2);
            totalQuestions = 0;
            return request;
        }

        if (request.getParameter("answer").equals("2") && totalQuestions == -1 ||
                request.getParameter("answer").equals("2") && totalQuestions == 3) {
            amountGames = 0;
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }

        totalQuestions++;

        if (answerRequest.equals("1") && totalQuestions < 1) {
            request.setAttribute("question", questions.questions1);
            request.setAttribute("answer1", questions.answer1);
            session.setAttribute("answer2", questions.answer2);
            amountGames++;

        } else if (answerRequest.equals("1") && totalQuestions == 1) {
            request.setAttribute("question", questions.questions2);
            request.setAttribute("answer1", questions.answer3);
            session.setAttribute("answer2", questions.answer4);

        } else if (answerRequest.equals("1") && totalQuestions == 2) {
            request.setAttribute("question", questions.questions3);
            request.setAttribute("answer1", questions.answer5);
            session.setAttribute("answer2", questions.answer6);

        } else if (answerRequest.equals("1") && totalQuestions == 3) {
            request.setAttribute("question", questions.winGame);
            request.setAttribute("answer1", questions.restert);
            session.setAttribute("answer2", questions.initialPage);

        } else if (answerRequest.equals("1") && totalQuestions == 4) {
            totalQuestions = -1;
            logicGame(request, response);

        } else if (answerRequest.equals("2") && totalQuestions > 0) {
            request.setAttribute("question", questions.lostGame);
            request.setAttribute("answer1", questions.restert);
            session.setAttribute("answer2", questions.initialPage);
            totalQuestions = -1;
        }
        return request;
    }
}





