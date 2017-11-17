FROM nginx:1.13.3

COPY ./cert/* /etc/nginx/
COPY nginx.conf /etc/nginx/nginx.conf
COPY ./conf/* /etc/nginx/conf.d/
COPY ./static /usr/share/nginx/html/static
COPY ./index.html /usr/share/nginx/html