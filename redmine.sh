git pull
docker-compose -f docker-compose-prod.yml rm -s -f cloud-nginx mysql redmine
docker-compose -f docker-compose-prod.yml up -d cloud-nginx mysql redmine