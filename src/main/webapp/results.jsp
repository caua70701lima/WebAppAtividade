<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultado da Simulação</title>

    <style>

        body {
            margin: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #f4f6f9;
            font-family: Arial, sans-serif;
        }

        #result {
            width: 350px;
            padding: 40px;
            border-radius: 20px;
            background: linear-gradient(180deg, #dbeafe, #bfdbfe);
            box-shadow: 0 10px 25px rgba(0,0,0,0.15);
            text-align: center;
        }

        #result h1 {
            color: #24543a;
        }

        #result h2 {
            margin-top: 25px;
            color: #2f6b4b;
        }

    </style>
</head>

<body>

<div id="result">

    <h1>Resultado da Simulação</h1>

    <h2>
        Parcela mensal:
        R$ <%out.print(request.getAttribute("resultadoParcela"));%>
    </h2>

</div>

</body>
</html>