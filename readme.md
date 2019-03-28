## Kubernetes workshop

Sample "microservices" projects with Kubernetes configs

### Commands

### local

docker run -p8080:8080 macnowak/invoice-app:0.1.0

docker run -p8081:8080 -eMICRONAUT_HTTP_SERVICES_INVOICE_URLS=http://192.168.1.142:8080 macnowak/video-rental-app:0.1.0




#### K8S
---------- WORKSHOP 1 --------------

	minikube start
	kubectl version
	minikube dashboard
	kubectl cluster-info
	Kubectl get nodes
	Kubectl get pods

---------- WORKSHOP 2 --------------

	kubectl run invoice-app-deployment --image=macnowak/invoice-app:0.1.0 --port=8080

	kubectl get deployments

	kubectl proxy
	curl http://localhost:8001/version
	kubectl get pods
	export POD_NAME=invoice-app-deployment-68db4b4d44-nr5jg
	curl http://localhost:8001/api/v1/namespaces/default/pods/$POD_NAME/proxy/invoice
	kubectl logs $POD_NAME
	kubectl exec -ti $POD_NAME sh

	kubectl delete deployment invoice-app-deployment

	kubectl get pods
	kubectl get deployments

	kubectl create -f deployment.yml

	kubectl get pods
	kubectl get deployments

---------- WORKSHOP 3 --------------

	kubectl get services
	kubectl create -f service.yml
	kubectl get services
	kubectl cluster-info
	kubectl describe service invoice-app-service

---------- WORKSHOP 4 --------------

	kubectl get deployments
	kubectl create -f config_map.yml
	kubectl apply --record -f deployment_v2.yml
	kubectl get pods
	kubectl rollout status deployment invoice-app-deployment


	kubectl set image --record deployment/invoice-app-deployment invoice-app=macnowak/invoice-app:0.1.1
	kubectl rollout status deployment invoice-app-deployment
	kubectl rollout history deployment invoice-app-deployment
	kubectl rollout undo deployment --to-revision=2 invoice-app-deployment


---------- WORKSHOP 5 --------------

	kubectl create -f deployment.yml
	kubectl create -f service.yml
	kubectl scale --replicas=3 deployment video-rental-deployment
	kubectl delete pod xxx
	kubectl get pods

---------- WORKSHOP 6 --------------

GCP
