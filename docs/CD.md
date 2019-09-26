# GitHub DevOps Workshop

<table>
<tr><td>
<img width="800" alt="DevOps Loop Four Workshop Sessions" src="https://user-images.githubusercontent.com/43185011/64963440-41485000-d867-11e9-83cf-553d3ad9997f.png">
</td></tr>
<tr><td>
Illustration: This workshop is made up of four sessions, and are numbered above in the order they are presented.
</tr></td>
</table>

## <img width="75" alt="CD Icon" src="https://user-images.githubusercontent.com/43185011/64966709-47412f80-d86d-11e9-85a6-db603eefde29.png"> Session 3: Continuous Delivery

### Clarifying the "CD" In A CI/CD Pipeline

It is important at the onset of a 'CD' workshop to explore in detail the differences between Continuous Deployment and Continuous Delivery. At the onset of the Continuous Delivery movement Jezz Humble and David Farley published their siminal work titled <u>"Continuous Delivery: Reliable Software Releases Through Build, Test and Deploy Automation".</u> The recent authors of <u>"The DevOps Handbook"</u> credit them with coining the phrase 'Continuous Delivery'. 

These same authors site a blog post by Tim Fritz on Continuous Deployment when they elaborate on the difference between these two terms. In a section in Chapter 12, these authors elaborate on how Jezz Humble has clarified his view of the two terms since the original publication of his book. The excerpt from Humble reads:

> " When all developers are working in small batches on trunk, or everyone is working off trunk in short-lived feature branches that get merged to trunk regularly, and when trunk is always kept in a releasable state, and when we can release on demand at the push of a button during normal business hours, we are doing continuous delivery. Developers get fast feedback when they introduce any regression errors, which include defects, performance issues, security issues, usability issues, etc. When these issues are found, they are fixed immediately so that trunk is always deployable.
> 
> In addition to the above, when we are deploying good builds into production on a regular basis through self-service (being deployed by Dev or by Ops) -- which typically means that we are deploying to production at least once per day per developer, or perhaps even automatically deploying every change a developer commits-- this is when we are engaging in continuouis deployment.
> 

#### Further clarification of the difference between Continuous Deployment and Continuous Delivery

It will be important to clarify the difference between Continuous Delivery and Continuous Deployment. These terms have been misunderstood and often misused in the DevOps community. In our Continuous Delivery workshop we will not be encouraging continuous deployment without release gating because most enterprise organizations require release gating for GRC (Governance, Risk Management and Compliance). The CDRA workshop will demonstrate these concepts thoroughly.

Martin Fowler, a leading thought leader on DevOps clarifies this issue in this way:

> Continuous Delivery is a software development discipline where you build software in such a way that the software can be released to production at any time.

> You’re doing continuous delivery when:

> - Your software is deployable throughout its lifecycle
> - Your team prioritizes keeping the software deployable over working on new features
> - Anybody can get fast, automated feedback on the production readiness of their systems any time somebody makes a change to them
> - You can perform push-button deployments of any version of the software to any environment on demand

>You achieve continuous delivery by continuously integrating the software done by the development team, building executables, and running automated tests on those executables to detect problems. Furthermore you push the executables into increasingly production-like environments to ensure the software will work in production. To do this you use a DeploymentPipeline.
>
> ...
>  
> Continuous Delivery is sometimes confused with Continuous Deployment. Continuous Deployment means that every change goes through the pipeline and automatically gets put into production, resulting in many production deployments every day. Continuous Delivery just means that you are able to do frequent deployments but may choose not to do it, usually due to businesses preferring a slower rate of deployment. In order to do Continuous Deployment you must be doing Continuous Delivery.

### So When Is Continuous Deployment Used?

For purposes of this workshop we will implement a CI/CD Pipeline for Continuous Deployment that is appropriate for use in an enterprise that practices Continuous Delivery. The idea is to take advantage of the pipeline automation to improve developer productivity and ultimately shorten the lead time to the ultimate deployment into production. Stated simply: We can use Continuous Deployment to deploy workloads to a pre-production environment at will. 

Subsequent to the deployment of application workloads into pre-production environments, we will also demonstrate how through a simple "Pull Request" the developers work may then be promoted to production without impairing the automation or delaying the promotion of the code changes.

#### Application Architecture and Continuous Deployment

GitHub through the years of its development as a company has enjoyed the ability to deploy most developer changes directly to production. This has a great deal to do with the architecture of the application, and the collaborative DNA of GitHub as an organization. GitHub relies heavily on peer reviewed code and the merge to trunk/master is only done after careful code review. The second advantage GitHub enjoys is the modularity of its application and the implementation of feature toggels. 

Legacy brownfield applications in large enterprises are often monolithic in their nature. This is a legacy of when large systems would be taken off-line to do deployments. This also required that all changes be fully integrated with the entire application and fully tested prior to deployment to production. 

To enable fast and frequest releases, GitHub has ensured that the core application is extensible and that features may be added, oftentimes without compromising the function of other parts of the application. Secondly, since it is a cloud platform with a huge dependency on the live database supporting the application, it is often beneficial to test in the cloud with the live application and data. By enabling features for certain organizations or repository owners, developers may simply deploy their code, and then turn it on for themselves or others to test it. If problems are found, they may be rectified prior to the announcement of the relase to others.

Note: This is an important point, and that is to distinguish between the deployment of code to production, and its actual release for use by customers.

### The Role Of Automated Testing in a CI/CD Pipeline

#### The Testing Process

All applications in all contexts require different types and levels of testing. Oftentimes an organizations business nature, level of regulation, sensitivity to breach, and other factors affect what is truly required to release software to production for use by the customer or consumer. 

GitHub Actions workflows are extremely configurable and may be employed for a variety of testing processes. Each workflow is triggered by a broad selection of events that allo different levels of testing to be performed as the applications goes from early development through a testing lifecycle and ultimately into a production use.

##### Code Coverage and Unit Tests

In Lean Programming practice the concept that every developer is responsible for their own testing emerged. In times past, developers would produce untested code and then a QA (Quality Assurance) department was responsible for testing the code produced. When the Agile and Lean movement began to improve they emphasized that a "shift left" approach was needed to give developers greater autonomy and improve output.

Advanced tools became available for what are known as Unit Tests. Units are individual code modules that perform a particular function. The greater the modularity of an application code base, the more thorough unit tests may be applied. J-Unit is a popular example of a Java testing framework for Unit Tests.

Code coverage is the percentage of units that have tests defined. The higher the code coverage the better an application development framework is at preventing defective code from going undetected early in the lifecycle. Tooling to provide code coverage reports has also been developed and is readily available to measure code covereage on an ongoing basis.

##### Integration Tests

Integration tests are not always what they appear to be. In large systems, often one module may affect the performance of another. If a banking application has one service that retrieves the address of a borrower base on a loan number, and a calling application that uses this service with others to present the entire borrower profile, then an integration test would include running the address service with the calling application as well as the backend database server or system.

Integration occurs at many levels. It can be when one services has to function with another, or even at a lower level where one class in an object oriented program has to be called by other code modules. Integration tests are typically at a higher level than unit tests. Unit tests are often run by a build process to reveal whether the code committed is without defect, where integrations tests go further to evaluate the function of the code module with others in the overall system.

##### Security Tests

Many organizations have begun to implement security policy when governing an automated build process. Tooling to scan a code base, evaluate the third-party code libraries used, and then evaluate the core application code, as well as its 'dependencies' (ie. the third-party code) are readily available.

OWASP Dependency check is one such security scanning system that is easily implemented in a CI/CD pipeline. It will utilize the NVD (National Vulnerability database) to interogate the system and report the known vulnerabilities detected and their severity based on a CVSS score.

GitHub Workflow pipeline may easily implement a Static Application Scanning Test (SAST) in the workflow. To improve developer productivity, this type of test is not typically run by every push, but instead is run when the code is being elevated in the promotion lifecycle, such as when it is being submitted in a Pull Request for merging with master.

##### Exploratory Test

To develop unit tests that can do spell checks or detect when a form field is placed in the wrong location on a web form is not typically feasible. And unless a system's code coverage is maintained at 100%, it is often unreasonable to soley use automated unit tests to determine whether code is ready for promoting to production.

This means that the application must be run, and the behavior of the application must be observed to determine that the code commits made have not introduced defects. Exploratory tests may be automated by sophisticated tooling but most organizations lack the resources to attempt full automation. Therefore most enterprise pipelines include some form of manual testing. This type of testing si often performed on a pre-production target such as a team server employed for runtime testing.

##### Smoke Tests

A Smoke Test, sometimes called a confidence test or sanity test, is thought to be a test that truly reveals whether the application is performing to its expectations. The nature of this types of testing greatly depends upon the nature of the application. If the application is a transaction based application, then a typical smoke test would be to run a transaction end-to-end to determine whether all of the modules involved perform to expectation. IN amny environments a sample of many transactions might be run, to fully complete this level of testing. Automated tooling is often used to do this type of testing. It is time consuming and requires that the suppoprting database, networking, storage, compute, and other factors of the test environment be staged and capable of running this test. Audit test would compar numericl outcomes with predefined results. Parallel tests would run the end-to-end tests and compare the outcome with the previously released software to see if they balance. 

##### Canary Deployments

A Canary Deployment is the idea of rolling out code changes to a limited number of users. Getting its name from the mining industry, the canary must be placed in the mine to see if it dies. Placing the newly released code in production for limited production use is a way to see if it functions before major damage to the broad base of users is done.

##### User Acceptance Testing

User Acceptance Testing (UAT) is a form of testing performed by the actual end users of an application. Typically these non technical personnel are users of the existing system, and are often asked to perform their work tasks on a newly provided test system, or in production with a feature toggle, to see if they can actually complete their work in accordance with their expectations.

If the functionality of the application is changing in a visible and meaningful way with this new release, then the users are often informed as to how these changes have been implemented so thay may evaluate whether the new code is performing to the new way. Obviously UAT requires fully developed target infrastructure inclusive of all applicable code modules and supporting infrastructure to complete.

##### The Andon Cord

Automated pipelines seek to implement all of the required testing steps to ensure continuous quality. The Andon Cord, named for the Japanese manufacturing cord that would stop a factory's assembly line, stops a deployment pipeline if and when defects are discovered through the applicable testing processes. The Andon Cord is a feedback loop from operations back to development that is of pinnacle importance to orthodox DevOps practice.

#### Automated Release and Rollback

In spite of best intentions, and in spite of thorough testing and automated pipelines, sometimes defects are introduced into production. They may not be detected immediately and are sometimes discovered days after release. Hot fixes, would be the measure taken if the defect may be patched in production without rolling back to a prior release.

Many organizations are releasing so frequently, that the production level volume detects release defects almost immediately. In these cases, it may prove more simple and expedient to roll the systems back to the prior release of the software, thus backing out the changes that have been newly introduced. In DevOps the MTTR (Mean Time To Recovery) is a key metric in measuring an organization's performance. An Automated Roll Back and Recovery process is key to achieving a positive MTTR measure.

### Building and Deploying Software With GitHub Actions Workflows

Having now reviewed the complex use cases that may be required in varying enterprise settings, it is important to reconcile this processes to the GitHub Flow and see how we can improve deployment lead times using carefully planned workflows.

#### How Continuous Integration Practice Affects Deployment Workflows

The practice of continuous integration is fundamental to continuous delivery and deployment. There are several factors that would affect the way a branch/merge strategy is performed and what triggers to use to launch particular workflows. The characteristic of the programming language also has a great deal of influence in how processes are performed. With this in mind, and using a language such as Java that requires compilation, we will discuss some of the key factors that affect the development of workflows for automated deployment.

<table>
<tr><td>
<img width="959" alt="Screen Shot 2019-09-26 at 2 21 02 PM" src="https://user-images.githubusercontent.com/43185011/65714540-4c6e5d80-e069-11e9-8100-02e4e72dafe1.png">
</td></tr>
<tr><td>
The above illustration shows how a continuous integration workflow might be used to deploy to a team server and the types of testing that might be performed at the team level.
</td></tr>
</table>

In contrast to deploying to a team server, the following shows how a pipeline workflow might be extended to deploy to a pre-production or production platform.

<table>
<tr><td>
<img width="945" alt="Screen Shot 2019-09-26 at 2 28 13 PM" src="https://user-images.githubusercontent.com/43185011/65714837-e8986480-e069-11e9-9667-8b3e9e33e874.png">
</td></tr>
<tr><td>
The above illustration shows how a continuous deployment workflow might be used to deploy to a pre-production or production server and the types of testing that might be performed at the portfolio project level.
</td></tr>
</table>

#### Distributed Version Control Systems

In GitHub Flow there is an illustration of how feature branches would be created to facilitate the work of developers, allowing code commits to be tested fully prior to merging with trunk or master. This is a fundamental tenate of continuous delivery. The master branch must be maintained as suitable for deployment. So the feature branch becomes the critical way a team may collaborate and test code changes prior to merging with master.

<table>
<tr><td>
<img width="955" alt="GitHub Flow Add Commits" src="https://user-images.githubusercontent.com/43185011/64981918-140d9900-d88b-11e9-993e-e3a2eaaa639d.png">
</td></tr>
In the lesson on GitHub Flow, the process of commits and then a push to a feature branch is the means by which the master branch is protected from code that is not yet fully functional.
</td></tr>
</table>

In a distributed setting, multiple team members may be making commits to their own feature branches locally. They may do compile processes and minimal testing based on their developer workstation capabilities. They would need to pull or fetch the branch to their local systems to understand how their changes impact the code base at the time they are making the changes.

#### Local Sandbox Compile and Build Automation

Unless the individual developer fetches or pulls the current branch snaptshot prior to compilation, then the compilation does not represent a true continuous integration test. For this reason, many development teams rely on team servers to allow them to commit and push changes up to the feature branch, and then have a compile and test run on the team server.

To see this represented in GitHub Flow, you would have a push event launch a workflow that compiles, tests and deploys the feature branch to a team server where further exploratory testing may be done by the infividual developer or others on the team.

#### Team CI Servers

Team continuous integration servers facilitate this preliminary ability for multiple team members to push code to a shared feature branch and see that code running, and test it on a runtime server, before taking the step to promote the code for merging to master.

In other words, the push event facilitates individuals to autonomously compile and test their code before approving it for peer review or team collaboration.

#### Team-Based Deployments

In enterprise settings there are often many team members that have made code changes that are batched into small work-in-progress batches prior to actual promotion to the higher level pre-production or production platforms. This usually means that pull requests must be managed to either represent the work of one individual or the work of many individuals.

[ THIS DOCUMENT IS INCOMPLETE PENDING FURTHER COLLABORATION WITH DEVOPS PRACTITIONERS ]

##### Using Multi-Tenancy In Target Infrastructures






### Using paths with push and pull_rquest event triggers

```
on.<push|pull_request>.paths
```
When using the push and pull_request events, you can configure a workflow to run when at least one modified file matches a pattern defined in paths. If you omit paths, no file paths are filtered.

You can match more than one file path by using the wildcard characters supported by Go path.Match.

For example, a workflow with the following path filter will only run on pushes which modify at least one file that doesn't have the .js extension:

```
on:
  push:
    paths:
    - '*'    
    - '!*.js'
```

### Path filter evaluation
Each modified file path is compared against each of the patterns defined in paths until an at least one match is found.

For example, to prevent a workflow from running when all the modified are JavaScript files, you must first include a positive match for all other files using the * wildcard character. If you only include the negative pattern !*.js, the workflow will never run because no positive match exists. Patterns are matched according to the following rules:

By default, all file paths are excluded. At least one positive matching pattern must exist to trigger the workflow.

#### The order that you define patterns matters:

A matching negative pattern after a positive match will exclude the path again.
A matching positive pattern after a negative match will include the path again.
As a consequence of these rules, the following workflow will never run because no positive patterns are included by default.

```
on:
  push:
    paths:
    # This pattern removes possible paths but doesn't include any positive matches
    - '!*.js'
```
The patterns in paths are compared against the set of file paths modified by any commit in the push or pull request, even if the modification is undone by a later commit. This means the set of paths is a superset of files contained in a diff.

#### Example matching paths in nested directories
This example runs anytime the push or pull_request event includes a file in the sub-project directory or its subdirectories. For example, changes to any of these files would trigger a workflow run: sub-directory/index.js, sub-directory/my-nested-directory/README.md, sub-directory/mona/lisa/octocat.rb.

```
on:
  push:
    paths:
      # '*' matches any character except '/'
      - 'sub-project/*'
      - 'sub-project/*/*'
      - 'sub-project/*/*/*'
```

#### Example using negative pattern matching
This example runs a workflow when at least one modified file is not located in the /docs directory.

```
on:
  push:
    paths:
    - '*'        # Run workflow for all file paths
    - '!/docs/*' # Don't run workflow when files are only in the /docs directory
```

### on.schedule

You can schedule a workflow to run at specific UTC times using POSIX cron syntax. Scheduled workflows run on the latest commit on the default or base branch.

This example triggers the workflow every 15 minutes:

```
on:
  schedule:
    # * is a special character in YAML so you have to quote this string
    - cron:  '*/15 * * * *'
```
For more information about cron syntax, see "Events that trigger workflows."
