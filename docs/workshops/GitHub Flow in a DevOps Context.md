## GitHub Flow in a DevOps Context

GitHub flow is a lightweight, branch-based workflow that supports teams and projects where deployments are made regularly. This workshop session explains how and why GitHub flow works in a DevOps context.

### Effective Version Control

Effective version control systems help establish and automate the following practices:

#### Establish and Maintain a Centralized Code Base
Effective version control is central to the overall development of a DevOps pipeline. Whether facilitating individual coding efforts or the efforts of large teams, the version control system establishes one 'source of truth' as to the exact content of a code base. All automated pipelines rely upon a code base to then automate the compilation and distribution of applications.

#### Institute Version Control and Practice Change Management
Version control is needed to track changes to the code base over time. In team settings it is often beneficial to also track whom within the team made specific changed. Since application source code may be voluminous and complex, being able to collaborate on changes suggested by team members is crucial. Additionally, being able to perform forensics when application behavior does not go as planned is likewise critical.

#### Establish a Common Practice of Continuous Integration
Continuous Integration is the process through which multiple team members integrate their disparate changes to the code base over time. The need to integrate frequently is due to the fact that merge conflicts may often result if team members integrate code change infrequently. By committing and compiling code frequently the potential for incongruence and inoperable code changes is minimized by reducing the number of discreet changes merged at any one time.

#### Branch Protection and Merge Strategy
GitHub through its experience with progressive software development organizations has promoted an extremely simple practice that speeds development and deployment. The practice known as GitHub Flow utilizes the 'master' or trunk branch of the code base to be considered the protected branch that is maintained as suitable for deployment.

Feature branches are created to facilitate small batches of changes and ensure that those changes may be integrated, compiled, tested, and quality assured before they are merged back into the master branch. Working in a feature branch allows a team to experiment and implement the Agile concept of fail-fast without compromising the master branch.

GitHub is highly configurable and by setting branch protection, it becomes possible to establish team disciplines that optimize code integirty.

#### Enable Collaboration and Transparency Amongst Team Members
The GitHub Flow practice emphasizes the use of code commits back to the feature branch. Then, based upon the completion of coding changes for a particular feature the changes may be 'pushed' from a developer's local repository to the shared hub repository. The 'push' event may be used to trigger a compile and build to ensure the integirty of the code changes suggested for implementation. Once the code has been compiled and unit tested a 'Pull Request' is the means of a developer submitting his or her code changes for merging into trunck. The Pull Request may be configured to require review by any or specific team members before the merge is allowed. The Pull Request likewise performs the build process to validate that the code changes are in fact functioning and passing required unit tests.

### GitHub Flow

#### Create a Branch
The first step in the GitHub Flow process is to Create a Branch.

<img width="955" alt="GitHub Flow Create A Branch" src="https://user-images.githubusercontent.com/43185011/64981875-fd674200-d88a-11e9-97b1-e6414957c322.png">

With each new feature a number of code changes will be necessary by one or more developers to one or more files. By creating a branch, you create a common version of the master branch that may accommodate changes over time from one or more developers without compromising the master branch. Each feature branch should be created for a limited time to accommodate a given set of changes necessary. It is suggested that teams work in small batches to ensire that feature branches are short lived. It is also suggested that only one feature branch be created at a time if merge conflicts are likely due to more than one developer working on the same file at the same time. The modularity of the application architecture will dictate a branch strategy to limit merge conflicts and ease the process of integration.

#### Add Commits

After a feature branch has been created either locally on a developers workstation, or on GitHub itself, developers may make changes to files and add files to the checked out branch as needed.

<img width="955" alt="GitHub Flow Add Commits" src="https://user-images.githubusercontent.com/43185011/64981918-140d9900-d88b-11e9-993e-e3a2eaaa639d.png">

Each of the changes made constitutes a 'commit' to stage the changes made for updates to the branch. Once a group of commits has been made and the code is ready to be updated to the feature branch, the developer may push the code to the central repository.

#### Open a Pull Request

When the commits made by one or more developers have been integrated into the feature branch, a CI build will be launched to compile the code and run unit tests. These builds may also be used to deploy the code to a team server for further testing and review. Once the developer believes the code is ready to submit for integration into the master branch a Pull Request should be openned.

<img width="955" alt="GitHub Flow Open an Pull Request" src="https://user-images.githubusercontent.com/43185011/64982051-4dde9f80-d88b-11e9-8020-36a30132a02c.png">

The Pull Request may be configured to require that the build runs and compiles clean. It also should check that automated tests have run and passed. Most development environments require peer review of the code changes. The Pull Request will not allow the code to be merged until the necessary approvals have been input.

#### Collaborate and Gain Peer Review and Approval
Often times thereview process instigated by the Pull Request leads to more collaboration on strategies and techniques to streamline the code. In many cases clarification of the feature and the optimal way to enable the feature via the code is uncovered by an asynchronous dialogue of stakeholders and colleagues facilitated by the Pull Request and codified through the entry of comments in the Pull Request.

<img width="955" alt="GitHub Flow Collaborate" src="https://user-images.githubusercontent.com/43185011/64982086-6058d900-d88b-11e9-90c6-07239c9e4410.png">

The original developer and stakeholders may make edits to the affected files as the Pull Request is deliberated by the approvers. Once the Pull Request has been approved and all of the necessary changes have been made, the Pull Request may be approved, and thus an enabling of the 'Merge" step will result.

#### Deploy the Branch and Validate Code Changes
The approval of the Pull Request is often used to launch a final build and deploy of the feature branch to ensure that the code is suitable for merging.

<img width="955" alt="GitHub Flow Deploy" src="https://user-images.githubusercontent.com/43185011/64982128-74043f80-d88b-11e9-9981-472cee6bec27.png">

Many organizations that employ feature toggles are able to make this deploy step a step that deploys to a target production environment, and testing may be completed on the production platform. Other organizations, such as those regulated by governance and compliance measures do not allow deployment into production without rigorous testing and the creation of an audit trail of approvals by authorized approvers. In these regulated contexts the feature branch is often deployed to a pre-production server for this final round of approvals and release gating.

#### Merge the New Code with Master
Once approved, for deployment to production, the code may be merged with the master branch.

<img width="955" alt="GitHub Flow Merge" src="https://user-images.githubusercontent.com/43185011/64982168-867e7900-d88b-11e9-83af-a8edc168949e.png">

This step is often used by automated workflows to trigger the deployment of the newly created master branch to production.

### Release Management
The complexities of release management and release automation are covered in other sessions and lessons within this DevOps curriculum. For purploses of this lesson, it is important to know that the naming of the feature branches is important to track the progress of the release through deploment pipelines. Likewise, upon the ultimate deployment of the master branch into production, build and deploy workflows will often utilize semantic numbering systems to name build artifacts and persist them to various registries for subsequent deployment. 

