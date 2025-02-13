# Usa uma imagem base do Node.js
FROM node:14-alpine

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia os arquivos de código do Angular para dentro do container
COPY ./frontend /app

# Instala as dependências do Angular
RUN npm install

# Compila o projeto Angular
RUN npm run build --prod

# Usa uma imagem base do Nginx para servir a aplicação Angular
FROM nginx:alpine
COPY --from=0 /app/dist/InternBank /usr/share/nginx/html

# Expõe a porta 4200
EXPOSE 4200

# Comando para iniciar o servidor Nginx
CMD ["nginx", "-g", "daemon off;"]
