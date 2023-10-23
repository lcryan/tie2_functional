# tie2_functional


# Setting up Docker in project 

to get started you need to start the database

```bash
docker compose up -d
```

top stop the database you should run

```bash
docker compose down
```

# Security requirements : 

```bash 
#CORS
Binnen de applicatie wordt rekening gehouden met CORS
De applicatie moet draaien met toegang tot de endpoints voor de juiste gebruikers geven
Belangrijk
#USER ROLES - ADMIN - USER 
De applicatie moet geen toegang geven zonder authenticatie en identificatie;
De applicatie heeft een user(employee)- en een admin-rol;
De applicatie moet draaien met toegang tot de endpoints voor de juiste gebruikers;
Los alle comments op uit de toegevoegde klassen, na het kopiëren en plakken van die klassen.
