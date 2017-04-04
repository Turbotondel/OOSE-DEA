package oose.dea.presentation.controller;

import oose.dea.presentation.model.AbonnementModel;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Singleton
@WebServlet("/Dienstuitproberen")
public class DienstUitproberenPageController extends HttpServlet {

    @Inject
    private AbonnementModel abonnementModel = new AbonnementModel();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String dienstnaam = request.getParameter("dienstnaam");
        String abonneenaam = "Ege Saraydar";
        try {
            abonnementModel.uitproberenAbonnement(dienstnaam,abonneenaam);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("HomeView.jsp").forward(request, response);
    }

}
