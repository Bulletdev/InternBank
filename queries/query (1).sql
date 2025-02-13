SELECT
    t.Transacoes_Id,
    d.Deposito_id,
    d.Entrada AS Deposito_Entrada,
    d.Saida AS Deposito_Saida
FROM
    Transacoes t
    INNER JOIN Transacoes_Conta tc ON tc.Transacao_Id = t.Transacoes_Id
    INNER JOIN Deposito d ON d.Deposito_id = t.Deposito_id;
