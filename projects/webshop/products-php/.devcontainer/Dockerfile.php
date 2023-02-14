FROM php:fpm
RUN apt update && apt install -y libpq-dev
RUN docker-php-ext-install pdo pdo_pgsql