
(load "singular-service")

(defn request-handler [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "request-handler" })

(defn request-handler-extra [request]

  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "request-handler-EXTRA" })


; copied from https://github.com/panta82/clojure-webdev/blob/master/src/webdev/core.clj
(def jetty-reloader #'ring-reload/reloader)

; copied from https://github.com/panta82/clojure-webdev/blob/master/src/webdev/core.clj
(defn web-reload []
  (let [reload-jetty! (jetty-reloader ["src"] true)]
     (reload-jetty!)))


(defn kill-web [web-ref] 
  (.stop web-ref))

(defn web-init [ server-port request-hander]
  (let [ web-server (ring/run-jetty request-hander {:port server-port :join? false}) ]
     (remove-service request-hander kill-web)
     (web-reload)
     (add-service request-hander kill-web web-server)
     ))

