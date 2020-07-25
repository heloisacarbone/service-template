(ns leiningen.new.service-template
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "service-template"))

;;lein new app "project-name

(defn service-template
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' service-template project.")
    (->files data ;; provides the structure that will be created [(where it will be created) (the one that we want to reproduce)]
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["test/{{sanitized}}/core_test.clj" (render "core_test.clj" data)]
             ["project.clj" (render "project.clj" data)])))


;; structure that we want to create
;;project.clj
;;src/app/core.clj
;;test/app/core_test