package quotes_servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;


public class QuotesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=cp1251");
        ArrayList<String> quotes = new ArrayList<String>();
        FileInputStream file = new FileInputStream("D:\\Program Files (x86)\\Git\\WebServlet\\Quotes.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(file));
        String tmp;
        while ((tmp = br.readLine()) != null){
            quotes.add(tmp);
        }
        Random rand = new Random();
        int randomIndex = rand.nextInt(quotes.size());
        String randomElement = quotes.get(randomIndex);
        PrintWriter writer = resp.getWriter();
        writer.println(randomElement);

    }
}
