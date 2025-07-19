# Spring Boot Metrics with Prometheus & Grafana

This project is a demonstration of integrating **Spring Boot**, **Prometheus**, and **Grafana** to build a robust monitoring and observability pipeline. It's intended for use during the hello world and hello observability, showcasing how to expose application metrics and visualize them using Grafana.

## Tech Stack

- **Spring Boot 3.x**
- **Maven**
- **Spring Web**
- **Spring Boot Actuator**
- **Micrometer**
- **Prometheus**
- **Grafana**
- **Docker** (for local Prometheus & Grafana setup)

---

## Features

- Expose default application metrics using Spring Boot Actuator
- Collect and scrape metrics using Prometheus
- Visualize metrics in real-time using Grafana dashboards
- Custom metrics endpoint examples
- Docker Compose setup for Prometheus + Grafana stack

---

## Configurations

	•	Prometheus: http://localhost:9090
	•	Grafana: http://localhost:3000
	•	Username: admin
	•	Password: admin

## Access Metrics
	•	Actuator metrics endpoint: http://localhost:8080/actuator/prometheus

## Grafana Dashboards
	1.	Open Grafana http://localhost:3000
	2.	Add Prometheus as a data source (URL: http://prometheus:9090)
	3.	Import dashboard ID 4701 from Grafana.com (Micrometer metrics dashboard)
	4.	Explore metrics like JVM memory, request count, response time, etc.

### Purpose of This Project

This project is designed for educational and demonstration purposes to understand:
	•	Basics of app instrumentation
	•	Observability using Micrometer
	•	Real-time monitoring with Prometheus and Grafana

### Credits

This setup is part of the hello world, hello observability organized on 20th July 2025.

### Contact

For questions or suggestions, feel free to reach out to:

Shivam Nandy
Email: shivam.nandy@wisemelon.ai
GitHub: github.com/hyphen-ani
