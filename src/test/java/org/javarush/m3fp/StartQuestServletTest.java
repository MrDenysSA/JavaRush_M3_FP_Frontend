package org.javarush.m3fp;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StartQuestServletTest {
    public StartQuestServlet startQuestServlet = new StartQuestServlet();
    public Questions questions = new Questions();
    @Mock
    HttpServletRequest request = mock();
    @Mock
    HttpServletResponse response = mock();

    @BeforeEach
    public void init() {
        request.setAttribute("nicName", null);
        request.setAttribute("answer", null);
    }

    @ParameterizedTest
    @CsvSource({"1", "2", "1000", "-122", "0", "@", "Max", "String", "-2.25"})
    void nickname(String value) {
        doReturn(value).when(request).getParameter("nicName");
        startQuestServlet.nickname(request);

        assertEquals(value, startQuestServlet.nickname);
    }

    @Test
    void nicknameNull() {
        startQuestServlet.nickname(request);
        assertEquals("Incognito", startQuestServlet.nickname);
    }

    @ParameterizedTest
    @CsvSource({"1,-1, 0",
            "1, 0, 1",
            "1, 1, 2",
            "1, 2, 3",
            "1, 3, 4",
            "2, 0, 5",
            "2, 1, 6",
            "2, 2, 7",
            "2, 4, 8",
            "2, 5, 9",})
    void logicGame(String answerVaue, Integer totalQuestionsValue, int count) throws ServletException, IOException {
        HttpSession sess = mock(HttpSession.class);
        doReturn(sess).when(request).getSession(true);
        doReturn(answerVaue).when(request).getParameter("answer");
        startQuestServlet.totalQuestions = totalQuestionsValue;
        startQuestServlet.logicGame(request, response);

        if (count == 0) {
            verify(request, atLeastOnce()).setAttribute("question", questions.questions1);
        } else if (count == 1) {
            verify(request, atLeastOnce()).setAttribute("question", questions.questions2);
        } else if (count == 2) {
            verify(request, atLeastOnce()).setAttribute("question", questions.questions3);
        } else if (count == 3) {
            verify(request, atLeastOnce()).setAttribute("question", questions.winGame);
        } else if (count == 4) {
            verify(request, atLeastOnce()).setAttribute("question", questions.questions1);
        } else if (count == 5) {
            verify(request, atLeastOnce()).setAttribute("question", questions.lostGame);
        } else if (count == 6) {
            verify(request, atLeastOnce()).setAttribute("question", questions.lostGame);
        } else if (count == 7) {
            verify(request, atLeastOnce()).setAttribute("question", questions.lostGame);
        } else if (count == 8) {
            verify(request, atLeastOnce()).setAttribute("question", questions.lostGame);
        } else if (count == 9) {
            verify(request, atLeastOnce()).setAttribute("question", questions.lostGame);
        }
    }

    @Test
    void logicGameNull() throws ServletException, IOException {
        HttpSession sess = mock(HttpSession.class);
        doReturn(sess).when(request).getSession(true);
        doReturn(null).when(request).getParameter("answer");
        startQuestServlet.logicGame(request, response);

        verify(request, atLeastOnce()).setAttribute("question", questions.questions1);
    }
}