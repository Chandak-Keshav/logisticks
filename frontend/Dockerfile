FROM node:18-alpine
WORKDIR /frontend
COPY package*.json ./
COPY . .
RUN npm install
EXPOSE 5173
CMD ["npm", "run", "dev"]

# Stage 2: Serve built react app with nginx
FROM nginx:1.21.1-alpine as production-stage

WORKDIR /usr/share/nginx/html

RUN rm -rf ./*

COPY --from=build-stage /app/dist .

# Add the Nginx configuration to handle client-side routing
COPY nginx.conf /etc/nginx/conf.d/default.conf

CMD ["nginx", "-g", "daemon off;"]
