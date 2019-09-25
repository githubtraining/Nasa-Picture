# GitHub DevOps Certification Program

Potential Topics For Curriculum

## 1. DevOps Fundamentals

### 1.0 The History of DevOps

- Agile and The Toyota Way
- The Phoenix Project and IT Revolution
- The Rise of the DevOps Movement

### 1.1 Debunking DevOps Myths

- DevOps is Only for Startups
- DevOps Replaces Agile
- DevOps is Incompatible with ITIL
- DevOps is Incompatible with Security and Compliance
- DevOps means Eliminating IT Operations or "NoOps"
- DevOps is Just Infrastructure as Code
- DevOps is Only for Open Source Software

### 1.2 Why Organizations Need DevOps

- The Core Conflict Between Development and Operations
- The Human and Economic Costs of Legacy Methods
- The Ethics of DevOps
- The Business Value of DevOps
- How Improving Developer Productivity Improves the World

### 1.3 The Three Ways

- Deriving Behavior Patterns From Principles
- The Principles of Flow
  - How a Value Stream Affects Software Manufacturing?
  - Deployment Lead Times vs Processing Times
  - Aligning Delivery with Expectation : Percent Complete and Accurate
  - Transparency, Inspection and Adaption
  - Limiting Work in Process
  - Reducing Batch Sizes
  - Reducing the Number of Hand-Offs
  - Dealing With Constraints
  - Achieving Deployment on Demand
  - Managing Architectural Change
    - Loosely Coupled Architecture
  - Analyzing Workstreams and Eliminating Waste
  - Enabling Defect Remediation Early in the Lifecycle
- The Principles of Feedback
  - Monitoring, Alerts and Defect Detection
  - Swarming Problems
  - Pushing Quality Left to the Source
  - Amplifying Feedback Loops
  - Optimizing for Downstream Work Centers
- The Principles of Continual Learning and Experimentation
  - Establishing a High-Trust Culture
  - Enabling Organizational Learning and a Safety Culture
    - Pathological, Bureaucratic and Generative Cultures
    - Institutionalizing Continuous Improvement
  - Transforming Local Discoveries into Global Improvements
  - Establishing Resilience Patterns in Daily Processes
  - Managing Risk
  - Enabling a Learning Culture at the Executive Level

### 1.4 Establishing a DevOps Pipeline

- Value Stream Mapping
  - Identifying the Teams Supporting the Value Stream
  - Stakeholder Identification
    - Portfolio and Product Management
    - Product Owner
    - Quality Assurance
    - Security
    - Risk Management
    - Application Architecture
    - Enterprise Architecture
    - Enterprise Engineering
    - Operations
- Contrasting Waterfall with Iterative Methods
- Fast-And-Frequent Release Cadence
- Greenfield vs. Brownfield
- Systems of Record and Systems of Engagement
- Creating a Transformation Team
  - Develop Consensus and Goal Sharing
  - Keep Improvements and Planning Horizons Short
- Reserve Cycles for Non-Functional Requirements
  - Reducing Technical Debt
- Increase the Visibility of Work
- Use Tools to Reinforce Desired Behavior

## 2. DevOps Practice and the CI/CD Pipeline

### 2.1 Developer Provisioning

- Using Shared Services to Ensure Standards and Controls
- Platform-as-a-Service (PaaS) and Sandbox Creation
- Using Containers in Development
- Isolate Dev Environments and Ensure Parity with Production
- Secure Software Onboarding
  - Open Source Scanning
- On-Demand Creation of Environments
- Using Infrastructure as Code (IaC) to Ensure Uniformity
- The Immutable Server
  - Server Hardening
  - Configuration Management

### 2.2 Continuous Integration

- VCS (Version Control System) and Team Enablemen
- Using the Repository as "Source of Truth"
- Being Deliberate about Workflows
- Branch and Merge Strategy
- Agile Backlog Management
- Batching Features
- The Potentially Shippable Increment (PSI)
  - Mapping PSIs and Releases
  - Trunk Based Development and Deployment Practice
- Distributed VCS and Branch Checkout
  - Commit-Push and Build Triggers
  - Commit Frequency
  - Badges and Fast Feedback
- The Pull Request and Rebasing
  - Code Reviews
- Using Issues for Collaboration
- Project Boards and the Agile Lifecycle
  - Kan-Ban and Agile Lifecycle Management Tools
- Considering Repo-Centric Infrastructure
- GitOps and Declarative Infrastructure
  - Using Pull Requests to Trigger Infrastructure Deployment

### 2.3 Continuous Build

- Polyglot and Third-party Build Tooling
- The Daily Build
- Build Dashboards
- Unit Testing and Code Coverage
- Build Pipelines
- Build Agents
- Ensuring Parity With Upper Environments

### 2.4 Automated Testing

- Test-Driven Development
  - Behavior-Driven Development
- Unit Tests
- Acceptance Tests
- Integration Tests
- UI Tests
- Non-Functional Requirements Testing
- Performance Tests
- Stress Tests

### 2.5 Security: Vulnerability Scanning

- OWASP "Top Ten" Vulnerabilities
- Tolerating Vulnerabilities
- Defining and Enforcing Security Policy
- Third-Party Scanning Tools
- Enabling Remediation Through Automated Scanning Feedback

### 2.6 Continuous Deployment

- Deploying the Same Way in Every Environment
  - The Need For Parity
    - The "Worked in Dev Problem"
- Enable Use of Production Feedback in the "Definition of Done"
- Self-Service and Triggered Deployments
  - The Build-Test-Deploy Pipeline
- The Automated Deployment Pipeline
- Dropping Build Artifacts
  - Packaging and Automated Installations
- Utilizing a Package Registry
  - Notaries and Code Signing
- Utilizing Ephemeral Infrastructures
  - Rebuild vs. Repair
- On-Demand Infrastructure
  - Infrastructure as Code
- Configuration Management
- Secure Software Supply-Chain
- Automated Smoke Tests
  - Initial Deployment Monitoring
- Data and Storage
- Managing Persistent Storage
- Automating Database Migrations

### 2.7 Release Gating

- The Challenge in Regulated Industries
- Using Gating to Ensure Quality
- Using Gating to Reduce Risk
- Automating Approval Processes Through Rules and Workflow
- Pulling the Andon Cord

### 2.8 Release Traceability

- Integrating Ops Into the Agile Cadence
- The Daily Scrum
- Review and Retrospectives
- Scaled Agile and the PSI Release Cadence

### 2.9 Automated Rollback and Recovery

- Minimizing MTTR (Mean Time To Repair)
- Using a Deployment Pipeline to Vacate and Replace
  - Containers and Cloud Orchestration
- Using the VCS to Enable Rollback and Recovery

### 2.10 Continuous Operations

- Log Aggregation and Monitoring
- Dashboards, Alerting and Analytics
- Integrating Monitoring with the VCS Repository
