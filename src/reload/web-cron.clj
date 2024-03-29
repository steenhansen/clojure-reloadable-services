
(ns reload.web-cron
  (:require [overtone.at-at :as at-at])       
  (:require [ring.adapter.jetty :as ring])
  (:require [java-time :as jav-time])      
  (:require [ring.middleware.reload :as ring-reload] )  
)

(load "cron-service")  
(load "web-service") 

(defn main []
  (web-init 3000 request-handler)
  (web-init 3001 request-handler-extra)

  (cron-init scrape-pages       {:cron-seconds 1000 :cron-run-always true } ) 
  (cron-init scrape-pages-extra {:cron-seconds 3000 :cron-run-always false } ) 

  (println " try http://localhost:3000 and http://localhost:3001 ")
  (println " (reload.web-cron/kill-services) to stop cron-jobs and web-servers ")
)
    
