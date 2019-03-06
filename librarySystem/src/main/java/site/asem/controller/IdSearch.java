package site.asem.controller;

import site.asem.model.Registry;
import site.asem.model.entity.Publication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IdSearch extends HttpServlet {
    private Registry registry = Registry.getInstance();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Publication p = registry.getByID(id);
        req.setAttribute("publication", p);
        req.getRequestDispatcher("/jsp/publication.jsp").forward(req, resp);
    }
}
