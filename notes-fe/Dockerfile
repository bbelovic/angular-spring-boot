FROM httpd:2.4
LABEL maintainer="bbelovic@gmail.com" \
      version="0.1"

RUN sed -i -e 's/#LoadModule rewrite_module modules\/mod_rewrite.so/LoadModule rewrite_module modules\/mod_rewrite.so/g' \
     -e '/Directory "\/usr\/local\/apache2\/htdocs"/a RewriteEngine On' \
     -e '/Directory "\/usr\/local\/apache2\/htdocs"/a RewriteCond %{DOCUMENT_ROOT}%{REQUEST_URI} -f [OR]' \
     -e '/Directory "\/usr\/local\/apache2\/htdocs"/a RewriteCond %{DOCUMENT_ROOT}%{REQUEST_URI} -d' \
     -e '/Directory "\/usr\/local\/apache2\/htdocs"/a RewriteRule ^ - [L]' \
     -e '/Directory "\/usr\/local\/apache2\/htdocs"/a RewriteRule ^ /index.html' /usr/local/apache2/conf/httpd.conf

RUN apt-get update && apt-get install -y curl dirmngr apt-transport-https lsb-release ca-certificates
RUN curl -sL https://deb.nodesource.com/setup_12.x | bash -
RUN apt-get install -y nodejs

COPY ["src/", "/opt/notes-fe/src/"]
COPY ["e2e/", "/opt/notes-fe/e2e/"]
COPY ["angular.json", "browserslist", "karma.conf.js", "package.json", "README.md", "tsconfig.app.json", "tsconfig.json", "tsconfig.spec.json", "tslint.json", "/opt/notes-fe/"]

WORKDIR /opt/notes-fe

RUN npm install
RUN npm install -g @angular/cli@9.0.2
RUN ng build

RUN pwd
RUN ls -al .
RUN ls -al dist

COPY ["dist/notes-fe/", "/usr/local/apache2/htdocs/"]