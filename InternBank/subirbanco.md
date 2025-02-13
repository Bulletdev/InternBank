Ativar a Conexão TCP/IP manualmente:

Abra um prompt de comando com privilégios de administrador.

Navegue até o diretório do SQL Server (normalmente algo como C:\Program Files\Microsoft SQL Server\MSSQLXX.YY\MSSQL\Binn).

Use o comando SQLCMD para acessar a instância do SQL Server.

````shell
sqlcmd -S localhost -U seu_usuario -P sua_senha
````

Habilitar TCP/IP via script T-SQL:

Uma vez conectado, você pode usar o seguinte script T-SQL para habilitar TCP/IP:

````SQL

-- Habilitar TCP/IP
EXEC xp_instance_regwrite
  N'HKEY_LOCAL_MACHINE',
  N'Software\Microsoft\Microsoft SQL Server\MSSQLServer\SuperSocketNetLib\Tcp',
  N'Enabled',
  REG_DWORD,
  1
GO
  
-- Definir a porta TCP/IP

EXEC xp_instance_regwrite
  N'HKEY_LOCAL_MACHINE',
  N'Software\Microsoft\Microsoft SQL Server\MSSQLServer\SuperSocketNetLib\Tcp\IPAll',
  N'TcpPort',
  REG_SZ,
  N'1433'
GO
````

Configurar o Firewall:

Abra o prompt de comando com privilégios de administrador.

Adicione uma regra de firewall para a porta 1433:

````shell
netsh advfirewall firewall add rule name="SQL Server" dir=in action=allow protocol=TCP localport=1433
````

Reiniciar o serviço do SQL Server:

No prompt de comando, use o seguinte comando para reiniciar o serviço do SQL Server:

````shell
net stop MSSQLSERVER
net start MSSQLSERVER
````