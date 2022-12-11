(ns todo-clj.web
  (:require [compojure.core :refer [defroutes]]
            [ring.adapter.jetty :as ring]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [todo-clj.controllers.todos :as todos]
            [todo-clj.views.layout :as layout]
            [todo-clj.models.migration :as schema])
  (:gen-class))

(defroutes routes
  todos/routes
  (route/resources "/")
  (route/not-found (layout/four-oh-four)))

(def application (wrap-defaults routes site-defaults))

(defn start [port]
  (ring/run-jetty application {:port port
                               :join? false}))

(defn -main []
  (schema/migrate)
  (let [port (Integer. (or (System/getenv "PORT") "3000"))]
    (start port)))