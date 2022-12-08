package elide.site.ui.pages

import csstype.ClassName
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.main
import react.*

/** */
val Home = FC<Props> {
  main {
    className = ClassName("elide-site-page center")

    div {
      +"Home"
    }
  }
}
