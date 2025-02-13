SELECT
    t.Transacoes_id,
    t.Pix_id,
    t.Pagamento_id,
    t.Deposito_id,
    t.Saque_id,
    t.Extrato_id,
    c.Conta_id,
    c.Agencia,
    c.Numero_Conta
FROM
    Conta c
    INNER JOIN Transacoes_Conta tc ON c.Conta_id = tc.Contas_id
    INNER JOIN Transacoes t ON tc.Transacao_Id = t.Transacoes_id;
