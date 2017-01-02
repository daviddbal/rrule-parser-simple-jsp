

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jfxtras.icalendarfx.properties.component.recurrence.RecurrenceRule;
import jfxtras.icalendarfx.properties.component.time.DateTimeStart;

/**
 * Servlet implementation
 */
@WebServlet("/RRuleServlet")
public class RRuleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String rruleContent = request.getParameter("rruleContent");
		request.getParameterMap().entrySet().forEach(System.out::println);
		int limit = Integer.parseInt(request.getParameter("limit"));
		DateTimeStart dateTimeStart = DateTimeStart.parse(request.getParameter("dateTimeStart"));
		
		RecurrenceRule rrule = RecurrenceRule.parse(rruleContent);
		String rrules = rrule.getValue().streamRecurrences(dateTimeStart.getValue())
				.limit(limit)
				.map(t -> t.toString())
				.collect(Collectors.joining(System.lineSeparator()));
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print("Recurrence Series" + System.lineSeparator() + rrules);
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public RRuleServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

}