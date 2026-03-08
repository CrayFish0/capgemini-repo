# Day 45 – SDLC: Waterfall and Agile Models

## What is SDLC?

The **Software Development Life Cycle (SDLC)** is a structured process for planning,
creating, testing, and delivering software. It defines a series of phases that guide a
team from an initial idea through to a deployed, maintained product.

---

## Phases Common to All SDLC Models

| # | Phase | Description |
|---|-------|-------------|
| 1 | **Requirement Analysis** | Gather and document what the system must do. |
| 2 | **System Design** | Architect the solution (HLD → LLD). |
| 3 | **Implementation** | Write and integrate the code. |
| 4 | **Testing** | Verify correctness and quality. |
| 5 | **Deployment** | Release to production. |
| 6 | **Maintenance** | Bug fixes and enhancements post-release. |

---

## Model 1: Waterfall

### Overview
The **Waterfall model** is a **linear, sequential** approach.  
Each phase must be **fully completed** before the next begins.  
Going back to a previous phase is expensive and discouraged.

```
Requirements → Design → Implementation → Testing → Deployment → Maintenance
```

### Characteristics
- Rigid, document-driven process.
- Requirements are frozen early.
- No working software until late in the cycle.
- Deliverables and timelines are easy to plan upfront.

### Example: Hospital Management System
```
1. Requirement Analysis
   - Stakeholders (doctors, admin) provide written requirements.
   - BRS (Business Requirement Spec) document is signed off.

2. System Design
   - Database schema: patients, appointments, billing tables.
   - UML class and sequence diagrams created.

3. Implementation
   - Java Spring Boot backend, MySQL database coded to spec.

4. Testing
   - QA team runs unit, integration, and UAT test cycles
     against the frozen requirement document.

5. Deployment
   - Single go-live event; entire system deployed at once.

6. Maintenance
   - Patch releases as bugs surface post-launch.
```

### When to Use Waterfall
- Requirements are **clear, stable, and well-documented**.
- Short projects with a fixed scope (government contracts, embedded systems).
- Regulatory environments that demand audit trails.

### Advantages vs Disadvantages

| ✅ Advantages | ❌ Disadvantages |
|---|---|
| Simple to understand and manage | No flexibility once requirements are frozen |
| Clear milestones and deliverables | Customer sees working software very late |
| Easy to estimate cost and schedule | Defects found late are expensive to fix |
| Extensive documentation | Not suitable for complex or evolving projects |

---

## Model 2: Agile

### Overview
**Agile** is an **iterative, incremental** approach.  
Work is divided into short cycles called **sprints** (typically 2–4 weeks).  
Working software is delivered at the end of every sprint.  
Requirements can change between sprints based on feedback.

```
Sprint 1 → Sprint 2 → Sprint 3 → ... → Final Release
 (plan→build→test→review)  (repeat)
```

### Core Values (Agile Manifesto, 2001)
1. **Individuals and interactions** over processes and tools.
2. **Working software** over comprehensive documentation.
3. **Customer collaboration** over contract negotiation.
4. **Responding to change** over following a plan.

### Key Practices
| Practice | Description |
|---|---|
| **Sprint** | Time-boxed iteration (2–4 weeks) producing a shippable increment. |
| **Daily Stand-up** | 15-minute team sync: what did I do, what will I do, any blockers? |
| **Sprint Planning** | Team selects items from the backlog and commits to the sprint goal. |
| **Sprint Review** | Demo working software to stakeholders; collect feedback. |
| **Sprint Retrospective** | Team reflects on process improvements for the next sprint. |
| **Product Backlog** | Prioritised list of all features/requirements (User Stories). |
| **User Story** | Requirement from the end-user perspective: "As a [user], I want [feature] so that [benefit]." |

### Example: E-Commerce Application
```
Sprint 1 (2 weeks)
  User Stories:
  - As a customer, I want to register/login.
  - As a customer, I want to browse product categories.
  Sprint Review: stakeholders demo the login + catalogue pages.

Sprint 2 (2 weeks)
  User Stories:
  - As a customer, I want to add items to a cart.
  - As a customer, I want to view my cart total.
  Feedback: stakeholders request a "save for later" feature → added to backlog.

Sprint 3 (2 weeks)
  User Stories:
  - As a customer, I want to checkout and pay (payment gateway).
  - As a customer, I want to receive an order confirmation email.

Sprint 4 (2 weeks)
  User Stories:
  - As an admin, I want to view and manage orders.
  - "Save for later" feature (carried over from Sprint 1 feedback).

Final Release: production deployment of all sprint increments.
```

### When to Use Agile
- Requirements are **unclear, changing, or evolving**.
- Long-running projects where early feedback is valuable.
- Cross-functional teams that can co-locate or collaborate closely.
- Startups, product companies, mobile/web applications.

### Advantages vs Disadvantages

| ✅ Advantages | ❌ Disadvantages |
|---|---|
| Working software delivered every sprint | Hard to predict final cost/timeline upfront |
| Changes welcomed throughout the project | Requires active, continuous customer involvement |
| Early identification and resolution of risks | Less documentation can cause knowledge gaps |
| High transparency and team collaboration | Scope creep risk if backlog is not managed |
| Customer satisfaction through frequent demos | Not ideal for fixed-price / fixed-scope contracts |

---

## Waterfall vs Agile — Side-by-Side Comparison

| Criteria | Waterfall | Agile |
|---|---|---|
| **Approach** | Linear, sequential | Iterative, incremental |
| **Flexibility** | Low — changes are costly | High — changes welcomed |
| **Customer Involvement** | Mainly at start and end | Continuous throughout |
| **Delivery** | Single release at project end | Working software every sprint |
| **Documentation** | Heavy | Light (just enough) |
| **Testing** | After implementation phase | Continuous, within each sprint |
| **Best For** | Stable, well-defined requirements | Dynamic, evolving requirements |
| **Risk** | High (defects found late) | Low (issues caught early) |
| **Team Size** | Can be large, siloed | Small, cross-functional |

---

## Other Noteworthy SDLC Models (Brief)

| Model | Key Idea |
|---|---|
| **V-Model** | Each development phase has a corresponding test phase (Verification & Validation). |
| **Spiral** | Risk-driven; each spiral loop = plan → risk analysis → build → evaluate. |
| **RAD (Rapid Application Development)** | Prototype-heavy; focuses on rapid delivery using reusable components. |
| **DevOps** | Extends Agile by integrating Ops; CI/CD pipelines enable continuous deployment. |
| **Scrum** | Most popular Agile framework; uses sprints, Product Owner, Scrum Master roles. |
| **Kanban** | Visual board (To Do / In Progress / Done); continuous flow, no fixed sprints. |
