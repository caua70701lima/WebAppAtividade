import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

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


        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().println("""
        <!DOCTYPE html>
        <html>
        <head>
            <title>Resultado</title>
        </head>
        <body>

            <h1>Resultado da Simulação</h1>

            <h2>Valor da parcela: R$: """ + valorParcela + """
            </h2>

        </body>
        </html>
        """);

    }
}