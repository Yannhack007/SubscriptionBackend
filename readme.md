 ---

### **README.md**

````markdown
# Payment Module - Spring Boot 3.3 with ScyllaDB

## Prérequis
- **Java JDK 21**
- **Maven 3.9+**
- **ScyllaDB 5.1+**
- **Docker et Docker Compose** (pour ScyllaDB)

---

## Installation

1. **Cloner le dépôt :**

```bash
git clone https://github.com/Yannhack007/SubscriptionBackend.git
cd SubscriptionBackend
````

2. **Démarrer ScyllaDB :**

```bash
cd docker/
docker-compose up -d
```

3. **Installer les dépendances :**

```bash
mvn clean install
```

4. **Configurer l'API de paiement**

Ouvrez le fichier /configurations/WebClientConfig et renseignez l'url de l'API et la cle

5. **Lancer l'application :**

```bash
mvn spring-boot:run
```

L'application sera accessible sur `http://localhost:5000`.

---

## Endpoints API

* `Swagger` - `http://localhost:5000/swagger-ui/index.html#/`

---

## Structure du projet

* `src/main/java/com/example/payment` - Code source principal
* `src/main/resources/application.yml` - Configuration Spring Boot
* `docker-compose.yml` - Déploiement de ScyllaDB
* `scylla.cql` - Schema de base de donnees Scylla

---

## Tests

Pour exécuter les tests unitaires :

```bash
mvn test
```

---

## Auteur

* Nom : Yann BIKO
* Email : yannbiko@gmail.com
* Github : Yannhack007
