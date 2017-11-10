git pull
docker-compose -f docker-compose-prod.yml rm -s -f cloud-nginx redmine
docker-compose -f docker-compose-prod.yml up -d cloud-nginx redmine
docker-compose -f docker-compose-prod.yml logs -f redmine