mvn clean install
docker build . -t docker.atl-paas.net/mghiraldelli/aurora-migration:latest
docker push docker.atl-paas.net/mghiraldelli/aurora-migration:latest
