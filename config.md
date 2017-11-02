
Google Cloud
------------

```
$ gcloud container clusters get-credentials cluster-testjee  --zone europe-west1-b --project testjee-171310

$ kubectl run hello-node --image=docker.io/fsantagostinobietti/testjee:latest --port=8080

$ kubectl expose deployment hello-node --port=80 --target-port=8080 --type="LoadBalancer"

$ kubectl get service hello-node
```


Openshift
---------
TODO


