FROM node:lts-alpine
RUN mkdir /app
ADD dist /app/dist
ADD node_modules /app/node_modules
EXPOSE 3000
ENTRYPOINT ["node", "/app/dist/main.js"]
