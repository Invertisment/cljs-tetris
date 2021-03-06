(ns core.keys)

(defn produce-keypress-fn [on-key-fn]
  (fn [keyboard-event]
    (on-key-fn (aget keyboard-event "code"))))

(defn setup-key-listener [on-key-fn]
  (-> js/document
      (.getElementById "doc-body")
      (.addEventListener "keydown" (produce-keypress-fn on-key-fn))))
