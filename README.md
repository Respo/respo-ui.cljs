
Respo UI
----

Command styles for Respo apps.

Demo http://ui.respo.site/

Read stylesheets: [style.cljs](https://github.com/Respo/respo-ui/blob/master/src/respo_ui/style.cljs)

### Usages

[![Clojars Project](https://img.shields.io/clojars/v/respo/ui.svg)](https://clojars.org/respo/ui)

```clojure
[respo/ui "0.3.6"]
```

```clojure
[respo-ui.core :as ui]
```

```clojure
(respo-ui.comp.icon/comp-ion :home {:color :red})
(respo-ui.comp.icon/comp-icon :flash)
(respo-ui.comp.icon/comp-ios-icon :bell)
(respo-ui.comp.icon/comp-android-icon :cart)
```

Use `ui/button` as `:style` attributes for buttons.

### Develop

https://github.com/mvc-works/calcit-workflow

### License

MIT
