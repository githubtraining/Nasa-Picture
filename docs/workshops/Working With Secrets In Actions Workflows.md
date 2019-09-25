# Working With Secrets In Actions Workflows

Oftentimes build tooling, external servers, third-party software and other utilities employed in a complete CI/CD pipeline require usernames, passwords, certificates and tokens to authenticate client processes. The 'runner' in an actions workflow is a virtual machine hosting the workflow actions and run statements. The common practice is for the 'runner' to checkout files from the applicable GitHub repository and then use and run processes against those files.

When sensitive Identity and Access Management (IAM) values are needed security best parctice advises that they not be stated simply in files that are human readable, and may be available to unauthorized personnel. To keep secrets secret, a vault, or software utility used to persist and encrypt secrets is employed. GitHub Actions workflows may use the provided secrets valut for this need.

## Setting Up Secrets Within A Repository Within GitHUb

To store secrets that may be used in an Actions workflow you would use the Settings Tab on the repository interface (ie. not the Settings selection on the user drop down) to go to the selection bar that displays the "Secrets" selection. This selection will not show up unless Actions have been enabled on the organization or user account that you are using.

<table>
<tr><td>
<img width="1320" border=2px alt="Screen Shot 2019-09-23 at 9 20 09 AM" src="https://user-images.githubusercontent.com/43185011/65429031-73b3f900-dde3-11e9-82a5-6a7641d86d0e.png">
</td></tr>
<tr><td>
The `SETTINGS` tab is on the same row as the `<> Code` tab on the repository interface
</td></tr>
</table>

Once the Settings Tab has been selected the system will display the screen with the Setting tab. Once the Settings tab has been clicked, a screen showing any existing secrets will be displayed.

### Changing Existing Secrets

Once stored secrets may not be changed unless they are removed and then added again.

On each row with an existing secret there is a 'Remove' button to delete an existing secret.

<table>
<tr><td>
<img width="1306" alt="Screen Shot 2019-09-23 at 9 25 36 AM" src="https://user-images.githubusercontent.com/43185011/65429439-2ab07480-dde4-11e9-8dd0-01c66c1f3cba.png">
</td></tr>
<tr><td>
The user interface shows existing secrets, how to remove them, and a hyperlink in blue that allows the user to 'Add a new secret".
</td></tr>
</table>

### Adding a New Secret

Adding a secret to the vault simply requires that the user click the 'Add a new secret' link. Upon doing so a form is displayed to provide the secret name, which must be unique for the given repository, and the secret's value.

<table>
<tr><td>
<img width="1107" alt="Screen Shot 2019-09-23 at 9 32 28 AM" src="https://user-images.githubusercontent.com/43185011/65429994-1c168d00-dde5-11e9-9d1f-425fd861fef8.png">
</tr></td>
<tr><td>
To add a secret the user simply gives the sectret a name and places the value, token, password, etc. in the Value form field. Then press the 'Add secret' button to add the secret.
</td></tr>
</table>

Once the secret has been added it will display with any other repository secrets. The secret data is encrypted and stored in the GitHub vault for use within Actions workflows.

### Using a Secret within an Actions Workflow

Secrets may be used within an Actions workflow by merely referencing the secret inline with workflow commands. The following example shows how a workflow might reference and use a stored secret.

<table>
<tr><td>
<img width="1066" alt="Screen Shot 2019-09-23 at 9 40 02 AM" src="https://user-images.githubusercontent.com/43185011/65430580-28e7b080-dde6-11e9-8aca-15b0866fc949.png">
</td></tr>
<tr><td>
The above example uses the secrets 'dhuser' and 'dhpassword' to perform the 'docker login' command and log into the dockerhub.com service.
</td></tr>
</table>

## Working With Large Secrets

Large secrets that may contain RSA keys or Certificate Tokens that are too long for the secrets value may be placed in the repository within encrypted files, and then decrypted at runtime within the workflow. An example might be a Key Pair issued by Amazon and stored in a '.pem. file to allow `ssh` and or `Ansible` to authenticate to the AWS server instance.

### Encrpting a file to store in the repository

To encrypt a file for storage within a repository you would employ a utility for encryption and decryption of file data. The `gpg` utility has been chosen for this example. To encrypt the file, you would use the `gpg` command against the file on a command line, on a local file system, or a virtual file system with a powershell on a cloud server. IN our example case we are simply encrypting the file on a local desktop system.

```console
$ gpg -c awskeypair.pem
```

The gpg command will prompt you for a 'passphrase' which is the encryption key that will be needed to decrypt the file contents at runtime in the workflow runner.

<img width="400" alt="Screen Shot 2019-09-23 at 9 50 10 AM" src="https://user-images.githubusercontent.com/43185011/65431840-1bcbc100-dde8-11e9-9bed-c5e07fc4f751.png">

The gpg command will ask you to enter the Passphrase twice to ensure it typed correctly. You must remember this exact phrase for the next step.

### Storing the Encryption Passphrase in the Secrets Vault

Once the Passphrase has been used to encrypt the file contents, you must store just the Passphrase value in the screts vault. You would follow the instructions above under the "Adding a New Secret" heading and name your Passphrase somethin that you will then reference in the Actions workflow runner to decrypt the secret.

The procedure encrypts the file contents, and the Passphrase, so that neither value is visible to the end user in unencypted form.

### Storing the encrypted file within a repository

A simple `git add, git commit, and git push' may be used to store your encrypted file in a repository. You may also use the GitHub web interface and choose to add the file through the 'Upload File' button.

<table>
<tr><td>
<img width="1105" alt="Screen Shot 2019-09-23 at 10 00 31 AM" src="https://user-images.githubusercontent.com/43185011/65432346-060acb80-dde9-11e9-8796-6efed010c2c6.png">
</td></tr>
<tr><td>
You may use the 'Upload files' button on the GitHub web interface to upload an encrypted file from your local system.
</td></tr>
</table>

When the gpg command is used to encrypt a file as stated in the example above, the new encrypted file will be output to the user's present working directory and the ".gpg" extension will be added to the original filename.

In the following example, we have uploaded our encrypted file to a folder called 'secrets' within the repository.

<table>
<tr><td>
<img width="1105" alt="Screen Shot 2019-09-23 at 10 06 03 AM" src="https://user-images.githubusercontent.com/43185011/65432765-c7c1dc00-dde9-11e9-8a14-50868d0acd82.png">
</td></tr>
<tr><td>
The above screen shows the 'awskeypair.pem.gpg' file that has been uploaded to the repository and stored within the 'secrets' folder.
</td></tr>
</table>

### Decrypting an encrypted file within an Action Workflow

To utilize the file within a workflow it is necessary to decrypt the file and then use the file in the desired command. To decrypt the encrypted file contents we will need the Passphrase that was stored in the secrets vault for this repository.

<table>
<tr><td>
<img width="1073" alt="Screen Shot 2019-09-23 at 10 12 50 AM" src="https://user-images.githubusercontent.com/43185011/65433296-bd541200-ddea-11e9-8451-3922f44aa9a8.png">
</td></tr>
<tr><td>
In the above example workflow the gpg command is used to decrypt the awskeypair.pem file and employs the 'awspassphrase' stored in the secrets vault to do so.
</td></tr>
</table>

Notice in the above example that the awspassphrase is first translated into an environment variable and then the environment variable is then referenced on the actual gpg command line run statement. This format is not required. The awspassphrase could be referenced directly on the gpg run line. This example has been shown because in many cases using environment variables aids in readability and maintance of the workflow yaml file.

The above example also changes the file permissions on the decrypted awskeypair.pem file because many 'ssh' and other utilities require it to be read-only by the file owner.

### Using a Decrypted Keyfile with Ansible

The use of the decrypted file will vary based on the utility being employed. The syntax for an ssh command is different than that of an Ansible command. For this example we will show how the keypair may be passed as an argument to Ansible. It could have also been referenced in the Ansible Inventory file. The particular use of these secrets is dependent upon the third-party software being employed within the Actions workflow.

<table>
<tr><td>
<img width="1073" alt="Screen Shot 2019-09-23 at 10 21 47 AM" src="https://user-images.githubusercontent.com/43185011/65433963-fe98f180-ddeb-11e9-818d-4a72dba9f555.png">
</td><tr>
<tr><td>
In the above example, the argument '--private-key' is used to pass the decrypted keyfile to the 'ansible-playbook' command.
</td></tr>
</table>

### Using a Decrypted Keyfile with Kubernetes kubectl Command

Another example might be to utilize a decrypted certificate file for the config file necessary to enable the 'kubectl' command from within an Actions Workflow runner.

<table>
<tr><td>
<img width="1102" alt="Screen Shot 2019-09-23 at 10 26 14 AM" src="https://user-images.githubusercontent.com/43185011/65434423-c80fa680-ddec-11e9-9010-35e82789fdd1.png">
</td><tr>
<tr><td>
In this example the 'gpg' command is used to decrypt the kubernetes config file in much the same way the previous aws keypair file was handled.
</td></tr>
</table>

In this case the 'kubectl' command allows the environment variable KUBECONFIG to specify where the config file is that specifies the certificates for accessing the Kubernetes API Server.

<table>
<tr><td>
<img width="1102" alt="Screen Shot 2019-09-23 at 10 25 58 AM" src="https://user-images.githubusercontent.com/43185011/65434583-0c02ab80-dded-11e9-8742-619e55488ac9.png">
</td><tr>
<tr><td>
By simply specifying the filename of the unencrypted Kubernetes config file, the kubectl command is able to find it and gain authorization from the Kubernetes API Server.
</td></tr>
</table>