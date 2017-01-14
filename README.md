
Respo UI
----

Command styles for Respo apps.

Demo http://ui.respo.site/

Read stylesheets: https://github.com/Respo/respo-ui/blob/master/src/respo_ui/style.cljc

Read command functions: https://github.com/Respo/respo-ui/blob/master/src/respo_ui/common.cljc

### Usages

[![Clojars Project](https://img.shields.io/clojars/v/respo/ui.svg)](https://clojars.org/respo/ui)

```clojure
[respo/ui "0.1.7"]
```

```clojure
[respo-ui.style :as ui]
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
boot dev!
```

Build:

```bash
boot build-advanced
export boot_deps=`boot show -c`
planck -c $boot_deps:src/ -i render.cljs
cd npm-package/
webpack
cd ..
# boot rsync
```

### License

MIT
