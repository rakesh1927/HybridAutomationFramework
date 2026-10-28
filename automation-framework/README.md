# Hybrid Automation Framework

A robust, scalable, and maintainable **Hybrid Test Automation Framework** built using Java, Selenium WebDriver, and TestNG. This framework leverages the Page Object Model (POM) design pattern alongside a Data-Driven approach to facilitate clean code structure and separation of test logic from test data.

## 🚀 Key Features
* **Hybrid Architecture:** Combines Data-Driven testing capabilities with structural design patterns.
* **Page Object Model (POM):** Enhances code reusability and minimizes test maintenance overhead.
* **Data-Driven Capabilities:** Externalizes test inputs from `testData/` directories to execute test cases across multiple variations.
* **Robust Reporting:** Generates an interactive execution summary saved directly as `report.html`.
* **Logging System:** Tracks execution steps and failures in real-time inside the `logs/` directory.
* **Automated Failure Capture:** Automatically captures runtime UI screenshots on test failures for fast debugging.

---

## 📁 Repository Structure

```text
HybridAutomationFramework/
├── src/test/              # Test scripts, Page Objects, Base utilities, and Listeners
├── testData/              # Test inputs (Excel/Properties/JSON configuration files)
├── testng.xml             # Test suite execution suite and parameter configurations
├── pom.xml                # Maven dependencies and build plugins lifecycle management
├── logs/                  # Application and framework execution logs
├── screenshots/           # Captured runtime browser screenshots on failure
└── report.html            # Consolidated HTML execution report
```

---

## 🛠 Prerequisites

Ensure you have the following installed on your machine before running the project:
* **Java Development Kit (JDK):** Version 11 or higher
* **Apache Maven:** Version 3.6+
* **IDE:** Eclipse IDE (with TestNG M2E plugin) or IntelliJ IDEA
* **Browsers:** Google Chrome / Mozilla Firefox / Microsoft Edge

---

## 💻 Getting Started & Installation

### 1. Clone the Repository
```bash
git clone https://github.com
cd HybridAutomationFramework
```

### 2. Import into Eclipse IDE
1. Open Eclipse and go to `File` ➔ `Import...`
2. Select `Maven` ➔ `Existing Maven Projects` and click **Next**.
3. Browse and select the cloned root directory (`HybridAutomationFramework`).
4. Click **Finish** and wait for Maven to download the mandatory project dependencies.

---

## 🏃 Execution Modes

### Option 1: Execute via TestNG XML Suite (Recommended for Local Dev)
Right-click on the `testng.xml` file at the project root ➔ **Run As** ➔ **TestNG Suite**.

### Option 2: Execute via Maven Command Line (Recommended for CI/CD Pipelines)
Open your terminal or command prompt at the root directory and run:
```bash
mvn clean test
```

---

## 📊 Reports & Logs
* **Execution Summary:** Open `report.html` in any web browser to view standard test summaries, pass/fail status, and stack traces.
* **Visual Debugging:** Any test failure automatically triggers a UI screenshot capture, instantly populated inside the `screenshots/` directory.
* **Execution Logs:** Detailed operational logs can be checked inside the `logs/` directory for historical or deep-dive analysis.

---

## 🧹 Best Practices Implemented
* **Ignoring Build Outputs:** Temporary folders like `/target/` and `/test-output/` are explicitly added to `.gitignore` to keep the code footprint lightweight.
* **Dynamic Driver Allocation:** Easily switch browsers via runtime properties or TestNG suite xml variables.
