package oose.dea.presentation.controller;

import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Singleton
@WebServlet("/Startdienstdelen")
public class StartDienstDelenPageController extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dienstnaam = request.getParameter("dienstnaam");
        String abonneenaam = request.getParameter("abonneenaam");
        request.setAttribute("abonneenaam", abonneenaam);
        request.setAttribute("dienstnaam", dienstnaam);
        request.getRequestDispatcher("DienstDelen.jsp").forward(request, response);
    }
}
