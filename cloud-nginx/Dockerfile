FROM nginx:1.13.3

COPY ./cert/* /etc/nginx/
COPY nginx.conf /etc/nginx/nginx.conf
COPY default.conf /etc/nginx/conf.d/default.conf
COPY ngrok.conf /etc/nginx/conf.d/ngrok.conf
COPY ./static /usr/share/nginx/html/static
COPY ./index.html /usr/share/nginx/html