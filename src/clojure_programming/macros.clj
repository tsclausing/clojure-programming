(ns clojure-programming.macros
  "Additional resources:
    - http://www.infoq.com/presentations/Clojure-Macros/")


; functions evaluate from the inside out

(defn foo [a b]
  (println a b)
  b)

(foo 1
     (foo 2
          (foo 3 "bar")))


; but macros evaluate from the outside in

(defmacro moo [a b]
  (println a b)
  b)

(moo 1
     (moo 2
          (moo 3 "bar")))


; combining, macros evaluate first, then functions inside out:
;   m1
;   m2
;   f2
;   f1

(defmacro m1 [a]
  (println "m1")
  a)

(defmacro m2 [a]
  (println "m2")
  a)

(defn f1 [a]
  (println "f1")
  a)

(defn f2 []
  (println "f2"))

(m1 (f1 (m2 (f2))))