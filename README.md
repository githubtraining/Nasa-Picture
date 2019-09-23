### Nasa-Picture

This is a test repo to develop actions against a sample java app

9-12-19 - Begun work to call kubectl from the runner and enable the workflow to sense when kubernetes yaml files are pushed.

9-17-19 Added deployment of test reports to aws server 

9-19-19 Added the deployment to build a container and deploy to Kubernetes

9-20-19 Added sed edits of pod yml to personalize each pod deployed.
        (Still need a variable port)

        Changed application to randomize the day in the url sent to Nasa
        
        Change the container name to be personalized to github student handle

Will still need to sanitize some of the file naming, and move this over to GitHub's dockerhub account, but this is fully functional.

9-23-19 Rotating credentials. Will complete the job by tomorrow mid-morning.
