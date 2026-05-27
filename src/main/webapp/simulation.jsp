<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Simulação de Financiamento</title>

    <style>

        body {
            margin: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #ffffff;
            font-family: Arial, sans-serif;
        }

        #simulation {
            display: flex;
            flex-direction: column;
            gap: 14px;
            width: 380px;
            padding: 40px;
            background: linear-gradient(180deg, #dbeafe, #bfdbfe);
            border-radius: 22px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.15);
        }

        #simulation h1 {
            text-align: center;
            margin-bottom: 10px;
            color: #1e3a5f;
        }

        #simulation label {
            font-weight: bold;
            color: #1e3a5f;
        }

        #simulation input {
            padding: 12px;
            border: none;
            border-radius: 10px;
            font-size: 15px;
            outline: none;
        }

        #simulation input[type="submit"] {
            margin-top: 10px;
            background-color: #2563eb;
            color: white;
            cursor: pointer;
            transition: 0.2s;
        }

        #simulation input[type="submit"]:hover {
            background-color: #1d4ed8;
            transform: scale(1.03);
        }

    </style>
</head>

<body>

<form id="simulation" action="simulationServlet" method="POST">

    <h1>Simulação</h1>

    <label>Valor do veículo</label>
    <input type="number" min="0" placeholder="R$ 0,00" name="valorVeiculo">

    <label>Valor da entrada</label>
    <input type="number" min="0" placeholder="R$ 0,00" name="valorEntrada">

    <label>Taxa de juros (%)</label>
    <input type="number" min="0" step="0.01" placeholder="0.00" name="taxaJuros">

    <label>Prazo do financiamento (meses)</label>
    <input type="number" min="0" placeholder="Ex: 48" name="prazoFinanc">

    <input type="submit" min="0" value="Simular">

</form>

</body>
</html>