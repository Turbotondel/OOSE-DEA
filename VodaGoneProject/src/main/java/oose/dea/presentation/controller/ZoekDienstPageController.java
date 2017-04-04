package oose.dea.presentation.controller;

import oose.dea.presentation.model.DienstModel;

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
@WebServlet("/Zoekdienst")
public class ZoekDienstPageController extends HttpServlet{

    @Inject
    private DienstModel dienstModel = new DienstModel();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String dienstopzoeken = request.getParameter("dienstopzoeken");

        if(dienstopzoeken == null){
            try {
                dienstModel.findAll();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("DienstUitproberen.jsp").forward(request, response);
        } else {
            try {
                dienstModel.findByTitle(dienstopzoeken);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            request.getRequestDispatcher("DienstUitproberen.jsp").forward(request, response);
        }
    }
}
