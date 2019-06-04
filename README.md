






we want to be able to show
 - cron-1
   cron-2
   web-1
   web-2

   all running and then all restarting in one file
   














delete-mongolabs
delete-amazonica         must have test in their names


problems:
  1. (:begins-all   ) actually returns 2 months, not one month
       so we only do one call to this.


2. amazonica does not use :_id. But that is ok as along as we 
   do the above



these are in home-page.clj


Nb DO WE DO THIS

(data-2-months _NOW_)

OR
(data-2-months _NOW_-one month)











delete 2 months old stuff


show-data(the-records)



we need to do 2x showing 
  Dec 1999
  jan 2000








--- we need to be able to do this for testing
 my-db-records
 end-html (show-web-page my-db-records)







--- comment("")














1 save first 100 of html, so thus read whole thing not just the header

2 empty-db for tests




HOURESSSSS






(http-client/head "http://google.ca/")           was 405 not allowed

(http-client/head "http://www.cnn.com/")           was invalid cookie





https://github.com/dakrone/clj-http#exceptions

; Response map is thrown as exception obj.
; We filter out by status codes
(try+
  (client/get "http://example.com/broken")
  (catch [:status 403] {:keys [request-time headers body]}
    (log/warn "403" request-time headers))
  (catch [:status 404] {:keys [request-time headers body]}
    (log/warn "NOT Found 404" request-time headers body))
  (catch Object _
    (log/error (:throwable &throw-context) "unexpected error")
    (throw+)))














1. on https://github.com/mcohen01/amazonica

(create-table cred       we want to have column1_idx so that we can query it

so we need to create a table like this new type to see if we can query it






////////////// below will show all on 2019-05-18 day !

  :id {:attribute-value-list ["2019-05-18"] :comparison-operator "BEGINS_WITH"}})

 :url-checked {:attribute-value-list ["http://www.google.ca/"] :comparison-operator "EQ"}})





so we need constants for the web pages so same everywhere




ALSO WE NEED TO SHOW WHICH FAILED, AND WHICH PASSED.........

{
	ID: "2019-05-18T01:54:03.844Z"
	TIME-TOOK: 123
	TOTAL-BYTES: 456
	URL-CHECKED : "GOOGLE"

    WAS-OK : FALSE                      0/1 INDICATES A FAIL


}


{  url-checked: "google"}















https://github.com/clojure-emacs/cider/issues/2420




sesman-restart (C-c C-s C-r) 














# my-project3

FIXME: description

## Installation

Download from http://example.com/FIXME.

## Usage

FIXME: explanation

    $ java -jar my-project3-0.1.0-standalone.jar [args]

## Options

FIXME: listing of options this app accepts.

## Examples

...

### Bugs

...

### Any Other Sections
### That You Think
### Might be Useful

## License

Copyright © 2019 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
