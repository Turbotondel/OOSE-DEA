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
@WebServlet("/Dienstdelen")
public class DienstDelenPageController extends HttpServlet {

    @Inject
    private AbonnementModel abonnementModel = new AbonnementModel();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String abonneeNaam = request.getParameter("abonneenaam");
        String abonneeDelenNaam =request.getParameter("delenabonneenaam");
        String dienstNaam = request.getParameter("dienstnaam");
        try {
            abonnementModel.delenDienst(abonneeNaam,abonneeDelenNaam,dienstNaam);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("HomeView.jsp").forward(request, response);
    }

}
