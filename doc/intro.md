


# clojure-reloadable-services

This project shows clean restarting of Clojure programs in CIDER that use cron jobs and web servers without issuing any special commands from the command line.

No need to use "(.stop server)" when using [ring.adapter.jetty](https://github.com/ring-clojure/ring/wiki/Getting-Started) for serving web pages. The web service is automatically stopped so that no "java.net.BindException" errors occur on restart.

Cron jobs using [Overtone/at-at](https://github.com/overtone/at-at) "Ahead-of-time function scheduler" are shut down and re-started without any interaction, stopping run-away threads.

# To Run
	- start Emacs
	- load "clojure-reloadable-services/src/reload/web-cron.clj"
	- M-x for "cider-jack-in"
	- "Load this buffer" with web-cron.clj
		- via the menu using "CIDER Eval | Load this buffer"
		- or via C-c C-k 
	- in the CIDER window enter (reload.web-cron/main)

# View web-servers at
	- http://localhost:3000/
	- http://localhost:3001/

# Cron-jobs output to Emacs

# To see point of program
	- Change code
	- "Load this buffer" with web-cron.clj
	- (reload.web-cron/main)

# Stop web-servers and cron-jobs with
	- (reload.web-cron/kill-services)






https://dillinger.io/
