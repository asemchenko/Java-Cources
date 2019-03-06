package site.asem.controller;

import site.asem.model.Registry;
import site.asem.model.relevance.RelevanceFunction;
import site.asem.model.relevance.RelevanceFunctionBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchServlet extends HttpServlet {
    private Registry registry = Registry.getInstance();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // generating relevance function
        RelevanceFunctionBuilder builder = new RelevanceFunctionBuilder(req);
        RelevanceFunction f = builder.getFunction();
        // getting relevant publications
        var publications = registry.getSortedByRelevance(f);
        // passing sorted publications to jsp
        req.setAttribute("publications", publications);
        req.getRequestDispatcher("jsp/searchResults.jsp").forward(req, resp);
    }
}
