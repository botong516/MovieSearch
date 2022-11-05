# create mysql
docker run -p 63306:3306 -e MYSQL_ROOT_PASSWORD=123456 --name mysql_movie -d mysql