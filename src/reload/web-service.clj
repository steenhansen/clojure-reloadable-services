
(load "singular-service")

(defn request-handler [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "request-handler" })

(defn request-handler-extra [request]

  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "request-handler-EXTRA" })

(def jetty-reloader #'ring-reload/reloader)

(defn web-reload []
  (let [reload-jetty! (jetty-reloader ["src"] true)]
     (reload-jetty!)))

(defn kill-web [web-ref] 
  (.stop web-ref))

(defn web-init [ server-port request-hander]
  (let [ web-server (ring/run-jetty request-hander {:port server-port :join? false}) ]
     (remove-service request-hander kill-web)
     (web-reload)
     (add-service  request-hander kill-web web-server)
     ))

