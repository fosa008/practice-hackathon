# AI-Empowered Operational Portal

An individual practical simulation full-stack application built to demonstrate industry-level AI integration, system data flows, and intelligent predictive data mining loops.

## 🚀 Live Demo URL
* **Deployment Platform:** Render / Local Host
* **Portal Link:** `http://localhost:8080/index.html`

---

## 📐 System Architecture & Data Flow

Below is the conceptual system flow mapping the 4 required quadrants. 

[Web Frontend UI: index.html]
│
│ (1) User submits unstructured text phrase via HTTP POST Request
▼
[Java Backend: TaskController.java]
│
├─► (2) DM / ML Heuristic Processing Layer (Extracts & evaluates value metrics)
│
│ (3) JPA Entity Object mapping
▼
[Relational Database: H2 Engine Instance]
│
└─► (4) Stores record persistent state -> Returns synced JSON payload -> UI updates live table

### The 4 Integrated Quadrants:
1. **Java Backend (Spring Boot):** Acts as the foundational RESTful API gateway, managing request-response routing lifecycle hooks, CORS control, and system controller definitions.
2. **Database (H2/Relational Schema):** Utilizes Hibernate JPA object-relational mapping to dynamically handle table definitions and persist operational feature properties under structured indices.
3. **Web Frontend (HTML5 / CSS3 / JavaScript):** A native dashboard interface deploying async-await browser `fetch()` streams to interface with the core backend seamlessly without requiring page reloads.
4. **DM / ML Module:** An intelligent processing routine implemented within the controller layer. It algorithmically mines unstructured transaction string tokens for systemic risk identifiers, computes numerical variance weights, and executes a classification mapping rule to return real-time system priorities.

---

## 🛠️ Tech Stack & Tools Used
* **Backend Framework:** Java Spring Boot 
* **Database Management:** Embedded H2 Relational Database Engine with Spring Data JPA
* **UI Engineering:** Vanilla JavaScript, HTML5 semantic layout, CSS3 grids
* **AI Collaborators & Tools:** Cursor, Gemini

---

## 📊 Features & Input Evaluation Scenarios

The integrated analytical loop evaluates system strings based on keyword extraction heuristics:

* **Scenario A (High-Risk Urgency):**
  * **Input:** `"System database is showing highly urgent latency profiles"`
  * **Mined Value Metric:** `92.50`
  * **Classification Decision Output:** `CRITICAL/HIGH` 🔴
* **Scenario B (Stable Routine):**
  * **Input:** `"Normal standard routine test execution success"`
  * **Mined Value Metric:** Low/Stabilized baseline
  * **Classification Decision Output:** `NORMAL / STABLE` 🟢

---

## 💻 Local Installation & Execution

To boot up the complete pipeline matrix environment locally:

1. **Clean build package artifacts:**
   ```bash
   mvn clean package -DskipTests