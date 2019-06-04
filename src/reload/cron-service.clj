
(load "singular-service")

(defn instant-time-fn []
  (str (jav-time/instant) )
)

(defn scrape-pages [    ] 
   (println "scrape-pages every second"))

(defn scrape-pages-extra [    ] 
   (println "scrape-pages-EXTRA once only"))

(defn cron-type [cron-run-always cron-seconds cron-func my-pool]   
   (if cron-run-always
        (at-at/every cron-seconds cron-func my-pool)
        (at-at/after cron-seconds cron-func my-pool)))

  (defn kill-cron [cron-ref] 
         (at-at/stop cron-ref))

(defn start-cron [cron-job cron-info] 
  (let [ {cron-seconds :cron-seconds cron-run-always :cron-run-always } cron-info ] 

	   (defn cron-func [] 
	        (cron-job))											 					

  (let [ thread-pool (at-at/mk-pool) 
         scheduled-task (cron-type cron-run-always cron-seconds cron-func thread-pool) ]
     					
     					(defn remove-crons []
					   			(try (at-at/stop-and-reset-pool! thread-pool)
              (catch Exception e (str " -- caught exception " (.getMessage e)))))

    scheduled-task)))   

(defn cron-init[  cron-job cron-info]
  ( let [  scheduled-task  (start-cron  cron-job cron-info ) ]
    (remove-service cron-job kill-cron)    
    (add-service  cron-job kill-cron scheduled-task)))

