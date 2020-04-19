SERVICE_URL = "http://localhost:8081/timestamp?shouldFail"

success:
	@while :; \
			do \
			curl $(SERVICE_URL)=false; \
			echo ""; \
			sleep 0.2; \
			done

failure:
	@while :; \
			do \
			curl $(SERVICE_URL)=true; \
			sleep 0.8; \
			done
