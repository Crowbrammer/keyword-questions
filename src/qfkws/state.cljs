(ns qfkws.state
  (:require [reagent.core :as r]))

(def keywords (r/atom (.getItem js/localStorage "keywords")))