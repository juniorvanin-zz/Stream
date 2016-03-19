include scripts/Makefile.web
include scripts/Makefile.db

at_database=vagrant ssh database -c
at_application=vagrant ssh application -c

build-war:
	gradle clean build

me-happy:
	vagrant up
	make db-migrate
	make db-seed
	make build-war
	make deploy-local