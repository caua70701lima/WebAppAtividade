import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;

@WebServlet("/simulationServlet")
public class SimulationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Formula = valorParcela = valorFinanciado x taxaJuros(1+taxaJuros)^quantParcelas / (1+taxaJuros)^quantParcelas - 1
        double valorParcela = 0;

        String veiculo = req.getParameter("valorVeiculo");
        double valorVeiculo  = Double.parseDouble(veiculo);

        String entrada = req.getParameter("valorEntrada");
        double valorEntrada  = Double.parseDouble(entrada);

        String taxa = req.getParameter("taxaJuros");
        double taxaJuros = Double.parseDouble(taxa);

        String prazo = req.getParameter("prazoFinanc");
        double prazoFinanc = Double.parseDouble(prazo);

        double valorFinanc = valorVeiculo - valorEntrada;
        taxaJuros = taxaJuros / 100;

        valorParcela = valorFinanc * (taxaJuros * Math.pow((1+taxaJuros), prazoFinanc)) / (Math.pow((1+taxaJuros), prazoFinanc) - 1);

        DecimalFormat df = new DecimalFormat("0.00");
        String resultadoParcela = df.format(valorParcela);

        req.setAttribute("resultadoParcela", resultadoParcela);

        RequestDispatcher rd =
                req.getRequestDispatcher("/results.jsp");
        rd.forward(req, resp);

    }
}