(ns clojure-webapp-workshop.core
    (:require [reagent.core :as reagent :refer [atom]]
              [reagent.session :as session]
              [secretary.core :as secretary :include-macros true]
              [accountant.core :as accountant]
              [ajax.core :as ajax]
              [cljs.reader :refer [read-string]]))

;; -------------------------
;; State

(def state (atom {:contacts []}))

;; -------------------------
;; Views

(defn contact-card [{:keys [name email] :as contact}]
  [:li {:key (gensym)}
   [:dl
    [:dt "Name:"]
    [:dd name]
    [:dt "Email:"]
    [:dd email]]])

(defn contact-list [contacts]
  [:ul.contact-list
   (map contact-card contacts)])

(defn home-page []
  [:div [:h2 "My contacts"]
   [contact-list (:contacts @state)]
   [:div [:a {:href "/about"} "go to about page"]]])

(defn about-page []
  [:div [:h2 "About clojure-webapp-workshop"]
   [:div [:a {:href "/"} "go to the home page"]]])

(defn current-page []
  [:div [(session/get :current-page)]])

;; -------------------------
;; Routes

(secretary/defroute "/" []
  (session/put! :current-page #'home-page))

(secretary/defroute "/about" []
  (session/put! :current-page #'about-page))

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [current-page] (.getElementById js/document "app")))

(defn init! []
  (accountant/configure-navigation!
    {:nav-handler
     (fn [path]
       (secretary/dispatch! path))
     :path-exists?
     (fn [path]
       (secretary/locate-route path))})
  (accountant/dispatch-current!)
  (mount-root)
  (ajax/GET "/api/contacts" {:handler (fn [body]
                                        (swap! state assoc :contacts (read-string body)))}))
