# GitHub DevOps Workshop

<table>
<tr><td>
<img width="800" alt="DevOps Loop Four Workshop Sessions" src="https://user-images.githubusercontent.com/43185011/64963440-41485000-d867-11e9-83cf-553d3ad9997f.png">
</td></tr>
<tr><td>
Illustration: This workshop is made up of four sessions, and are numbered above in the order they are presented.
</tr></td>
</table>

## <img width="75" alt="CI Icon" src="https://user-images.githubusercontent.com/43185011/64965672-6ccd3980-d86b-11e9-9904-9a8dfb9c5b22.png"> Session 2: Continuous Integration

The Continuous Integration session builds upon the fundamental use of GitHub for VCS and instructs the student on the use of GitHub Workflow Actions to enable an automated build and unit test process. As a precursor to the Continuous Delivery session, this workshop focusses on the following practices:

- Initial development of a GitHub Workflow
- Enabling a build process such as Maven or Gradle through workflows
- Implementation of Unit Tests through the build
- The persistence of build artifacts to the GitHub Package Registry
- Using Docker to package an application for a container deployment
- Using Docker Hub as a container registry

### Initial development of a GitHub Workflow

To develop a GitHub Workflow process that employs Actions to automate the Continuous Integration process, you being by adding the workflow file to the `.github` directory. You may do this manually, or by clicking the `ACTIONS` tab at the top of the repository web interface.

<table>
<tr><td>
<img width="1328" alt="Actions Tab" src="https://user-images.githubusercontent.com/43185011/64985492-f6443200-d892-11e9-9fdc-603007c2ab6e.png">
</td></tr>
<tr><td>
Screen Shot: The `ACTIONS` tab will display the library of available workflows if none have already been created in the active repository.
</tr></td>
</table>

### Selecting a sample workflow if one may be available

The `github.com/actions/starter-workflows` repository contains many sample workflow files. If they are featured on the Actions page that displays under the ACTIONS tab, then you may scroll to the workflow you desire and click the `Set up this workflow` button.

<table>
<tr><td>
<img width="464" alt="Starter-Workflow Gradle" src="https://user-images.githubusercontent.com/43185011/64985714-82eef000-d893-11e9-87fc-c913f1d7e56b.png">
</tr></td>
</table>

Once the workflow sample has been selected, it will install the file to your active repository.

### Auto Install of First Workflow File
The Actions Workflow wizard will install the sample workflow selected in your repo within the `.github` folder. You may edit the name of the file and its contents on the screen provided.

<table>
<tr><td>
<img width="1325" alt="ScreenShot First Workflow" src="https://user-images.githubusercontent.com/43185011/64986187-7919bc80-d894-11e9-8799-107f5373bf82.png">
</tr></td>
</table>

This completes the step of creating our first workflow, and having it compile a sample java application with gradle.

### Implementation of Unit Tests through the build

[THIS SECTION IS BEING ADDED IN ANOTHER MARKDOWN FILE TO KEEP THIS CONTENT MODULAR]


