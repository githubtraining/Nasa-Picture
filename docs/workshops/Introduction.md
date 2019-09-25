# GitHub DevOps Workshop Introduction

## Workshop Sessions

The GitHub DevOps Workshop that may be delivered onsite through a classroom experience or over-the-wire with GitHub's Learning Lab platform.

The illustration below shows the DevOps "loop" lifecycle and where each of the four workshop sessions fit into an overall DevOps CI/CD lifecycle.

<table>
<tr><td>
<img width="800" alt="DevOps Loop Four Workshop Sessions" src="https://user-images.githubusercontent.com/43185011/64963440-41485000-d867-11e9-83cf-553d3ad9997f.png">
</td></tr>
<tr><td>
Illustration: This workshop is made up of four sessions, and are numbered above in the order they are presented.
</tr></td>
</table>

### <img width="50" alt="VCS Icon" src="https://user-images.githubusercontent.com/43185011/64966047-13b1d580-d86c-11e9-9684-e8b521f0525b.png"> Session 1: Version Control System 

This sessions reviews the use of GitHub as a foundational practice to foster orthodox DevOps practice. The session reviews with students a hands-on lab teaching the fundamental aspects of GitHub Flow and how it may be applied to a CI/CD context. The workshop covers:

- Repository Creation
- Cloning a Repository
- Protecting the Master Branch
- Making Changes To Files On Your Local Machine
- Committing and Pushing Changes To A Feature Branch
- Openning a Pull Request To Facilitate Code Review
- Merging A Feature Branch With Master

In a DevOps context, the use of a branch merge strategy will enable GitHUb event triggers to be used for CI/CD automation. The fundamentals of GitHub Flow establish the team practice that enables development, testing, and initial team-level deployments to be automated.


### <img width="50" alt="CI Icon" src="https://user-images.githubusercontent.com/43185011/64965672-6ccd3980-d86b-11e9-9904-9a8dfb9c5b22.png"> Session 2: Continuous Integration

The Continuous Integration session build upon the fundamental use of GitHub for VCS and instructs the student on the use of GitHub Workflow Actions to enable an automated build and unit test process. As a precursor to the Continuous Delivery session, this workshop focusses on the following practices:

- Initial development of a GitHub Workflow
- Enabling a build process such as Maven or Gradle through workflows
- Implementation of Unit Tests through the build
- The persistence of build artifacts to the GitHub Package Registry
- Using Docker to package an application for a container deployment
- Using Docker Hub as a container registry


### <img width="50" alt="CD Icon" src="https://user-images.githubusercontent.com/43185011/64966709-47412f80-d86d-11e9-85a6-db603eefde29.png"> Session 3: Continuous Delivery

The Continuous Delivery session builds upon the Continuous Integration session and guides the student through the use of a GitHub Actions Workflow to deploy the persisted application package or container image to a team server. The workshop session focusses on:

- Use of event triggers to launch different workflows based on developer events
- Deploying a conventional package to a virtual machine in a public cloud
- Deploying a containerized application to a Kubernetes Cluster in a public cloud
- Creating release snapshots to enable rollback and recovery
- Enabling application workload promotion through dev, test and pre-production targets
- Deploying to production

### <img width="50" alt="Release Automation" src="https://user-images.githubusercontent.com/43185011/64967417-75733f00-d86e-11e9-95e7-796965bd9e1a.png"> Session 4: Release Automation

The Release Automation session will build upon the workflows covered in the Continuous Delivery session with particular emphasis on release gating in regulated contexts. The workshop session will focus on the following capabilities:

- Creating GitHub Action Workflows that enable user approval(s) prior to commencement
- Using release snapshots to automate rollback and recovery
- 
