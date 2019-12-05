package myApp.controllers.action;

import myApp.controllers.form.MainPageForm;
import myApp.utils.HibernateUtil;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Select list of all books.
 */

public class MainPageAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        MainPageForm mainPageForm = (MainPageForm) form;
        final Session session = HibernateUtil.getHibernateSession();
        session.beginTransaction();
        List books = session.createQuery("from BooksEntity order by title " + mainPageForm.getSortParam()).list();
        request.setAttribute("books", books);
        session.close();
        return mapping.findForward("main");
    }
}
