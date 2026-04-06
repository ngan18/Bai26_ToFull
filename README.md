# 🚀 Bai26_ToFull - Automation Testing Project

## 📌 Giới thiệu
Lesson Automation Testing sử dụng **Java + TestNG + Maven**.  
Project được xây dựng nhằm thực hành các kỹ thuật testing phổ biến như:
- Page Object Model (POM) with Parallel
- Data Driven Testing
- Đọc file Excel / Properties
- Logging (Log4j)
- Reporting (Allure Report, Extent Report)
- Screenshot khi test fail
- Listener

```
## 🧱 Cấu trúc project

Bai26_ToFull
│── src
│ ├── main
│ │ ├── java
│ │ └── resources
│ │ └── log4j2.properties
│ │
│ ├── test
│ │ ├── java
│ │ │ ├── Bai26_POMWithParallel
│ │ │ ├── Bai27_PropertiesFile
│ │ │ ├── Bai28_ExcelFile
│ │ │ ├── Bai29_DataProvider
│ │ │ ├── Bai30_screenshot
│ │ │ ├── Bai31_ITestListener
│ │ │ ├── Bai32_log4j
│ │ │ ├── Bai33_ExtentReport
│ │ │ ├── Bai34_AllureReport
│ │ │ ├── BT
│ │ │ ├── common
│ │ │ └── Listener
│ │ │
│ │ └── resources
│ │ ├── configs
│ │ │ └── config.properties
│ │ └── DataCRM
│
│── pom.xml
│── README.md
```

---

## ⚙️ Công nghệ sử dụng

- Java
- TestNG
- Maven
- Selenium WebDriver
- Log4j2
- Allure Report
- Extent Report

---

## 📂 Mô tả chi tiết các module

### 🔹 Bai26_POMWithParallel
- Áp dụng **Page Object Model**
- Chạy test song song (Parallel Execution)

---

### 🔹 Bai27_PropertiesFile
- Đọc dữ liệu từ file `.properties`
- Dùng để config môi trường test

---

### 🔹 Bai28_ExcelFile
- Đọc dữ liệu từ file Excel
- Phục vụ Data Driven Testing

---

### 🔹 Bai29_DataProvider
- Sử dụng `@DataProvider` trong TestNG
- Chạy test với nhiều bộ dữ liệu

---

### 🔹 Bai30_screenshot
- Chụp màn hình khi test fail
- Hỗ trợ debug lỗi nhanh

---

### 🔹 Bai31_ITestListener
- Custom Listener của TestNG
- Bắt sự kiện test: pass/fail/skip

---

### 🔹 Bai32_log4j
- Ghi log bằng Log4j2
- Theo dõi quá trình chạy test

---

### 🔹 Bai33_ExtentReport
- Tạo báo cáo test bằng Extent Report
- Giao diện đẹp, dễ đọc

---

### 🔹 Bai34_AllureReport
- Tích hợp Allure Report
- Report chuyên nghiệp, chi tiết

---

### 🔹 common
- Chứa các hàm dùng chung: BaseTest, Driver setup

---

### 🔹 Listener
- Chứa các class xử lý listener
- Kết nối với report, screenshot, Allure Listener

---

