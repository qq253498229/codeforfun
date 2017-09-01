FROM nginx:1.13.3

COPY nginx.conf /etc/nginx/nginx.conf
COPY default.conf /etc/nginx/conf.d/default.conf
COPY ./static /usr/share/nginx/html
COPY ./index.html /usr/share/nginx/html