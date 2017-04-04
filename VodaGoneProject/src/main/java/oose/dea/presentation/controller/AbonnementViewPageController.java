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
@WebServlet("/Abonnement")
public class AbonnementViewPageController extends HttpServlet {

    @Inject
    private AbonnementModel abonnementModel = new AbonnementModel();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String abonnee = request.getParameter("abonnee");
        try {
            abonnementModel.getAllAbonnementen(abonnee);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("Abonnementen.jsp").forward(request, response);
    }

}
