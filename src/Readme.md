# 🏫 **School Library Borrowing System**

## 📘 **Description**
A simple Java console application that simulates a **school library**.  
It allows **students** and **teachers** to borrow and return books,  
and helps the librarian keep track of **who borrowed what** using a `Map`.

---

## 🧩 **Class Overview**
| Class | Description |
|--------|--------------|
| **Book** | Represents a book with title, author, and availability status. |
| **Member** | Abstract base class for all library members. |
| **Student** | Subclass of `Member` representing a student. |
| **Teacher** | Subclass of `Member` representing a teacher. |
| **Loan** | Represents a borrowing record that HAS-A `Book` and a `Member`. |
| **LibrarySystem (Main)** | Contains the main method and manages borrowing logic. |

---

## ⚙️ **Core Concepts**
- **Inheritance** → `Student` and `Teacher` inherit from `Member`.
- **Composition (HAS-A)** → `Loan` object HAS-A `Book` and a `Member`.
- **Collections** → Uses a `Map<Member, List<Book>>` to track all borrowings.
- **Encapsulation** → Class fields are private with getters and setters.

---

## 🚀 **Features**
✅ Borrow books  
✅ Return borrowed books  
✅ Show who borrowed what  
✅ Display overdue books

---

---

## 🧑‍💻 **Developed By**

> **Name:** Sajid Hussain  
> **Project:** 📚 *School Library Borrowing System (Java OOP Project)*  
> **Language:** ☕ Java

---

