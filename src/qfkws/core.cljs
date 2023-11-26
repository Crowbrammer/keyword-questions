(ns qfkws.core
  (:require [reagent.core :as r]
            [qfkws.state :as state]))

(defn app
  []
  [:div.container
   [:h1 "Questions"]
   [:h1 "Keywords"]
   [:div
     (when (not (empty? @state/keywords))
        (for [kw (clojure.string/split @state/keywords #"\n")]
           [:p {:key (random-uuid)} (str "Why is " (clojure.string/lower-case kw) " important?")]))]
   [:textarea#keywords {:value @state/keywords
                        :on-change #(reset! state/keywords (.. % -target -value))}]
   ])
   

(defn ^:export main
  []
  (r/render
    [app]
    (.getElementById js/document "app")))