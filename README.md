# OptiChoice

## Team Members
* **Aziel Gian L. Raymundo** - azielraymundo-ux
* **Jaime Lorenzo C. Tanciongco** - jaimetanciongo-blip

---

## Problem Statement
Everyone, regardless of age, suffers from decision fatigue, the deterioration in the quality of decisions made by an individual after a long session of decision-making. Many people end up struggling with important choices because they are faced with too many options, or they are not really sure what is the better one. When faced with too many choices, the human brain tends to either default to a baseline or “safe” but sub-optimal choice or experience decision paralysis.

**OptiChoice** helps users deal with that by giving users a straightforward and organized way to look at different alternatives tailored to the preferences, values, and personal goals of the users. It is a web application that will suggest what seems like the most suitable choice, based on what the user cares about most.

---

## Goals
* Help users make better and more confident decisions.
* Reduce stress and confusion when choosing between options.
* Provide a fair and organized way to compare choices.
* Save users time by giving clear recommendations based on their priorities.
* Foster clarity by reducing cognitive load by providing a structured visualization of trade-offs.

---

## Target Users
OptiChoice is tailored specifically for students and professionals who need to manage competing priorities across five specific life domains: **Academic**, **Professional**, **Financial**, **Health**, and **Social**.

---

## Brief Description
OptiChoice is a decision-support application that helps users evaluate options by applying custom importance levels to five specific life domains: **Academic** (i.e., courses, project ideas), **Professional** (i.e., internships, career paths), **Financial** (i.e., budgeting, purchase prioritization), **Health** (i.e., wellness habits, routine scheduling), and **Social** (i.e., extracurriculars, group projects). The system ranks user-provided options by calculating a total preference score, offering a bias-free recommendation based on the defined priorities of the user.

---

## Core OOP Concepts
* **Encapsulation:** The `Choice` class keeps the user-defined importance levels `private`, ensuring that the scoring logic remains protected from accidental modification.
* **Inheritance:** There is a base `Domain` class that provides shared functionality, which is inherited by the five specialized classes: `Academic`, `Professional`, `Financial`, `Health`, and `Social`.
* **Polymorphism:** The `calculateScore()` method and the `getQuestionnaire()` is defined in the base `Domain` class and overridden by each specific domain to handle category-specific weighting.
* **Abstraction:** The `DecisionEngine` provides a clean interface that allows users to input data and receive a ranked result without needing to interact with the underlying mathematical formulas.

---

## Initial Class Ideas
* **`Choice`:** This acts as a container that holds the different options a user wants to compare and stores the final calculated scores for each.
* **`Domain`:** This class defines the five categories. It requires every category to have its own unique questionnaire structure.
* **`Questionnaire`:** This is a base class that defines the structure for asking questions. Specialized child classes (like `FinancialQuestionnaire` or `HealthQuestionnaire`) provide specific prompts tailored to that domain.
* **`DecisionEngine`:** This collects the category-specific weights from the various questionnaires, runs the math to compare the options, and produces the final ranked list.
* **`User`:** Stores the user's account information, such as username, email, and password, for login and authentication.
* **`UserProfile`:** Stores the user's preferences, goals, and saved decision history.
* **`Criteria`:** It represents one evaluation criterion like Cost, Time, Effort, or Impact, and it also carries the importance level that’s assigned to it.
* **`DecisionArchive`:** Stores previous decisions so users can review and reflect on their past choices.
* **`AIAnalyzer`:** Talks with the AI model in order to sketch out the user’s possibilities, figure out the trade-offs, and then create more tailored suggestions that feel right for the user.

---

## User Stories
* **As a college student**, I want to compare different project topics so that I can choose the best one for my academic growth.
* **As a young professional**, I want to evaluate various internship offers so that I can pick the one that aligns with my career trajectory.
* **As a budget-conscious person**, I want to compare different investment options so that I can make a decision that matches my financial objectives.
* **As a beginner in the gym**, I want to compare different fitness routines so that I can choose the one that fits my daily schedule and health needs.
* **As a community member**, I want to evaluate extracurricular activities so that I can choose the one that fits my daily schedule and social goals.

---

## Core Features
* **User Login & Registration**
* **Decision Planning**
* **Custom Questionnaires**
* **Choice Ranking Matrix**
* **Comparison Dashboard**
* **Decision Archive**

---

## Screen Mockups
**User Log in Page**
<img width="1920" height="1080" alt="User Log in Page" src="https://github.com/user-attachments/assets/b49da898-01ef-4d00-9e4e-fdf15f0e51b6" />

**Sign Up Page**
<img width="1920" height="1080" alt="Sign Up Page" src="https://github.com/user-attachments/assets/a1781c32-a9e6-4abd-a358-68bd9db0148f" />

