
Respo UI
----

Command styles for Respo apps.

Demo http://ui.respo.site/

Read stylesheets: https://github.com/Respo/respo-ui/blob/master/src/respo_ui/style.cljc

### Usages

[![Clojars Project](https://img.shields.io/clojars/v/respo/ui.svg)](https://clojars.org/respo/ui)

```clojure
[respo/ui "0.2.0"]
```

```clojure
[respo-ui.style :as ui]
[respo-ui.style.colors :as colors]
[respo-ui.comp.switchy :refer [comp-switch]] ; `switch` is a reserved word
[respo-ui.command :refer [init-input update-input on-input]]
```

Use `ui/button` as `style` attributes for buttons.

### Develop

https://github.com/mvc-works/boot-workflow

Dev:

```bash
cd npm-package/
webpack
cd ..
boot dev
export deps=`boot show -c`
env=dev lumo -Kc src/:$deps -i tasks/render.cljs
stack-editor
http-server -c-1
# open localhost:8080/dev.html
```

Build:

```bash
boot build-advanced
export deps=`boot show -c`
lumo -Kc src/:$deps -i tasks/render.cljs
cd npm-package/
webpack
cd ..
# boot rsync
```

### License

MIT
