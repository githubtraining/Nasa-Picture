# How To Deploy A Container App To Kubernetes

GitHub Actions Workflow allows users to take advantage of a vast selection of open source tooling and solutions. Since the Actions Workflow 'runners' are in themselves Virtual Machines (VMs) running on cloud servers, the operating system choice for the runner dictates the syntax of run commands, the operating system commands available, and the third-party applications available for us on any particular runner.

In this example we build upon prior examples and utilize docker to containerize an application, and push it to dockerhub.com. Then we call the Kubernetes kubectl utility to create or update a pod deployment using the container we pushed to dockerhub.com.

## The GitHub Actions Workflow Architecture

To illustrate the manner through which a GitHub Actions Workflow might be employed for a CI/CD pipeline, it is important to understand the high level architecture of the GitHub Workflow runner.

The following illustration is a basic workflow runner and shows the external public cloud systems that might be utilized to host the application on Kubernetes. The role of dockerhub.com has also been added to the architecture.

<table>
<tr><td>
<img width="1204" alt="Screen Shot 2019-09-23 at 3 06 02 PM" src="https://user-images.githubusercontent.com/43185011/65454711-b8f01f00-de13-11e9-90d6-613e3000db75.png">
</td></tr>
<tr><td>
The GitHub Actions Workflow 'Runner' is a VM that launches on each workflow trigger and terminates upon workflow completion. The above architecture shows an Amazon EC2 server instance that has launched previously and has been configured to run Kubernetes. In this example, the java application is imaged into a docker container that is then pushed to docker hub. The kubectl command is then run from the 'runner' VM instance to deploy the pod to pull and run the container image.
</td></tr>
</table>

### Containerizing a Java Application

#### Building the Container Image

After and applications has been compiled with a build tool such as gradle r maven, there is a java archive that is i jar, war or ear format dependent upon the build configuration. In our example we have built a war (web archive) file that contains the java bytecode for a Spring Boot application. 

One way to create a docker image that may be deployed is to use a Dockerfile. In this case we have placed one in the root directory of our repository. The Dockerfile simply contains the necessary commands to create the image we need to run the very simple Spring Boot application. The example Dockerfile is shown below:

<table>
<tr><td>
<img width="1111" alt="Screen Shot 2019-09-23 at 3 14 51 PM" src="https://user-images.githubusercontent.com/43185011/65455294-edb0a600-de14-11e9-96e3-7db3f66113a5.png">
</td></td>
</table>

This Dockerfile starts with a base image called java:8-jdk-alpine. It then copies the war file created by the gradle build into our new image file. It establishes the working directory as /usr/app, exposes the web port 8080, and establishes an 'entrypoint' that is a command to start the application once deployed.

The command to build the container image is:

```
docker build -t nasa-picture .
```
This command simply tells the docker runtime in the runner to execute the Dockerfile, and tag the image with the name 'nasa-picture'. The . at the end is telling the build to look in the present working directory for the Dockerfile spec.

#### Pushing the Container Application to Docker Hub

To push the application to Docker Hub, authentication is required. The following command is used in the workflow to pull the docker username and password from the secrets vault and authenticate to the docker hub API endpoint.

```
docker login -u ${{secrets.dhuser}} -p ${{secrets.dhpassword}}
```

####

To take the most recently tagged image named 'nasa-picture' and tell docker where to push the image to in docker hub, you would use this command:

```
docker tag nasa-picture:latest githubtraining/universe:np-${{github.actor}}
```
This tells docker to take the nasa-picture image and tag it with the external tag that will place it in the 'githubtraining' repository, within a folder named 'universe' on docker hub and name it np-<GitHub Username>.

The last step is to push the image to docker hub with the following command:

```
docker push githubtraining/universe:np-${{github.actor}}
```

Each of these individual command s are run as a disctinct command within the workflow. The entire set of commands looks as follows in the workflow yaml.

<table>
<tr><td>
<img width="1111" alt="Screen Shot 2019-09-23 at 3 29 07 PM" src="https://user-images.githubusercontent.com/43185011/65456263-ee4a3c00-de16-11e9-94a6-94f94de92730.png">
</td><tr>
</table>

## Deploying a Container App To A Kubernetes Cluster

There are many ways to deploy applications to Kubernetes. The HELM utility is an excellent way to simplify the process and manage many dependencies. Our focus here is on the minimal workflow necessary and we wish to simplify the process. This means we will use the Kubernetes command line utility called 'kubectl' for our purposes.

#### Configuraing kubectl

On any client platform 'kubectl' must be configured to make calls to the Kubernetes API Server. Dependent upon how you install Kubernetes, there are various ways that the Kubernetes Configuration file is handled. It can usually be found in the /etc/kubernetes directory on the Kubernetes Master server instance.

In our example we have placed an encrypted Kubernetes Configuration file in our repository and it is in the secrets folder and named k8s_config.gpg. In a prior workflow step we have decrypted the Kubernetes Configuration file using the gpg utility with a secret passphrase stored in the vault.

The new decrypted file has been placed in the present working directory and has been named by its basename k8s_config without the gpg extension.

The example for this decryption is below:

<table>
<tr><td>
<img width="1111" alt="Screen Shot 2019-09-23 at 3 43 58 PM" src="https://user-images.githubusercontent.com/43185011/65457213-0f139100-de19-11e9-954e-3d642212f552.png">
</tr></td>
</table>

#### Using kubectl to Deploy the Container Image

To deploy the container image there are two Kubernetes objects required. The first is a service that will map the exposed container port to an outside port available to the Internet. The second is the pod deployment spec that defines how many replicas of the container application to run, the container image to pull, and other Kubernetes specific requirements. 

Again, for our purposes we are providing examples to demonstrate the capabilities of the Actions workflow runner. Further information on the Kubernetes yaml and other matters may be found in the Kubernetes documentation and is not specific to GitHub.

<table>
<tr><td>
<img width="1111" alt="Screen Shot 2019-09-23 at 3 48 01 PM" src="https://user-images.githubusercontent.com/43185011/65457438-8f39f680-de19-11e9-9f86-b538b2569813.png">
</td></tr>
<tr><td>
The above illustration shows the kubectl command which applies a service and pod spec in the repo folder named Kubernetes with the file name of nasa-picture.yml.
</td></tr>
</table>

#### The Service and Pod Spec

This is the example service and pod spec referenced in the kubectl command above.

<table>
<tr><td>
<img width="1111" alt="Screen Shot 2019-09-23 at 3 53 02 PM" src="https://user-images.githubusercontent.com/43185011/65457746-4171be00-de1a-11e9-8afe-4f8bbdcfcfc9.png">
</td></tr>
</table>

#### Useing Linux sed Command to Modify Template Files

You may remember that the example we gave above used the variable ${{ github.actor }} to name the container image before pusing it to docker hub. This dynamic naming requires some complexity in our otherwise simple workflow.

To achieve the substitution of service and pod spec values in the kubernetes yaml, we will use a template file, and then execute sed commands against it to place in the substitution values.

An example service and pod spec is placed in the repository and named nasa-picture.template. A sample is pictured below:

<table>
<tr><td>
<img width="1098" alt="Screen Shot 2019-09-23 at 3 58 10 PM" src="https://user-images.githubusercontent.com/43185011/65458124-f906d000-de1a-11e9-87ba-0ff8d173e3fb.png">
</td></tr>
<tr><td>
In this example the literal 'nasa-picture' has been replaced with 'np-GITHUB_ACTOR' and the literal node port of 30000 has been replaced with the string 'NODE_PORT'. This allows us to use the sed command line editor to replace these stubbed values with the variables we obtain from the workflow context we are running.
</td></tr>
</table>

To then use the sed editor in the workflow we add the following run commands:

<table>
<tr><td>
<img width="1098" alt="Screen Shot 2019-09-23 at 4 04 29 PM" src="https://user-images.githubusercontent.com/43185011/65458566-daed9f80-de1b-11e9-9e99-d90c85d57e35.png">
</td></tr>
</table>

The above commands use 'sed' to edit in the Image name and Pod Spec labels, and the node port to expose the container on. It then copies the template over the nasa-picture.yml file and uses cat to display the results of the editing in the console log.


 
