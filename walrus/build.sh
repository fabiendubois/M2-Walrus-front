docker run -u $(id -u) --rm -v "$PWD":/app trion/ng-cli npm install
docker run -u $(id -u) --rm -v "$PWD":/app trion/ng-cli ng build --prod