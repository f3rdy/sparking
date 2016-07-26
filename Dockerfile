FROM java:8

MAINTAINER Fred Thiele <ferdy_news@gmx.de>


COPY . /tmp

RUN 	cd /tmp && \
	./gradlew distZip && \
	unzip build/distributions/*.zip -d /opt && \
	rm -rf /tmp/* 

CMD ["/opt/sparking-1.0-SNAPSHOT/bin/sparking"]
