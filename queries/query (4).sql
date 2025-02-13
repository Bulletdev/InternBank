SELECT
    s.Saldo_id,
    s.Visualizacao AS Saldo,
    c.Conta_id,
    c.Agencia,
    c.Numero_Conta,
    u.Nome AS Titular
FROM
    Saldo s
    INNER JOIN Conta c ON s.Conta_id = c.Conta_id
    INNER JOIN Usuario u ON c.Usuario_id = u.Usuario_id;
