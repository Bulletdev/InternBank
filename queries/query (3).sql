SELECT
    p.Pagamento_id,
    c.Conta_id,
    c.Usuario_id
FROM
    Pagamento p
    INNER JOIN Conta c ON p.Pagamento_id = c.Conta_id;
