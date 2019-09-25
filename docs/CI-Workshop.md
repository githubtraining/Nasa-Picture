## Workshop Definition

### Track: Automate

10:40 am / Tuesday Nov 12

Presenters: Rex Mpala, Jamie Strusz

## Continuous integration with GitHub Actions (Part I)

The popular "GitOps" process is an excellent way to fully enable the developer and use GitHub as the source of truth for continuous integration (CI) and continuous delivery (CD) pipelines. By implementing a declarative approach to CI assets and infrastructure definition, the groundwork may be laid for frictionless deployments. The first part of this two-part workshop covers all aspects of orthodox CI practice and applies the process knowledge gained to hands-on GitHub practice.

**For the purposes of this workshop, we will be emphasizing the capabilities of Actions to create a CI/CD pipeline.**

- Provision GitHub repositories in multiple programming languages as use cases
- Use advanced GitHub tooling to quickstart CI processes and fully implement lean and agile development lifecycle practices
- Improve code coverage with automated unit tests
- Implement static application security testing
- Implement build automation
- Collaborate through issues and configure repositories so that pull requests may trigger downstream deployments

## Provision GitHub repositories in multiple programming languages as use cases

It is difficult to rank the most popular languages in use now that there are differentiators between conventional virtual environments and cloud computing. Cloud computing often entails running application workloads in containers and thus making them portable and lightweight.

For non-cloud environments Java has been the clear winner for quite some time especially amongst large enterprise organizations. However many architects and engineers who are promoting microservices and decoupled application architectures have begun to use newer languages such as Python, PHP, Ruby and Go.

For the purposes of this workshop, we will be emphasizing the capabilities of Actions to create a CI/CD pipeline. The actions available in the beta release will likely simplify or make complex the build environments for any particular language.

Due to its popularity amongst the enterprise I suggest we use Java as one of the languages we automate. The Maven build has been a mainstay in enterprise Java environments and the use of J-Unit and other test frameworks is very common.

We will be engineering an end-to-end pipeline with Java as one example. This will be familiar to many of our students that work in enterprise environments. The other languages we choose to teach as use cases is contingent upon the time we have to complete the Action automation. 

While it is certainly open to discussion, Ruby and Python would both serve as popular examples.

### Considerations for Containers and Kubernetes

It is important to remember that this first CI workshop is part of a two part workshop. The deployments performed in the Part II, or CD workshop will be to a Kubernetes environment and thus it is necessary to package the build artifacts in docker containers so they may be deployed as conventional pod deployments in Kubernetes.

## Use advanced GitHub tooling to quickstart CI processes and fully implement lean and agile development lifecycle practices

The fact that GitHub Actions are open-sourced is a huge benefit to the GitHub ecosystem. Additionally, the architecture of Actions allows for extensibility through the simple addition of actions written in JavaScript. 

> Note: At the time of this writing the author is unsure whether Node.js or other JavaScript derivatives are supported. But once we have engineered our pipelines, additional narrative will be added to this document to denote all of the way actions may be authored.

The library of existing actions, and the sample actions CI/CD pipelines are the artifacts that will 'quickstart' any GitHub user's development of unique CI/CD pipelines for their own applications.

The course will have at least two, and hopefully more sample pipelines featuring different programming languages. These will guide the students through as examples for the workshop.

### Lean and Agile Lifecycle Practices

Continuous Integration is a foundational process for any teams using Agile or Lean practice. It will be important to briefly cover the fundamentals of these practices without spending too much time on methodology. We want the majority of the workshop to be about the GitHub Actions tooling and be as hands-on as pragmatic.

Having said that, the following are some key points that might be considered when developing the informational aspect of the workshop content. These are verbatim from the ThoughtWorks website and serve as a succinct overview of orthodox CI practice.

> Continuous Integration (CI) is a development practice that requires developers to integrate code into a shared repository several times a day. Each check-in is then verified by an automated build, allowing teams to detect problems early. 

> By integrating regularly, you can detect errors quickly, and locate them more easily.
 
> ### Solve Problems Quickly

> Because you’re integrating so frequently, there is significantly less back-tracking to discover where things went wrong, so you can spend more time building features.

> Continuous Integration is cheap. Not integrating continuously is expensive. If you don’t follow a continuous approach, you’ll have longer periods between integrations. This makes it exponentially more difficult to find and fix problems. Such integration problems can easily knock a project off-schedule, or cause it to fail altogether.

> ### Continuous Integration brings multiple benefits to your organization:

> - Say goodbye to long and tense integrations
> - Increase visibility enabling greater communication
> - Catch issues early and nip them in the bud
> - Spend less time debugging and more time adding features
> - Build a solid foundation
> - Stop waiting to find out if your code’s going to work
> - Reduce integration problems allowing you to deliver software more rapidly

> ### Continuous Integration is backed by several important principles and practices.

> #### The practices
> - Maintain a single source repository
> - Automate the build
> - Make your build self-testing
> - Every commit should build on an integration machine
> - Keep the build fast
> - Test in a clone of the production environment
> - Make it easy for anyone to get the latest executable version
> - Everyone can see what’s happening 
> - Automate deployment

> #### How to do it
> 
> Developers check out code into their private workspaces. When done, commit the changes to the repository. The CI server monitors the repository and checks out changes when they occur.
> 
> - The CI server builds the system and runs unit and integration tests
> - The CI server releases deployable artefacts for testing
> - The CI server assigns a build label to the version of the code it just built
> - The CI server informs the team of the successful build
> - If the build or tests fail, the CI server alerts the team
> - The team fixes the issue at the earliest opportunity
> - Continue to continually integrate and test throughout the project

> #### Team responsibilities
> - Commit frequently
> - Create branches often to accomplish small and modular units of work
> - Open pull requests early and include as much context as possible (what the pull request is addressing, if it's a work in progress, what is left to do, who and what will be affected, links to relevant issues or pull requests, when it is expected to be ready for review or merged, etc.)
> - Merge branches quickly
> - Start new branches for new work (vs. reusing one branch for multiple purposes)
> - Don’t check in broken code
> - Don’t merge untested code into `master`
> - Don’t merge into `master` when the build is broken
> - Don’t go home after merging into `master` until the system builds
> 
> https://www.thoughtworks.com/continuous-integration

### Pre-Requisites For This Workshop

The VCS Workshop which is the first workshop of the day covers all aspects of GitHub Flow and how to use GitHub for the CI process explained above. Rather than repeat those processes here, you may reference them at the Pull Request for that workshop's definition.

https://github.com/github/services/pull/6533

For our purposes in this workshop we will expect the students to know how to fork a repository, clone it to their local machine, make changes, commit those changes, push their changes and open a pull request.

We will configure that sample CI/CD workflow to execute a build and run unit tests when they push their changes to a feature branch. We will have to engineer an appropriate way to avoid merge conflicts. (Suggestions welcome) We do want the students to function as a Scrum team and not work individually on the same examples. These exercises will be defined in detail and be added to this repository.

## Implement code coverage with automated unit tests

The workshop repos that are fully engineered with Actions CI/CD will include applications that the Java unit tests define. The unit tests will execute as part of the automated build. Part of the instruction will be to show the students the code that sets up the unit tests, show them how the Actions workflow spawns the build, and how Actions provide build feedback through the Pull Request.

## Implement static application security testing

The Actions workflow CI/CD pipelines provided will utilize Dependabot, and possibly a third-party open source SAST tool for scanning dependencies and identifying common vulnerabilities in the application source code and component libraries used to build the application binaries. At the time of this writing it is not known by this author whether Dependabot will perform all of the scanning required in a way that is consistent with orthodox DevSecOps practice. This will become known when we engineer the pipelines and run our actual scenarios as a proof-of-concept.

## Implement build automation

The build automation used in the workshop will be Maven for enterprise Java, and an appropriate build process for the other languages supported. Azure DevOps contains pipeline samples for Ruby applications that use a 'gem update' and 'rake' process to run a build and unit tests indicative of a Ruby use case.

The specific build automation employed in the sample pipelines will be engineered and provided to the presenters in sufficient time to review them as preparation for giving the class in November. It is hopeful that all of this engineering will be completed prior to October leaving a full month for preparation of supporting course materials and content.


## Collaborate through issues and pull requests

## Configure repositories so that pull requests may trigger deployments


As previously stated, the Pull Request is the seminal process to facilitate team collaboration and instantiate the downstream Continuous Deployment (CD) process.

> Note: Please see the narrative provided in the VCS course definition if the use of the term Continuous Delivery vs. Continuous Deployment are unfamiliar. These terms have been used somewhat interchangably in the community but mean different things. Stated in brief here, Continuous Deployment is the automated step of deploying build artifacts and configuring them to run on a target server environment. Continuous Delivery is the broader concept which entails making certain the trunk or master branch of the repository is kept in a deployable state. To help with this clarification, the following excerpt is provided from the same Thoughtworks reference previously cited.

> ### Continuous Deployment

> Continuous Deployment is closely related to Continuous Integration and refers to the release into production of software that passes the automated tests.

> "Essentially, it is the practice of releasing every good build to users”, explains Jez Humble, author of Continuous Delivery.

> By adopting both Continuous Integration and Continuous Deployment, you not only reduce risks and catch bugs quickly, but also move rapidly to working software.

> With low-risk releases, you can quickly adapt to business requirements and user needs. This allows for greater collaboration between ops and delivery, fueling real change in your organization, and turning your release process into a business advantage.

### Caveats for Enterprise Organizations

The Continuous Delivery Part II workshop that follows this one will get into the enterprise contexts that affect whether a simple deploy master to production process may be supported. One of the key benefits of orthodox DevOps practice is the improvement of Recovery and Rollback automation. MTTR (Mean Time To Recovery) is often measured in DevOps maturity guides to determine an organization's adherence to orthodox devops practice.

For this reason We will be covering several alternatives in the CD workshop that follows this one. Release management, feature branches, semantic naming of releases, and traceability of releases through the pipeline will be covered thoroughly in that workshop.

Subsequent to the CD workshop is a fourth workshop on Continuous Delivery Release Automation (CDRA). This workshop will deal with the challenges faced by regulated industry such as the inability to deploy directly to production instances. In these more complex contexts the use cases will demonstrate automated deployment to the more conventional target systems such as pre-staging and pre-production environments.

## GitOps

GitOps is a fairly new practice that was first promoted by Weaveworks in 2017. It has gained popularity amongst the DevOps community and is a great paradigm or framwork for Kubernetes deployments. Stated simply, GitOps utilizes the GitHub repository for versioning the application source code as well as the code for infrastructure instantiation and configuration.

Intuit, a well know GitHub client that is also a FinTech (hghly regulated enterprise) showcased how they have implemented GitOps for their workloads at the recent DevOps World/Jenkins World. The slides used for that presentation are being compiled into a workshop report and their live demo was captured on video. As part of the preparation for presenters of our DevOps Universe workshops these materials will be shared.

Additionally, the sample repos and pipelines being engineered will include the Kubernetes YAML as well as Ansible Playbooks to fully automate the deployment of the workshop sample applications to a live Kubernetes environment.

### Docker Containers

Since the ultimate target environment for the workloads built in this workshop is a Kubernetes environment, a Dockerfile or Docker Compose script will be included in the repo build to containerize the binary runtime artifacts created by the build processes employed.

### Package Registry

The newly release GitHub Package Registery will be employed to stage build artifacts in packaged form for subsequent deployment. The dilineation between this workshop and Part II will be drawn at the 'publish' step to the package registery. This workshop should explain the use of the package registry in the Actions workflows, but the CD workshop will cover their actual promotion and deployment to the target infrastructures.

## Summation

This definition has been provided to fully explain to the presenters the subject matter of the CI workshop and how it fits into the overall 'Automate Track' of four workshops that has been defined.

While many of the teaching artifacts regarding DevOps and the practice of Continuous Integration may be developed now using third-party resources, it is understood that the sample applications and Actions workflows must be engineered prior to the completion of teaching mediums for this particular practice and use case.

This file is provided to begin a collaborative effort to determine whom will develop the other teaching content such as slide decks, Learning Lab courses, video, and other desire mediums.

This definition is also provided so that the full team of presenters may provide editing and additional materials and ideas that will improve the overall quality of our 2019 Universe Workshop experience.
