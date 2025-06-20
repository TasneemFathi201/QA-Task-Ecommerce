# QA Task: E-commerce Website Testing with Selenium Automation

## Website Under Test
https://magento.softwaretestingboard.com/men/tops-men/hoodies-and-sweatshirts-men.html

## Project Name
Magento E-commerce Site Testing

## Testing Type
Functional Testing (Automated with Selenium WebDriver & TestNG)

## Tester
Tasneem Fathi

---

## Automated Test Cases

| Test Case ID | Objective                                  | Steps                                                                                      | Expected Result                                              | Actual Result                                                 | Status |
|--------------|--------------------------------------------|---------------------------------------------------------------------------------------------|--------------------------------------------------------------|---------------------------------------------------------------|--------|
| TC001        | Verify product search using a valid keyword | 1. Open website<br>2. Type “Red” in the search box<br>3. Press Enter                        | Products related to "Red" are displayed                      | Products or clothes containing red appeared                   | Pass   |
| TC002        | Add item to cart and complete checkout      | 1. Choose a product from search results<br>2. Select options (size, color)<br>3. Add to cart<br>4. Proceed to checkout | Confirmation page appears and prompts for Shipping Address | Cart updated, checkout proceeded, Shipping page displayed     | Pass   |
| TC003        | Test invalid product search input           | 1. Enter “123@” in search<br>2. Press Enter                                                 | “No results found” message appears                           | Message shown correctly                                        | Pass   |

---

## 🧾 Bug Reports

| ID     | Title                                               | Description                                                                                 | Expected Result                                       | Actual Result                                                         | Severity  | Priority | Steps                                                                                         | Screenshot                                                                                                       |
|--------|-----------------------------------------------------|---------------------------------------------------------------------------------------------|-------------------------------------------------------|------------------------------------------------------------------------|-----------|----------|-----------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|
| BR-001 | UI Bug in Home Page                                 | "Home Page" appears in large text as if it were placeholder UI                             | Homepage should not have placeholder text             | "Home Page" text is visibly displayed                                | Critical  | High     | 1. Open [Homepage](https://magento.softwaretestingboard.com/)                             | [View](https://drive.google.com/file/d/1ZlWs-4Qkotn1uHC5KzdFYF0pmrJZamn-/view?usp=drive_link)                   |
| BR-002 | No Indication Product is Out of Stock               | Some out-of-stock products are selectable without visible indicator                         | Show “Out of Stock” or disable add button             | Clicking "Add To Cart" shows product unavailable message              | Major     | Medium   | 1. Open site<br>2. Click a product like the bag<br>3. Click "Add to Cart"                   | [View](https://drive.google.com/file/d/1sN-tXWDz5AZesf6gnNYGUdcpP_htUGWY/view?usp=drive_link)                   |
| BR-003 | Missing Payment Method Options During Checkout      | Payment methods are not displayed on checkout page                                          | Payment options like Credit Card, PayPal should show | Payment section missing; user cannot complete checkout                | Critical  | High     | 1. Add item to cart<br>2. Proceed to checkout<br>3. Observe "Payment Method" section       | [View](https://drive.google.com/file/d/1sN-tXWDz5AZesf6gnNYGUdcpP_htUGWY/view?usp=drive_link)                   |

---

## Setup & Execution Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/TasneemFathi201/QA-Task-Ecommerce.git
   ```

2. Open in IntelliJ IDEA (or any IDE that supports Maven).

3. Ensure Maven dependencies are installed. The key dependencies include:
   - Selenium Java: 4.19.1
   - TestNG: 7.9.0
   - Java: 22

4. To run tests:
   - Open the class `SearchAndCheckoutTests.java`
   - Right-click and choose Run or Debug

---

## Notes

- All tests were conducted on the Magento demo website.
- Bugs discovered are documented manually and supported with screenshots.
