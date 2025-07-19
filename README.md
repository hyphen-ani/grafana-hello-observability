# Spring Boot Metrics with Prometheus & Grafana

This project is a hands-on demonstration of integrating **Spring Boot**, **Prometheus**, and **Grafana** to build a robust monitoring and observability pipeline. It is part of the **"Hello World, Hello Observability"** event held on **20th July 2025**, where developers will explore how to expose, scrape, and visualize metrics from a Spring Boot application.

---

## Tech Stack

- 🚀 **Spring Boot 3.x**
- 🔨 **Maven**
- 🌐 **Spring Web**
- 📈 **Spring Boot Actuator**
- 📊 **Micrometer**
- 🗃️ **Prometheus**
- 📉 **Grafana**
- 🐳 **Docker** (for Prometheus & Grafana setup)

---

## Features

- Expose default system and application metrics using Spring Boot Actuator
- Collect metrics using Prometheus via `/actuator/prometheus`
- Real-time visualization of application performance using Grafana dashboards
- Support for custom user-defined metrics using Micrometer annotations
- Pre-configured Docker Compose setup for Prometheus + Grafana integration

---

## Configuration URLs

| Tool        | URL                          | Notes              |
|-------------|------------------------------|---------------------|
| 🔍 Prometheus | [http://localhost:9090](http://localhost:9090) | Prometheus UI |
| 📊 Grafana    | [http://localhost:3000](http://localhost:3000) | Grafana UI   |
| 🔐 Login      | Username: `admin` <br> Password: `admin` | Default credentials |
| 📡 Metrics Endpoint | [http://localhost:8080/actuator/prometheus](http://localhost:8080/actuator/prometheus) | Spring Boot metrics |

---

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/hyphen-ani/grafana-hello-observability.git
```

### 2. Run the Spring Boot Application

```bash
./mvnw spring-boot:run
```

App is available at: 

```bash
http://localhost:8080
```

### 3. Launch Prometheus & Grafana

```bash
docker-compose up -d
```

This will spin up:
* Prometheus at <u>http://localhost:9090</u>
* Grafana at <u>http://localhost:3000</u>

Grafana Dashboard Setup
1. Open http://localhost:3000
2. Log in with:
	* Username: admin
	* Password: admin
3. Add Prometheus as a data source:
	* URL: http://prometheus:9090
4. Import a dashboard:
	* Go to “Dashboards” → “Import”
	* Use dashboard ID: 4701 (Micrometer JVM metrics)
5. Start exploring key metrics:
	* JVM Memory usage
	* HTTP request counts
	* Response times
	* Uptime, Threads, Garbage Collection stats

### Prometheus Configuration (prometheus.yml)

```bash
scrape_configs:
  - job_name: "AniAppMetrics"
    metrics_path: '/actuator/prometheus'
    scrape_interval: 5s
    static_configs:
      - targets: ['host.docker.internal:8080']
        labels:
          application: 'spring-prometheus'
```

✅ Use host.docker.internal for Mac/Windows. For Linux, use the host IP or configure the bridge network accordingly.

### Purpose of This Project

This project was built to:
* Understand the basics of application observability
* Learn how to expose metrics from a Java app using Micrometer
* Use Prometheus to scrape and collect data
* Build beautiful, real-time dashboards using Grafana

### Credits

This project was created for the “Hello World, Hello Observability” workshop held on 20th July 2025, organized by the community to promote cloud-native observability practices.

### Contact

For questions, feedback, or collaboration, feel free to connect:

**Shivam Nandy**
* Email: shivam.nandy@wisemelon.ai
* GitHub: github.com/hyphen-ani

Happy Monitoring!
