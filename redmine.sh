git pull
docker-compose -f docker-compose-prod.yml rm -s -f cloud-nginx redmine-mariadb redmine
docker-compose -f docker-compose-prod.yml up -d cloud-nginx redmine-mariadb redmine