(ns todo-clj.models.todo
  (:require [clojure.java.jdbc :as sql]))

(def spec (or (System/getenv "DATABASE_URL")
              "postgresql://postgres@localhost:5432/todo"))

(defn all []
  (into [] (sql/query spec ["select * from todos order by id desc"])))

(defn create [todo]
  (sql/insert! spec :todos [:content] [todo]))