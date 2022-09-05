# MovieSearch
Movie Search Project


# 环境搭建：（本来采用docker-composed 方式搭建，想了想就一个 mysql 依赖，没太大必要，如果后续有多个依赖，可以加入）
# 安装Docker:
https://docs.docker.com/desktop/install/mac-install/

# 运行docker
docker run -p 63306:3306 -e MYSQL_ROOT_PASSWORD=123456 --name mysql_movie -d mysql

# login Mysql:
mysql -h 127.0.0.1 -P 63306 -u root -p123456

create database movie;

# Login（现在还是假登陆）
http://localhost:8080/hello ,跳转登陆页 U: botong P: 123456




