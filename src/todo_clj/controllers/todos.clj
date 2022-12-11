(ns todo-clj.controllers.todos
  (:require [compojure.core :refer [defroutes GET POST]]
            [clojure.string :as str]
            [ring.util.response :as ring]
            [todo-clj.views.todos :as view]
            [todo-clj.models.todo :as model]))

(defn index []
  (view/index (model/all)))

(defn create
  [todo]
  (when-not (str/blank? todo)
    (model/create todo))
  (ring/redirect "/"))

(defroutes routes
  (GET  "/" [] (index))
  (GET  "/dross" [] "<h2>Wilkommen bei dross</h2>")
  (POST "/" [todo] (create todo)))