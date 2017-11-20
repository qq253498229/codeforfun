FROM nginx:1.13.3

COPY ./cert/* /etc/nginx/
COPY nginx.conf /etc/nginx/nginx.conf
COPY ./conf/* /etc/nginx/conf.d/
COPY ./cloud-front/* /usr/share/nginx/html/cloud-front