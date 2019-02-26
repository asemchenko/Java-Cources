package site.asem;

import static org.apache.commons.text.StringEscapeUtils.escapeHtml4;

import site.asem.model.Model;
import site.asem.model.entities.NicknameDuplicateException;
import site.asem.model.entities.PhoneBook;
import site.asem.model.entities.Record;
import site.asem.view.RegexConstants;
import site.asem.view.TextConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;


public class SimpleServlet extends HttpServlet {
    private static Model model = new PhoneBook();
    private TextConstants textConstants = TextConstants.getForLocale(Locale.ENGLISH);
    private RegexConstants regexConstants = RegexConstants.getForLocale(Locale.ENGLISH);
//    static {
//        Record r = new Record();
//        r.setFirstName("asem 777");
//        r.setNickname();
//        try {
//            model.addRecord(r);
//        } catch (NicknameDuplicateException e) {
//            // do nothing
//        }
//    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        prepareRequest(req);

        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Record record = getRecord(req);
        try {
            model.addRecord(record);
        } catch (NicknameDuplicateException e) {
            prepareRequest(req);
            req.setAttribute("message", textConstants.SORRY_OCCUPIED_NICKNAME);
            req.setAttribute("recordFormValue", e.getRecord());
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }
        prepareRequest(req);
        req.setAttribute("message", "Successfully added");
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
    private Record getRecord(HttpServletRequest req) {
        Record record = new Record();
        record.setFirstName(escapeHtml4(req.getParameter("firstName")));
        record.setLastName(escapeHtml4(req.getParameter("lastName")));
        record.setPatronymic(escapeHtml4(req.getParameter("patronymic")));
        record.setMobilePhone(escapeHtml4(req.getParameter("mobilePhone")));
        String nickname = escapeHtml4(req.getParameter("nickname"));
        record.setNickname(nickname);
        return record;
    }

    private void prepareRequest(HttpServletRequest req) {
        req.setAttribute("lang", textConstants);
        req.setAttribute("recordRegex", regexConstants);
        req.setAttribute("records", model.getAllRecords());
    }
}
