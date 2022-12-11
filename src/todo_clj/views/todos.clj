(ns todo-clj.views.todos
  (:require [todo-clj.views.layout :as layout]
            [hiccup.core :refer [h]]
            [hiccup.form :as form]
            [ring.util.anti-forgery :as anti-forgery]))

(defn todo-form []
  [:div {:id "todo-form" :class "sixteen columns alpha omega"}
   (form/form-to [:post "/"]
                 (anti-forgery/anti-forgery-field)
                 (form/label "todo" "Add note")
                 (form/text-area "todo")
                 (form/submit-button "SAVE!"))])

(defn display-todos [todos]
  [:div {:class "todos sixteen columns alpha omega"}
   (map
    (fn [todo] [:h2 {:class "todo"} (h (:body todo))])
    todos)])

(defn index [todos]
  (layout/common "TODO-CLJ"
                 (todo-form)
                 [:div {:class "clear"}]
                 (display-todos todos)))