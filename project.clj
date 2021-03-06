(defproject jonase/eastwood "0.2.1-SNAPSHOT"
  :description "A Clojure lint tool"
  :url "https://github.com/jonase/eastwood"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :aot [eastwood.copieddeps.dep10.clojure.tools.reader.impl.ExceptionInfo]
  :global-vars {*warn-on-reflection* true
                ;;*unchecked-math* :warn-on-boxed
               }
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojars.brenton/google-diff-match-patch "0.1"]
                 [org.ow2.asm/asm-all "4.2"]]
  :profiles {:dev {:dependencies [[org.clojure/tools.macro "0.1.2"]
                                  [jafingerhut/dolly "0.1.0"]]
                   ;; I want the namespaces defined in files in
                   ;; "cases" and its subdirectories to be accessible
                   ;; during 'lein test' in the classpath, but they
                   ;; themselves should not be eval'd by 'lein test'.
                   ;; I also want those namespaces available for
                   ;; one-off tests at the command line like "lein
                   ;; eastwood '{:namespaces [testcases.testtest]}'",
                   ;; and for that, the :test profile does not work,
                   ;; so put them in :dev
                   :resource-paths [ "cases" ]}
             :1.5 {:dependencies [[org.clojure/clojure "1.5.1"]]}
             :1.7 {:dependencies [[org.clojure/clojure "1.7.0-master-SNAPSHOT"]]}}
  ;; Note: comment out the following line if you want to do 'lein
  ;; test' and get a Clojure version later than 1.5.1, even if you
  ;; have an explicit org.clojure/clojure in the :dependencies
  ;; Also: Having the following line uncommented causes a problem when
  ;; doing 'lein test', I think because of a different version of
  ;; core.cache or core.memoize on which the latest tools.analyzer.jvm
  ;; 0.1.0-SNAPSHOT depends, versus what Leiningen itself probably
  ;; depends on.
;;  :eval-in-leiningen true
  ;; Eastwood may work with earlier Leiningen versions, but this is
  ;; close to the earliest version that it was most tested with.
  :min-lein-version "2.3.0"
  :resource-paths ["resource"])
