import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ClockInOut extends HttpServlet {
	User user = null;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		user = new User("matt", "9943");
		System.out.println("created user: matt pin: 9943");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Date date = new Date();
		String username = req.getParameter("user");
		String pinNumber = req.getParameter("pin");
		if (verifyUser( username.trim(), pinNumber.trim()) == true) {
			if (!user.isClockedIn()) {
				user.setClockedIn(true);
				System.out.println("user is clocked in at " + date);
			} else {
				user.setClockedIn(false);
				System.out.println(username + " is clocked out at " + date);
			}
		} else {
			System.out.println("not a valid user");
			System.out.println(username + "    " + pinNumber);
			
			
			
		}
		
		
		PrintWriter out = null;
		out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("RESULT");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("User: " + req.getParameter("user") + " @ " + date);
		out.println("</body>");
		out.println("</html>");
	}
	
	private boolean verifyUser(String username, String pin) {
		if (username.equals(user.getUsername())  && pin.equals(user.getPin())) {
			return true;
		} else {
			System.out.println("not verified");
			System.out.println("username from req = " + username);
			System.out.println("pin from req = " + pin);
			return false;
		}
	}

}
